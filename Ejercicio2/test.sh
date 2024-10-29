#!/bin/sh

javac -d bin -cp /usr/share/java/junit-jupiter-api.jar --source-path src:test test/conjunto/LinkedListSetTest.java

java -jar /usr/share/java/junit-platform-console-standalone.jar --class-path bin --scan-class-path

