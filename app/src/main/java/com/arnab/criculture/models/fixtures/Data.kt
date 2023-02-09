package com.arnab.criculture.models.fixtures

data class Data(
    val code: String,
    val country_id: Int,
    val fixtures: List<FixtureX>,
    val id: Int,
    val image_path: String,
    val name: String,
    val national_team: Boolean,
    val resource: String,
    val updated_at: String
)