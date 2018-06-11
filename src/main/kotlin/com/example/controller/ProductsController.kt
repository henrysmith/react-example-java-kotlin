package com.example.controller

import com.example.model.Product
import com.example.repository.ProductRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux


@RestController
@RequestMapping("/api/v1/products")
class ProductsController (val productRepository: ProductRepository) {

    @GetMapping
    fun getProducts(): Flux<Product> {
        return this.productRepository.findAll()
    }


}


