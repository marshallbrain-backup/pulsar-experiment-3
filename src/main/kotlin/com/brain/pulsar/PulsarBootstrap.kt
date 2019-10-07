package com.brain.pulsar

import com.brain.ion.Ion
import com.brain.ion.components.Collection
import com.brain.ion.components.vectors.Path
import com.brain.ion.components.vectors.Rectangle
import com.brain.ion.components.vectors.Style
import com.brain.ion.graphics.Group
import com.brain.ion.graphics.IonGraphics
import com.brain.pulsar.body.Body
import com.brain.pulsar.colony.Colony

fun main() {
	
	val ion = Ion("Pulsar")
	val body = Body()
	val colony = Colony(body)
	val ui = Ui(ion.ionGraphics)
	
}

private class Ui(val graphics: IonGraphics){
	
	val stack = graphics.renderStack
	
	val background = Style("000000", 0.5)
	val boundingBox = Style("FFFFFF", 1, 2)
	
	val frame = Rectangle(1000, 720, background)
	val flag = Path(
			"M(65,10);y(5.3594);l(20,11.5469);y(46.1875);l(-20,11.5468);" +
					"y(10.3594);x(-55);y(165);x(595);y(-250);z",
			boundingBox)
	val preview = Path(
			"M(45,90);l(-35,-19.7927);y(-40.4146);l(35.4146,-20.2072);" +
					"l(35,20.2073);y(40.4146);z",
			boundingBox)
	
	val view = Collection(100, 100, frame, flag, preview)
	
	val group = Group("frame")
	
	init {
		
		group.addToQueue(view)
		
		stack.addGroup(group)
		
	}
	
}