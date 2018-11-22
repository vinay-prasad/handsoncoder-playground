#!/bin/bash
echo "This script builds the project."
read -n 1 -s -r -p "Press any key to continue"
mvn clean install -Dmaven.test.skip=true 
