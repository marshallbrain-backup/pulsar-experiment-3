package com.brain.pulsar

class Colony (
		val body: Body
){
	
	val emptyDistrict = DistrictType("empty")
	val districts = List(5) { _ -> emptyDistrict}
	
	init {
		
		print(districts)
		
	}

}