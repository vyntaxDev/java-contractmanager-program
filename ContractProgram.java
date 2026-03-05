import java.io.*;
import java.util.Scanner;

public class ContractProgram  { 

    public static void main(String[] args) throws FileNotFoundException  {

        boolean fileFlag = false;    
        Scanner stdin = new Scanner(System.in);
        String fileName = "";

        // This loops until a file is found/valid.
        while (!fileFlag) {
            System.out.print("What is the path to the file containing the contracts? ");
            fileName = stdin.nextLine();
            // Creates a File object using the name the user typed.
            File file = new File(fileName);
            // Checks if the file actually exists.
            if (file.exists()) 
            {
            	// Sets the flag to true so the loop stops.
                fileFlag = true; 
            } 
            else 
            {
                // If the file does NOT exist, the user gets this message.
                System.out.println("File not found.");
            }
        }

		// Creates the ContractManager using the file the user gave us.
		// This reads the file, builds all the Contract objects,
		// and stores them inside the new "manager" so we can work with them.
		ContractManager manager = new ContractManager(fileName);
		
        // Prints all contracts stored inside the ContractManager.
        System.out.println(manager);
        // Test1
        
        System.out.println("Requesting estimate for contract 0; expecting -1.");
        System.out.println("Result: " + manager.getEstimate(0));
        System.out.print("");

        // Test2
        System.out.println("Requesting estimate for contract 1; expecting a valid estimate.");
        System.out.println("Result: " + manager.getEstimate(1));
        System.out.print("");

        // Test3
        System.out.println("Requesting estimate for contract 4; expecting a valid estimate if it exists.");
        System.out.println("Result: " + manager.getEstimate(4));
        System.out.print("");

        // Closes the scanner now that we are done with user input.
        stdin.close();
    }
}