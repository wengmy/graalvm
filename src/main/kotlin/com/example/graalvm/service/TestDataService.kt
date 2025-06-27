package com.example.graalvm.service

import com.example.graalvm.model.TestData
import com.example.graalvm.repo.TestDataRepository
import org.springframework.stereotype.Service

@Service
class TestDataService(private val testDataRepository: TestDataRepository) {
    fun findByName(name: String): TestData? {
        return testDataRepository.findByName(name)?.let { TestData.from(it) }
    }
}