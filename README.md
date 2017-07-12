# coding-sample-001

# Input format:
~~~~
[Sort order],[max pieces per pack],[max weight per pack]
[item id],[item length],[item quantity],[piece weight]
[item id],[item length],[item quantity],[piece weight]
[item id],[item length],[item quantity],[piece weight]
...
~~~~
# Output format:
~~~~
Pack number: [pack number]
[item id],[item length],[item quantity],[piece weight]
[item id],[item length],[item quantity],[piece weight]
...
Pack Length: [pack length], Pack Weight: [pack weight]
~~~~
# STD input example: (input ends when an empty line is received or you reach the end of the input stream)
~~~~
NATURAL,40,500.0
1001,6200,30,9.653
2001,7200,50,11.21
~~~~
# Example output for the above input:
~~~~
Pack Number: 1
1001,6200,30,9.653
2001,7200,10,11.21
Pack Length: 7200, Pack Weight: 401.69
Pack Number: 2
2001,7200,40,11.21
Pack Length: 7200, Pack Weight: 448.4
~~~~

# How to run

~~~~
java -cp target/coding-sample-001-1.0-SNAPSHOT.jar nz.co.manasys.App
~~~~
# Run with test file as input
~~~~
java -cp target/coding-sample-001-1.0-SNAPSHOT.jar  nz.co.manasys.App  < src/test/resources/input002.txt
~~~~

Now copy and paste data into stdin

There are sample input files in src/test/resources 
