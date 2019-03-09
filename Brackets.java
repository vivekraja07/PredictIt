public class Brackets
{
  private int numberOfBrackets;
  private String [] brackets;
  
 //constructors 
  public Brackets(String... inBrackets)
  {
    numberOfBrackets=inBrackets.length;
    brackets=new String [numberOfBrackets];
    for (int i=0;i<numberOfBrackets;i++)
    {
     brackets[i]=inBrackets[i]; 
    }
    
  }
//getters
  public int getNumberOfBrackets()
  {
   return numberOfBrackets; 
  }
  
  public String [] getBrackets()
  {
   return brackets; 
  }
  
//setters  
  public void setBrackets(String []inBrackets)
  {
   brackets=inBrackets; 
  }
  
//toString
  public String toString()
  {
    String toReturn="There are "+numberOfBrackets+" brackets:";
    toReturn+="\n";
    for (int i=0;i<numberOfBrackets;i++)
   {
    toReturn+=brackets[i]+"\t";  
    }
    return toReturn;
  }
}