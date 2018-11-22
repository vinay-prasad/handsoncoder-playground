#!/bin/bash
echo "This test verifies that bottleneck rate for any path u-v in spanning tree T is equal to best achievable bottleneck rate for the pair u-v in graph G"
read -n 1 -s -r -p "Press any key to continue"
mvn clean -Dtest=BestBottleneckPathTest test 
