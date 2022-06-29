package com.example.squarejavasdkdemo

import com.squareup.square.Environment
import com.squareup.square.SquareClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct

@Service
class SquareService {

    @Value("\${SQUARE_ACCESS_TOKEN:default}")
    private lateinit var squareAccessToken: String

    @Value("\${SQUARE_SDK_CONNECT_URL:unknown}")
    private lateinit var squareSdkConnectUrl: String

    private lateinit var client: SquareClient

    @PostConstruct
    fun setup() {
        client = SquareClient.Builder()
            .environment(Environment.CUSTOM)
            .customUrl(squareSdkConnectUrl)
            .accessToken(squareAccessToken)
            .build()

        Runtime.getRuntime().addShutdownHook(Thread { shutdownSquareClient() })
    }

    fun getClient(): SquareClient {
        return client
    }

    private fun shutdownSquareClient() {
        SquareClient.shutdown()
    }
}
