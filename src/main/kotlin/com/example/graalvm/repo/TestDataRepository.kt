package com.example.graalvm.repo

import com.example.graalvm.entity.TestDataEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TestDataRepository : CrudRepository<TestDataEntity, String> {
    fun findByName(name: String): TestDataEntity?
}