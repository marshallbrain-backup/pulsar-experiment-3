package com.brain.pulsar.colony.buildables

import com.brain.pulsar.colony.resources.ResourceType

data class District (
		var districtType: DistrictType
){
	
	val resourceUpkeep = mutableMapOf<ResourceType, Int>()
	val resourceProduction = mutableMapOf<ResourceType, Int>()
	
	init {
		
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