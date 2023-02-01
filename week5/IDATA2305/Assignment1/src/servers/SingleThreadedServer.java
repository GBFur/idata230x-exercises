package servers;

import java.io.IOException;
import java.net.ServerSocket;

import computation.SearchSimulator;

public class SingleThreadedServer implements Runnable {

  protected int serverPort = 8080;
  protected ServerSocket serverSocket = null;
  protected boolean isStopped = false;

  public SingleThreadedServer(int port) {
    this.serverPort = port;
  }

  public void run() {

    openServerSocket();

    while (!isStopped()) {
      // wait for a connection
      // on receiving a request, execute the heavy computation
      try {
        var clientSocket = this.serverSocket.accept();
        SearchSimulator.processClientRequest(clientSocket);
      } catch (Exception e) {
        System.out.println("Server stopped?");
      }


    }

    System.out.println("Server Stopped.");
  }

  private synchronized boolean isStopped() {
    return this.isStopped;
  }

  public synchronized void stop() {
    // implementation to stop the server from the main thread if needed
    this.isStopped = true;
    try {
      this.serverSocket.close();
    } catch (IOException e) {
      throw new RuntimeException();
    }
  }

  private void openServerSocket() {
    try {
        this.serverSocket = new ServerSocket(this.serverPort);
    } catch (IOException e) {
        throw new RuntimeException("can't open socket port");
    }
}
}