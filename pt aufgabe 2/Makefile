all:	addition minimum conversion

addition:
	javac addition01/Addition.java -d ./

minimum:
	javac zahlenminimum/MinimumFinder.java zahlenminimum/In.java -d ./

conversion: f2c c2f

f2c:
	javac tempconv/F2C.java tempconv/Fahrenheit.java tempconv/Conversion.java -d ./

c2f:
	javac tempconv/C2F.java tempconv/Celsius.java tempconv/Conversion.java -d ./


clean:
	rm *.class
