import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Basic {
    public static void main(String[] args) {
        String[] songs={ "1.sample.wav","2.doc.wav"};
        Scanner scanner=new Scanner(System.in);
        System.out.println("******** My playlist ********");
        for(String s:songs){
            System.out.println(s);
        }
        System.out.print("Choose the song:");
        int songNum=scanner.nextInt();
        String path="";
        switch (songNum){
            case 1->path=songs[0];
            case 2->path=songs[1];
            default -> System.out.println("invalid song choice");
        }

        File file=new File(path);
        String option="";
        try(
                AudioInputStream audioStream= AudioSystem.getAudioInputStream(file)){
            Clip clip=AudioSystem.getClip();
            clip.open(audioStream);

            while(!option.equalsIgnoreCase("Q")){
                System.out.println("P - Play");
                System.out.println("R - Reset");
                System.out.println("S - Stop");
                System.out.println("C - Change");
                System.out.println("Q - Quit");
                System.out.print("Enter the option:");
                option=scanner.next();
                switch (option){
                    case "p"->clip.start();
                    case "r"->clip.setMicrosecondPosition(0);
                    case "s"->clip.stop();
                    case "q"->clip.close();

                    default-> System.out.println("invalid input");
                }
            }
        }catch (UnsupportedAudioFileException e){
            System.out.println("file unsupported");
        }  catch (LineUnavailableException e) {
            System.out.println("error in file accessing");
        } catch (IOException e) {
            System.out.println("something went wrong");
        }
    }
}