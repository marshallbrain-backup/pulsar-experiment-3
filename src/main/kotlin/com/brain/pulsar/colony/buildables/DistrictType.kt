package com.brain.pulsar.colony.buildables

import com.brain.pulsar.colony.resources.Job
import com.brain.pulsar.colony.resources.Resource

data class DistrictType (
		val id: String,
		val buildTime: Int = 0,
		val cost: List<Resource> = listOf(),
		val upkeep: List<Resource> = listOf(),
		val production: List<Resource> = listOf(),
		val employ: List<Job> = listOf()
){
}