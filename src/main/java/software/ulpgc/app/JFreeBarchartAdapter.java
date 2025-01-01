package software.ulpgc.app;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import software.ulpgc.model.Barchart;

public class JFreeBarchartAdapter {

    public static JFreeChart adapt(Barchart barchart) {
        return ChartFactory.createBarChart(
                barchart.getTitle(),
                barchart.getxAxis(),
                barchart.getyAxis(),
                datasetof(barchart)
        );

    }

    private static CategoryDataset datasetof(Barchart barchart) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (String line : barchart.keySet()) {
            dataset.addValue(barchart.get(line),"",line);
        }
        return dataset;
    }
}
