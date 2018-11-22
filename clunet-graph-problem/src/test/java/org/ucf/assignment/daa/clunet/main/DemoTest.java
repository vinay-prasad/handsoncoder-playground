package org.ucf.assignment.daa.clunet.main;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.ucf.assignment.daa.clunet.CluNetConnectedGraph;
import org.ucf.assignment.daa.clunet.CluNetSpanningTree;
import org.ucf.assignment.daa.clunet.util.GraphUtils;
import org.ucf.assignment.daa.clunet.util.Utils;

public class DemoTest {
	public static final Logger LOG = Logger.getLogger(DemoTest.class);
	public static final String str = "----------------------------------";

	@Test
	public void bestBottleneckOnAStaticGraphTest() {
		LOG.info(String.format("%-20s%-20s%-20s%-20s", str, str, str, str));
		LOG.info("Test bestBottleneckOnAStaticGraphTest()");
		CluNetConnectedGraph graph = getStaticGraph();
		int V = graph.getV();
		int V1 = Utils.getRandomVertex(V, -1);
		int V2 = Utils.getRandomVertex(V, V1);
		graph.printGraphLinks();

		CluNetSpanningTree tree = new CluNetSpanningTree(graph);
		tree.convertToMaxSpanningTree();
		tree.printTreeLinks();

		LOG.info("Finding best bottleneck path for Graph");
		GraphUtils graphUtil = new GraphUtils(graph);
		int expected = graphUtil.getBestBottleneck(V1, V2);

		LOG.info("\nFinding best bottleneck path for Tree");
		GraphUtils treeUtil = new GraphUtils(tree);
		int actual = treeUtil.getBestBottleneck(V1, V2);

		assertEquals("Expected and Actual Bottleneck Path are different", expected, actual);
	}

	private CluNetConnectedGraph getStaticGraph() {
		int V = 6, E = 11;
		CluNetConnectedGraph graph = new CluNetConnectedGraph(V, E);
		graph.addLink(0, 3, 3);
		graph.addLink(3, 5, 7);
		graph.addLink(0, 1, 2);
		graph.addLink(3, 4, 11);
		graph.addLink(2, 1, 8);
		graph.addLink(4, 5, 5);
		graph.addLink(0, 2, 4);
		graph.addLink(2, 5, 10);
		graph.addLink(2, 4, 9);
		graph.addLink(1, 3, 1);
		graph.addLink(2, 3, 6);
		return graph;
	}

	@Test
	public void bestBottleneckOnARandomGraphTest() {
		LOG.info(String.format("%-20s%-20s%-20s%-20s", str, str, str, str));
		LOG.info("Test bestBottleneckOnARandomGraphTest()");
		int V = Utils.getRandomVertex(30, -1);;
		CluNetConnectedGraph graph = Utils.getConnectedGraph(V);
		int V1 = Utils.getRandomVertex(V, -1);
		int V2 = Utils.getRandomVertex(V, V1);
		graph.printGraphLinks();

		CluNetSpanningTree tree = new CluNetSpanningTree(graph);
		tree.convertToMaxSpanningTree();
		tree.printTreeLinks();

		LOG.info("Finding best bottleneck path for Graph");
		GraphUtils graphUtil = new GraphUtils(graph);
		int expected = graphUtil.getBestBottleneck(V1, V2);

		LOG.info("\nFinding best bottleneck path for Tree");
		GraphUtils treeUtil = new GraphUtils(tree);
		int actual = treeUtil.getBestBottleneck(V1, V2);

		assertEquals("Expected and Actual Bottleneck Path are different", expected, actual);
	}

}
