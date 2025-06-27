package com.example.graalvm.controller

import com.example.graalvm.model.TestData
import com.example.graalvm.service.TestDataService
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping
class TestDataController(private val testDataService: TestDataService) {
    private val logger = LoggerFactory.getLogger(TestDataController::class.java)

    @GetMapping("/testData/{name}")
    fun findByName(@PathVariable name: String): ResponseEntity<TestData> {
        val testData = testDataService.findByName(name).also { data -> logger.info("Test data: $data") }
        return ResponseEntity.ok(testData)
    }
}