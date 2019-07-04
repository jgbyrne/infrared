package io.github.jgbyrne.core

import java.awt.Graphics2D
import java.awt.geom.Line2D
import java.util.*

class World(random: Random) {

    val cities = (0 until 20).map {
        City(
            City.possibleNames[random.nextInt(City.possibleNames.size)],
            random.nextGaussian() * 250 + 250,
            random.nextGaussian() * 250 + 250
        )
    }

    init {

    }

    fun draw(g: Graphics2D) {

        cities.forEach {
            g.draw(Line2D.Double(it.x - 10, it.y, it.x + 10, it.y))
            g.draw(Line2D.Double(it.x, it.y - 10, it.x, it.y + 10))

            g.drawString(it.name, it.x.toInt() + 2, it.y.toInt() - 2)

        }

    }

}

class City(val name: String, val x: Double, val y: Double) {
    companion object {
        val possibleNames = listOf("Batley", "Dewsbury", "Welwyn Garden")
    }
}

