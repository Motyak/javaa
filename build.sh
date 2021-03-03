#!/bin/sh
javac Mk/*.java &&
jar cf Mk/Mk.jar Mk/*.class &&
rm Mk/*.class &&
javac -cp Mk/Mk.jar Main.java