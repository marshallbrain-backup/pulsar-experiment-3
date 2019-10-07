package com.brain.pulsar.colony.buildables

import com.brain.pulsar.colony.resources.Resource
import com.brain.pulsar.colony.resources.ResourceType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DistrictTest {
	
	private val energy = ResourceType("energy")
	private val minerals = ResourceType("minerals")
	private val districtType = DistrictType("test", 0,
			upkeep = listOf(Resource(energy, 1)),
			production = listOf(Resource(minerals, 4)))
	private val district = District(districtType)
	
	@Test
	fun `resource production`() {
		val actual = district.resourceProduction
		val expected = mapOf(Pair(minerals, 4))
		
		assertThat(actual).containsAllEntriesOf(expected)
	}
	
	@Test
	fun `resource upkeep`() {
		val actual = district.resourceUpkeep
		val expected = mapOf(Pair(energy, 1))
		
		assertThat(actual).containsAllEntriesOf(expected)
	}
}