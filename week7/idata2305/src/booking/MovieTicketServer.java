package booking;

public class MovieTicketServer {
  private String movieName;
  private int availableSeats;

  public MovieTicketServer(String movieName, int availableSeats) {
    this.availableSeats = availableSeats;
    this.movieName = movieName;
  }

  /**
   * Run the unsynchronized boot ticket method wrapped in a synhronized method.
   * 
   * @param customerName
   * @param numberOfSeats
   */
  public synchronized void bookTicketSynchronized(String customerName, int numberOfSeats) {
    this.bookTicketUnsynchronized(customerName, numberOfSeats);
  }

  /**
   * Unsynchronized boot ticket.
   * 
   * @param customerName
   * @param numberOfSeats
   */
  public void bookTicketUnsynchronized(String customerName, int numberOfSeats) {
    System.out.println("Hi, " + customerName + " There is " + availableSeats + " Seats available for " + movieName);

    if ((availableSeats - numberOfSeats) < 0) {
      System.out.println("Hi, " + customerName + " Sorry but there is no seats available for " + movieName);
      return;
    }

    System.out.println("Hi, " + customerName + " " + numberOfSeats + " Seats booked successfully for " + movieName);
    this.availableSeats = availableSeats - numberOfSeats;
  }
}