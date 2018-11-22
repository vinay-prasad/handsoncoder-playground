#!/bin/bash
echo "This test generates 1000 connected graphs and convert each to its corresponding maximum spanning tree to achieve best bottleneck path. The execution results are plotted into a graph."
read -n 1 -s -r -p "Press any key to continue"
mvn clean -Dtest=PerformanceMetricsTest test 
