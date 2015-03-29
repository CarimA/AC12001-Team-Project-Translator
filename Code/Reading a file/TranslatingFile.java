import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.IOException;
/**
 * Write a description of class translateingFile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TranslatingFile
{
    // instance variables - replace the example below with your own
    public void file()
    {
        FileReader inputRead;
        BufferedReader bufferInput;
        FileOutputStream outputRead;
        PrintWriter addingOutput;
        String inputFile;
        String outputFile;
        String inputText;
        try
        {
            System.out.println("Input a filename to read from");
            inputFile = Genio.getString();
            inputRead = new FileReader(inputFile);
            bufferInput = new BufferedReader(inputRead);

            System.out.println("Input a filename to write to");
            outputFile = Genio.getString();
            outputRead = new FileOutputStream(outputFile);
            addingOutput = new PrintWriter(outputRead);

            try
            {       
                inputText=bufferInput.readLine();
                while(inputText!=null)
                {
                    System.out.println(inputText);
                    addingOutput.println(inputText);
                    inputText=bufferInput.readLine();
                }
                bufferInput.close();
                addingOutput.close();
            }
            catch(IOException e)
            {
                System.out.println("An unexpected error has occurred");

            }

            finally
            {
                try
                {
                    bufferInput.close();
                    addingOutput.close();
                }
                catch(IOException e){
                    System.out.println("An unexpected error has occurred");    
                }
            }
        }
        catch(IOException e)
        {
            System.out.println("An unexpected error has occurred");
        }
    }

    public static void main(String[] args){
        TranslatingFile run = new TranslatingFile();
        run.file();
    }
}
