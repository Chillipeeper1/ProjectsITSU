package PROYECTO;


import java.util.ArrayList;
import java.util.Collections;





public class FrequencyChartGD extends RiosZabdielIntegrador 
{
    FrequencyChartGD()
    {

    }
   
   FrequencyChartGD(ArrayList<Double> dm)
   {
     super(dm);
   }

   double r,k,i,xi,fr,fa=0,fra=0,j=0,f=0,median,var2=0;
   double aux,aux2,max,li;
   ArrayList<Double> sum = new ArrayList<>();


   public void FreqChaGd()
   {
    
   
      max = Collections.max(dm);
      aux = Collections.min(dm);
      r = Collections.max(dm);
      r = r - aux;
      k = 1 + 3.32 * Math.log10(dm.size());
      k = Math.ceil(k);
      i = r/k;      
      aux2 = Collections.min(dm);

      while(j < k)
      {
         aux2 = aux2 + i;
         f = 0;
         for(double z = 0; z < dm.size(); z++)
         {
            double CurrentNo = dm.get((int) z);
            
            if(CurrentNo >= aux && CurrentNo <= aux2)
            {
                   f++;
            }
         }

         fr = f / dm.size();
         fr = Math.round(fr * 100.0)/100.0;
         fa = fa += f;
         fra = fra += fr;
         fra = Math.round(fra * 100.0)/100.0;
         
         aux2 = Math.round(aux2*100.0)/100.0;
         xi = aux + aux2;
         xi = xi / 2;
         System.out.println("("+aux + " - " + aux2+")" + "|" + xi + "|" + f + "|" + fr + "|" + fa + "|" + fra);
         aux = aux2;
         j++;
         
      }
      if(aux2 < max)
      {
         
          aux2 = aux2 + i;
         f = 0;
         for(double z = 0; z < dm.size(); z++)
         {
            double CurrentNo = dm.get((int) z);
            
            if(CurrentNo >= aux && CurrentNo <= aux2)
            {
                   f++;
            }
         }

         fr = f / dm.size();
         fr = Math.round(fr * 100.0)/100.0;
         fa = fa += f;
         fra = fra += fr;
         fra = Math.round(fra * 100.0)/100.0;
        
         
         aux2 = Math.round(aux2*100.0)/100.0;
         xi = aux + aux2;
         xi = xi / 2;
         System.out.println("("+aux + " - " + aux2+")" + "|" + xi + "|" + f + "|" + fr + "|" + fa + "|"+ fra);
         aux = aux2;
         j++;
      }
      
   }


   public void MeanGD()
   {
      FreqChaGd();
      aux = Collections.min(dm);
      aux2 = Collections.min(dm);
      double mean;
     
      j=0;
      while(j < k)
      {
         aux2 = aux2 + i;
            f = 0;
            for(double z = 0; z < dm.size(); z++)
            {
               double CurrentNo = dm.get((int) z);
               
               if(CurrentNo >= aux && CurrentNo <= aux2)
               {
                      f++;
               }
            }
            aux2 = Math.round(aux2*100.0)/100.0;
            xi = aux + aux2;
            xi = xi / 2;
            xi = Math.round(xi*100.00)/100.00;
            mean = xi * f;
            sum.add(mean);
            aux = aux2;
            j++;
            
      }
      if(aux2 < max)
      {
         aux2 = aux2 + i;
            f = 0;
            for(double z = 0; z < dm.size(); z++)
            {
               double CurrentNo = dm.get((int) z);
               
               if(CurrentNo >= aux && CurrentNo <= aux2)
               {
                      f++;
               }
            }
            aux2 = Math.round(aux2*100.0)/100.0;
            xi = aux + aux2;
            xi = xi / 2;
            xi = Math.round(xi*100.00)/100.00;
            mean = xi * f;
            sum.add(mean);
            aux = aux2;
            j++;
      }
      double meansum = sum.stream().mapToInt(Double::intValue).sum();
      meansum = meansum / dm.size();
      System.out.println(meansum);

    
   }

   

   public void MedianGD()
   {
      MeanGD();
      aux = Collections.min(dm);
      aux2 = Collections.min(dm);
      
      double cont1=0,Fi1=0,fi,n2,aux3,position;
      ArrayList<Double> a1 = new ArrayList<>();   
    
      double meansum = sum.stream().mapToInt(Double::intValue).sum();
      meansum = meansum / dm.size();
      j=0;
      fa=0;
      while(j < k)
      {
         aux2 = aux2 + i;
            f = 0;

      
            for(double z = 0; z < dm.size(); z++)
            {
               double CurrentNo = dm.get((int) z);
               
               if(CurrentNo >= aux && CurrentNo <= aux2)
               {

                      f++;
                     
 
                      if(meansum >= aux && meansum <=aux2)
                      {
                         aux3 = Collections.max(a1);
                         position = a1.indexOf(aux3);
                         li = aux;
                         cont1--;
                         Fi1 = a1.get((int) position-1);
                         fi = f;
                         meansum=0;
                      }


               }
            }

            fa = fa += f;
            a1.add(fa);
            aux2 = Math.round(aux2*100.0)/100.0;
            aux = aux2;
            j++;
      }
      n2 = dm.size()/2.0;
      median = n2 - Fi1;
      median = median / 2;
      median = li + median * i;
      System.out.println(median);
   }

   public void varGD()
   {
      MeanGD();
      double meansum = sum.stream().mapToInt(Double::intValue).sum();
      meansum = meansum / dm.size();
      aux = Collections.min(dm);
      aux2 = Collections.min(dm);
      double var,pow=2;
      j=0;
      xi=0;
      while(j < k)
      {
         j++;
         aux2 = aux2 + i;
         f = 0;
         for(double z = 0; z < dm.size(); z++)
         {
            double CurrentNo = dm.get((int) z);
            
            if(CurrentNo >= aux && CurrentNo <= aux2)
            {
                   f++;
            }
         }
         xi = aux + aux2;
         xi = xi / 2;
         xi = Math.round(xi*100.0)/100.0;
         var = xi - meansum;
         var = Math.pow(var, pow);
         var = var * f;
         var2 = var2 += var;
         aux = aux2;
     
      }
      
      if(aux2 <= max)
      {
         aux2 = aux2 + i;
         f = 0;
         for(double z = 0; z < dm.size(); z++)
         {
            double CurrentNo = dm.get((int) z);
            
            if(CurrentNo >= aux && CurrentNo <= aux2)
            {
                   f++;
            }
         }
         xi = aux + aux2;
         xi = xi / 2;
         xi = Math.round(xi*100.0)/100.0;
         var = xi - meansum;
         var = Math.pow(var, pow);
         var = var * f;
         var2 = var2 += var;
         j++;
         aux = aux2;
      }


      var2 = var2 / dm.size();
      System.out.println(var2);
   }

   public void EstandarDevGD()
   {
      Double standartDev = Math.sqrt(var2);

      System.out.println(standartDev);
   }


   
}
