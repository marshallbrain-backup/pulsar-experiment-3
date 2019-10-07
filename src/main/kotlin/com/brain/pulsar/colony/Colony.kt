package com.brain.pulsar.colony

import com.brain.pulsar.colony.buildables.DistrictType
import com.brain.pulsar.body.Body

data class Colony (
		val body: Body
){
	
	val emptyDistrict = DistrictType("empty")
	val districts = List(5) { _ -> emptyDistrict}
	
	init {
	}

}