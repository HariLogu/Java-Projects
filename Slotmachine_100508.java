import java.util.Random;
import java.util.Scanner;
public class Basic {
    static String[] sym={"🍎","🍉","🍇","🍌","🍋"};
    static Random random=new Random();
    static int fir;
    static int sec;
    static int thi;
    static int balance=100;

    public static void main(String[] args) {
//       Slot machine game
        Scanner scanner=new Scanner(System.in);

        intro();

        String repeat="y";
        while(repeat.equals("y") && balance>0) {
            System.out.print("place your bet amount: ");

            int bet=scanner.nextInt();
            balance -= bet;
            System.out.println("balance: " + balance);

            if (bet < 0) {
                System.out.println("Bet cannot be negative");
            } else if (bet > balance) {
                System.out.println("Insufficient balance");
            } else if (bet < balance) {
                spinnerOp();
                payout();
            }

            System.out.println("You want to play again?(Y/N):");
            repeat=scanner.next();
        }
        System.out.println("Game Over,Your Balance is ₹"+balance);
    }

    //    header
    static void intro(){
        System.out.println("************************");
        System.out.println("Welcome to Java slots");
        System.out.println("Symbols: 🍎 🍉 🍇 🍌 🍋");
        System.out.println("************************");
        System.out.println("Current Balance: ₹"+balance);
    }
    static void spinnerOp(){
        System.out.println("spinning...");
        System.out.println("********************");
        fir=random.nextInt(sym.length);
        sec=random.nextInt(sym.length);
        thi=random.nextInt(sym.length);
        System.out.print(" " + sym[fir]);
        System.out.print("  |  ");
        System.out.print(sym[sec]);
        System.out.print("  |  ");
        System.out.println(sym[thi]);
        System.out.println("********************");
    }
    static void payout(){
        if(fir !=sec && sec!=thi){
            System.out.println("you lose");
        }
        else if(fir==sec && sec==thi){
            System.out.println("you won ₹100");
            balance+=100;
        }
        else if(fir==sec || sec==thi){
            System.out.println("you won ₹25");
            balance+=25;
        }
    }
}