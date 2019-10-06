package com.brain.pulsar

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class DistrictTest {
	
	private val energy = ResourceType("energy")
	private val minerals = ResourceType("minerals")
	private val districtType = DistrictType("test", 0,
			upkeep = listOf(Resource(energy, 1)),
			production = listOf(Resource(minerals, 4)))
	private val district = District(districtType)
	
	@Test
	fun `resource production`() {
		
	}
	
	@Test
	fun `resource upkeep`() {
	
	}
}