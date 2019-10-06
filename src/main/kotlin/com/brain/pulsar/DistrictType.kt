package com.brain.pulsar

class DistrictType (
		val id: String,
		val buildType: Int = 0,
		val cost: List<Resource> = listOf(),
		val upkeep: List<Resource> = listOf(),
		val production: List<Resource> = listOf(),
		val employ: List<Job> = listOf()
){
	
	val resourceTotal = mutableMapOf<ResourceType, Int>()
	
	init {
		
		for (r in cost){
			val t = resourceTotal.putIfAbsent(r.resourceType, r.amount)
			if (t != null) {
				resourceTotal[r.resourceType] = t + r.amount
			}
		}
		
		for (r in upkeep){
			val t = resourceTotal.putIfAbsent(r.resourceType, r.amount)
			if (t != null) {
				resourceTotal[r.resourceType] = t + r.amount
			}
		}
		
		for (r in production){
			val t = resourceTotal.putIfAbsent(r.resourceType, r.amount)
			if (t != null) {
				resourceTotal[r.resourceType] = t + r.amount
			}
		}
		
	}
	
}