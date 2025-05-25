package com.twoweekhee.goldengoose

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GoldenGooseApplication

fun main(args: Array<String>) {
    runApplication<GoldenGooseApplication>(*args)
}
