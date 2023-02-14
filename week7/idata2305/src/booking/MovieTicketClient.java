package booking;

public class MovieTicketClient extends Thread {
  private String customerName;
  private int numberOfSeats;
  private MovieTicketServer movieTicketServer;
  private Boolean isSynchronized;

  public MovieTicketClient(MovieTicketServer movieTicketServer, String customerName, int numberOfSeats) {
    this.customerName = customerName;
    this.numberOfSeats = numberOfSeats;
    this.movieTicketServer = movieTicketServer;
  }

  @Override
  public void run() {
    this.movieTicketServer.bookTicketUnsynchronized(customerName, numberOfSeats);
  }
}