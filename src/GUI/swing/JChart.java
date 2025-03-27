package GUI.swing;

import UTILS.Cons;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JPanel;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.XChartPanel;

public class JChart {

    private JPanel distributionChartPanel;

    public JChart(ArrayList<Double> scores, ArrayList<Integer> count) {

        CategoryChart chart = new CategoryChartBuilder()
                .width(850)
                .height(460)
                .title("Biểu đồ điểm số")
                .xAxisTitle("Điểm số")
                .yAxisTitle("Só lượng")
                .build();
        
        Color[] colors = new Color[]{Cons.COLOR_MENU};
        chart.getStyler().setSeriesColors(colors);

        chart.getStyler().setChartBackgroundColor(Color.WHITE);

        chart.getStyler().setYAxisDecimalPattern("#");
        chart.getStyler().setXAxisDecimalPattern("#.##");

        chart.getStyler().setAxisTicksLineVisible(false);
        
        Font font = new Font("Arial", Font.PLAIN, 8);
        chart.getStyler().setAxisTickLabelsFont(font);
        
        chart.addSeries("Số lượng", scores, count);

        distributionChartPanel = new XChartPanel<>(chart);
        distributionChartPanel.setBackground(Color.WHITE);
        distributionChartPanel.setOpaque(true);
    }

    public void draw(JPanel panel) {
        panel.add(distributionChartPanel);
        panel.revalidate();
        panel.repaint();
    }
}
