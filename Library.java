import java.text.DecimalFormat;
import java.util.*;
public class Library
{
 private Complex [] myShares;
 private double cash=100.0;
 
 //constructor
 public Library(Complex... inMyShares)
 {
   myShares=inMyShares;
 }
 
 //getter
 public Complex [] getMyShares()
 {
  return myShares; 
 }
 
 //setter
 public void setMyShares(Complex [] inMyShares)
 {
  myShares=inMyShares;
 }
 
 //calculate all possible combinations of profits
 public String profitCombos()
 {
  DecimalFormat df= new DecimalFormat("####0.00");
  String toReturn="\t\t\t\t\tAll Profit Combinations:\n";
  int size=1;
  for (int i=0;i<myShares.length;i++)
  {
   size*=myShares[i].getTotals().length;
  }
  double[]profitCombinations=new double[size];
  
  List<Double> profits=new ArrayList<Double>();
  List<Double> newProfits=new ArrayList<Double>();
  //the actual math
  double fixed;
  for (int i=0;i<myShares.length;i++)
  {
    if (i==0)
    {
      for (int j=0;j<myShares[i].getTotals().length;j++)
      {
        profits.add(myShares[i].getTotals()[j]);
      }
    }
   else 
   {
     for (int k=0;k<profits.size();k++)
     {
       fixed=profits.get(k);
       for (int j=0;j<myShares[i].getTotals().length;j++)
       {
         newProfits.add(k,fixed+myShares[i].getTotals()[j]); 
       }
     }
     
     //set profits equal to nonprofits
    profits.clear();
    for (int c=0;c<newProfits.size();c++)
    {
     profits.add(newProfits.get(c)); 
    }
     newProfits.clear();
   }
  }
  //making the arraylist equal to the array
  for (int i=0;i<profits.size();i++)
  {
   profitCombinations[i]=profits.get(i); 
  }
  //arranging in order from lowest to highest
  Arrays.sort(profitCombinations);
  //formatting it
  int k=0;
  int sum=0;
  for (int i=0;i<profitCombinations.length;i++)
  {
    sum+=profitCombinations[i];
    if (k!=5)
    {
      toReturn+=df.format(profitCombinations[i])+"\t\t";
      k++;
    }
    else
    {
     toReturn+="\n"+df.format(profitCombinations[i])+"\t\t"; 
     k=1;
    }
  }
  toReturn+="\n\nYour maximum profit is "+df.format(profitCombinations[0])+" dollars";
  toReturn+="\nYour minimum profit is "+df.format(profitCombinations[size-1])+" dollars";
  toReturn+="\nYour average return is "+df.format(sum/size)+" dollars";
  toReturn+="\nYour median return is "+df.format(profitCombinations[size/2])+" dollars";
  toReturn+=("\n===================================================================================================================================================================");
  return toReturn;
 }
 
 //toString
 public String toString()
 {
  String toReturn="Your Library: \n";
  for (int i=0;i<myShares.length;i++)
  {
  toReturn+=myShares[i]+"\n";
  }
  return toReturn;
 }
}


























