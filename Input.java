import java.util.Scanner;

/**
* Class InputReader reads user input from the keyboard.
* @version 2012.06.05
* @author Colleen Penrowley
*   Heavily modified by Matthew Molski added (Boolean, Float, Char, Long, Byte, and Short) 
*   Modification date: 2022-09-12
*/

public class Input
{
    private Scanner scanner;
    /** Create a new InputReader to read user input.
       */
    public Input()
    {
        scanner = new Scanner(System.in);
    }
    
    public String getString()
    
   {
       
       scanner = new Scanner(System.in);
       return scanner.nextLine();
    
    }

    /**
    * Gets the user's input
    * @return the user's input as an int
    */

   public int getInt()
   {
       try { return scanner.nextInt();}
        
       catch(java.util.InputMismatchException e) 
       {
            System.out.println("Not a number - treating as zero");
            scanner.nextLine(); // clear the buffer
            return 0;
       }
    }
    
    public boolean getBoolean()
   {
         Scanner scan = new Scanner(System.in); 
         return scan.nextBoolean();
    }
    
    public char getChar() {
        Scanner sc = new Scanner(System.in);   
        char c = sc.next().charAt(0);
        return c;
    }
    
    public long getLong() {
        try { return scanner.nextLong();}
        
       catch(java.util.InputMismatchException e) 
       {
            System.out.println("Not a number - treating as zero");
            scanner.nextLine(); // clear the buffer
            return 0;
       }
    }
    
    public float getFloat() {
        Scanner scan = new Scanner(System.in); 
         return scan.nextFloat();
    }
    
    public byte getByte() {
        Scanner scan = new Scanner(System.in); 
         return scan.nextByte();
    }
    
    public short getShort(){
        Scanner scan = new Scanner(System.in); 
         return scan.nextShort();
    }
    
    public double getDouble() {
       try { return scanner.nextDouble();}
        
       catch(java.util.InputMismatchException e) 
       {
            System.out.println("Not a number - treating as zero");
            scanner.nextLine(); // clear the buffer
            return 0;
       }
    }
}
