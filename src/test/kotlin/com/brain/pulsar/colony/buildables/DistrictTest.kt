package com.brain.pulsar.colony.buildables

import com.brain.pulsar.colony.resources.Resource
import com.brain.pulsar.colony.resources.ResourceType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class DistrictTest {
	
	private val energy = ResourceType("energy")
	private val minerals = ResourceType("minerals")
	private val districtType = DistrictType("test", 0,
			upkeep = listOf(Resource(energy, 1)),
			production = listOf(Resource(minerals, 4)))
	
	private val queue = ConstructionQueue()
	private val district = District(queue)
	
	init {
		district.queueRetool(districtType)
	}
	
	@Nested
	inner class Resources() {
		
		@Test
		fun production() {
			val actual = district.resourceProduction
			val expected = mapOf(Pair(minerals, 4))
			
			assertThat(actual).containsAllEntriesOf(expected)
		}
		
		@Test
		fun upkeep() {
			val actual = district.resourceUpkeep
			val expected = mapOf(Pair(energy, 1))
			
			assertThat(actual).containsAllEntriesOf(expected)
		}
		
		@Test
		fun cost() {}
		
		@Test
		fun job() {}
		
	}
	
	@Nested
	inner class Construction() {
		
		@Test
		fun retooling() {
			val districtType = DistrictType("new test", 0,
					upkeep = listOf(Resource(energy, 2)),
					production = listOf(Resource(minerals, 8)))
			district.queueRetool(districtType)
			
			assertThat(district.districtType).isEqualTo(
					DistrictType("new test", 0,
					upkeep = listOf(Resource(energy, 2)),
					production = listOf(Resource(minerals, 8)))
			)
		}
		
		@Test
		fun build() {
			district.queueBuild()
			assertThat(district.amount).isEqualTo(1)
		}
		
		@Test
		fun demolish() {}
		
		@Test
		fun upgrade() {}
		
		@Test
		fun downgrade() {}
		
		@Test
		fun `un-tooling`() {}
		
	}
	
	@Test
	fun disable() {}
	
}