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