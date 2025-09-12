import java.util.Random;
import java.util.Scanner;
public class Basic {
//Dice rolling program
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the no of times the dice rolled:");
        int input=scanner.nextInt();
        int total=0;
        for (int i = 0; i < input; i++) {
            Random random=new Random();
            int rand=random.nextInt(1,7);
            total+=rand;
            if(input>0) {
                switch (rand) {
                    case 1:
                        System.out.println(" ------- \n|       |\n|   ●   |\n|       |\n ------- ");
                        System.out.println("you rolled: 1");
                        break;
                    case 2:
                        System.out.println(" ------- \n| ●     |\n|       |\n|     ● |\n ------- ");
                        System.out.println("you rolled: 2");
                        break;
                    case 3:
                        System.out.println(" ------- \n| ●     |\n|   ●   |\n|     ● |\n ------- ");
                        System.out.println("you rolled: 3");
                        break;
                    case 4:
                        System.out.println(" ------- \n| ●   ● |\n|       |\n| ●   ● |\n ------- ");
                        System.out.println("you rolled: 4");
                        break;
                    case 5:
                        System.out.println(" ------- \n| ●   ● |\n|   ●   |\n| ●   ● |\n ------- ");
                        System.out.println("you rolled: 5");
                        break;
                    case 6:
                        System.out.println(" ------- \n| ●   ● |\n| ●   ● |\n| ●   ● |\n ------- ");
                        System.out.println("you rolled: 6");
                        break;
                }
            }
        }
        System.out.println();
        System.out.println((input>0)?"Total number: "+total:"Input cannot be negative");
    }
}
