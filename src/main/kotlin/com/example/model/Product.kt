package com.example.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Product(
        @Id
        var id: String? = null, var name: String = "", var price: Double = 300.00, var description: String = "Default")