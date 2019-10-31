package com.brain.pulsar.colony.resources

data class Resource (
		val resourceType: ResourceType,
		private var baseAmount: Int
){
	
	var amount = 0
	var multiplyer = 0
	
	constructor(r: Resource) : this(r.resourceType, r.amount) {
	}
	
	operator fun plusAssign(add: Resource) {
		if (resourceType == add.resourceType) {
			baseAmount += add.baseAmount
			timesAssign(multiplyer)
		}
	}
	
	operator fun timesAssign(m: Int) {
		multiplyer = m
		amount = baseAmount
		amount *= multiplyer
	}
	
}