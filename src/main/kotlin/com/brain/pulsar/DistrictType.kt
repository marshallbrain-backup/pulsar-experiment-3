package com.brain.pulsar

class DistrictType (
		val id: String,
		val buildType: Int = 0,
		val cost: List<Resource> = listOf(),
		val production: List<Resource> = listOf(),
		val upkeep: List<Resource> = listOf(),
		val employ: List<Job> = listOf()
){
	
	val resourceTotal = mutableMapOf<ResourceType, Int>()
	
}