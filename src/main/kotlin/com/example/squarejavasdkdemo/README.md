# Summary
Specifically am running into the following when making a HTTP request (initiated when calling checkoutApi.createPaymentLink())

```
java.lang.NoSuchMethodError: 'okhttp3.RequestBody okhttp3.RequestBody.create(byte[], okhttp3.MediaType)
```

Digging into the code, I traced it down to this line in the sdk:
https://github.com/square/square-java-sdk/blame/43f766599bcd941423faa42143ad4c82f7d42662/src/main/java/com/squareup/square/http/client/OkClient.java#L282-L283
In the same SDK release (e.g. 18.0.0.20211215), the okhttp version was bumped to [okhttp 4.9.1]([url](https://github.com/square/square-java-sdk/blame/43f766599bcd941423faa42143ad4c82f7d42662/pom.xml#L208)), according to the [okhttp docs]([url](https://github.com/square/okhttp/blob/parent-4.9.1/okhttp/src/main/kotlin/okhttp3/ResponseBody.kt#L304)) for 4.9.1, the `create` method is expected to be:
```
fun create(contentType: MediaType?, content: ByteString)
```

(order is switch between contentType and content. (The method is also deprecated)


# Additional Detail
One more data point that might be of interest:
Looking at the okhttp code referenced here: https://github.com/square/okhttp/pull/5121/files#diff-ab573759adaad4f83ee49ed90b3bf8257c8fcfbfa186d4bccc058553aed7a541R176-R187

Even though the Deprecated message says:
**message = “Moved to extension function. Put the ‘content’ argument first to fix Java”**

The actual implementation in kotlin ([RequestBody.kt]([url](https://github.com/square/okhttp/pull/5121/files#diff-ab573759adaad4f83ee49ed90b3bf8257c8fcfbfa186d4bccc058553aed7a541))) is still with `contentType` first follow by `content`:
```
    fun create(
      contentType: MediaType?,
      content: ByteString
    ): RequestBody = content.toRequestBody(contentType)
```

Looking at the rest of the PR, some of the java references has it as 1. content 2. contentType. So seems like a discrepancy in 4.9.1 version of okhttp
