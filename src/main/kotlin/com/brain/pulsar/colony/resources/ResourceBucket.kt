package com.brain.pulsar.colony.resources

class ResourceBucket(
		path: String
) {
	
	val bucket = mutableMapOf<String, Resource>()
	
	fun addResources(list: List<Resource>, type: String) {
		for (r in list){
			val current = bucket.putIfAbsent("$type.${r.resourceType.id}", Resource(r))
			current?.let { it += r }
		}
	}
	
	fun modifyAmount(amount: Int) {
		for ((_, r) in bucket) {
			r *= amount
		}
	}
	
	fun clear(){
		bucket.clear()
	}
	
}