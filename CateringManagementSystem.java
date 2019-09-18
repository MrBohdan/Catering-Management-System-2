package cateringmanagementsystem;
import java.util.*;
import java.io.* ;

public class CateringManagementSystem {
    /**
     * declare the variable
     * private access level, because we using just one class
     */
    private static String clientsnum;
    private static double discountcount;
    private static double servicecount;
    private static double priceofmenue;
    private static double priceofserves;
    private static String typeofservice1, typeofservice2, typeofservice3, typeofservice4, typeofservice5;
    private static double priceofserves1, priceofserves2, priceofserves3, priceofserves4, priceofserves5;
    private static int orderid = (int) (Math.random() * 10000 + 1);
    private static String typeofmenu;
    private static String typeofservice;
    private static int totalcust;
    private static String discount;
    private static double totalprice;
    private static int admincount;
    private static String div = "-----";
    private static Scanner read = new Scanner(System.in);
  

    public static void main(String[] args) {

        MainMenu();
    }
    private static void MainMenu() {
        System.out.println("|----Welcome to Catering Management System----|");
        delimiter();
        System.out.println("[O]Order");
        System.out.println("[R]Report ");
        System.out.println("[P]Payment");
        System.out.println("[E]Exit");

        String inp;
        inp = read.nextLine();
        switch (inp) {
            case "O":
            case "o":
                Order();
                break;
            case "R":
            case "r":
                Report();
                break;
            case "P":
            case "p":
                Payment();
                break;
            case "E":
            case "e":
                exiting();
                break;
        }
        /**
         * use this to avoid errors and to make the program looped
         */
        if (inp != "O" || inp != "o" || inp != "R" || inp != "r" || inp != "P" || inp != "p" || inp != "E" || inp != "e" || inp.isEmpty()) {
            MainMenu();
        }
    }

    private static void Order() {
        Scanner read = new Scanner(System.in);
        System.out.println("|----Order module----|");
        delimiter();
        System.out.println("[F]Place orders for food");
        System.out.println("[S]Place orders for other services ");
        System.out.println("[M]Return to Main Menu");

        String inp1;
        inp1 = read.nextLine();

        switch (inp1) {
            case "F":
            case "f":
                OrdersForFood();
                break;
            case "S":
            case "s":
                OdersForOtherServices();
                break;
            case "M":
            case "m":
                ReturnToMainMenue();
                break;
        }

        if (inp1 != "F" || inp1 != "f" || inp1 != "S" || inp1 != "s" || inp1 != "M" || inp1 != "m" || inp1.isEmpty()) {
            MainMenu();
        }

    }

    private static void Payment() {
        System.out.println("|----Payment module----|");
        delimiter();
        System.out.println("[T]Display total amount to be paid");
        System.out.println("[P]Make payment");
        System.out.println("[M]Return to Main Menu");

        String inp2;
        inp2 = read.nextLine();

        switch (inp2) {
            case "T":
            case "t":
                DisplayTotalAmount();
                break;
            case "P":
            case "p":
                MakePayment();
                break;
            case "M":
            case "m":
                ReturnToMainMenue();
                break;
        }

        if (inp2 != "T" || inp2 != "t" || inp2 != "P" || inp2 != "p" || inp2 != "M" || inp2 != "m" || inp2.isEmpty()) {
            MainMenu();
        }

    }


    private static void Report() {
        System.out.println("|----Report module----|");

        delimiter();
        System.out.println("[I]Display the invoice for order made");
        System.out.println("[S]Display the summary of orders and payments made ");
        System.out.println("[M]Return to Main Menu");

        String inp3;
        inp3 = read.nextLine();

        switch (inp3) {
            case "I":
            case "i":
                SerachOrder();
                break;
            case "S":
            case "s":
                SummaryOfOrdersAndPayments();
                break;
            case "M":
            case "m":
                ReturnToMainMenue();
                break;
        }

        if (inp3 != "I" || inp3 != "i" || inp3 != "S" || inp3 != "s" || inp3 != "M" || inp3 != "m" || inp3.isEmpty()) {
            MainMenu();
        }
    }


