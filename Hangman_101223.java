import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
//        hangman game
        String path = "words.txt";
        String line;
        ArrayList<String> wordsNew=new ArrayList<>();
        Scanner scanner=new Scanner(System.in);
        try (BufferedReader reader = new BufferedReader(new FileReader(path));) {
            while((line=reader.readLine())!=null){
                wordsNew.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("check the address");
        } catch (IOException e) {
            System.out.println("something went wrong");
        }

//        creating random object
        Random random=new Random();

        System.out.println();
        String word=wordsNew.get(random.nextInt(wordsNew.size()));
        int wrongGuess=0;

        System.out.println("****************************");
        System.out.println("Welcome to Java Hangman Game");
        System.out.println("****************************");
        ArrayList<Character> wordList=new ArrayList<>();
        System.out.print("your word: ");
        for (int i = 0; i < word.length(); i++) {
            wordList.add(i,'_');
        }
        for(char c:wordList){
            System.out.print(c+" ");
        }
        System.out.println();
        int i;
//        here the 6 is actually 5 cases of hangman
        while(wrongGuess<6) {
            System.out.print("\nEnter your guess:");
            char guess = scanner.next().charAt(0);
            if (word.indexOf(guess) != -1) {
                System.out.println("Correct");
                for (int j = 0; j < word.length(); j++) {
                    if(word.charAt(j)==guess){
                        wordList.set(j,guess);
                    }
                }
                for(char c:wordList){
                    System.out.print(c+" ");
                }
            } else {
                wrongGuess++;
                System.out.println(getHangman(wrongGuess));
            }

            if(!wordList.contains('_')){
                System.out.println("\n******* YOU WIN *******");
                break;
            }
        }

        System.out.println("\nwrong guesses: "+wrongGuess);
        for(char c:wordList){
            System.out.print(c+" ");
        }

        if(wrongGuess == 6){
            System.out.println("\n***** YOU LOST *****");
            System.out.println("\nThe word is "+word);
            System.out.println(getHangman(wrongGuess));
        }
        scanner.close();
    }
    static String getHangman(int wrong){
        switch (wrong){
            case 0 -> {
                return """
                            
                            
                            
                            """;
            }

            case 1-> {
                return """
                         o
                                
                                
                       """;
            }

            case 2-> {
                return """
                         o
                         |      
                                
                       """;
            }
            case 3-> {
                return """
                         o
                        /|       
                                
                       """;
            }
            case 4-> {
                return """
                         o
                        /|\\        
                                
                       """;
            }
            case 5-> {
                return """
                         o
                        /|\\        
                        /        
                       """;
            }
            case 6-> {
                return """
                         o
                        /|\\        
                        / \\        
                       """;
            }
            default -> {
                return "";
            }
        }
    }
}