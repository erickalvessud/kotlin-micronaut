package com.erick

import javax.inject.Singleton

@Singleton
@Suppress("unused")
class GreetingEndpoint(val greetingService : GreetingService) : GreeterGrpcKt.GreeterCoroutineImplBase() {
    override suspend fun sayHello(request: HelloRequest): HelloReply {

        val message = greetingService.sayHello(request.name)
        val reply = HelloReply.newBuilder().setMessage(message).build()
        return reply
    }
}