import java.util.Scanner;
public class Basic {
    static double dp;
    static double wd;
    static double balance = 0;
    static String showBalance(){return "your balance is :₹"+balance;}
    static void deposit(double amount){balance+= amount;}
    static void withdraw(double amount){
        if(balance>amount) {balance -= amount;
            System.out.println("₹" + wd + " withdrawed successfully\n");}
        else
            System.out.println("Insufficient balance");
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(true) {
            System.out.println("**********\nBanking Program\n**********" +
                    "\n1.Show Balance\n2.Deposit\n3.Withdraw\n4.Exit\n**********\n");
            System.out.print("Enter your choice:");
            int choice = scanner.nextInt();
            if (choice == 1)
                System.out.println(showBalance()+"\n");
            else if(choice==2){
                System.out.print("Enter the amount to deposit:");
                dp=scanner.nextInt();
                if(dp>0) {
                    deposit(dp);
                    System.out.println("₹" + dp + " depositted successfully\n");
                }else
                    System.out.println("amount cannot be negative");
            }
            else if(choice==3){
                System.out.print("Enter the amount to withdraw:");
                wd=scanner.nextInt();
                if(wd>0){
                    withdraw(wd);
                }
                else
                    System.out.println("amount cannot be negative");
            }
            else if(choice==4){break;}
            else{
                System.out.println("invalid input");
                System.out.println();
            }
        }
        System.out.println("***************");
        System.out.println("Thank you have a nice day");
        System.out.println("***************");
        scanner.close();
    }
}