    private static void OrdersForFood() {

        System.out.println("|----Type of menu----|");
        delimiter();
        System.out.println("[B] Breakfast (Charge per head: RM20.00)");
        System.out.println("---- Include ---- \n" + "Nasi lemak \n" + "Fried noodles \n" +
                "Roti chanai \n" + "Fried noodles \n" + "Pasta \n" + "Hot drink \n");
        System.out.println("[L]Lunch (Charge per head: RM30.00)");
        System.out.println("---- Include ---- \n" + "Chicken Chop \n" + "Steamed Fish \n" +
                "Salad \n" + "Fried Rice \n" + "Soft Drink \n");
        System.out.println("[BQ]BBQ (Charge per head: RM60.00)");
        System.out.println("---- Include ---- \n" + "Sausages with sautéed onions \n" + "Beef burgers with sautéed onions \n" +
                "Minted Lamb Kebabs\n" + "Potato salad \n");
        System.out.println("[AT]Afternoon Teas (Charge per head: RM15.50)");
        System.out.println("---- Include ---- \n" + "Assorted sandwiches\n" + "Prawn vol au vents \n" +
                "Smoked salmon canapés\n" + "Fresh cream scones with jam, cream and strawberries \n");

        Scanner input1 = new Scanner(System.in);
        String inp4;
        inp4 = input1.nextLine();

        switch (inp4) {
            case "B":
            case "b":
                typeofmenu = "Breakfast";
                priceofmenue = 20.00;
                break;
            case "L":
            case "l":
                typeofmenu = "Lunch";
                priceofmenue = 30.00;
                break;
            case "BQ":
            case "bq":
                typeofmenu = "BBQ";
                priceofmenue = 60.00;
                break;
            case "AT":
            case "at":
                typeofmenu = "Afternoon Teas";
                priceofmenue = 15.50;
                break;
        }
        System.out.println("---->Enter number of clients : ");
        clientsnum = input1.nextLine();
        /**
         * If input will be empty, system send you back to Food module
         */
        if (clientsnum.isEmpty()) {
            OrdersForFood();
        }
        /**
         * Convert String to Integer
         */
        totalcust = Integer.parseInt(clientsnum);
        Discount();
        input1.close();

    }

    private static void OdersForOtherServices() {
        Scanner input2 = new Scanner(System.in);
        System.out.println("|----Type of services----|");
        delimiter();
        System.out.println("[1]Tent: RM400 per one unit (10ft)");
        System.out.println("[2]Chairs: RM100 for 50 chairs");
        System.out.println("[3]Tables: RM80 for 10 tables");
        System.out.println("[4]Table cloths: RM20 for 10 table cloths");
        System.out.println("[5]Private room: RM2000 for 50 people");
        String in1;
        System.out.println("===>Select service (Or press 'Enter' to checkout)");
        in1 = input2.nextLine();
        if (in1.isEmpty()) {
            CoutnTotalAmount();
        }
        String unitsin;
        if (in1.equals("1")) {
            System.out.println("===>How many units you need?");
            typeofservice1 = "Tent";
            unitsin = input2.nextLine();
            if (unitsin.isEmpty()) {
                OdersForOtherServices();
            }
            servicecount = Integer.parseInt(unitsin);
            priceofserves1 = 400 * servicecount;
            CountForServices();
            System.out.println("It will cost: Rm" + priceofserves + " to continue press 'Enter'");
            String in2;
            in2 = input2.nextLine();
            OdersForOtherServices();
        }
        if (in1.equals("2")) {
            System.out.println("===>How many set of chairs you need?");
            typeofservice2 = "Chairs";
            unitsin = input2.nextLine();
            if (unitsin.isEmpty()) {
                OdersForOtherServices();
            }
            servicecount = Integer.parseInt(unitsin);
            priceofserves2 = 100 * servicecount;
            CountForServices();
            System.out.println("It will cost: Rm" + priceofserves + " to continue press 'Enter'");
            String in3;
            in3 = input2.nextLine();
            OdersForOtherServices();
        }
        if (in1.equals("3")) {
            System.out.println("===>How many set of tables you need?");
            typeofservice3 = "Tables";
            unitsin = input2.nextLine();
            if (unitsin.isEmpty()) {
                OdersForOtherServices();
            }
            servicecount = Integer.parseInt(unitsin);
            priceofserves3 = 80 * servicecount;
            CountForServices();
            System.out.println("It will cost: Rm" + priceofserves + " to continue press 'Enter'");
            String in4;
            in4 = input2.nextLine();
            OdersForOtherServices();
        }
        if (in1.equals("4")) {
            System.out.println("===>How many set of chairs you need?");
            typeofservice4 = "Table cloths";
            unitsin = input2.nextLine();
            if (unitsin.isEmpty()) {
                OdersForOtherServices();
            }
            servicecount = Integer.parseInt(unitsin);
            priceofserves4 = 20 * servicecount;
            CountForServices();
            System.out.println("It will cost: Rm" + priceofserves + " to continue press 'Enter'");
            String in5;
            in5 = input2.nextLine();
            OdersForOtherServices();
        }
        if (in1.equals("5")) {
            System.out.println("===>How many person come?(For each additional person RM30)");
            typeofservice5 = "Private room";

            unitsin = input2.nextLine();

            if (unitsin.isEmpty()) {
                OdersForOtherServices();
            }
            int guests = Integer.parseInt(unitsin);

            totalcust = guests + totalcust;
            if (guests < 50) {
                System.out.println("----'ERROR'----\n" + "We provide this service from 50 person to 150\n" + "press 'Enter'to continue...");
                String in5;
                in5 = input2.nextLine();
                OdersForOtherServices();
            }
            if (guests >= 50 && guests <= 150) {
                priceofserves5 = 2000;
                CountForServices();
                System.out.println("It will cost: Rm" + priceofserves + " to continue press 'Enter'");
                String in5;
                in5 = input2.nextLine();
                OdersForOtherServices();
            }
            if (guests >= 151) {
                guests = guests - 150;
                priceofserves5 = (30 * guests) + 2000;
                CountForServices();
                System.out.println("It will cost: Rm" + priceofserves + " to continue press 'Enter'");
                String in5;
                in5 = input2.nextLine();
                OdersForOtherServices();

            }
            input2.close();
        }
 
    }

