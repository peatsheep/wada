package com.aow.wada.message.web

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

@Configuration
class MessageRoutingController {
    @Bean
    fun routes(messageHandler: MessageHandler): RouterFunction<ServerResponse> = router {
        "/messages".nest {
            GET("/", messageHandler::listMessages)
            GET("/{id}", messageHandler::getMessage)
            POST("/", messageHandler::createMessage)
        }
    }
}