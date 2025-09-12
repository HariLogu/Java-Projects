import java.util.Scanner;

public class Basic {
    public static void main(String[] args) {
//        Quiz game
        System.out.println("*****************************");
        System.out.println("welcome to the Java Quiz Game");
        System.out.println("*****************************\n");
        Scanner scanner=new Scanner(System.in);
        String[] questions={"What is our national animal?",
                "when is our independence day?",
                "How many colors does a rainbow have?"};
        String[][] options={{"1.Lion","2.tiger","3.horse"},
                {"1.16th Aug","2.18th Aug","3.15th Aug"},
                {"1.4","2.7","3.9"}};
        int[] answers={2,3,2};
        int points=0;
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);

            for(String option:options[i]){
                System.out.println(option);
            }
            System.out.print("Enter the option:");
            int input=scanner.nextInt();
            if(input==answers[i]){
                System.out.println("correct");
                points++;
            }
            else if(input> options.length || input==0){
                System.out.println("invalid input");
                break;
            }
            else{
                System.out.println("wrong");
            }
            System.out.println();
        }
        System.out.println("**************************");
        System.out.println("you got "+points+(points==1?" point":" points")+" out of "+questions.length+".");
        System.out.println("**************************");
        scanner.close();
    }
}