    private static void Discount() {
        if (totalcust >= 10 && totalcust <= 25) {
            priceofmenue = totalcust * priceofmenue;
            discountcount = priceofmenue * 5 / 100;
            discount = "5%";
            CoutnTotalAmount();
        } else if (totalcust >= 26 && totalcust <= 50) {
            priceofmenue = totalcust * priceofmenue;
            discountcount = priceofmenue * 10 / 100;
            discount = "10%";
            CoutnTotalAmount();
        } else if (totalcust >= 51 && totalcust <= 100) {
            priceofmenue = totalcust * priceofmenue;
            discountcount = priceofmenue * 15 / 100;
            discount = "15%";
            CoutnTotalAmount();
        } else if (totalcust >= 100) {
            priceofmenue = totalcust * priceofmenue;
            discountcount = priceofmenue * 20 / 100;
            discount = "20%";
            CoutnTotalAmount();
        } else if (totalcust < 10) {
            priceofmenue = totalcust * priceofmenue;
            discount = "0%";
            CoutnTotalAmount();
        }
    }

    private static void CountForServices() {
        priceofserves = priceofserves1 + priceofserves2 + priceofserves3 + priceofserves4 + priceofserves5;
        if (typeofservice1 == null) {
            typeofservice1 = "";
        }
        if (typeofservice2 == null) {
            typeofservice2 = "";
        }
        if (typeofservice3 == null) {
            typeofservice3 = "";
        }
        if (typeofservice4 == null) {
            typeofservice4 = "";
        }
        if (typeofservice5 == null) {
            typeofservice5 = "";
        }
        typeofservice = typeofservice1 + "-" + typeofservice2 + "-" + typeofservice3 + "-" + typeofservice4 + "-" + typeofservice5;
    }

    private static void CoutnTotalAmount() {
        priceofmenue = priceofmenue - discountcount;
        totalprice = priceofmenue + priceofserves;
        if (discount == null) {
            typeofservice1 = "0%";
        }
        if (typeofmenu == null) {
            typeofservice1 = " ";
        }
        System.out.println("Order Has been Successfully Made."+"\n"+"|Type of menu: |" + typeofmenu +"\n"+"|Type of service:" +
                " |" + typeofservice +"\n"+"|Discount " + discount +"\n"+"|Total price: |RM" + totalprice + "|");
        System.out.println("Press [1] To select other services...");
        System.out.println("Press [2] Proceed to checkout ...");
        CaseToPayment();
    }

    private static void WriteBills() {
        /**
         * Write data to data base in byte array 
         */
        try {
            FileOutputStream fos = new FileOutputStream("Bills.txt", true);
            String s = "Oder ID: " + (orderid++) + System.lineSeparator() + "Type of menu: " + typeofmenu + System.lineSeparator() + "Type of services: " + typeofservice +
                    System.lineSeparator() + "Amount of Clients: " + totalcust + System.lineSeparator() + "Discount: " +
                    discount + " = RM: " + discountcount + System.lineSeparator() + "Total price: RM" + totalprice + System.lineSeparator() + div + System.lineSeparator();
            byte b[] = s.getBytes();     //converting string into byte array 
            fos.write(b);
            fos.close();
        } catch (IOException e) {
            System.out.println("Error");
            MainMenu();
        }
    }

