import java.util.Random;
import java.lang.StringBuilder;
import java.util.*;

public class AirplaneSeatAssignment {

    private static char AirlineSeat[][]; // initialize 2d array
    static Scanner scanner = new Scanner(System.in); // accessible scanner

    // Method for all available seats
    static void FreeAirlineSeat() {
        for (int x = 0; x < AirlineSeat.length ; x++) {
            for (int y = 0; y < AirlineSeat[0].length; y++) {
                AirlineSeat[x][y] = '*';
            }
        }
    }
    
    // Method for randomly preoccupied seats
    static void RandomAirlineSeat() {
        Random random = new Random();
        int max = 10; // in each column at least 10 seats are taken
        int min = 1; // in each row at least 1 seat is taken
        
        for (int x = 0; x < AirlineSeat.length; x++) {
            for (int y = 0; y < AirlineSeat[0].length; y++) {
                int r = random.nextInt(max + min) + min;
                    if (r > 5) {
                        AirlineSeat[x][y] = '*';
                    } else if (r < 5) {
                        AirlineSeat[x][y] = 'X';
                    } else {
                        AirlineSeat[x][y] = '*';
                    }
            }
        }
    }

    // Method for displaying seats
    static void DisplaySeats() {
        System.out.print(dashedLine()); // calling dashedLine();

        // printf to use %8s, which means that this format will transform the corresponding argument into a string
        System.out.printf("%8s ", ""); // empty space
        
        char a = 'A'; // printing row characters A to F
            for (int label = 0; label < AirlineSeat[0].length; label++) {
                // %5s is a right-aligned in a column of at least five characters. 
                System.out.printf("%5s ", a + "");
                a++;
            }
            System.out.println(); // line break

            // print rows in terminal
            for (int x = 0; x < AirlineSeat.length; x++) {
                System.out.printf("%8s ", "Row " + (x + 1));

                    // shows the rows in terminal
                    for (int y = 0; y < AirlineSeat[0].length; y++) {
                        System.out.printf("%5s ", AirlineSeat[x][y] + "");
                    }
                System.out.println();
            }
    }

    // Method for displaying ticket types
    static String[] initTicket() { 

        System.out.print(dashedLine());
        System.out.print("Ticket Types: ");
        System.out.println("");

        String[] ticket = {"<F> First Class ","<B> Business Class ",
        "<E> Economy Class ", "<Q> Quit Program"};

        for (int i = 0; i < ticket.length; i++) {
            System.out.print((ticket[i]));
        }
        System.out.println("");
        return ticket;

    }
    
    // Method for selecting tickets
    static void SelectTicket () {

        String TicketType = "";
        
        // if the input is not equal to Q/q the program will not terminate
        while(!TicketType.equalsIgnoreCase("Q")) {

            // calling the methods
            DisplaySeats();
            initTicket();

            System.out.print(dashedLine());
            System.out.print("Select ticket type: ");  
            TicketType = scanner.nextLine();
            System.out.print(dashedLine());

            // toUpperCase to read lowercase inputs
            switch (TicketType.toUpperCase()) {
                case "F":
                    System.out.println("You have a First Class ticket.");
                    SeatSelect(1, 2); // calling SeatSelect();
                    break;
                case "B":
                    System.out.println("You have a Business Class ticket.");
                    SeatSelect(3, 7);
                    break;
                case "E":
                    System.out.println("You have an Economy Class ticket.");
                    SeatSelect(8, 13);
                    break;
                case "Q": // terminates program
                    System.out.println("Thank you for choosing Ymirates Airline!");
                    System.out.print(dashedLine());
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
                    break;
            }
        }  
    }

        /*
    * Method for selecting a seat and displaying if it is
    * successful or incorrect
    */

    static void SeatSelect (int rowMin, int rowMax) {
        int row = 0; // declared as 0 since input is numerical

        do {
            System.out.println("Select a row between " + rowMin + " and " + rowMax + ": ");
            try {
                row = Integer.parseInt(scanner.nextLine());
                    if (row < rowMin || row > rowMax) {
                        System.out.println("Inapplicable row. Try again");
                        System.out.print(dashedLine());
                    }
            } catch (Exception e) {
                System.out.println("Inapplicable input. Try again.");
                System.out.print(dashedLine());
            }                   
        } while (row < rowMin || row > rowMax);
            char selected = ' ';
            char max = (char) ('A' + AirlineSeat[0].length - 1);
            
            // looking for last column
        do {
            System.out.println("Choose a seat between 'A' to '" + max + "' : ");
                try {
                selected = scanner.nextLine().toUpperCase().charAt(0);
                    if (selected < 'A' || selected > max) {
                        System.out.println("Invalid seat. Try again.");
                        System.out.print(dashedLine());
                    }
                } catch (Exception e) {
                    System.out.println("Error. Try Again.");
                    System.out.print(dashedLine());
                }
        } while (selected < 'A' || selected > max); // row & column to array index
            int x = row - 1;
            int y = selected - 'A';

                    // booking
                    if (AirlineSeat[x][y] == 'X') {
                        System.out.print(dashedLine());
                        System.out.println("Seat is unavailable.");
                        System.out.print(dashedLine());
                    } else {
                        AirlineSeat[x][y] = 'X';
                        System.out.print(dashedLine());
                        System.out.println("Successfully booked seat.");
                        System.out.print(dashedLine());
                    }
    }

    // Method for creating dash divisions
    static String dashedLine() {
        StringBuilder sb = new StringBuilder(40);
        for (int n = 0; n < 40; ++n)
            sb.append('-');
        sb.append(System.lineSeparator());
        
        return sb.toString();
    }
    public static void main(String[] args) throws Exception {

        // welcome message and intructions
        System.out.print(dashedLine());
        System.out.println("Welcome to Ymirates Airline!");
        
        System.out.print(dashedLine());
        System.out.println("Enter the following information.");
        System.out.print(dashedLine());

        AirlineSeat = new char[13][6]; // declaring the 2d array

        String option = "";
            
            System.out.print("View preoccupied seats? (Y/N): ");
            option = scanner.nextLine();
            
                switch (option.toUpperCase()) {
                    case "Y":
                        RandomAirlineSeat();
                        break;
                    case "N":
                        FreeAirlineSeat();
                        break;
                    default:
                        System.out.println("Invalid option. Try again.");
                        break;
                }
        // view & book seats, ticket types, and ticket select method
        SelectTicket();
    }
}
