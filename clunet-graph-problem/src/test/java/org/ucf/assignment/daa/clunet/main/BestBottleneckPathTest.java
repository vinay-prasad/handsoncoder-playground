package org.ucf.assignment.daa.clunet.main;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.ucf.assignment.daa.clunet.CluNetConnectedGraph;
import org.ucf.assignment.daa.clunet.CluNetSpanningTree;
import org.ucf.assignment.daa.clunet.util.GraphUtils;
import org.ucf.assignment.daa.clunet.util.Utils;
public class BestBottleneckPathTest {
	private static final String str = "----------------------------------";
	public static final Logger LOG = Logger.getLogger(BestBottleneckPathTest.class);

	@Test
	public void findBestBottleneckPathForConnectedGraphWithVertex3() {
		
		LOG.info(String.format("%-20s%-20s%-20s%-20s", str,str,str,str));
		LOG.info("Test findBestBottleneckPathForConnectedGraphWithVertex3()");
		int V = 3;
		int V1 = Utils.getRandomVertex(V, -1);
		int V2 = Utils.getRandomVertex(V, V1);
		CluNetConnectedGraph graph = Utils.getConnectedGraph(V);
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
		LOG.info("Expected and Actual Bottleneck Path are equal - " + expected);
	}

	@Test
	public void findBestBottleneckPathForConnectedGraphWithVertex4() {
		
		LOG.info(String.format("%-20s%-20s%-20s%-20s", str,str,str,str));
		LOG.info("Test findBestBottleneckPathForConnectedGraphWithVertex4()");
		int V = 4;
		int V1 = Utils.getRandomVertex(V, -1);
		int V2 = Utils.getRandomVertex(V, V1);
		CluNetConnectedGraph graph = Utils.getConnectedGraph(V);
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
		LOG.info("Expected and Actual Bottleneck Path are equal - " + expected);
	}
	@Test
	public void findBestBottleneckPathForConnectedGraphWithVertex5() {
		
		LOG.info(String.format("%-20s%-20s%-20s%-20s", str,str,str,str));
		LOG.info("Test findBestBottleneckPathForConnectedGraphWithVertex5()");
		int V = 5;
		int V1 = Utils.getRandomVertex(V, -1);
		int V2 = Utils.getRandomVertex(V, V1);
		CluNetConnectedGraph graph = Utils.getConnectedGraph(V);
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
		LOG.info("Expected and Actual Bottleneck Path are equal - " + expected);
	}

	@Test
	public void findBestBottleneckPathForConnectedGraphWithVertex6() {
		
		LOG.info(String.format("%-20s%-20s%-20s%-20s", str,str,str,str));
		LOG.info("Test findBestBottleneckPathForConnectedGraphWithVertex6()");
		int V = 6;
		int V1 = Utils.getRandomVertex(V, -1);
		int V2 = Utils.getRandomVertex(V, V1);
		CluNetConnectedGraph graph = Utils.getConnectedGraph(V);
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
		LOG.info("Expected and Actual Bottleneck Path are equal - " + expected);
	}

	@Test
	public void findBestBottleneckPathForConnectedGraphWithVertex7() {
		
		LOG.info(String.format("%-20s%-20s%-20s%-20s", str,str,str,str));
		LOG.info("Test findBestBottleneckPathForConnectedGraphWithVertex7()");
		int V = 7;
		int V1 = Utils.getRandomVertex(V, -1);
		int V2 = Utils.getRandomVertex(V, V1);
		CluNetConnectedGraph graph = Utils.getConnectedGraph(V);
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
		LOG.info("Expected and Actual Bottleneck Path are equal - " + expected);
	}

	@Test
	public void findBestBottleneckPathForConnectedGraphWithVertex8() {
		
		LOG.info(String.format("%-20s%-20s%-20s%-20s", str,str,str,str));
		LOG.info("Test findBestBottleneckPathForConnectedGraphWithVertex8()");
		int V = 8;
		int V1 = Utils.getRandomVertex(V, -1);
		int V2 = Utils.getRandomVertex(V, V1);
		CluNetConnectedGraph graph = Utils.getConnectedGraph(V);
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
		LOG.info("Expected and Actual Bottleneck Path are equal - " + expected);
	}

	@Test
	public void findBestBottleneckPathForConnectedGraphWithVertex9() {
		
		LOG.info(String.format("%-20s%-20s%-20s%-20s", str,str,str,str));
		LOG.info("Test findBestBottleneckPathForConnectedGraphWithVertex9()");
		int V = 9;
		int V1 = Utils.getRandomVertex(V, -1);
		int V2 = Utils.getRandomVertex(V, V1);
		CluNetConnectedGraph graph = Utils.getConnectedGraph(V);
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
		LOG.info("Expected and Actual Bottleneck Path are equal - " + expected);
	}

	@Test
	public void findBestBottleneckPathForConnectedGraphWithVertex10() {
		
		LOG.info(String.format("%-20s%-20s%-20s%-20s", str,str,str,str));
		LOG.info("Test findBestBottleneckPathForConnectedGraphWithVertex10()");
		int V = 10;
		int V1 = Utils.getRandomVertex(V, -1);
		int V2 = Utils.getRandomVertex(V, V1);
		CluNetConnectedGraph graph = Utils.getConnectedGraph(V);
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
		LOG.info("Expected and Actual Bottleneck Path are equal - " + expected);
	}

	@Test
	public void findBestBottleneckPathForConnectedGraphWithVertex11() {
		
		LOG.info(String.format("%-20s%-20s%-20s%-20s", str,str,str,str));
		LOG.info("Test findBestBottleneckPathForConnectedGraphWithVertex11()");
		int V = 11;
		int V1 = Utils.getRandomVertex(V, -1);
		int V2 = Utils.getRandomVertex(V, V1);
		CluNetConnectedGraph graph = Utils.getConnectedGraph(V);
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
		LOG.info("Expected and Actual Bottleneck Path are equal - " + expected);
	}

	@Test
	public void findBestBottleneckPathForConnectedGraphWithVertex12() {
		
		LOG.info(String.format("%-20s%-20s%-20s%-20s", str,str,str,str));
		LOG.info("Test findBestBottleneckPathForConnectedGraphWithVertex12()");
		int V = 12;
		int V1 = Utils.getRandomVertex(V, -1);
		int V2 = Utils.getRandomVertex(V, V1);
		CluNetConnectedGraph graph = Utils.getConnectedGraph(V);
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
		LOG.info("Expected and Actual Bottleneck Path are equal - " + expected);
	}



}
