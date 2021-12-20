package com.example.Springkotlnhw.dao

import com.example.Springkotlnhw.domain.RGB
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RGBDao: JpaRepository<RGB,Long> {
}