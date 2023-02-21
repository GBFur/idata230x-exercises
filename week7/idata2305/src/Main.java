import booking.MovieTicketServer;
import booking.MovieTicketClient;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MovieTicketServer movieTicketServer = new MovieTicketServer(
                "Troll",
                10, false);

        MovieTicketServer movieTicketServerUnsynchronized = new MovieTicketServer("Troll", 10, true);

        Thread t1 = new MovieTicketClient(movieTicketServer, "Xiangming", 3, true);
        Thread t2 = new MovieTicketClient(movieTicketServer, "Ilaria", 2, true);
        Thread t3 = new MovieTicketClient(movieTicketServer, "Sam", 3, true);
        Thread t4 = new MovieTicketClient(movieTicketServer, "Andreas", 4, true);

        System.out.println("Syncronized:");

        // Starting all threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        Thread.sleep(1000L); //Sleeps the thread, ensures the first threads is done before second job.
        System.out.println(" ");

        System.out.println("Not syncronized:");

        // Creating 4 threads
        Thread t1s = new MovieTicketClient(movieTicketServerUnsynchronized, "Xiangming", 3, false);
        Thread t2s = new MovieTicketClient(movieTicketServerUnsynchronized, "Ilaria", 2, false);
        Thread t3s = new MovieTicketClient(movieTicketServerUnsynchronized, "Sam", 3, false);
        Thread t4s = new MovieTicketClient(movieTicketServerUnsynchronized, "Andreas", 4, false);

        // Starting all threads
        t1s.start();
        t2s.start();
        t3s.start();
        t4s.start();
    }
}