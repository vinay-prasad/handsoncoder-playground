package org.ucf.assignment.daa.clunet.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.ucf.assignment.daa.clunet.CluNetConnectedGraph;
import org.ucf.assignment.daa.clunet.CluNetSpanningTree;
import org.ucf.assignment.daa.clunet.CommunicationLink;
/* 
 */
/***
 * This class contains various utility methods to operate on the given graph to 
 * generate useful results like possible paths between two nodes, 
 * check if given graph is a connected graph, get weight/bandwidth of an edge etc. 
 **/
public class GraphUtils {
	public static final Logger LOG = Logger.getLogger(GraphUtils.class);

	private int V;
	private ArrayList<Integer>[] adjacentList;
	private List<CommunicationLink> graphLinks;
	private Map<String, Integer> edgesMap;

	public GraphUtils(CluNetConnectedGraph graph) {

		this.V = graph.getV();
		this.graphLinks = graph.getGraphLinks();
		this.edgesMap = new HashMap<String, Integer>(this.graphLinks.size());
		initAdjList(this.graphLinks);
	}

	public GraphUtils(CluNetSpanningTree tree) {

		this.V = tree.getV();
		this.graphLinks = tree.getMstLinks();
		this.edgesMap = new HashMap<String, Integer>(this.graphLinks.size());
		initAdjList(this.graphLinks);
	}

	public int getV() {
		return V;
	}

	public void setV(int v) {
		V = v;
	}

	public ArrayList<Integer>[] getAdjacentList() {
		return adjacentList;
	}

	public void setAdjacentList(ArrayList<Integer>[] adjacentList) {
		this.adjacentList = adjacentList;
	}

	public List<CommunicationLink> getGraphLinks() {
		return graphLinks;
	}

	public void setGraphLinks(List<CommunicationLink> graphLinks) {
		this.graphLinks = graphLinks;
	}

	public Map<String, Integer> getEdgesMap() {
		return edgesMap;
	}

	public void setEdgesMap(Map<String, Integer> edgesMap) {
		this.edgesMap = edgesMap;
	}

	@SuppressWarnings("unchecked")
	private void initAdjList(List<CommunicationLink> graphLinks) {
		adjacentList = new ArrayList[V];

		for (int i = 0; i < V; i++) {
			adjacentList[i] = new ArrayList<>();
		}

		for (CommunicationLink link : graphLinks) {
			this.edgesMap.put(link.getSourceNode() + "," + link.getDestinationNode(), link.getBandwidth());
			adjacentList[link.getSourceNode()].add(link.getDestinationNode());
			adjacentList[link.getDestinationNode()].add(link.getSourceNode());
		}

	}

	/**
	 * Returns list of all possible paths between two nodes of a graph
	 */
	public List<List<Integer>> getAllPossiblePaths(int s, int d) {
		List<List<Integer>> possiblePaths = new ArrayList<List<Integer>>();
		boolean[] isVisited = new boolean[V];
		ArrayList<Integer> pathList = new ArrayList<>();

		pathList.add(s);

		printAllPathsUtil(s, d, isVisited, pathList, possiblePaths);
		return possiblePaths;
	}

	/**
	 * Recursive method to print all the paths between two nodes of a graph
	 */
	private void printAllPathsUtil(Integer u, Integer d, boolean[] isVisited, List<Integer> localPathList,
			List<List<Integer>> possiblePaths) {

		isVisited[u] = true;

		if (u.equals(d)) {
			// LOG.info(localPathList);
			possiblePaths.add(new ArrayList<>(localPathList));
		}

		for (Integer i : adjacentList[u]) {
			if (!isVisited[i]) {
				localPathList.add(i);
				printAllPathsUtil(i, d, isVisited, localPathList, possiblePaths);

				localPathList.remove(i);
			}
		}

		isVisited[u] = false;
	}

	public boolean isPathExist(Integer s, Integer d) {
		boolean[] isVisited = new boolean[V];
		ArrayList<Integer> pathList = new ArrayList<>();

		pathList.add(s);

		return isPathFound(s, d, isVisited, pathList);
	}

	/**
	 * Finds if there is at least one path between two nodes
	 */
	private boolean isPathFound(Integer u, Integer d, boolean[] isVisited, List<Integer> localPathList) {

		isVisited[u] = true;

		if (u.equals(d)) {
			// LOG.info(localPathList);
			LOG.info("Path found " + localPathList);
			return true;
		}

		for (Integer i : adjacentList[u]) {
			if (!isVisited[i]) {
				localPathList.add(i);
				if (isPathFound(i, d, isVisited, localPathList)) {
					return true;
				} else {
					// continue
				}
				localPathList.remove(i);
			}
		}

		isVisited[u] = false;
		return false;
	}

	/**
	 * Returns the best bottleneck solution between two nodes of the given graph.
	 */
	public int getBestBottleneck(int source, int destination) {
		LOG.info("Possible paths from node " + source + " and " + destination);
		LOG.info("[Path] [bandwidth1 bandwidth2, ..] [min-bottleneck]");
		List<List<Integer>> paths = getAllPossiblePaths(source, destination);
		int max = 0;
		int min = Integer.MAX_VALUE;
		int currBandwidth = 0;
		for (List<Integer> path : paths) {
			List<Integer> bandwidthList = new ArrayList<Integer>();
			min = Integer.MAX_VALUE;
			for (int i = 0; i < path.size() - 1; i++) {
				String key = path.get(i) + "," + path.get(i + 1);
				String revKey = path.get(i + 1) + "," + path.get(i);
				if (this.edgesMap.containsKey(key)) {
					currBandwidth = this.edgesMap.get(key);
				} else {
					currBandwidth = this.edgesMap.get(revKey);
				}
				bandwidthList.add(currBandwidth);
				if (currBandwidth < min) {
					min = currBandwidth;
				}
			}
			if (min > max) {
				max = min;
			}

			LOG.info(path + " " + bandwidthList + "[" + min + "]");
		}
		LOG.info("\nBest Bottleneck [" + max + "]");
		return max;
	}
}
