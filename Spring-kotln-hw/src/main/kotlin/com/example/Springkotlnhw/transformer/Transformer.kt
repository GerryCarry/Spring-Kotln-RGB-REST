package com.example.Springkotlnhw.transformer

interface Transformer<A,B> {
    fun transform(source: A):B
}