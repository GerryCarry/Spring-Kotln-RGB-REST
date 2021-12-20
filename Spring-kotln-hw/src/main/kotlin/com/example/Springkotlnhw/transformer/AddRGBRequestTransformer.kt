package com.example.Springkotlnhw.transformer

import com.example.Springkotlnhw.domain.RGB
import com.example.Springkotlnhw.dto.AddRGBRequest
import org.springframework.stereotype.Component

@Component
class AddRGBRequestTransformer:Transformer<AddRGBRequest, RGB> {
    override fun transform(source: AddRGBRequest): RGB {
        return RGB(
            red = source.red,
            green = source.green,
            blue =  source.blue
        )
    }

}