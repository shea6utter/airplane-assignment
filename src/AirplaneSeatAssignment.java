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
    
    static void RandomAirlineSeat () {
        Random random = new Random();
        int max = 10;
        int min = 1;
        
        for (int x = 0; x < AirlineSeat.length; x++) {
            for (int y = 0; y > AirlineSeat[0].length; y++) {
                int r = random.nextInt (max + min) + min;
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

    static void DisplaySeats () {
        System.out.printf("%8s ", "");

        char a = 'A';
            for (int label = 0; label < AirlineSeat.length; label++) {
                System.out.printf("%5s ", a + "");
                a++;
            }
            System.out.println();

            for (int x = 0; x < AirlineSeat.length; x++) {
                System.out.printf("%8s ", "Row" + (x + 1));
                    for (int y = 0; y < AirlineSeat[0].length; y++) {
                        System.out.printf("%5s ", AirlineSeat[x][y] + "");
                    }
                System.out.println();
            }
    }
    
    static void SeatSelect (int rowMin, int rowMax) {
        int row = 0;

        do {
            System.out.println("Choose a row between " + rowMin + " and "+ rowMax + ": ");
            try {
                row = Integer.parseInt(scanner.nextLine());
                    if (row < rowMin || row > rowMax) {
                        System.out.println("Invalid row! Try again");
                    }
            } catch (Exception e) {
                System.out.println("Invalid input! Try again");
            }                   
        } while (row < rowMin || row > rowMax);
            char seat = ' ';
            char max = (char) ('A' + AirlineSeat[0].length - 1);

        do {
            System.out.println("Choose a seat between 'A' to '" + max + "' : ");
                try {
                AirlineSeat = scanner.nextLine().toUpperCase().charAt(0);
                    if (AirlineSeat < 'A' || AirlineSeat > max) {
                        System.out.println("Invalid seat. Please Try again");
                    }
                } catch (Exception e) {
                    System.out.println("Input Error. Please Try Again");
                }
        } while (AirlineSeat < 'A' || AirlineSeat > max);
            int x = row - 1;
            int y = seat - 'A';

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
        String[] ticket = {"F - First Class","B - Business Class",
        "E - Economy Class"};

        for (int i = 0; i < ticket.length; i++)
            System.out.println(ticket[i]);
        
        return ticket;

    }
    
    static void selectTicket (String TicketType) {
        switch (TicketType.toUpperCase()) {
            case "F":
                System.out.println("You have a First Class ticket.");
                System.out.println("Select a seat in Rows 1-2.");
                SeatSelect(1, 2);
                break;
            case "B":
                System.out.println("You have a Business Class ticket.");
                System.out.println("Select a seat in Rows 3-7.");
                SeatSelect(3, 7);
                break;
            case "E":
                System.out.println("You have an Economy Class ticket.");
                System.out.println("Select a seat in Rows 8-13.");
                SeatSelect(8, 13);
                break;
            case "Q":
                System.out.println("Thank you for choosing Ymirates Airline!");
            default:
                System.out.println("Invalid selection. Please try again.");

        }
    }

    static String selectTicket2() {
        String TicketType;

        System.out.print("Select ticket type: ");  
        TicketType = scanner.nextLine();
        System.out.print(dashedLine());

        selectTicket(TicketType);
        System.out.print(dashedLine());

        return TicketType;
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

        AirlineSeat = new char [13][6];

        String option;

        System.out.print("View available seats? (Y/N): ");
            option = scanner.nextLine();

                switch (option.toUpperCase()) {
                    case "Y":
                        FreeAirlineSeat();
                        break;
                    case "N":
                        RandomAirlineSeat();
                        break;
                    default:
                        System.out.println("Invalid option");
                }

        System.out.println("Ticket Types: ");
        System.out.println();
        initTicket();
        System.out.print(dashedLine());

        selectTicket2();
              
    }
}
