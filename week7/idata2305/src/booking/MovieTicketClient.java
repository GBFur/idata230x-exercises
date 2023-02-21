package booking;

import javax.print.event.PrintJobAdapter;

public class MovieTicketClient extends Thread {
  private String customerName;
  private int numberOfSeats;
  private MovieTicketServer movieTicketServer;
  private boolean isSynchronized;

  public MovieTicketClient(MovieTicketServer movieTicketServer, String customerName, int numberOfSeats, boolean isSynchronized) {
    this.customerName = customerName;
    this.numberOfSeats = numberOfSeats;
    this.movieTicketServer = movieTicketServer;
    this.isSynchronized = isSynchronized;
  }

  @Override
  public void run() {
    this.movieTicketServer.bookTicket(customerName, numberOfSeats, isSynchronized);
  }
}