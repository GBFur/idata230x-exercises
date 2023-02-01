package servers;

import java.io.IOException;
import java.net.ServerSocket;

import computation.AsyncSearchSimulator;

public class MultiThreadedServer implements Runnable {

  protected int serverPort;
  protected ServerSocket serverSocket;
  protected boolean isStopped = false;

  public MultiThreadedServer(int port) {
    this.serverPort = port;
  }

  public void run() {
    openServerSocket();

    while (!isStopped()) {
      // wait for a connection
      try {
        var clientSocket = this.serverSocket.accept();
        new Thread(
          new AsyncSearchSimulator(
              clientSocket,
              "Multithreaded Server"))
          .start();
      } catch (Exception e) {
        System.out.println("Server stopped");
      }
      // on receiving a request, execute the heavy computation in a new thread
    }

    System.out.println("Server Stopped.");
  }

  private synchronized boolean isStopped() {
    return this.isStopped;
  }

  public synchronized void stop() {
    // implementation to stop the server from the main thread if needed
    this.isStopped = true;
  }

  private void openServerSocket() {
    try {
      this.serverSocket = new ServerSocket(this.serverPort);
    } catch (IOException e) {
      throw new RuntimeException("can't open socket port");
    }
  }
}