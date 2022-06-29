# square-java-sdk-demo
Demo Kotlin Spring App to validate Square Java SDK integration

## How to Run

```
Kotlin: 1.6.21
JVM: 11

➜  square-java-sdk-demo java --version
openjdk 11.0.10 2021-01-19 LTS
OpenJDK Runtime Environment (build 11.0.10+9-LTS)
OpenJDK 64-Bit Server VM (build 11.0.10+9-LTS, mixed mode)
```

Start server:
```
./gradlew bootRun
```

```
curl --request GET 'http://localhost:8080/api/v1/status'
```

See exception:
```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.6.9)

2022-06-29 10:59:31.062  INFO 79209 --- [           main] c.e.s.SquareJavaSdkDemoApplicationKt     : Starting SquareJavaSdkDemoApplicationKt using Java 14.0.2 on slei-macbookpro.local with PID 79209 (/Users/slei/dev/square-java-sdk-demo/build/classes/kotlin/main started by slei in /Users/slei/dev/square-java-sdk-demo)
2022-06-29 10:59:31.064  INFO 79209 --- [           main] c.e.s.SquareJavaSdkDemoApplicationKt     : No active profile set, falling back to 1 default profile: "default"
2022-06-29 10:59:32.151  INFO 79209 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2022-06-29 10:59:32.169  INFO 79209 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2022-06-29 10:59:32.169  INFO 79209 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.64]
2022-06-29 10:59:32.247  INFO 79209 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2022-06-29 10:59:32.247  INFO 79209 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1096 ms
2022-06-29 10:59:32.918  INFO 79209 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2022-06-29 10:59:32.929  INFO 79209 --- [           main] c.e.s.SquareJavaSdkDemoApplicationKt     : Started SquareJavaSdkDemoApplicationKt in 2.454 seconds (JVM running for 2.861)
2022-06-29 11:00:23.343  INFO 79209 --- [nio-8080-exec-4] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2022-06-29 11:00:23.344  INFO 79209 --- [nio-8080-exec-4] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2022-06-29 11:00:23.347  INFO 79209 --- [nio-8080-exec-4] o.s.web.servlet.DispatcherServlet        : Completed initialization in 3 ms
2022-06-29 11:00:23.443 ERROR 79209 --- [nio-8080-exec-4] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Handler dispatch failed; nested exception is java.lang.NoSuchMethodError: 'okhttp3.RequestBody okhttp3.RequestBody.create(byte[], okhttp3.MediaType)'] with root cause

java.lang.NoSuchMethodError: 'okhttp3.RequestBody okhttp3.RequestBody.create(byte[], okhttp3.MediaType)'
	at com.squareup.square.http.client.OkClient.convertRequest(OkClient.java:292) ~[square-20.0.0.20220512.jar:na]
	at com.squareup.square.http.client.OkClient.execute(OkClient.java:156) ~[square-20.0.0.20220512.jar:na]
	at com.squareup.square.http.client.OkClient.execute(OkClient.java:177) ~[square-20.0.0.20220512.jar:na]
	at com.squareup.square.api.DefaultCheckoutApi.createPaymentLink(DefaultCheckoutApi.java:301) ~[square-20.0.0.20220512.jar:na]
	at com.example.squarejavasdkdemo.DemoController.getBillingCheckoutFormUrl(DemoController.kt:35) ~[main/:na]
	at com.example.squarejavasdkdemo.DemoController.getStatus(DemoController.kt:28) ~[main/:na]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:na]
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
	at java.base/java.lang.reflect.Method.invoke(Method.java:564) ~[na:na]
	at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:205) ~[spring-web-5.3.21.jar:5.3.21]
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:150) ~[spring-web-5.3.21.jar:5.3.21]
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:117) ~[spring-webmvc-5.3.21.jar:5.3.21]
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:895) ~[spring-webmvc-5.3.21.jar:5.3.21]
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:808) ~[spring-webmvc-5.3.21.jar:5.3.21]
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87) ~[spring-webmvc-5.3.21.jar:5.3.21]
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1067) ~[spring-webmvc-5.3.21.jar:5.3.21]
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:963) ~[spring-webmvc-5.3.21.jar:5.3.21]
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006) ~[spring-webmvc-5.3.21.jar:5.3.21]
	at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:898) ~[spring-webmvc-5.3.21.jar:5.3.21]
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:655) ~[tomcat-embed-core-9.0.64.jar:4.0.FR]
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883) ~[spring-webmvc-5.3.21.jar:5.3.21]
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:764) ~[tomcat-embed-core-9.0.64.jar:4.0.FR]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:227) ~[tomcat-embed-core-9.0.64.jar:9.0.64]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-9.0.64.jar:9.0.64]
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53) ~[tomcat-embed-websocket-9.0.64.jar:9.0.64]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189) ~[tomcat-embed-core-9.0.64.jar:9.0.64]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-9.0.64.jar:9.0.64]
	at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100) ~[spring-web-5.3.21.jar:5.3.21]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117) ~[spring-web-5.3.21.jar:5.3.21]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189) ~[tomcat-embed-core-9.0.64.jar:9.0.64]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-9.0.64.jar:9.0.64]
	at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93) ~[spring-web-5.3.21.jar:5.3.21]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117) ~[spring-web-5.3.21.jar:5.3.21]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189) ~[tomcat-embed-core-9.0.64.jar:9.0.64]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-9.0.64.jar:9.0.64]
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201) ~[spring-web-5.3.21.jar:5.3.21]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117) ~[spring-web-5.3.21.jar:5.3.21]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189) ~[tomcat-embed-core-9.0.64.jar:9.0.64]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-9.0.64.jar:9.0.64]
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:197) ~[tomcat-embed-core-9.0.64.jar:9.0.64]
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:97) ~[tomcat-embed-core-9.0.64.jar:9.0.64]
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:541) ~[tomcat-embed-core-9.0.64.jar:9.0.64]
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:135) ~[tomcat-embed-core-9.0.64.jar:9.0.64]
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:92) ~[tomcat-embed-core-9.0.64.jar:9.0.64]
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:78) ~[tomcat-embed-core-9.0.64.jar:9.0.64]
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:360) ~[tomcat-embed-core-9.0.64.jar:9.0.64]
	at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:399) ~[tomcat-embed-core-9.0.64.jar:9.0.64]
	at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:65) ~[tomcat-embed-core-9.0.64.jar:9.0.64]
	at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:890) ~[tomcat-embed-core-9.0.64.jar:9.0.64]
	at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1787) ~[tomcat-embed-core-9.0.64.jar:9.0.64]
	at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49) ~[tomcat-embed-core-9.0.64.jar:9.0.64]
	at org.apache.tomcat.util.threads.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1191) ~[tomcat-embed-core-9.0.64.jar:9.0.64]
	at org.apache.tomcat.util.threads.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:659) ~[tomcat-embed-core-9.0.64.jar:9.0.64]
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61) ~[tomcat-embed-core-9.0.64.jar:9.0.64]
	at java.base/java.lang.Thread.run(Thread.java:832) ~[na:na]
```

