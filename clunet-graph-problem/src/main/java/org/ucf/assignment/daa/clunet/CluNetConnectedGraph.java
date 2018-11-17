package org.ucf.assignment.daa.clunet;

import java.util.ArrayList;
import java.util.List;

public class CluNetConnectedGraph {
	private int V;
	private int E;

	private List<CommunicationLink> graphLinks;

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

	public CluNetConnectedGraph(int v, int e) {
		super();
		V = v;
		E = e;
		graphLinks = new ArrayList<CommunicationLink>(E);
	}

	public void addLink(int source, int destination, int bandwidth) {
		this.graphLinks.add(new CommunicationLink(source, destination, bandwidth));
	}

	public void printGraphLinks() {
		System.out.println(String.format("%-12s|%-12s|%12s", "source", "destination", "bandwidth"));
		for (CommunicationLink link : graphLinks) {
			System.out
					.println(String.format("%-12s|%-12s|%12s", link.sourceNode, link.destinationNode, link.bandwidth));
		}
	}
}
