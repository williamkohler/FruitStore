import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;


public class StoreFront implements Store, PrintGuide{

    Scanner keyboard = new Scanner(System.in);
    Item[] stock = new Item[7];
    ArrayList<Item> checkoutCart = new ArrayList<Item>();
    ArrayList<Item> purchases = new ArrayList<Item>();
    Wallet usrWallet = new Wallet();
    String Shopper;
    int checkoutCount=0;

    ArrayQuickSorter mySort = new ArrayQuickSorter();



    StoreFront() {
        ShopSignIn();
        System.out.println();
        buyItems();

        try {
            sortCart();
            purchaseCart();
            WriteReceipt();

            if (checkoutCart.size() <1)
                throw new Exception("nothing in checkout cart");

        }

        catch(Exception e){
            System.out.println("You didn't buy anything! Get out of here!!");
            System.exit(0);
        }

    }

    private void ShopSignIn() {
        System.out.println("Welcome to Bill's Fruit Store");
        System.out.println("Please sign in. Enter your name: ");
        setShopper(keyboard.nextLine());
        System.out.println("Welcome " + Shopper);
        System.out.println();


        EstablishStock();
        System.out.println("---");
    }

    private void setShopper(String shopper) {
        Shopper = shopper;
    }

    public void showStock() {

        for (int index = 0; index < stock.length; index++) {
            System.out.format(stock[index].getDesc() + " / $" + "%.2f", stock[index].getPrice());
            System.out.println();
        }

    }

    public void EstablishStock() {
        for (int index = 0; index < stock.length; index++) {
            stock[index] = new Fruit();
        }
        stock[0].setDesc("Orange");
        stock[1].setDesc("Banana");
        stock[2].setDesc("Peach");
        stock[3].setDesc("Strawberries");
        stock[4].setDesc("Mango");
        stock[5].setDesc("Watermelon");
        stock[6].setDesc("Cherries");

        stock[0].setPrice(100.00);
        stock[1].setPrice(40.00);
        stock[2].setPrice(3.95);
        stock[3].setPrice(6.67);
        stock[4].setPrice(0.00);
        stock[5].setPrice(2.99);
        stock[6].setPrice(79.99);

    }

    public void buyItems() {


        String usrInput;



        String[] ValidSelections = new String[7];
        for (int index = 0; index < 7; index++) {
            ValidSelections[index] = stock[index].getDesc();
        }

        boolean activeStore =true;
        while (activeStore== true) {


            System.out.println("To stop shopping, enter 'checkout' ");
            System.out.println();
            System.out.println("Fruit for Sale:");
            showStock();
            System.out.println("Enter fruit for purchase:");
            usrInput = keyboard.nextLine();

            if (usrInput.equalsIgnoreCase("checkout")){
                activeStore=false;
                System.out.println("Ok, let's pay.");
                System.out.println();
                break;
            }



            else {

                boolean MatchFound = false;
                for (int index = 0; index < 7; index++) {


                    if (usrInput.equalsIgnoreCase(ValidSelections[index])) {


                        boolean validQuantityInt=false;
                        while (!validQuantityInt){

                            System.out.println("Set quantity for " + ValidSelections[index]);
                            Scanner keyboard2 = new Scanner(System.in);


                            try{
                                stock[index].setQuantity(keyboard2.nextInt());
                                validQuantityInt=true;
                            }

                            catch (java.util.InputMismatchException e){
                                System.out.println("Must enter whole number.");
                            }

                        }


                        boolean validPriorityInt=false;
                        while (!validPriorityInt){

                            System.out.println("Set priority for " + ValidSelections[index]);
                            Scanner keyboard3 = new Scanner(System.in);

                            try {
                                stock[index].setPriority(keyboard3.nextInt());
                                validPriorityInt=true;
                            }

                            catch (java.util.InputMismatchException e) {
                                System.out.println("Must enter whole number.");
                            }
                        }



                        System.out.println("Putting item in cart");
                        checkoutCart.add(stock[index]);
                        MatchFound = true;
                        break;
                    }
                }

                if ((!MatchFound) & (!activeStore) ){
                    System.out.println("not valid entry. Please try again");
                    System.out.println("---");
                    buyItems();

                }
            }

        }


    }

    public void sortCart(){
        mySort.QuickSorting(checkoutCart,0,(checkoutCart.size() - 1));
    }

    public void purchaseCart(){


        for (int index=0; index<checkoutCart.size(); index++){
            if ( (checkoutCart.get(index).getPrice() * checkoutCart.get(index).getQuantity() )< usrWallet.getUserWallet()){

                purchases.add(checkoutCart.get(index));

                usrWallet.payUserWallet( ((checkoutCart.get(index).getPrice()) * checkoutCart.get(index).getQuantity()
                ));
                checkoutCount++;
            }


            else {
                System.out.println ("Not enough funds available in wallet for " + checkoutCart.get(index).getDesc());
                System.out.println("Moving on to the next prioritized item...");
                System.out.println("");
            }


        }


    }


    public void WriteReceipt(){



        String Receipt = "Receipt";
        PrintWriter outputStream = null;

        try{
            outputStream = new PrintWriter(Receipt);

        }

        catch(FileNotFoundException e){
            System.out.println();
            System.out.println("I'm afraid I can't do that Dave");
            Hal9000 myHal = new Hal9000();
        }

        Date myDate = new Date();

        System.out.println("Printing Receipt.");


        // lines to print to stream
        outputStream.println("--Receipt--");
        outputStream.println(myDate);
        outputStream.println("Here are your purchases:");
        for (int index=0; index < purchases.size() ; index++){
            outputStream.println();
            outputStream.println("Fruit: " + purchases.get(index).getDesc());
            outputStream.println("Quantity: " + purchases.get(index).getQuantity());
            outputStream.println("Priority: " + purchases.get(index).getPriority());
            outputStream.print("total $");
            outputStream.format("%.2f", (purchases.get(index).getPrice()  * purchases.get(index).getQuantity() )  );
            outputStream.println();

        }
        outputStream.println();
        outputStream.println("Thanks for shopping at my Fruit Store, "+ Shopper +".");
        outputStream.print("Your remaining wallet amount: $");
        outputStream.format("%.2f", usrWallet.getUserWallet());
        outputStream.close();

        System.out.println("Receipt has printed.");
        System.out.println("Goodbye " + Shopper);

    }



}








