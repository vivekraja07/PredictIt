import java.text.DecimalFormat;
public class Basic
{
  //instance variables
  private double [][] basic;
  private Brackets bracketNames;
  private int count=0;
  
  //constructors
  public Basic(Brackets inBrackets)
  {
   basic=new double [inBrackets.getNumberOfBrackets()][4]; 
   bracketNames=inBrackets;
  }
  
  //adders of data
  public void addData(double inAvgCost, double inSharesOwned, double inYesNo)
  {
    basic[count][0]=inAvgCost;
    basic[count][1]=inSharesOwned;
    basic[count][2]=inYesNo;
    basic[count][3]=(basic[count][0])*(basic[count][1]);  
    count++;
  }
  
  //getters
  public double [][] getBasic()
  {
    return basic;
  }
   
   public Brackets getBracketNames()
  {
    return bracketNames;
  }
   
  //setters
  public void setBasic(double[][] inBasic)
  {
  basic=inBasic;
  }
  
  //toString
  public String toString()
  {
    DecimalFormat df= new DecimalFormat("####0.00");
    String toReturn="";
    toReturn+=("\t\tAvg Cost\tShares\tYes/No\tTotal Cost");
    for (int n=0;n<bracketNames.getNumberOfBrackets();n++)
    {
      toReturn+=("\n"+bracketNames.getBrackets()[n]+"\t"+df.format(basic[n][0])+"\t"+df.format(basic[n][1])+"\t"+df.format(basic[n][2])+"\t"+df.format(basic[n][3])); 
    } 
    return toReturn;
  }
}