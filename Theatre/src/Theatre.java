


import java.io.FileWriter;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.*;


public class Theatre {
    private static ArrayList<Ticket> ticketArraylist = new ArrayList<>();
    public static boolean loop = true;
    public static float total = 0.0F;
    //Making arrays to indicate rows and seats
    public static void main(String[] args) {
        System.out.println("Welcome to the Theatre");
        Scanner sc = new Scanner(System.in);
        int[] row1 = new int[12];
        int[] row2 = new int[16];
        int[] row3 = new int[20];
        // filling arrays with 0
        Arrays.fill(row1, 0); //https://www.geeksforgeeks.org/how-to-fill-initialize-at-once-an-array-in-java/
        Arrays.fill(row2, 0);
        Arrays.fill(row3, 0);

        //Printing the menu
        while (loop) {
            System.out.println("------------------------------------------------------------------------------------------------------------");
            System.out.println("Please select an option:");
            System.out.println("01) Buy a Ticket");
            System.out.println("02) Print seating area");
            System.out.println("03) Cancel ticket");
            System.out.println("04) List available seats");
            System.out.println("05) Save to file");
            System.out.println("06) Load from file");
            System.out.println("07) Print ticket information and Total price");
            System.out.println("08) Sort ticket by price");
            System.out.println("         0)Quit");
            System.out.println("-------------------------------------------------------------------------------------------------------------");
            // using switch case method for selection.
            try {
                System.out.print("Enter option:");
                int option1 = sc.nextInt();
                switch (option1) {
                    case 1:
                        buy_ticket(row1, row2, row3);
                        print_seating_area(row1, row2, row3);

                        break;
                    case 2:
                        print_seating_area(row1, row2, row3);
                        break;
                    case 3:
                        cancel_ticket(row1, row2, row3);
                        break;
                    case 4:
                        show_available(row1, row2, row3);
                        break;
                    case 5:
                        save(row1, row2, row3);
                        break;
                    case 6:
                        load(row1, row2, row3);
                        break;
                    case 7:
                        showticketinfo();
                        break;
                    case 8:
                        sort_tickets();
                        break;
                    case 0:
                        leave();
                        break;
                    default:
                        System.out.println("Invalid option, please try again.");
                        break;
                }
            }catch (Exception e4){
                System.out.println("Invalid input");
                return;
            }
        }
    }
    public static void leave() {
        System.out.println("Thank you,Good bye!");
        loop = false;
    }
    // Option 01 //Task 03 // Getting the row ,seat no and personal info and the ticket prices.
    public static void buy_ticket(int[] row1, int[] row2, int[] row3) {
        while (loop){
            try {
                while (true) {
                    Scanner input = new Scanner(System.in);
                    System.out.print("Enter the row number: ");
                    int rowno = input.nextInt();
                    if (rowno<1 || rowno>3){
                        System.out.println("Enter a valid row number!");
                        continue;
                    }
                    System.out.print("Enter seat number: ");
                    int seatno = input.nextInt();
                    if (rowno ==1 && (seatno > row1.length) || (seatno < 1)){
                        System.out.println("Enter a valid seat number!");
                        continue;
                    }if (rowno ==2 && (seatno > row2.length) || (seatno < 1)){
                        System.out.println("Enter a valid seat number!");
                        continue;
                    }if (rowno ==3 && (seatno > row3.length) || (seatno < 1)){
                        System.out.println("Enter a valid seat number!");
                        continue;
                    }
                    seatno--;
                    switch (rowno){
                        case 1:
                            ticket_condition_check(row1,seatno,rowno);
                            break;
                        case 2:
                            ticket_condition_check(row2,seatno,rowno);
                            break;
                        case 3:
                            ticket_condition_check(row3,seatno,rowno);
                            break;
                    }break;
                }
            } catch (Exception e) {
                System.out.println("Enter a valid number!");
                continue;}
            break;
        }
    }
    //condition checking and booking the seat
    public static void ticket_condition_check(int []rownum,int seatno,int rowno) {
        if (rownum[seatno] == 1){
            System.out.println("Sorry, This seat is already booked!");
        } else {
            rownum[seatno] = 1;
            Scanner details = new Scanner(System.in);
            System.out.print("Enter Your Name: "); //getting name input
            String name = details.next();
            System.out.print("Enter Your Surname: "); //getting surname input
            String surname = details.next();
            System.out.print("Enter the email:");
            String email = details.next();
            while (loop){
                try {
                    Scanner tickpricein = new Scanner(System.in);
                    System.out.print("Enter the price: "); //getting the price input
                    float price = tickpricein.nextFloat();
                    person personinstance = new person(name,surname,email); //setting the instance of the person class
                    Ticket ticketinstance = new Ticket(rowno,seatno,price,personinstance); //setting the instance of the ticket class
                    ticketArraylist.add(ticketinstance); //adding the details to the array list
                    total += ticketinstance.getPrice(); //getting the price from a getter and add to the total
                    System.out.println("You Booked successfully");
                }catch (Exception e){
                    System.out.println("Enter a valid price!");
                    continue;}
                break;
            }
        }
    }
    //option2 //task04 // printing the seating area.
    public static void print_seating_area(int[] row1, int[] row2, int[] row3) {
        System.out.println("   ****************");
        System.out.println("   *    STAGE     *");
        System.out.println("   ****************");
        System.out.print("    ");
        for (int i = 0; i < row1.length; i++) {
            if (row1[i] == 0) {
                System.out.print("O");
            }
            if (row1[i] == 1) {
                System.out.print("X");
            }
            if (i == 5) {
                System.out.print(" ");
            }
        }
        System.out.print("\n" + "  ");
        for (int j = 0; j < row2.length; j++) {
            if (row2[j] == 0) {
                System.out.print("O");
            }
            if (row2[j] == 1) {
                System.out.print("X");
            }
            if (j == 7) {
                System.out.print(" ");
            }
        }
        System.out.println();
        for (int k = 0; k < row3.length; k++) {
            if (row3[k] == 0) {
                System.out.print("O");
            }
            if (row3[k] == 1) {
                System.out.print("X");
            }
            if (k == 9) {
                System.out.print(" ");
            }
        }
        System.out.println();

    }

