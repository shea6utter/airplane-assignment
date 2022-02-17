import java.util.Random;
import java.util.Scanner;
import java.lang.StringBuilder;

public class AirplaneSeatAssignment
{
    static String[] initTicket()
    {
        String[] ticket = {"First Class","Business Class",
        "Economy Class"};

        for (int i = 0; i < ticket.length; i++)
            System.out.println(ticket[i]);
        
        return ticket;

    }
    
    static void selectTicket (String TicketType)
    {
        switch (TicketType)
        {
            case "First Class":
                System.out.println("You have a First Class ticket.");
                System.out.println("Select a seat in Rows 1-2.");
                break;
            case "Business Class":
                System.out.println("You have a Business Class ticket.");
                System.out.println("Select a seat in Rows 3-7.");
                break;
            case "Economy Class":
                System.out.println("You have an Economy Class ticket.");
                System.out.println("Select a seat in Rows 8-13.");
                break;
            default:
                System.out.println("Invalid selection. Please try again.");

        }
    }

    static String selectTicket2()
    {
        Scanner scanner = new Scanner(System.in);

        String TicketType;
        System.out.print("Select ticket type: ");  
        TicketType = scanner.nextLine();
        System.out.print(dashedLine());

        selectTicket(TicketType);
        System.out.print(dashedLine());

        scanner.close();
        return TicketType;
    }

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

    static String dashedLine()
    {
        StringBuilder sb = new StringBuilder(20);
        for (int n = 0; n < 20; ++n)
            sb.append('-');
        sb.append(System.lineSeparator());
        
        return sb.toString();
    }
    public static void main(String[] args) throws Exception 
    {

        System.out.print(dashedLine());
        System.out.println("Welcome to Ymirates Airline!");
        
        System.out.print(dashedLine());
        System.out.println("Enter the following information.");
        System.out.print(dashedLine());

        System.out.println("Ticket Types: ");
        System.out.println("");
        initTicket();
        System.out.print(dashedLine());

        selectTicket2();
      
        char[][] airlineSeat = new char [13][9];
        initSeat(airlineSeat);
    }
}
