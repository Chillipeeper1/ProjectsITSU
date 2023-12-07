package LetterSoup;

public class main 
{
   public static void main(String[] args) 
   {
      View slView = new View();
      randomGen random = new randomGen();
      Filecreator createF = new Filecreator();
      LS run = new LS(slView,random,createF);
      run.game();
      Filecreator createfile = new Filecreator();
      //createfile.easy();
   } 
}
