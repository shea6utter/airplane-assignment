import java.util.Random;
import java.util.Scanner;

public class AirplaneSeatAssignment
{
    public static void Tickets (String TicketType)
    {
        String[] ticket = {"First Class","Business Class",
                           "Economy Class"};

        System.out.println(ticket[0] + "Row 1 to 2");
        System.out.println(ticket[1] + "Row 3 to 7");
        System.out.println(ticket[2] + "Row 8 to 13");

        Scanner scanner = new Scanner(System.in);

        String ticketChosen = scanner.next();
        System.out.println("Select ticket type: " + ticketChosen);

        Scanner.close();
    }

    public static void Seat (String DesiredSeat)
    {
        Random random = new Random();
        int[][] airlineSeat = new int [13][9];

        for(int x = 0; x < 13; x++)
            for (int y = 0; y < 9; y++)
                airlineSeat[x][y] = random.nextInt();

        
    }

    public static void main(String[] args) throws Exception 
    {
        System.out.println("Welcome to Ymirates Airline!");
        System.out.println("");
        System.out.println("Enter the following information:");
    }
}
