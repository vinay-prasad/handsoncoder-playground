package org.ucf.assignment.daa.clunet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CluNetSpanningTree {
	private int V;
	private List<CommunicationLink> graphLinks;
	private List<CommunicationLink> mstLinks;

	public CluNetSpanningTree(int v, List<CommunicationLink> graphLinks) {
		super();
		V = v;
		this.graphLinks = graphLinks;
		mstLinks = new ArrayList<CommunicationLink>(V-1);
	}

	private int findParent(int v, int[] parent) {
		if (parent[v] == v) {
			return v;
		}
		return findParent(parent[v], parent);
	}

	public List<CommunicationLink>  getMaxSpanningTree() {
		Collections.sort(graphLinks);

		// union
		int[] parent = new int[V];
		for (int i = 0; i < V; i++) {
			parent[i] = i;
		}
		int count = 0; // to count edges added to MST
		int i = 0; // denotes current edge on sorted edges
		while (count != V - 1) {
			CommunicationLink currentLink = graphLinks.get(i);
			// Check if we can add in MST or not
			int sourceNodeParent = findParent(currentLink.sourceNode, parent);
			int destinationNodeParent = findParent(currentLink.destinationNode, parent);

			// if source-parent and destination parent are different then it can be added
			if (sourceNodeParent != destinationNodeParent) {
				mstLinks.add(currentLink);
				count++;
				parent[sourceNodeParent] = destinationNodeParent;
			}
			i++;
		}
		System.out.println(String.format("%-12s|%-12s|%12s", "source", "destination", "bandwidth"));
		for (CommunicationLink link : mstLinks) {
			System.out.println(String.format("%-12s|%-12s|%12s", link.sourceNode, link.destinationNode,
					link.bandwidth));
		}
		return mstLinks;
		
	}
}
