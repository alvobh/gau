all: comp jar

comp:
	javac -extdirs jars -d dist *.java models/*.java tests/*.java

jar:
	jar cmf mainClass gau.jar gau

run:
	cd dist
	java -cp dist gau.Main

