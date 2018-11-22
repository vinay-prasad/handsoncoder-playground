#!/bin/bash
echo "This test generates random connected-graphs from nodes 3 to 12 with random and distinct weights. For each graph, we pick two random vertices and find if at least one path exists between the nodes (This is to prove that generated graph is a connected-graph)."
read -n 1 -s -r -p "Press any key to continue"
mvn clean -Dtest=GenerateConnectedGraphTest test 
