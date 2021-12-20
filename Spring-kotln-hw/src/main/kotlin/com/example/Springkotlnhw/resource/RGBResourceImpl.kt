package com.example.Springkotlnhw.resource

import com.example.Springkotlnhw.dto.AddRGBRequest
import com.example.Springkotlnhw.dto.RGBResponse
import com.example.Springkotlnhw.dto.RGBRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import com.example.Springkotlnhw.resource.RGBResourceImpl.Companion.BASE_RGB_URL
import com.example.Springkotlnhw.service.RGBManegmentService
import java.net.URI

@RestController
@RequestMapping(value = [BASE_RGB_URL])
class RGBResourceImpl(private val RGBManegmentService: RGBManegmentService) : RGBResource {

    @GetMapping("/{id}")
    override fun findById(@PathVariable id: Long): ResponseEntity<RGBResponse?> {
        val RGBResponse: RGBResponse? = this.RGBManegmentService.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(RGBResponse)
    }

    @GetMapping
    override fun findAll(): ResponseEntity<List<RGBResponse>> = ResponseEntity.ok(this.RGBManegmentService.findAll())

    @PostMapping
    override fun save(@RequestBody addRGBRequest: AddRGBRequest): ResponseEntity<RGBResponse> {
        val rgbResponse = this.RGBManegmentService.save(addRGBRequest)
        return ResponseEntity
            .created(URI.create(BASE_RGB_URL.plus("${rgbResponse.id}")))
            .body(rgbResponse)
    }

    @PutMapping
    override fun update(@RequestBody RGBRequest: RGBRequest): ResponseEntity<RGBResponse> {
        return ResponseEntity.ok(this.RGBManegmentService.update(RGBRequest))
    }

    @DeleteMapping("/{id}")
    override fun deleteById(@PathVariable id: Long): ResponseEntity<Unit> {
        this.RGBManegmentService.deleteById(id)
        return ResponseEntity.noContent().build()
    }

    companion object{
        const val BASE_RGB_URL: String = "/api/v1/rgb"
    }
}