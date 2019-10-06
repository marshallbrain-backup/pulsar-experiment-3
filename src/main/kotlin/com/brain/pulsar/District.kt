package com.brain.pulsar

class District (
		var districtType: DistrictType
){
	
	val resourceUpkeep = mutableMapOf<ResourceType, Int>()
	val resourceProducton = mutableMapOf<ResourceType, Int>()
	
	init {
		
		for (r in districtType.upkeep){
			val t = resourceUpkeep.putIfAbsent(r.resourceType, r.amount)
			if (t != null) {
				resourceUpkeep[r.resourceType] = t + r.amount
			}
		}
		
		for (r in districtType.production){
			val t = resourceProducton.putIfAbsent(r.resourceType, r.amount)
			if (t != null) {
				resourceProducton[r.resourceType] = t + r.amount
			}
		}
		
	}
	
}