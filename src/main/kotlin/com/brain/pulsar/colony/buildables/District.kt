package com.brain.pulsar.colony.buildables

import com.brain.pulsar.colony.resources.ResourceBucket
import com.brain.pulsar.colony.resources.ResourceType

data class District(
		private val constructionQueue: ConstructionQueue
){
	
	val bucket = ResourceBucket()
	
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
		
		bucket.clear()
		bucket.path = districtType.id
		amount = 0
		
		bucket.addResources(districtType.upkeep, "upkeep")
		bucket.addResources(districtType.production, "production")
		
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