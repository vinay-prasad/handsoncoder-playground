#!/bin/bash
echo "This test runs simple test to demonstrate generation of static and random connected graph, converting it to its maximum spanning tree and finding the best bottleneck solution."
read -n 1 -s -r -p "Press any key to continue"
mvn clean -Dtest=DemoTest test  
