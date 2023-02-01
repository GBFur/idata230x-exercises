import servers.SingleThreadedServer;

public class SingleMain {
  public static void main(String[] args) {
    new Thread(new SingleThreadedServer(8080)).start();
  }
}
