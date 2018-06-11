package com.example.repository

import com.example.model.Product
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
open interface ProductRepository : ReactiveMongoRepository<Product, String>