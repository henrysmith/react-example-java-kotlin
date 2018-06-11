package com.example

import com.example.model.Product
import com.example.repository.ProductRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import reactor.core.publisher.Flux

@SpringBootApplication
class ReactWebApplication {


    @Bean
    fun init(productRepository: ProductRepository) = CommandLineRunner {

        productRepository.saveAll(
                Flux.fromIterable(arrayListOf(Product(name = "Cocoa"), Product(name = "Rice"), Product(name = "Coffee"))))
                .subscribe(System.out::println)
    }

}

fun main(args: Array<String>) {
    runApplication<ReactWebApplication>(*args)
}

