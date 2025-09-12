import javax.sound.sampled.*;
import java.io.*;
import java.util.Scanner;

public class Basic {
    public static void main(String[] args) {
//  music player
        String path= "sample.mp3";
        File file=new File(path);
        String option="";
//        we should close scanner after we use so these types of objects
//        should be given in the try block
        try(Scanner scanner=new Scanner(System.in);
            AudioInputStream audioStream= AudioSystem.getAudioInputStream(file)){
            Clip clip=AudioSystem.getClip();
            clip.open(audioStream);

            while(!option.equalsIgnoreCase("Q")){
                System.out.println("P - Play");
                System.out.println("S - Stop");
                System.out.println("R - Reset");
                System.out.println("Q - Quit");
                System.out.print("Enter your option:");
                option=scanner.next();

                switch (option) {
                    case "P", "p" -> clip.start();
                    case "S", "s" -> clip.stop();
                    case "R", "r" -> clip.setMicrosecondPosition(0);
                    case "Q", "q" -> clip.close();
                    default -> System.out.println("Invalid input");
                }
            }
        } catch(FileNotFoundException e){
            System.out.println("Check the address");
        } catch(UnsupportedAudioFileException e){
            System.out.println("unsupported file");
        } catch (LineUnavailableException e) {
            System.out.println("unable to access the file");
        } catch (IOException e) {
            System.out.println("something went wrong");
        }finally{
            System.out.println("bye");
        }
    }
}