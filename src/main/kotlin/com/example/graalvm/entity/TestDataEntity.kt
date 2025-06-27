package com.example.graalvm.entity

import com.example.graalvm.model.TestData
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.jetbrains.annotations.NotNull

@Entity
@Table(name = "test_data")
data class TestDataEntity(
    @Id
    @NotNull
    val name: String,
    val gender: String,
) {
    companion object {
        fun from(model: TestData) =
            with(model) {
                TestDataEntity(name = this.name, gender = this.gender)
            }
    }
}
