
1. Compile the code to bytecode

```bash
javac -sourcepath ./src -d ./out ./src/*.java
```

2. 

2. Run the main class
```bash
java -cp ./out Main
```
Observation:
When the ticket server is running unsynchronized, the clients are getting the same variable at 10 seats.
Multiple threads read the same variable.

When using the synchronized ticket server, only one thread can execute at a time, so thread 1 will execute its work first,
then thread 2 etc... This means that the first thread that executes, is able to finish their work before a new thread starts.