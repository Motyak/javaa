#!/bin/bash
javac Mk/*.java Main.java &&
jar cfm main.jar <(echo 'Main-Class: Main') Mk/*.class *.class &&
rm *.class Mk/*.class
