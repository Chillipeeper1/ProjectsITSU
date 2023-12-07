package LetterSoup;

import java.io.File;
import java.io.IOException;

public class Filecreator 
{
    String direction = "C:\\Users\\Josuk\\OneDrive\\Documentos 1\\Codigos-20230620T213721Z-001\\Codigos\\CODIGOS\\LetterSoup";

    public void easy()
    {
        File fileeasy = new File(direction + "/Easy");
        fileeasy.mkdirs();

        String filename = "Easylevel.java";
        File a1 = new File(fileeasy, filename);

        try 
        {
            if(a1.createNewFile())
            {
                System.out.println("The game has been started!");
            }
            else
            {
                System.out.println("the game is already running!");
            }
        } 
        catch (IOException e) 
        {
           System.out.println("There was an error during the game loading procces. Try again" + e.getMessage()); 
        }
    }
    public void medium()
    {
         File filemedium = new File(direction + "/Medium");
         filemedium.mkdirs();

         String filename = "Mediumlevel.java";
        File a1 = new File(filemedium, filename);

        try 
        {
            if(a1.createNewFile())
            {
                System.out.println("The game has been started!");
            }
            else
            {
                System.out.println("the game is already running!");
            }
        } 
        catch (IOException e) 
        {
           System.out.println("There was an error during the game loading procces. Try again" + e.getMessage()); 
        }
    }
    public void hard()
    {
        File filehard = new File(direction + "/Hard");
        filehard.mkdirs();

        String filename = "Hardlevel.java";
        File a1 = new File(filehard, filename);

        try 
        {
            if(a1.createNewFile())
            {
                System.out.println("The game has been started!");
            }
            else
            {
                System.out.println("the game is already running!");
            }
        } 
        catch (IOException e) 
        {
           System.out.println("There was an error during the game loading procces. Try again" + e.getMessage()); 
        }
    }
    
}
