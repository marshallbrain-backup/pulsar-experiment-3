package com.brain.pulsar.colony

import com.brain.ion.handler.EventHandler
import com.brain.pulsar.colony.buildables.DistrictType
import com.brain.pulsar.body.Body
import com.brain.pulsar.colony.buildables.ConstructionQueue
import com.brain.pulsar.colony.buildables.District

data class Colony (
		val body: Body,
		val eventHandler: EventHandler
){
	
	private val constructionQueue = ConstructionQueue()
	private val emptyDistrict = DistrictType("")
	val districts = List(5) { District(emptyDistrict, this, eventHandler, constructionQueue) }
	val districtTypes = mutableListOf<DistrictType>()
	
	var totalDistrictSlots = 18
		private set
	var currentDistrictSlots = totalDistrictSlots
		private set
	
	fun updateDistrictSlots() {
		currentDistrictSlots = totalDistrictSlots
		for (d in districts) {
			currentDistrictSlots -= d.amount
		}
	}
	
	fun getPossibleDistricts(): List<DistrictType> {
		
		val availableDistrictType = mutableListOf<DistrictType>()
		val usedDistrictType = mutableSetOf<DistrictType>()
		
		for (d in districts){
			usedDistrictType.add(d.districtType)
		}
		for (t in districtTypes){
			if (!usedDistrictType.contains(t)) {
				availableDistrictType.add(t)
			}
		}
		
		return availableDistrictType
	}

}