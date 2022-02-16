import java.util.Random;
import java.util.Scanner;

public class AirplaneSeatAssignment
{
    /**
     * initTicket Method
     * @param TicketType
     *  Display and selection of ticket types.
     */
    static String[] initTickets()
    {
        String[] ticket = {"First Class (Row 1-2)","Business Class (Row 3-7)",
        "Economy Class (Row 8-13)"};

        for (int i = 0; i < ticket.length; i++)
            System.out.println(ticket[i]);
        
        return ticket;
    }
    
    static void displayTickets (String TicketType)
    {
        if (TicketType.equalsIgnoreCase("First Class (Row 1-2)"))
        {
            System.out.println("You have selected " + TicketType);
        }
    
    }
    /**
     * 
     * @param args
     * @throws Exception
     */
    
    static void initSeat (char[][] airlineSeat)
    {
        Random random = new Random();

        for (int x = 0; x < 13; x++)
            for (int y = 0; y < 6; y++)
                airlineSeat[x][y] = (char) random.nextInt();
   
    }

    static void SeatDisplay (int[][] initSeat)
    {
        for (int a = 0; a < 13; a++)
            for (int b = 0; b < 6; b++)
                System.out.println(initSeat[a][b] + "\t");
    }
    public static void main(String[] args) throws Exception 
    {
        System.out.println("--------------------------------");
        System.out.println("Welcome to Ymirates Airline!");
        System.out.println("--------------------------------");
        System.out.println("Enter the following information.");
        System.out.println("--------------------------------");

        System.out.println("Ticket Types: ");
        System.out.println("");
        initTickets();

        Scanner scanner = new Scanner(System.in);
        String TicketType;  
        System.out.print("Select ticket type: ");
        displayTickets(TicketType = scanner.nextLine());

        char[][] airlineSeat = new char [13][9];
        initSeat(airlineSeat);

        scanner.close();
    }
}
