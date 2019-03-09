import java.util.Scanner;
import java.text.DecimalFormat;
public class PredictIt1
{
  public static void main (String [] args)
  {
   System.out.println("How many brackets are there?");
   Scanner scan=new Scanner(System.in);
   DecimalFormat df= new DecimalFormat("####0.00");
   int numberOfBrackets=scan.nextInt();
   String [] brackets= new String [numberOfBrackets];
   String waste=scan.nextLine();
   for (int i=0; i<brackets.length;i++)
   {
     System.out.println("Please enter the name of B"+(i+1));
     brackets[i]=scan.nextLine();
   }
   double[][] basic=new double [numberOfBrackets][4];
   for (int nob=0;nob<numberOfBrackets;nob++)
   {
       System.out.println("Please enter the avg cost of B"+(nob+1)+": "+brackets[nob]);
       basic[nob][0]=scan.nextDouble();
        System.out.println("Please enter the shares owned of B"+(nob+1)+": "+brackets[nob]);
       basic[nob][1]=scan.nextDouble();
       System.out.println("Please enter '0' if it's a 'Yes' share or enter a '1' if it's a 'No' Share");
       basic[nob][2]=scan.nextDouble();
       basic[nob][3]=(basic[nob][0])*(basic[nob][1]);
   }
 
   double [][] complex=new double[numberOfBrackets][numberOfBrackets];
   double odd,even;
   for (int r=0;r<numberOfBrackets;r++)
   {
     if (basic[r][2]==0)
     {
      odd=.9*(basic[r][1])*(1-basic[r][0]);
      even=-(basic[r][1])*(basic[r][0]);
     }
     else
     {
      even=.9*(basic[r][1])*(1-basic[r][0]);
      odd=-(basic[r][1])*(basic[r][0]);
     }
    for (int c=0;c<numberOfBrackets;c++)
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
   System.out.println("");
   System.out.println("");
   System.out.println("");
   System.out.println("\tAvg Cost\tShares\tYes/No\tTotal Cost");
   for (int n=0;n<numberOfBrackets;n++)
   {
     System.out.println(brackets[n]+"\t"+df.format(basic[n][0])+"\t"+df.format(basic[n][1])+"\t"+df.format(basic[n][2])+"\t"+df.format(basic[n][3])); 
   }
   System.out.println();
   System.out.println();
   System.out.print("\t");
   for(int i=0;i<numberOfBrackets;i++)
   {
    System.out.print("Contribution if B"+(i+1)+"\t");
   }
    System.out.println();
   for (int r=0; r<numberOfBrackets;r++)
   {
     System.out.print(brackets[r]);
     for (int c=0;c<numberOfBrackets;c++)
     {
       System.out.print("\t\t"+df.format(complex[r][c]));
     }
     System.out.println();
     System.out.println();
   }
   double [] totals=new double [numberOfBrackets];
   double sum;
   for (int c=0;c<numberOfBrackets;c++)
   {
     sum=0;
     for (int r=0;r<numberOfBrackets;r++)
     {
      sum+=complex[r][c];
     }
     totals[c]=sum;
   }
   System.out.print("Profits\t\t");
   for (int i=0;i<numberOfBrackets;i++)
   {
    System.out.print(df.format(totals[i])+"\t\t"); 
   }
   System.out.println();
   System.out.println();
   double max=-100000000.0;
   double min=100000000.0;
   for (int i=0;i<numberOfBrackets;i++)
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
   System.out.println("Lowest Possible Profits (Risk): "+df.format(min));
   System.out.println("Highest Possible Profits: "+df.format(max));
   if (min>0)
   {
     System.out.println("You have achieved negative risk. You are guaranteed profits");
   }
  }
}