    private static void ReadBills() {
        /**
         * read each line in file and display them
         */
        try {
            FileInputStream fstream = new FileInputStream("Bills.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(fstream));
            System.out.println("|----Summary of orders and payments made----|");
            String strLine;
            while ((strLine = reader.readLine()) != null) {
                System.out.println(strLine);
            }
            delimiter();
            Scanner sc = new Scanner(System.in);
            System.out.println("Press 'Enter' to continue...");
            String inp10;
            inp10 = sc.nextLine();
            Report();
        } catch (IOException e) {
            System.out.print("File has not been created");
        }
    }

    private static void SerachOrder() {
        /**
         * System scanning data-base(Bills.txt) and check just 2 row of all data
         * if it found same data as an input, system will display this line and six next.
         */
        File inpufile = new File("Bills.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(inpufile);
        } catch (IOException e) {
            System.out.print("Error");
        }
        try {
            Scanner read = new Scanner(System.in);
            System.out.println("Enter ID");
            String input1;
            input1 = read.nextLine();
            while (scanner.hasNextLine()) {
                String line1 = scanner.nextLine();
                String line2 = scanner.nextLine();
                String line3 = scanner.nextLine();
                String line4 = scanner.nextLine();
                String line5 = scanner.nextLine();
                String line6 = scanner.nextLine();
                String line7 = scanner.nextLine();
                String[] cols = line1.split(" ");
                if (cols[2].equals(input1)) {
                    System.out.println(line1);
                    System.out.println(line2);
                    System.out.println(line3);
                    System.out.println(line4);
                    System.out.println(line5);
                    System.out.println(line6);
                    System.out.println(line7);
                    System.out.println("Press 'Enter' to continue...");
                    String input2;
                    input2 = read.nextLine();
                    ReturnToMainMenue();
                }
            }
        } finally {
            scanner.close();
            Scanner read = new Scanner(System.in);
            System.out.println("Oder was not found." + "\n" + "Press 'Enter' to continue...");
            String input2;
            input2 = read.nextLine();
            ReturnToMainMenue();
        }
    }

    public static void CaseToPayment() {
        Scanner read = new Scanner(System.in);
        String inp5;
        inp5 = read.nextLine();
        switch (inp5) {
            case "1":
                OdersForOtherServices();
                break;
            case "2":
                Payment();
                break;
        }
        if (inp5 !="1" || inp5 !="2"|| inp5.isEmpty() ){
            MainMenu();
        }
    }

    private static void DisplayTotalAmount() {
        System.out.println("|----Total amount to be paid----|");
        System.out.println("Order ID: " + orderid);
        System.out.println("Type of menu: " + typeofmenu);
        System.out.println("Type of services: " + typeofservice);
        System.out.println("Amount of Clients: " + totalcust);
        System.out.println("Discount: " + discount + " = RM: " + discountcount);
        System.out.println("Total amount: RM" + totalprice);
        System.out.println("Press 'Enter' to continue...");
        Scanner read = new Scanner(System.in);
        String inp6;
        inp6 = read.nextLine();
        Payment();
    }

    private static void MakePayment() {
        System.out.println("|----Payment successful. Thank you----|");
        delimiter();
        System.out.println("Order ID: " + orderid);
        System.out.println("Type of menu: " + typeofmenu);
        System.out.println("Type of services: " + typeofservice);
        System.out.println("Amount of Clients: " + totalcust);
        System.out.println("Discount: " + discount);
        System.out.println("Total price: RM" + totalprice);
        System.out.println(div);
        WriteBills();
        System.out.println("Press 'Enter' to continue...");
        String inp9;
        inp9 = read.nextLine();
        MainMenu();
    }

    private static void SummaryOfOrdersAndPayments() {
        ReadBills();
    }

    private static void delimiter() {
        System.out.println("--|--|--|--|--|--|--|--|--|--|--|--|--|--|--|--|--|--");
    }

    private static void ReturnToMainMenue() {
        MainMenu();
    }

    private static void exiting() {
        Scanner input = new Scanner(System.in);
        String inp;
        delimiter();
        System.out.println("-->Press 'Enter' to Exit");
        inp = input.nextLine();
        System.exit(0);
    }
}



