package com.brain.pulsar.colony.buildables

import com.brain.ion.handler.EventHandler
import com.brain.ion.handler.EventType
import com.brain.pulsar.colony.Colony
import com.brain.pulsar.colony.resources.ResourceBucket

data class District(
		var districtType: DistrictType,
		val parentColony: Colony,
		val eventHandler: EventHandler,
		private val constructionQueue: ConstructionQueue
){
	
	val bucket = ResourceBucket()
	
	var amount = 0
	
	fun queueRetool(retoolType: DistrictType, instant: Boolean = true){
		constructionQueue.add(if(instant) 0 else retoolType.buildTime){
			retool(retoolType)
		}
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
	
	fun queueBuild(instant: Boolean = false){
		constructionQueue.add(if(instant) 0 else districtType.buildTime) {
			build()
		}
	}
	
	fun queueDemolish() {
		constructionQueue.add(0) {
			demolish()
		}
	}
	
	private fun build() {
		if (parentColony.currentDistrictSlots > 0) {
			amount++
			parentColony.updateDistrictSlots()
			bucket.modifyAmount(amount)
			eventHandler.trigger(this, Event.BUILD)
		}
	}
	
	private fun demolish(){
		if (amount-1 >= 0) {
			amount--
			parentColony.updateDistrictSlots()
			bucket.modifyAmount(amount)
			eventHandler.trigger(this, Event.DEMOLISH)
		}
	}
	
	enum class Event: EventType {
		BUILD,
		DEMOLISH
	}
	
}