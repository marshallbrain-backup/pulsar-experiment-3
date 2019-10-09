package com.brain.pulsar.colony.buildables

import com.brain.pulsar.colony.resources.ResourceType

data class District(
		private val constructionQueue: ConstructionQueue
){
	
	val resourceUpkeep = mutableMapOf<ResourceType, Int>()
	val resourceProduction = mutableMapOf<ResourceType, Int>()
	
	lateinit var districtType: DistrictType
	
	fun queueRetool(districtType: DistrictType, instant: Boolean = true){
		constructionQueue.add(this::retool)
	}
	
	private fun retool(districtType: DistrictType){
		this.districtType = districtType
		initialize()
	}
	
	private fun initialize() {
		
		resourceProduction.clear()
		resourceUpkeep.clear()
		
		for (r in districtType.upkeep){
			val t = resourceUpkeep.putIfAbsent(r.resourceType, r.amount)
			if (t != null) {
				resourceUpkeep[r.resourceType] = t + r.amount
			}
		}
		
		for (r in districtType.production){
			val t = resourceProduction.putIfAbsent(r.resourceType, r.amount)
			if (t != null) {
				resourceProduction[r.resourceType] = t + r.amount
			}
		}
		
	}
	
}