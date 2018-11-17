package org.ucf.assignment.daa.clunet;

/***
 * @author Maheshwari, Radhika 
 * This class represents an edge of graph G = (V,E)
 * - sourceNode is the source site 
 * - destinationNode is the destination site 
 * - bandwidth represents the weight of the edge
 **/

public class CommunicationLink implements Comparable<CommunicationLink> {
	int sourceNode;
	int destinationNode;
	int bandwidth;

	public CommunicationLink(int sourceNode, int destinationNode, int bandwidth) {
		this.sourceNode = sourceNode;
		this.destinationNode = destinationNode;
		this.bandwidth = bandwidth;
	}

	public int compareTo(CommunicationLink compareLink) {
		// Maximum Spanning tree
		return compareLink.bandwidth - this.bandwidth;
		// Minimum Spanning Tree
		// return this.bandwidth - compareLink.bandwidth;
	}
}
