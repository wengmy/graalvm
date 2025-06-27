package com.example.graalvm

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GraalvmApplication

fun main(args: Array<String>) {
    runApplication<GraalvmApplication>(*args)
}
