
import jetbrains.datalore.plot.PlotSvgExport
import org.jetbrains.letsPlot.geom.geomDensity
import org.jetbrains.letsPlot.intern.toSpec
import org.jetbrains.letsPlot.letsPlot
import java.awt.Desktop
import java.io.File

fun main() {
    val rand = java.util.Random()
    val n = 200
    val data = mapOf<String, Any>(
        "x" to List(n) { rand.nextGaussian() }
    )

    val plt = letsPlot(data) +
                geomDensity(
                    color = "dark-green",
                    fill = "green",
                    alpha = 0.3,
                    size = 2.0
                ) { x="x" }

    val content = PlotSvgExport.buildSvgImageFromRawSpecs(plt.toSpec())
    openInBrowser(content)
}

fun openInBrowser(content: String) {
    val dir = File(System.getProperty("user.dir"), "lets-plot-images")
    dir.mkdir()
    val file = File(dir.canonicalPath, "my_plot.html")
    file.createNewFile()
    file.writeText(content)

    Desktop.getDesktop().browse(file.toURI())
}
