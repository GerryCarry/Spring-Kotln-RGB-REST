package com.example.Springkotlnhw.resource

import com.example.Springkotlnhw.dto.AddRGBRequest
import com.example.Springkotlnhw.dto.RGBResponse
import com.example.Springkotlnhw.dto.RGBRequest
import org.springframework.http.ResponseEntity

interface RGBResource {
    fun findById(id:Long): ResponseEntity<RGBResponse?>
    fun findAll(): ResponseEntity<List<RGBResponse>>
    fun save(addRGBRequest: AddRGBRequest): ResponseEntity<RGBResponse>
    fun update(RGBRequest: RGBRequest): ResponseEntity<RGBResponse>
    fun deleteById(id:Long):ResponseEntity<Unit>
}