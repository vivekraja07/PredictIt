import java.text.DecimalFormat;
public class Complex
{
  //instance variables
  private double [][] complex;
  private String name;
  private Basic basicData;
  private double odd,even;
  private double [] totals;
  private double sum;
  private double max=-100000000.0;
  private double min=100000000.0;
  
  //constructers
  public Complex(Basic inBasic, String inName)
  {
    complex=new double [inBasic.getBasic().length][inBasic.getBasic().length];
    basicData=inBasic;
    name=inName;
    for (int r=0;r<inBasic.getBasic().length;r++)
    {
      if (basicData.getBasic()[r][2]==0)
      {
        odd=.9*(basicData.getBasic()[r][1])*(1-basicData.getBasic()[r][0]);
        even=-(basicData.getBasic()[r][1])*(basicData.getBasic()[r][0]);
      }
      else
      {
        even=.9*(basicData.getBasic()[r][1])*(1-basicData.getBasic()[r][0]);
        odd=-(basicData.getBasic()[r][1])*(basicData.getBasic()[r][0]);
      }
      for (int c=0;c<inBasic.getBasic().length;c++)
      { 
        if (r==c)
        {
          complex[r][c]=odd;
        }
        else
        {
          complex[r][c]=even;
        }
      }
    }
    totals=new double [inBasic.getBasic().length];
    for (int c=0;c<inBasic.getBasic().length;c++)
    {
      sum=0;
      for (int r=0;r<inBasic.getBasic().length;r++)
      {
        sum+=complex[r][c];
      }
      totals[c]=sum;
    }
    
    for (int i=0;i<inBasic.getBasic().length;i++)
    {
      if (totals[i]>max)
      {
        max=totals[i]; 
      }
      if (totals[i]<min)
      {
        min=totals[i]; 
      }
    }
  }
  
  //getters
  public double [][] getComplex()
  {
    return complex;
  }
  
  public double [] getTotals()
  {
   return totals; 
  }
  
//setters
  public void setComplex(double [][] inComplex)
  {
    complex=inComplex;
  }
  
//toString
  public String toString()
  {
    DecimalFormat df= new DecimalFormat("####0.00");
    String toReturn="\t\t\t\t\t\t"+name;
    toReturn+="\n\t\t";
   for(int i=0;i<basicData.getBasic().length;i++)
   {
    toReturn+=("Contribution if B"+(i+1)+"\t");
   }
    toReturn+=("\n");
   for (int r=0; r<basicData.getBasic().length;r++)
   {
     toReturn+=(basicData.getBracketNames().getBrackets()[r]);
     for (int c=0;c<basicData.getBasic().length;c++)
     {
       toReturn+=("\t\t"+df.format(complex[r][c]));
     }
     toReturn+="\n";
   }
   toReturn+="------------------------------------------------------------------------------------------------------------------------------------------------------------------";
   toReturn+=("\nProfits    \t\t");
   for (int i=0;i<basicData.getBasic().length;i++)
   {
     toReturn+=(df.format(totals[i])+"\t\t"); 
   }
   toReturn+="------------------------------------------------------------------------------------------------------------------------------------------------------------------";
   toReturn+="\n";
   toReturn+="\n";
   toReturn+=("Lowest Possible Profits (Risk): "+df.format(min));
   toReturn+=("\n\nHighest Possible Profits: "+df.format(max));
   if (min>0)
   {
     toReturn+=("\nYou have achieved negative risk. You are guaranteed profits");
   }
   toReturn+=("\n===================================================================================================================================================================");
   return toReturn;
  } 
}























