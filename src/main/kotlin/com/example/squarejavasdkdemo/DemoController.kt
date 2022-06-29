package com.example.squarejavasdkdemo

import com.squareup.square.models.CheckoutOptions
import com.squareup.square.models.CreatePaymentLinkRequest
import com.squareup.square.models.Money
import com.squareup.square.models.QuickPay
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api")
class DemoController(
    private val squareService: SquareService,
) {
    @GetMapping(
        value = ["/v1/status"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    @ResponseBody
    fun getStatus(
    ): ResponseEntity<Any> {
        return ResponseEntity.ok().body(getBillingCheckoutFormUrl())
    }

    private fun getBillingCheckoutFormUrl(): String {
        val defaultBillingCheckoutFormUrl = "https://www.afterpay.com/en-AU"
        var billingCheckoutFormUrl: String
        try {
            val createPaymentLinkResponse = squareService.getClient().checkoutApi.createPaymentLink(createPaymentLinkRequest())
            billingCheckoutFormUrl = if (createPaymentLinkResponse.context.response.statusCode == HttpStatus.OK.value()) {
                createPaymentLinkResponse.paymentLink.url
            } else defaultBillingCheckoutFormUrl
        } catch (e: Exception) {
            billingCheckoutFormUrl = defaultBillingCheckoutFormUrl
        }
        return billingCheckoutFormUrl
    }

    private fun createPaymentLinkRequest(): CreatePaymentLinkRequest {
        return CreatePaymentLinkRequest.Builder()
            .idempotencyKey(UUID.randomUUID().toString())
            .description("Test Plan")
            .quickPay(
                QuickPay(
                    "Test Plan",
                    Money(399, "USD"),
                    "LKCW13XPDC4ZE"
                )
            )
            .checkoutOptions(
                CheckoutOptions.Builder()
                    .allowTipping(false)
                    .subscriptionPlanId("XHIFBYO45LVGKGFYMS3VXNHN")
                    .redirectUrl("https://www.google.com")
                    .merchantSupportEmail("test@foo.com")
                    .askForShippingAddress(false)
                    .build()
            )
            .build()
    }
}
