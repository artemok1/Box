package FINAL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.knowm.xchart.ChartBuilder_Category;
import org.knowm.xchart.Chart_Category;
import org.knowm.xchart.demo.charts.ExampleChart;
import org.knowm.xchart.internal.chartpart.Chart;
import org.knowm.xchart.internal.style.Styler.ChartTheme;

@SuppressWarnings("rawtypes")
public class CompareChart implements ExampleChart {
	private String title;
	private String[] xValues;
	private Double[] yValues;
	private List<Stock> stocks;

	public static final String MAX_PRICE = "MAX_PRICE";
	public static final String MIN_PRICE = "MIN_PRICE";
	public static final String BID = "BID";

	public CompareChart(List<Stock> stocks, String type) {
		super();

		this.stocks = stocks;

		xValues = new String[this.stocks.size()];
		yValues = new Double[this.stocks.size()];

		if (type.equals(MAX_PRICE)) {
			for (int i = 0; i < this.stocks.size(); i++) {
				xValues[i] = this.stocks.get(i).getName();
				yValues[i] = this.stocks.get(i).getMaxPrice();
			}

			title = "Max Price";
		}
		
		if (type.equals(MIN_PRICE)) {
			for (int i = 0; i < this.stocks.size(); i++) {
				xValues[i] = this.stocks.get(i).getName();
				yValues[i] = this.stocks.get(i).getMinPrice();
			}

			title = "Min Price";
		}	
		
		if (type.equals(BID)) {
			for (int i = 0; i < this.stocks.size(); i++) {
				xValues[i] = this.stocks.get(i).getName();
				yValues[i] = this.stocks.get(i).getBid();
			}

			title = "Bid";
		}			
	}

	@Override
	public Chart getChart() {
	    // Create Chart
	    Chart_Category chart = new ChartBuilder_Category().width(800).height(600).title(title).xAxisTitle("").yAxisTitle("").theme(ChartTheme.XChart).build();
	    
	    // Series
	    for (int i = 0; i < xValues.length; i++) {
	    	chart.addSeries(xValues[i], new ArrayList<String>(Arrays.asList(new String[] { "Stocks" })), new ArrayList<Number>(Arrays.asList(new Number[] { yValues[i] })));
		}
 	 
	    return chart;		
	}
}
