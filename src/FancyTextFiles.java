import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Class to manage text input/output to/from files
 */
public class FancyTextFiles {
    // Atributes
    private String fileName = "words.txt";
    File myFileObject;


    //Contructor
    public FancyTextFiles() {
        createAFile();
        //write2File();
        readFromFile();
    }

    //Reads text from a file
    private void readFromFile() {
        try {
            Scanner myFileScanner = new Scanner(myFileObject);
            int longestLenght = 0;
            String longestWord = "";

            while (myFileScanner.hasNextLine()) {// skriver ut orden
                String currentWord = myFileScanner.next();

                if (currentWord.length() > longestLenght){
                    longestLenght = currentWord.length();
                    longestWord = currentWord;
                }

                System.out.print  (myFileScanner.nextLine());
            }

            System.out.println("längsta ordet är: "longestWord);

        } catch (FileNotFoundException e) {
            System.out.println("file does not exist");
        }


    }

    //Writes Strings to a file
    private void write2File() {
        try {
            FileWriter myFileWriter = new FileWriter(myFileObject, true);

            Scanner myKeyScanner = new Scanner(System.in);
            System.out.println("What do you wnat to write to the file?");

            myFileWriter.write(myKeyScanner.nextLine());


            myFileWriter.close();
            System.out.println("I have written to the file");

        } catch (IOException e) {
            System.out.println("FileWriter could no be created");
        }


    }

    // Creats a file if file does not already exist
    private void createAFile() {
        myFileObject = new File(fileName);
        try {
            if (myFileObject.createNewFile()) {
                System.out.println("File has been created");
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException ioError) {
            System.out.println("File could not be created");

        } catch (Exception e) {
            System.out.println("something went wrong");
        }
    }


}
