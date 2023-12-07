package LetterSoup;

import java.util.Scanner;

public class View 
{
    Scanner key = new Scanner(System.in);
    int selection;

    public void menu()
    {
        System.out.println("Select the difficulty\n 1.Easy\n 2.Medium\n 3.Hard");
        selection = key.nextInt();

    }
    
}


