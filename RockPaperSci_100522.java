import java.util.Random;
import java.util.Scanner;
public class Basic {
    public static void main(String[] args) {
//        Rock paper scissor game
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] moves = {"rock", "paper", "scissor"};
        String move;
        int point=0;
        String repeat="yes";
        while (repeat.equals("yes")) {
            int r = random.nextInt(3);
            String comMove = moves[r];
            System.out.print("Enter you move(rock,paper,scissor):");
            move = scanner.next();
            System.out.println("Com Move: " + comMove);
            if(!move.equals("rock") && !(move.equals("paper")) && !(move.equals("scissor"))){
                System.out.println("invalid input");
                continue;
            }
            else if((move.equals("rock") && comMove.equals("paper"))||
                    (move.equals("paper") && comMove.equals("scissor"))||
                    (move.equals("scissor") && comMove.equals("rock"))){
                System.out.println("Com Wins!");
            }
            else if((comMove.equals("rock") && move.equals("paper"))||
                    (comMove.equals("paper") && move.equals("scissor"))||
                    (comMove.equals("scissor") && move.equals("rock"))){
                System.out.println("You Win!");
                point++;
            }
            else{
                System.out.println("Its a tie");
            }
            System.out.print("play again (yes/no): ");
            repeat=scanner.next();
            System.out.println();
        }
        System.out.println("you got "+point+(point>1?" points":" point"));
    }
}