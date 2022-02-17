import java.util.Random;
import java.lang.StringBuilder;
import java.util.*;

public class AirplaneSeatAssignment {

    private static char AirlineSeat[][];
    static Scanner scanner = new Scanner(System.in);

    /*
    * SEATS
    */

    static void FreeAirlineSeat() {
        for (int x = 0; x < AirlineSeat.length ; x++) {
            for (int y = 0; y < AirlineSeat[0].length; y++) {
                AirlineSeat[x][y] = '*';
            }
        }
    }
    
    static void RandomAirlineSeat() {
        Random random = new Random();
        int max = 10;
        int min = 1;
        
        for (int x = 0; x < AirlineSeat.length; x++) {
            for (int y = 0; y > AirlineSeat[0].length; y++) {
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

    static void DisplaySeats() {
        System.out.printf("%8s ", "");
        char a = 'A';
            for (int label = 0; label < AirlineSeat[0].length; label++) {
                System.out.printf("%5s ", a + "");
                a++;
            }
            System.out.println();

            for (int x = 0; x < AirlineSeat.length; x++) {

                System.out.printf("%8s ", "Row " + (x + 1));
                    for (int y = 0; y < AirlineSeat[0].length; y++) {
                        System.out.printf("%5s ", AirlineSeat[x][y] + "");
                    }
                System.out.println();
            }
    }
    
    static void SeatSelect (int rowMin, int rowMax) {
        int row = 0;

        do {
            System.out.println("Select a row between " + rowMin + " and " + rowMax + ": ");
            try {
                row = Integer.parseInt(scanner.nextLine());
                    if (row < rowMin || row > rowMax) {
                        System.out.println("Inapplicable row. Try again");
                    }
            } catch (Exception e) {
                System.out.println("Inapplicable input. Try again.");
            }                   
        } while (row < rowMin || row > rowMax);
            char selected = ' ';
            char max = (char) ('A' + AirlineSeat[0].length - 1);

        do {
            System.out.println("Choose a seat between 'A' to '" + max + "' : ");
                try {
                selected = scanner.nextLine().toUpperCase().charAt(0);
                    if (selected < 'A' || selected > max) {
                        System.out.println("Invalid seat. Try again.");
                    }
                } catch (Exception e) {
                    System.out.println("Error. Try Again.");
                }
        } while (selected < 'A' || selected > max);
            int x = row - 1;
            int y = selected - 'A';

                    if (AirlineSeat[x][y] == 'X') {
                        System.out.println("Seat is unavailable.");
                    } else {
                        AirlineSeat[x][y] = 'X';
                        System.out.println("Successfully booked seat.");
                    }
    }
    
    /*
    * TICKETS
    */

    static String[] initTicket() {

        System.out.print(dashedLine());
        System.out.println("Ticket Types: ");
        System.out.println("");

        String[] ticket = {"F - First Class","B - Business Class",
        "E - Economy Class"};

        for (int i = 0; i < ticket.length; i++) {
            System.out.println(ticket[i]);
        }
        System.out.print(dashedLine());
        System.out.println("Q - Quit Program");
        return ticket;

    }
    
    static void selectTicket () {

        String TicketType = "";
        
        while(!TicketType.equalsIgnoreCase("Q")) {

            DisplaySeats();
            initTicket();
            System.out.print("Select ticket type: ");  
            TicketType = scanner.nextLine();

            switch (TicketType.toUpperCase()) {
                case "F":
                    System.out.println("You have a First Class ticket.");    
                    SeatSelect(1, 2);
                    break;
                case "B":
                    System.out.println("You have a Business Class ticket.");
                    SeatSelect(3, 7);
                    break;
                case "E":
                    System.out.println("You have an Economy Class ticket.");
                    SeatSelect(8, 13);
                    break;
                case "Q":
                    System.out.println("Thank you for choosing Ymirates Airline!");
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
                    break;
            }
        }  
    }

    

    static String dashedLine() {
        StringBuilder sb = new StringBuilder(20);
        for (int n = 0; n < 20; ++n)
            sb.append('-');
        sb.append(System.lineSeparator());
        
        return sb.toString();
    }
    public static void main(String[] args) throws Exception {

        System.out.print(dashedLine());
        System.out.println("Welcome to Ymirates Airline!");
        
        System.out.print(dashedLine());
        System.out.println("Enter the following information.");
        System.out.print(dashedLine());

        AirlineSeat = new char[13][6];

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
        selectTicket();
    }
}
