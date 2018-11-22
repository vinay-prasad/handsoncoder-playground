package org.ucf.assignment.daa.clunet.main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.BitmapEncoder.BitmapFormat;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.ucf.assignment.daa.clunet.CluNetConnectedGraph;
import org.ucf.assignment.daa.clunet.CluNetSpanningTree;
import org.ucf.assignment.daa.clunet.util.Utils;

public class PerformanceMetricsTest {
	public static final Logger LOG = Logger.getLogger(PerformanceMetricsTest.class);
	public static final String str = "----------------------------------";

	@Test
	public void executePerformanceMetricsTest() {
		double[] nodes = new double[1003 - 3];
		double[] millis = new double[1003 - 3];
		LOG.info("Test executePerformanceMetricsTest()");
		for (int V = 3, i = 0; V < 1003; V++) {
			LOG.info(String.format("%-20s%-20s%-20s%-20s", str, str, str, str));

			CluNetConnectedGraph graph = Utils.getConnectedGraph(V);
			graph.printGraphLinks();

			CluNetSpanningTree tree = new CluNetSpanningTree(graph);
			long start = System.currentTimeMillis();
			tree.convertToMaxSpanningTree();
			tree.printTreeLinks();
			long end = System.currentTimeMillis();

			nodes[i] = V;
			millis[i] = end - start;
			i++;

			assertEquals("Max Spanning tree edges should be exactly V-1", tree.getMstLinks().size(), (V - 1));
		}

		try {
			generateGraph(nodes, millis);
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
	}

	private void generateGraph(double[] nodes, double[] millis) throws IOException {
		createDirectory("target/results");
		XYChart chart = QuickChart.getChart("Performance", "Number of Nodes in G",
				"Time Taken for Maximum Spanning Tree T of G", "millis(nodes)", nodes, millis);
		new SwingWrapper<XYChart>(chart).displayChart();
		BitmapEncoder.saveBitmap(chart, "./target/results/performance_plot", BitmapFormat.PNG);
		BitmapEncoder.saveBitmapWithDPI(chart, "./target/results/performance_plot_100_dpi", BitmapFormat.PNG, 100);

		LOG.info("Please look at target/results/performance_plot for nodes vs time distribution");

	}

	private void createDirectory(String dir) {
		File directory = new File(dir);
		if (!directory.exists()) {
			directory.mkdir();
		} else {
			directory.delete();
			directory.mkdir();
		}
	}

}
