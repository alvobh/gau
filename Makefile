comp:
	javac -extdirs jars -d dist models/*.java tests/*.java

run:
	java dist/gau/Main

