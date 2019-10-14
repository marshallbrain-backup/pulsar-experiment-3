package com.brain.pulsar.colony.resources

data class Resource (
		val resourceType: ResourceType,
		var amount: Int
){
	
	constructor(r: Resource) : this(r.resourceType, r.amount) {
	
	}
	
	operator fun plusAssign(add: Resource) {
		if (resourceType == add.resourceType) {
			amount += add.amount
		}
	}
	
	operator fun timesAssign(multiply: Int) {
		amount *= multiply
	}
	
}