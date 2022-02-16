import java.util.Scanner;

public class AirplaneSeatAssignment
{
    public static void DesiredSeat (String seatChosen)
    {
        Random random = new Random();
        int[][] airlineSeat = new int [13][9];
    }
    public static void main(String[] args) throws Exception 
    {
        System.out.println("Welcome to Ymirates Airline!");
        System.out.println("");
        System.out.println("Enter the following information:");
    
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        System.out.println("Select ticket type " + ("(First Class, Business Class, or Economy Class") + input);

        
        scanner.close();
    }
}
