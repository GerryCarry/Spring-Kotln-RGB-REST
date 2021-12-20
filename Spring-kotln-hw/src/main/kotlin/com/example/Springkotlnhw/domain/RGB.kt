package com.example.Springkotlnhw.domain

import com.example.Springkotlnhw.dto.RGBResponse
import javax.persistence.*


@Entity
data class RGB(

    @Id
    @SequenceGenerator(name = RGB_SEQUENCE, sequenceName = RGB_SEQUENCE, initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = RGB_SEQUENCE)
    val id:Long=1,
    var red: Int = 0,
    var green: Int = 0,
    var blue: Int = 0) {

    constructor(red: Int,green: Int,blue: Int) : this() {

        // Check the Red component is in the 0..255 range
        if(red < 0)
        {
            this.red = 0
        }else if(red > 255){
            this.red = 255
        } else {
            this.red = red
        }

        // Check the Green component is in the 0..255 range
        if(green < 0)
        {
            this.green = 0
        }else if(green > 255){
            this.green = 255
        } else {
            this.green = green
        }

        // Check the Blue component is in the 0..255 range
        if(blue < 0)
        {
            this.blue = 0
        }else if(blue > 255){
            this.blue = 255
        } else {
            this.blue = blue
        }

    }

    fun toRGBResponse():RGBResponse{
        return RGBResponse(
            id = this?.id ?: 1L,
            red = this.red,
            green = this.green,
            blue = this.blue
        )
    }

    companion object{
        const val RGB_SEQUENCE: String = "RGB_SEQUNENCE"
    }
}