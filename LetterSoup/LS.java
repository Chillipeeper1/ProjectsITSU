package LetterSoup;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class LS 
{
   
    View slView;
    randomGen random;
    Filecreator createF;
    String Filename  = "C:\\Users\\Josuk\\OneDrive\\Documentos 1\\Codigos-20230620T213721Z-001\\Codigos\\CODIGOS\\LetterSoup\\wordEasy.txt";
    String Filename2  = "C:\\Users\\Josuk\\OneDrive\\Documentos 1\\Codigos-20230620T213721Z-001\\Codigos\\CODIGOS\\LetterSoup\\wordMedium.txt";
    String Filename3  = "C:\\Users\\Josuk\\OneDrive\\Documentos 1\\Codigos-20230620T213721Z-001\\Codigos\\CODIGOS\\LetterSoup\\wordHard.txt";
    String Filename4  = "C:\\Users\\Josuk\\OneDrive\\Documentos 1\\Codigos-20230620T213721Z-001\\Codigos\\CODIGOS\\LetterSoup\\questionsEasy.txt";
    String Filename5 = "C:\\Users\\Josuk\\OneDrive\\Documentos 1\\Codigos-20230620T213721Z-001\\Codigos\\CODIGOS\\LetterSoup\\questionMedium.txt";
    String Filename6 = "C:\\Users\\Josuk\\OneDrive\\Documentos 1\\Codigos-20230620T213721Z-001\\Codigos\\CODIGOS\\LetterSoup\\questionsHard.txt";
    
    ArrayList<String> lines = new ArrayList<>();
    ArrayList<String> checking = new ArrayList<>();
    ArrayList<String> questions = new ArrayList<>();
    ArrayList<String> questionsaux = new ArrayList<>();
    String[][] a1 = new String [30][30];
    String[][] a2 = new String [30][30];
    Scanner key = new Scanner(System.in);
    
   public LS(View slView, randomGen random, Filecreator createF)
   {
     this.slView = slView;
     this.random = random;
     this.createF = createF;
   }

    public void game()
    {
        slView.menu();
        random.Random();
        int size=0;


       switch(slView.selection)
       {
        case 1:
        size = 10;

            try (BufferedReader br = new BufferedReader(new FileReader(Filename)))
            {
                String line;
                while((line = br.readLine()) != null)
                {   
                    lines.add(line);
                }
            } 

            catch (IOException e) 
            {
                e.printStackTrace();
            }

            try (BufferedReader br = new BufferedReader(new FileReader(Filename4)))
            {
                String line;
                while((line = br.readLine()) != null)
                {   
                   
                        questions.add(line);
                    
                }
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }

        Random r = new Random();
        int cont = 16;
        String randomquestion = "";
        String correctanswer = "";
        int randomposition = 0;
           
                    while(cont > 0)
                        {
                            randomposition = r.nextInt(questions.size()+1);
                            correctanswer = lines.get(randomposition-1);
                            randomquestion = questions.get(randomposition-1);
                            checking.add(correctanswer);
                            questionsaux.add(randomquestion);
                            int row = r.nextInt(size);
                            int col = r.nextInt(a1[0].length);

                            if(a1[row][col] == null)
                            {
                                a1[row][col] = correctanswer;
                                cont--;
                            }
                        }

        for (int x = 0; x < size; x++) 
            {
                                for (int y = 0; y < a1[0].length; y++) 
                                {
                                    if(a1[x][y]==null)
                                    {
                                        a1[x][y] = random.randomizer;
                                    }
                                }            
            }

        int check = 15;
        for (int x = 0; x < size; x++) 
                            {
                                for (int y = 0; y < a1[0].length; y++) 
                                {
                                    
                                    System.out.print(a1[x][y]);
                                    
                                }            
                            }
        while(check > 0) 
        {
                    boolean condition = true;
                    while(condition)
                    {
                    randomposition = r.nextInt(checking.size()+1);
                    randomquestion = questionsaux.get(randomposition);
                    correctanswer = checking.get(randomposition);
                    System.out.println(" ");
                    System.out.println(randomquestion);
                    String answer = key.nextLine();
                    answer.toLowerCase();
                     if(answer.equals(correctanswer))
                     {
                        System.out.println("Correct!");
                        questionsaux.remove(randomposition);
                        checking.remove(randomposition);
                        check--;
                        condition = false;
                         for (int x = 0; x < size; x++) 
                            {
                                for (int y = 0; y < a1[0].length; y++) 
                                {
                                    if(a1[x][y].equals(answer))
                                    {
                                        System.out.print("\u001B[41m");  

                                    }
                                    System.out.print(a1[x][y]);
                                    System.out.print("\u001B[0m");
                                }            
                            }
                     }
                     else
                     {
                        System.out.println("Incorrect answer try again");
                     }
                    }
                    
                if(check==0)
                {
                    System.out.println(" ");
                    System.out.println("you won the game!");
                    break;
                }              
        }
       
        
          break;

          case 2:
          size = 20;

            try (BufferedReader br = new BufferedReader(new FileReader(Filename2)))
            {
                String line;
                while((line = br.readLine()) != null)
                {   
                    lines.add(line);
                }
            } 

            catch (IOException e) 
            {
                e.printStackTrace();
            }

            try (BufferedReader br = new BufferedReader(new FileReader(Filename5)))
            {
                String line;
                while((line = br.readLine()) != null)
                {   
                   
                        questions.add(line);
                    
                }
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }

        Random r2 = new Random();
        int cont2 = 21;
        String randomquestion2 = "";
        String correctanswer2 = "";
        int randomposition2 = 0;
           
                    while(cont2 > 0)
                        {
                            randomposition2 = r2.nextInt(questions.size()+1);
                            correctanswer2 = lines.get(randomposition2+1);
                            randomquestion2 = questions.get(randomposition2-1);
                            checking.add(correctanswer2);
                            questionsaux.add(randomquestion2);
                            int row = r2.nextInt(size);
                            int col = r2.nextInt(a1[0].length);

                            if(a1[row][col] == null)
                            {
                                a1[row][col] = correctanswer2;
                                cont2--;
                            }
                        }

        for (int x = 0; x < size; x++) 
            {
                                for (int y = 0; y < a1[0].length; y++) 
                                {
                                    if(a1[x][y]==null)
                                    {
                                        a1[x][y] = random.randomizer;
                                    }
                                }            
            }

        int check2 = 21;
        for (int x = 0; x < size; x++) 
                            {
                                for (int y = 0; y < a1[0].length; y++) 
                                {
                                    
                                    System.out.print(a1[x][y]);
                                    
                                }            
                            }
        while(check2 > 0) 
        {
                    boolean condition = true;
                    while(condition)
                    {
                    randomposition2 = r2.nextInt(checking.size()+1);
                    randomquestion2 = questionsaux.get(randomposition2);
                    correctanswer2 = checking.get(randomposition2);
                    System.out.println(" ");
                    System.out.println(randomquestion2);
                    String answer = key.nextLine();
                    answer.toLowerCase();
                     if(answer.equals(correctanswer2))
                     {
                        System.out.println("Correct!");
                        questionsaux.remove(randomposition2);
                        checking.remove(randomposition2);
                        check2--;
                        condition = false;
                         for (int x = 0; x < size; x++) 
                            {
                                for (int y = 0; y < a1[0].length; y++) 
                                {
                                    if(a1[x][y].equals(answer))
                                    {
                                        System.out.print("\u001B[41m");  

                                    }
                                    System.out.print(a1[x][y]);
                                    System.out.print("\u001B[0m");
                                }            
                            }
                     }
                     else
                     {
                        System.out.println("Incorrect answer try again");
                     }
                    }
                     
                
                if(check2==0)
                {
                    System.out.println(" ");
                    System.out.println("you won the game!");
                    break;
                }              
        }
          break;

          case 3:
          size = 30;
          
          try (BufferedReader br = new BufferedReader(new FileReader(Filename3)))
            {
                String line;
                while((line = br.readLine()) != null)
                {   
                    lines.add(line);
                }
            } 

            catch (IOException e) 
            {
                e.printStackTrace();
            }

            try (BufferedReader br = new BufferedReader(new FileReader(Filename6)))
            {
                String line;
                while((line = br.readLine()) != null)
                {   
                   
                        questions.add(line);
                    
                }
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }

        Random r3 = new Random();
        int cont3 = 31;
        String randomquestion3 = "";
        String correctanswer3 = "";
        int randomposition3 = 0;
           
                    while(cont3 > 0)
                        {
                            randomposition3 = r3.nextInt(questions.size()+1);
                            correctanswer3 = lines.get(randomposition3+1);
                            randomquestion3 = questions.get(randomposition3+1);
                            checking.add(correctanswer3);
                            questionsaux.add(randomquestion3);
                            int row = r3.nextInt(size);
                            int col = r3.nextInt(a1[0].length);

                            if(a1[row][col] == null)
                            {
                                a1[row][col] = correctanswer3;
                                cont3--;
                            }
                        }

        for (int x = 0; x < size; x++) 
            {
                                for (int y = 0; y < a1[0].length; y++) 
                                {
                                    if(a1[x][y]==null)
                                    {
                                        a1[x][y] = random.randomizer;
                                    }
                                }            
            }

        int check3 = 31;
        for (int x = 0; x < size; x++) 
                            {
                                for (int y = 0; y < a1[0].length; y++) 
                                {
                                    
                                    System.out.print(a1[x][y]);
                                    
                                }            
                            }
        while(check3 > 0) 
        {
                    boolean condition = true;
                    while(condition)
                    {
                    randomposition3 = r3.nextInt(checking.size()+1);
                    randomquestion3 = questionsaux.get(randomposition3);
                    correctanswer3 = checking.get(randomposition3);
                    System.out.println(" ");
                    System.out.println(randomquestion3);
                    String answer = key.nextLine();
                    answer.toLowerCase();
                     if(answer.equals(correctanswer3))
                     {
                        System.out.println("Correct!");
                        questionsaux.remove(randomposition3);
                        checking.remove(randomposition3);
                        check3--;
                        condition = false;
                         for (int x = 0; x < size; x++) 
                            {
                                for (int y = 0; y < a1[0].length; y++) 
                                {
                                    if(a1[x][y].equals(answer))
                                    {
                                        System.out.print("\u001B[41m");  

                                    }
                                    System.out.print(a1[x][y]);
                                    System.out.print("\u001B[0m");
                                }            
                            }
                     }
                     else
                     {
                        System.out.println("Incorrect answer try again");
                     }
                    }
                     
                
                if(check3==0)
                {
                    System.out.println(" ");
                    System.out.println("you won the game!");
                    break;
                }              
        }
          break;
          default:
          System.out.println("invalid option");
          break;
       }
       
    }
}
