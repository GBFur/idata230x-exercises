Setup:

1. Compile the code to bytecode

```bash
javac -sourcepath ./src -d ./out ./src/*.java
```

2. Run the desired type of server.

For single threaded server:
```bash
java -cp ./out MultiMain
```

For single threaded server:
```bash
java -cp ./out SingleMain
```

Observations:

When we run multiple requests on the single threaded server, the request will run one at a time.''
But running at the multi threaded server, the requests are able to be processed concurrently.
In general this allows for a faster application if multiple threads are used.

Using postman to test the application, results in a exception.
Therefore we recommend requesting by iwr or curl to the server.

[Video showing the result](https://github.com/GBFur/idata230x-exercises/blob/main/week5/IDATA2305/Assignment1/assignment1-video.mkv)
