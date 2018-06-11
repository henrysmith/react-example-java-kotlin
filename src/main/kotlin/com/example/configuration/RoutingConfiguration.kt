package com.example.configuration

import com.example.handlers.ProductHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

@Configuration
class RoutingConfiguration {


    val path = "/api/v2/products"

    @Suppress("unused")
    @Bean
    fun routerFunction(productHandler: ProductHandler): RouterFunction<ServerResponse> = router {
        (path).nest {
            GET("/", productHandler::getAllProducts)
            GET("/{id}", productHandler::getProductById)
        }
    }

}