package com.example.Springkotlnhw.service

import com.example.Springkotlnhw.dao.RGBDao
import com.example.Springkotlnhw.domain.RGB
import com.example.Springkotlnhw.dto.AddRGBRequest
import com.example.Springkotlnhw.dto.RGBResponse
import com.example.Springkotlnhw.dto.RGBRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import com.example.Springkotlnhw.transformer.AddRGBRequestTransformer

@Service
class RGBManegmentServiceImpl(private val RGBDao: RGBDao,
                              private val addRGBRequestTransformer: AddRGBRequestTransformer) : RGBManegmentService {

    override fun findById(id: Long): RGBResponse? = this.findRGBById(id)?.toRGBResponse()

    override fun findAll(): List<RGBResponse> = this.RGBDao.findAll().map(RGB::toRGBResponse)

    override fun save(addRGBRequest: AddRGBRequest): RGBResponse {
        return this.saveOrUpdate(
            addRGBRequestTransformer.transform(addRGBRequest)
        )
    }

    override fun update(RGBRequest: RGBRequest): RGBResponse {
        val rgb = findRGBById(RGBRequest.id) ?: throw IllegalStateException("${RGBRequest.id} not found!")

        return this.saveOrUpdate(rgb.apply{
            this.red = RGBRequest.red
            this.green = RGBRequest.green
            this.blue = RGBRequest.blue
        })
    }

    override fun deleteById(id: Long) {
        this.RGBDao.deleteById(id)
    }

    private fun findRGBById(id: Long): RGB? = this.RGBDao.findByIdOrNull(id)

    private fun saveOrUpdate(person: RGB):RGBResponse = this.RGBDao.save(person).toRGBResponse()

                                  }