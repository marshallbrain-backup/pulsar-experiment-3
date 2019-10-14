package com.brain.pulsar.colony.buildables

import com.brain.pulsar.colony.resources.ResourceType

data class District(
		private val constructionQueue: ConstructionQueue
){
	
	val resourceUpkeep = mutableMapOf<ResourceType, Int>()
	val resourceProduction = mutableMapOf<ResourceType, Int>()
	
	lateinit var districtType: DistrictType
	var amount = 0
	
	fun queueRetool(retoolType: DistrictType, instant: Boolean = true){
		constructionQueue.add({
			retool(retoolType)
		}, if(instant or !this::districtType.isInitialized) 0 else retoolType.buildTime)
	}
	
	private fun retool(retoolType: DistrictType){
		this.districtType = retoolType
		initialize()
	}
	
	private fun initialize() {
		
		resourceProduction.clear()
		resourceUpkeep.clear()
		amount = 0
		
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
	
	fun queueBuild(instant: Boolean = true){
		constructionQueue.add({
			build()
		}, if(instant or !this::districtType.isInitialized) 0 else districtType.buildTime)
	}
	
	private fun build() {
		amount++
	}
	
}