package com.brain.pulsar.colony.buildables

class ConstructionQueue {
	
	private val queue = mutableListOf<QueueEntry>()
	
	fun add(time: Int, done: () -> Unit) {
		if(time == 0) {
			done()
		} else {
			queue.add(QueueEntry(done, time))
		}
	}
	
	fun tick(amount: Int = 1){
		if (queue[0].tick(amount)) {
			queue.removeAt(0)
		}
	}
	
	fun get(){}
	
	fun getAll(){}
	
}

class QueueEntry(private val done: () -> Unit, var time: Int) {
	
	fun tick(amount: Int) : Boolean{
		time -= if (amount >= 0) amount else time
		
		if(time <= 0) {
			done()
			return true
		}
		
		return false
	}
	
}