import java.util.Scanner;
import java.io.IOException;

/**
 * Created by williamkohler on 6/20/16.
 */

public abstract class MoneyContainer {


        String MoneyIn;
        double userWallet;
        boolean validMoney;


        public double getUserWallet(){
            return userWallet;
        }

        public void payUserWallet(double payment){
            userWallet = userWallet - payment;
        }

    }

