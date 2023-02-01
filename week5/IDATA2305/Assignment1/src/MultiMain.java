import servers.MultiThreadedServer;

public class MultiMain {

  public static void main(String[] args) {
    new Thread(new MultiThreadedServer(8080)).start();
  }

  
  
}
