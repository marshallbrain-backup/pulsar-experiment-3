package com.brain.pulsar

data class Colony (
		val body: Body
){
	
	val emptyDistrict = DistrictType("empty")
	val districts = List(5) { _ -> emptyDistrict}
	
	init {
		
		print(districts)
		
	}

}