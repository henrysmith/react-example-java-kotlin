package com.example.handlers

import com.example.repository.ProductRepository
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Mono

@Component
class ProductHandler(val productRepository: ProductRepository) {


    fun getAllProducts(request: ServerRequest): Mono<ServerResponse> =
            ServerResponse.ok().body(productRepository.findAll())


    fun getProductById(request: ServerRequest): Mono<ServerResponse> {
        val pathId = request.pathVariable("id")
        val findById = productRepository.findById(pathId)
        return ServerResponse.ok().body(findById).switchIfEmpty(ServerResponse.notFound().build())
    }

}