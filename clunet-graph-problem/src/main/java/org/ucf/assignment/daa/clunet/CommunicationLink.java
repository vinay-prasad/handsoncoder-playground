package org.ucf.assignment.daa.clunet;

import org.apache.log4j.Logger;

/* 
 */
/***
 * This class represents an individual edge of graph G = (V,E) where 
 *    -	sourceNode is the source site 
 *    -	destinationNode is the destination site 
 *    -	bandwidth represents the weight of the edge
 **/

public class CommunicationLink implements Comparable<CommunicationLink> {
	public static final Logger LOG = Logger.getLogger(CommunicationLink.class);
	int sourceNode;
	int destinationNode;
	int bandwidth;

	
	public CommunicationLink(int sourceNode, int destinationNode, int bandwidth) {
		this.sourceNode = sourceNode;
		this.destinationNode = destinationNode;
		this.bandwidth = bandwidth;
	}
	
	public int getSourceNode() {
		return sourceNode;
	}

	public void setSourceNode(int sourceNode) {
		this.sourceNode = sourceNode;
	}

	public int getDestinationNode() {
		return destinationNode;
	}

	public void setDestinationNode(int destinationNode) {
		this.destinationNode = destinationNode;
	}

	public int getBandwidth() {
		return bandwidth;
	}

	public void setBandwidth(int bandwidth) {
		this.bandwidth = bandwidth;
	}

	/* 
	 * Below method will be used to print the contents of an edge in (source, destination, bandwidth) format
	 */
	public String toString() {
		return String.format("(%s,%s,%s)", this.sourceNode, this.destinationNode, this.bandwidth);
	}

	/* 
	 * Comparable's compareTo method overriding will help in sorting the list of 
	 * edges for Kruskal's algorithm. Current overriding will sort elements in descending order
	 */
	public int compareTo(CommunicationLink compareLink) {
		// Maximum Spanning tree
		return compareLink.bandwidth - this.bandwidth;
		// Minimum Spanning Tree
		// return this.bandwidth - compareLink.bandwidth;
	}
}
