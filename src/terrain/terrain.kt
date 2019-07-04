package terrain

import terrain.noise.OpenSimplexNoise
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

fun main() {
    val WIDTH: Int = 512
    val HEIGHT: Int = 512
    val FEATURE_SIZE: Double = 24.0

    var noise = OpenSimplexNoise()

    var img = BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB)
    for (y in 0 until HEIGHT - 1) {
        for (x in 0 until WIDTH - 1) {
            val value = noise.eval(x / FEATURE_SIZE, y / FEATURE_SIZE, 0.0)
            println(((65793 * ((value + 1) * 127.5)) + (512 * y)).toInt())
            val rgb = maxOf(65793, ((65793 * ((value + 1) * 127.5)) + (512 * y)).toInt())
            img.setRGB(x, y, rgb)
        }
    }
    ImageIO.write(img, "png",  File("noise.png"))
}
