import java.util.*;
import java.util.concurrent.TimeUnit;
 
public class fruitmachine
        {       //Generate 3 random numbers    
                public static void slotNumbers(ArrayList<Integer> slotMachine)
       
                {
                        int count = 0;
                        while (count < 3)
                        {
                                Random slot = new Random();
                                int slotNumber= slot.nextInt(7)+1;
                                slotMachine.add(slotNumber);
                                count+=1;
                        }
                        return;
               
        }// End of slotNumbers method
 
// Declarations and Pay out Logic
 
public static int winnings(ArrayList<Integer> slotMachine)
                {
        int slot1= slotMachine.get(0);
        int slot2= slotMachine.get(1);
        int slot3= slotMachine.get(2);
        int credits = 0;
               
                // Jack pot match
                if(slot1==7 && slot2==7 && slot3==7)
                        {
                        credits=150;
                        return credits;
                        }
               
                // three matches
                if(slot1==slot2 && slot1==slot3 && slot2==slot3)
                        {
                        credits=80;
                        return credits;
                        }
               
               
       
                // any slot 7
               
                if (slot1==7 || slot2==7 || slot3==7)
                {
                        credits=2;
                        return credits;
                }
               
                // Two matches odd or even
                if(slot1==slot2 || slot2==slot3 || slot1==slot3)
                {
                        // checks odd
                        if (((slot1%2)==1 && (slot2%2)==1 ) || ((slot2%2==1) && (slot3%2)==1) || ((slot1%2)==1 && (slot3%2==1)))
                        {
                        credits=5;
                        return credits;
                        }
                        // checks even
                        else if(((slot1%2)==0 && (slot2%2)==0 ) || ((slot2%2==0) && (slot3%2)==0) || ((slot1%2)==0 && (slot3%2==0)))
                                {
                                        credits =10;
                                        return credits;
                                }      
                }
                        return credits; // added because cannot return void.
        }
 
               
 
@SuppressWarnings("resource")
 
public static void main(String[] args) throws InterruptedException
{      
        int userCredits;
        int credits;
        Scanner input = new  Scanner (System.in);
       
        // Allow user to bet
        System.out.println("Enter Playable bet: ");
        userCredits= input.nextInt();
        input.nextLine();
       
        while (userCredits>0)
                {
                        System.out.println("Do you want to Spin ? (y/n)" );
                        String answer= input.nextLine();
                        if (answer.equalsIgnoreCase("y"))
                                {
                                        userCredits-=1; // deduct credit for spin
                                        ArrayList<Integer> slotMachine = new ArrayList<Integer>();
                                       
                                        //get random 3 numbers
                                        slotNumbers(slotMachine);
                                       
                                        //credits earned
                                        credits=winnings(slotMachine);
                                        userCredits+=credits;
                                       
                                        // add lag
                                        for (int i=0; i<3; i++)
                                        {
                                                TimeUnit.SECONDS.sleep(1);
                                                System.out.print(slotMachine.get(i) + "\t");
                                        }
                                        // Display Credits
                                        System.out.println("\nCredits Won: " +credits);
                                        System.out.println("Credit Left: " +userCredits);
                                }
                                       
                                        else if (answer.equalsIgnoreCase("n"))
                                        {
                                        // Final Display
                                        System.out.println("Thanks for Playing!");
                                        System.out.println("Credits Left: " + userCredits);
                                        
                                        break;
                                        }
                                }//end of while
                        }// end of main
                } // end of class