    //option 3 //task05 // Canceling the booked tickets.
    public static void cancel_ticket(int[] row1, int[] row2, int[] row3) {
        Scanner cc = new Scanner(System.in);
        System.out.println("*****CANCELING THE SEAT*****");
        System.out.print("Enter the row number: ");
        int row = cc.nextInt();
        System.out.print("Enter the seat number:");
        int seat = cc.nextInt();

        if (row > 3) {  // try again this part try to expand the checking values
            System.out.println("Enter valid row  number.");

        } else {
            switch (row) {
                case 1:
                    mymethod2(row1, seat, row);
                    return;

                case 2:
                    mymethod2(row2, seat, row);
                    return;
                case 3:

                    mymethod2(row3, seat, row);
            }


        }
    }

    public static void mymethod2(int[] rowno, int seat, int row) {
        if (rowno[seat - 1] == 1) {
            rowno[seat - 1] = 0;
            cancel_condition_check(seat,row,ticketArraylist);
            System.out.println("The seat number " + seat + "in the row number " + row + " is has been canceled.");

        } else {
            System.out.println("This seat hasn't booked yet.");


        }


    }
    public static void cancel_condition_check(int seat,int row,ArrayList<Ticket>ticketArrayList) {

        for (int i =0;i<ticketArrayList.size();i++){
            if ((ticketArrayList.get(i).getRow() == row )&&( ticketArrayList.get(i).getSeat() == seat)){

                ticketArrayList.remove(i);
                i--;
            }
        }


    }


    //option 04 //task 06 //Showing available tickets.
    public static void show_available(int[] row1, int[] row2, int[] row3) {

        mymethod(row1, "row1");
        mymethod(row2, "row2");
        mymethod(row3, "row3");
    }

    public static void mymethod(int[] rowx, String rowname) {
        System.out.print("Seats available in " + rowname + ": ");
        int i = 0;
        int j = 1;
        while (i < rowx.length) {
            if (rowx[i] == 0) {
                System.out.print(j + ",");
            }
            j++;
            i++;
        }
        System.out.print("\b.");
        System.out.println();
    }
    // option 5 // Saving seating info to txt file.

    public static void save(int[] row1, int[] row2,int[]row3) {
        try {
            FileWriter file = new FileWriter("Available seats.txt");
            mymethod3(file, row1);
            mymethod3(file, row2);
            mymethod3(file, row3);
            file.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
        System.out.println("Successfully saved to file");
    }

    public static void mymethod3 (FileWriter file, int[] rowNumber) throws IOException {
        for (int i = 0; i <= (rowNumber.length - 1); i++){
            file.write(rowNumber[i] + " ");
        }
        file.write("\n");

    }



    //option 6 // Loading from the file
    public static void load(int[] row1,int[]row2,int[]row3){

        try{
            System.out.println("Loaded from the file!");
            File textfile = new File("Available seats.txt");
            Scanner fileReader = new Scanner(textfile);
            mymethod4(row1, fileReader);
            mymethod4(row2, fileReader);
            mymethod4(row3, fileReader);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public static void mymethod4(int[]rownum, Scanner fileReader){
        for (int i = 0; i <rownum.length; i++){
            rownum[i] = fileReader.nextInt();
        }
        fileReader.nextLine();
    }




    //option 7 // Showing the ticket info
    public static void showticketinfo(){
        if (ticketArraylist.size()==0){
            System.out.println("No tickets booked!");
        }
        for (int i =0;i< ticketArraylist.size();i++){
            ticketArraylist.get(i).print();
            System.out.println();
        }
        System.out.println("The Total price is : "+total+"£");
    }


    //option 08 // Sorting tickets according to price
    public static void sort_tickets (){
        //cloning the array list
        //https://www.geeksforgeeks.org/arraylist-clone-method-in-java-with-examples/
        ArrayList<Ticket> clonedlist = (ArrayList<Ticket>)ticketArraylist .clone();
        int size = clonedlist.size() - 2;
        Ticket temp;
        boolean looping = true;
        while (looping) {
            looping = false;
            for (int i = 0; i <= size; i++) {
                if (clonedlist.get(i).getPrice() > clonedlist.get(i+1).getPrice()) {
                    temp = clonedlist.get(i);
                    clonedlist.set(i, clonedlist.get(i+1));
                    clonedlist.set((i+1),temp);
                    looping = true;
                }
            }size--;
        }
        if (clonedlist.size()==0){
            System.out.println("No tickets booked!");
        }
        for (int i =0;i< clonedlist.size();i++){
            clonedlist.get(i).print();
            System.out.println();
        }
        System.out.println("The Total price is : "+total+"£");
    }




}





































