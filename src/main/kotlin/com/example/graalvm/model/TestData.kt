package com.example.graalvm.model

import com.example.graalvm.entity.TestDataEntity

data class TestData(
    val name: String,
    val gender: String,
) {
    companion object {
        fun from(entity: TestDataEntity) =
            with(entity) {
                TestData(name = this.name, gender = this.gender)
            }
    }
}
