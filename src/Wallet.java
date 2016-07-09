import java.util.Scanner;
import java.io.IOException;

/**
 * Created by williamkohler on 6/20/16.
 */
public class Wallet extends MoneyContainer {



        String MoneyIn;
       static double userWallet;
        boolean validMoney;


        Scanner keyboard = new Scanner(System.in);


        Wallet(){

            userWallet = 0.00;
            validMoney = false;

            System.out.println("Hello, welcome to my fruit store.");
            System.out.println("First, how much money would you like to place in your wallet to spend in the store?");



            while (!validMoney){
                System.out.println("Enter wallet amount: ");
                MoneyIn = (keyboard.nextLine());

                try {
                    userWallet = Float.parseFloat(MoneyIn);
                    validMoney = true;
                }

                catch (NumberFormatException e){
                    System.out.println("not valid input. ");
                }

            }

            System.out.print("Thank you. You now have $");
            System.out.format("%.2f", userWallet);
            System.out.println(" in your wallet.");
            System.out.println("");


        }

        public double getUserWallet(){
            return userWallet;
        }

        public void payUserWallet(double payment){
            userWallet = userWallet - payment;
        }

    }


