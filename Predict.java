public class Predict
{
 public static void main (String [] args)
 {
  //create a new Brackets for Obama's Job Approval 
   Brackets obamaJobApproval=new Brackets("49.5%+     ", "49.0%-49.4%","48.5%-48.9%", "48.0%-48.4%", "47.9%-     ");
   
   //create a new Bracket for California Democratic Primary
   Brackets caDemPrimary=new Brackets( "Hillary Clinton", "Bernie Sanders");
   
   //create a new Bracket for Trump vs. Clinton polling
   Brackets tvC=new Brackets("Clinton +5.0% or more", "Clinton +4.0% to 4.9%", "Clinton +3.0% to 3.9%", "Clinton +2.0% to 2.9%", 
                             "Clinton lead by 1.9% or less");

   
   //create a new Basic for my Investment in Obama's Job Approval that comes out on May 27th
   Basic oJAMay27=new Basic(obamaJobApproval);
   oJAMay27.addData(.26, 20, 0);
   oJAMay27.addData(.38, 10, 0);
   oJAMay27.addData(.32, 10, 0);
   oJAMay27.addData(.86, 10, 1);
   oJAMay27.addData(.95, 10, 1);
   
   //create a new Basic for my Investment in California Democratic Primary
   Basic calDPJune7=new Basic(caDemPrimary);
   calDPJune7.addData(.72, 75, 0);
   calDPJune7.addData(0,0,0);
   
   //create a new Basic for my Investment in Trump vs. Clinton polling
   Basic tvCMay26=new Basic(tvC);
   tvCMay26.addData(0,0,0);
   tvCMay26.addData(0,0,0);
   tvCMay26.addData(0,0,0);
   tvCMay26.addData(0,0,0);
   tvCMay26.addData(.80,25,0);
   
   //create a new Complex for my Investment in Obama's Job Approval that comes out on May 27th
   Complex cOJAMay27=new Complex(oJAMay27, "My Investment in Obama's Job Approval that comes out on May 27th");
   
   //create a new Complex for my Investment in California Democratic Primary that comes out on June 7th
   Complex ccalDPJune7=new Complex(calDPJune7, "My Investment in California Democratic Primary that comes out on June 7th");
   
   //create a new Complex for my Investment in Trump vs. Clinton Polling that comes out on May 26th
   Complex ctvCMay26=new Complex(tvCMay26, "My Investment in Trump vs. Clinton Polling that comes out on May 26th");
   
   //create a new Library for my Investments
   Library vivek=new Library(cOJAMay27, ctvCMay26, ccalDPJune7);
   
   //test toString and class methods
   System.out.println(vivek);
   System.out.println(vivek.profitCombos());
   
 }
}
