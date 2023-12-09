package PROYECTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;


public class RiosZabdielIntegrador 
{
    Scanner key = new Scanner(System.in);
    ArrayList<Double> dm = new ArrayList<>(); 

   RiosZabdielIntegrador()
   {

   }
   RiosZabdielIntegrador(ArrayList<Double> dm)
   {
      this.dm = dm;
   }
   
  

   public void CaptureData()
   {    
     double data;
     String input;

     System.out.println("Enter your data. To finish press the letter 'a' ");

     while(key.hasNext())
     {
       if(key.hasNextDouble())
       {
         data = key.nextDouble();
         dm.add(data);
         System.out.println("the entered number is: " + data);
       }
       else
       {
         input = key.next();

         if(input.equals("a"))
         {
           break;
         }
       }
     }
   }

   public void sortData()
   {
    Collections.sort(dm);
    System.out.println(dm);
   }

   public void CalculateMean()
   {
    double mean = dm.stream().mapToInt(Double::intValue).sum();
    System.out.println(" Your mean is: " + mean/dm.size());
   }



   public void CalculateMedian()
   {
     double median,op,op3;

     if(dm.size()%2 > 0)
     {
       median = dm.size();
       op = median+1;
       op = op / 2;
       op = op - 1;
       int op2 = (int) op;
       System.out.println("Your median is: " + dm.get(op2));
     }
     if(dm.size()%2 == 0)
     {
      median = dm.size();
      op = median+1;
      op = op / 2;
      op = op - 1;
      int op2 = (int) op;
      op3 = dm.get(op2) + dm.get(op2 + 1);
      op3 = op3 / 2;
      System.out.println("Your median is: "+op3);
     }
   }



   public void CalculateMode()
   {
    int maxnumrep = 0;
    double mode = 0;
     for(int i = 0; i < dm.size(); i++)
     {
        double arr1 = dm.get(i);
        int Arr = (int) arr1;
        int x = 0;
       for(int j = 0; j < dm.size(); j++)
       {
         double arr2 = dm.get(j);
         int Arr1 = (int) arr2;

         if(Arr == Arr1)
         {
           x++;
         }
         if(x >maxnumrep)
         {
           mode = dm.get(i);
           maxnumrep = x;
         }
       }
     }
     System.out.println("your mode is: "+mode); 
   }


  public void CalcuateFrequencyChart()
  {
     double fr,fa=0,fra=0; 
     Set<Double> hs = new LinkedHashSet<Double>(dm);

     for(double y : hs)
     {
        
       Collections.sort(dm);
       fa = fa += Collections.frequency(dm, y);
       fr = Collections.frequency(dm, y);
       fr = fr / dm.size();
       fra = fra += fr;
       System.out.println(y + "|" + Collections.frequency(dm, y) + "|" + fr + "|" + fa + "|" + fra);
     } 
  }

  public void CalculateVariance()
  {
     ArrayList<Double> variance = new ArrayList<Double>();
     double mean,op,sumatory=0;
     int pow = 2;

     mean = dm.stream().mapToInt(Double::intValue).sum();
     mean =  mean/dm.size();

     for(double y : dm)
     {
        op = y - mean;
        op = Math.pow(op, pow);
        variance.add(op);
        sumatory = variance.stream().mapToInt(Double::intValue).sum();
        sumatory = sumatory / dm.size();
     }
     System.out.println("Your variance is: " + sumatory);
  }

  public void CalculateStandardeviation()
  {

     ArrayList<Double> variance = new ArrayList<Double>();
     double mean,op,sumatory=0;
     int pow = 2;

     mean = dm.stream().mapToInt(Double::intValue).sum();
     mean =  mean/dm.size();

     for(double y : dm)
     {
        op = y - mean;
        op = Math.pow(op, pow);
        variance.add(op);
        sumatory = variance.stream().mapToInt(Double::intValue).sum();
        sumatory = sumatory / dm.size();
     }

     System.out.println("your standart deviation is: " + Math.sqrt(sumatory));
  }

  public void menu()
   {
     System.out.println("Welcome to the data machine!");
     CaptureData();
     sortData();

     if(dm.size() <= 30)
     {
        int opt;
        System.out.println("you are working with ungrouped data ");
        System.out.println(" ");
        System.out.println(" Please select an option:\n 1. Central tendency measures \n 2. Frequency chart \n 3. Variance \n 4. Standart deviation");
        opt = key.nextInt();

        switch(opt)
        {
          case 1:
          CalculateMean();
          CalculateMedian();
          CalculateMode();
          break;

          case 2:
          CalcuateFrequencyChart();
          break;

          case 3:
          CalculateVariance();
          break;

          case 4:
          CalculateStandardeviation();
          break;
          
        }
        
        
     }

     if(dm.size() > 30)
     {
       int opt;
       FrequencyChartGD a1 = new FrequencyChartGD(dm);
       System.out.println("You are working with grouped data ");
       System.out.println(" ");
       System.out.println(" Please select an option:\n 1. Frequency chart \n 2. Central tendency measures \n 3. Variance \n 4. Standart deviation");
       opt = key.nextInt(); 

       switch(opt)
       {
         case 1:
         a1.FreqChaGd();
         break;
         case 2:
         a1.MedianGD();
         break;
         case 3:
         a1.varGD();
         break;
         case 4:
         a1.EstandarDevGD();
         break;
       }
     }
   }


   
   
}
