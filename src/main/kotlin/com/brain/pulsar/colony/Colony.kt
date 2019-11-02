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
	private val emptyDistrict = DistrictType("empty")
	val districts = List(5) { District(emptyDistrict, eventHandler, constructionQueue) }
	
	init {
	}

}