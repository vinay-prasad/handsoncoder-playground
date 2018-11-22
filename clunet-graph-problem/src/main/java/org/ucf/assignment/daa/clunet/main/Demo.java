package org.ucf.assignment.daa.clunet.main;

import org.apache.log4j.Logger;
import org.ucf.assignment.daa.clunet.CluNetConnectedGraph;
import org.ucf.assignment.daa.clunet.CluNetSpanningTree;
import org.ucf.assignment.daa.clunet.util.GraphUtils;
import org.ucf.assignment.daa.clunet.util.Utils;

/***
* 	This class demonstrates basic functionalities of the project. For complete functionalities 
* 	please refer to JUnit tests under src/test/java  
**/
public class Demo {

	public static final Logger LOG = Logger.getLogger(Demo.class);

	public static void test1() {
		CluNetConnectedGraph graph = getStaticGraph();
		int V = graph.getV();
		graph.printGraphLinks();
		GraphUtils demoGraph = new GraphUtils(graph);

		demoGraph.getBestBottleneck(2, 3);
		CluNetSpanningTree tree = new CluNetSpanningTree(graph);
		tree.getMaxSpanningTree();
		tree.printTreeLinks();
		GraphUtils demoTree = new GraphUtils(tree);
		demoTree.getBestBottleneck(2, 3);
	}

	public static void test2() {
		int V = 10;
		CluNetConnectedGraph graph = Utils.getConnectedGraph(V);

		graph.printGraphLinks();
		GraphUtils demoGraph = new GraphUtils(graph);

		demoGraph.getBestBottleneck(2, 3);
		LOG.info(demoGraph.isPathExist(2, 3));

		CluNetSpanningTree tree = new CluNetSpanningTree(graph);
		tree.getMaxSpanningTree();
		tree.printTreeLinks();
		GraphUtils demoTree = new GraphUtils(tree);
		demoTree.getBestBottleneck(2, 3);

		LOG.info(demoTree.isPathExist(2, 3));
	}

	public static void main(String[] args) {
		test1();
		test1();
	}

	private static CluNetConnectedGraph getStaticGraph() {
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
}
