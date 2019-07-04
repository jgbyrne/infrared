package io.github.jgbyrne.core

import java.awt.Dimension
import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.RenderingHints.*
import java.lang.Exception
import java.util.*
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.WindowConstants.EXIT_ON_CLOSE

fun main() {

    val random = Random(0)
    val world = World(random)

    JFrame("Infrared").also {

        it.defaultCloseOperation = EXIT_ON_CLOSE
        it.contentPane = object : JPanel() {

            init {
                preferredSize = Dimension(1280, 720)
            }

            override fun paintComponent(g: Graphics) {
                super.paintComponent(g)
                g as? Graphics2D ?: throw Exception("Graphics Error")

                g.setRenderingHints(
                    mapOf(
                        KEY_ANTIALIASING to VALUE_ANTIALIAS_ON,
                        KEY_TEXT_ANTIALIASING to VALUE_TEXT_ANTIALIAS_ON
                    )
                )

                world.draw(g)
            }
        }
        it.pack()
        it.isVisible = true
    }


}
