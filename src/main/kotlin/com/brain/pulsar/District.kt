package com.brain.pulsar

class District (
		var districtType: DistrictType
){
	
	val resourceTotal = districtType.resourceTotal.toMutableMap()
	
}