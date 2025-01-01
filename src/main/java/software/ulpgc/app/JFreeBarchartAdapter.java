package software.ulpgc.app;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import software.ulpgc.model.Barchart;

import java.awt.*;

import static java.awt.Color.GREEN;
import static java.awt.Color.RED;

public class JFreeBarchartAdapter {

    public static JFreeChart adapt(Barchart barchart) {
        JFreeChart chart = ChartFactory.createBarChart(
                barchart.getTitle(),
                barchart.getxAxis(),
                barchart.getyAxis(),
                datasetof(barchart)
        );
        CategoryPlot plot = chart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();

        setColorGradient(barchart, renderer, RED, GREEN);

        renderer.setItemMargin(-5);

        return chart;
    }

    private static CategoryDataset datasetof(Barchart barchart) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (String line : barchart.keySet()) {
            dataset.addValue(barchart.get(line),line,line);
        }
        return dataset;
    }

    private static void setColorGradient(Barchart barchart, BarRenderer renderer, Color initial, Color end) {
        int size = barchart.keySet().size();
        for (int col = 0; col < size; col++) {
            double ratio = (double) col / (size-1);
            int r= (int) (initial.getRed()-ratio*(initial.getRed()- end.getRed()));
            int g= (int) (initial.getGreen()-ratio*(initial.getGreen()- end.getGreen()));
            int b= (int) (initial.getBlue()-ratio*(initial.getBlue()- end.getBlue()));

            Color color=new Color(r,g,b);
            renderer.setSeriesPaint(col, color);
        }
    }
}
