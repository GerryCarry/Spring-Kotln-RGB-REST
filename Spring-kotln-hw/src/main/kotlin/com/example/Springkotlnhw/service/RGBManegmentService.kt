package com.example.Springkotlnhw.service

import com.example.Springkotlnhw.dto.AddRGBRequest
import com.example.Springkotlnhw.dto.RGBResponse
import com.example.Springkotlnhw.dto.RGBRequest

interface RGBManegmentService {
    fun findById(id:Long): RGBResponse?
    fun findAll():List<RGBResponse>
    fun save(addRGBRequest: AddRGBRequest): RGBResponse
    fun update(RGBRequest: RGBRequest): RGBResponse
    fun deleteById(id:Long):Unit
}