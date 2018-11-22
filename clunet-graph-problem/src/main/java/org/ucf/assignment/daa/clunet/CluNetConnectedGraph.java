package org.ucf.assignment.daa.clunet;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/***
 * This class represents a CluNet's connected graph G = (V,E) where 
 *    -	V is the number of vertices 
 *    -	E is number of edges 
 *    -	graphLinks is a list of edges represented by CommunicationLink
 **/
public class CluNetConnectedGraph {
	public static final Logger LOG = Logger.getLogger(CluNetConnectedGraph.class);
	private int V;
	private int E;
	private List<CommunicationLink> graphLinks;
	
	public CluNetConnectedGraph(int v, int e) {
		super();
		V = v;
		E = e;
		graphLinks = new ArrayList<CommunicationLink>(E);
	}

	public int getV() {
		return V;
	}

	public void setV(int v) {
		V = v;
	}

	public int getE() {
		return E;
	}

	public void setE(int e) {
		E = e;
	}

	public List<CommunicationLink> getGraphLinks() {
		return graphLinks;
	}

	public void setGraphLinks(List<CommunicationLink> graphLinks) {
		this.graphLinks = graphLinks;
	}

	public void addLink(int source, int destination, int bandwidth) {
		this.graphLinks.add(new CommunicationLink(source, destination, bandwidth));
	}

	
	/**
	 * Prints the contents of graph G =(V,E) in terms of its edges
	 */
	public void printGraphLinks() {
		LOG.info("Graph G = (source, destination, bandwidth), (source, destination, bandwidth), .. \n ");
		if (this.graphLinks.size() > 0) {
			for (int i = 0; i < this.graphLinks.size() - 1; i++) {
				LOG.info(this.graphLinks.get(i).toString() + ",");
			}
			LOG.info(this.graphLinks.get(graphLinks.size() - 1));
		} else {
			LOG.info("[]");
		}
		LOG.info("\n");
	}
}
