import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class ContractManager {
	
    private ArrayList<Contract> contracts;

    public String toString() {
        // If there are no contracts found it just returns a blank "".
        if (contracts.size() == 0) 
        {
            return "";
        }
        
        String contractPrint = "";
        // Loops through the Contract objects in the ArrrayList.
        for (Contract c : contracts) {
            contractPrint = contractPrint + c.toString() + "\n\n";
        }
        // Returns the contracts in a formatted string.
        return contractPrint;
    }
    
    public double getEstimate(int invoiceNumber) {
        // Loop through each Contract in the list
        for (Contract c : contracts) 
        {
            // Check if this contract has the invoice number we want
            if (c.getInvoiceNumber() == invoiceNumber) 
            {
                return c.getEstimate();
            }
        }
        return -1;
    }
    
    public ContractManager(String filePath) throws FileNotFoundException {

        File file = null;

        // Creates the ArrayList contracts.
        contracts = new ArrayList<Contract>();

        // Uses the filePath provided by the client program.
        file = new File(filePath);

        // If the file does not exist, the user gets the prompt that it is not found.
        if (!file.exists()) 
        {
           System.out.println("File not found.");
        }

        // Creates a Scanner to read the file AFTER confirming it exists.
        Scanner fileScanner = new Scanner(file);

        // Reads the file line by line.
        while (fileScanner.hasNextLine()) 
        {
            String name = fileScanner.nextLine();
            String address = fileScanner.nextLine();

            // Changes a string to an integer
            int hvyCleanup = Integer.parseInt(fileScanner.nextLine());
            int lghtCleanup = Integer.parseInt(fileScanner.nextLine());
            // Changes string into a double.
            double sqrYards = Double.parseDouble(fileScanner.nextLine());
            
            // Creates a new Contract named client using the information gathered from the file.
            Contract client = new Contract(name, address, hvyCleanup, lghtCleanup, sqrYards);
            
            // Adds the info in client to the ArrayList contracts.
            contracts.add(client);
        }

        fileScanner.close();
        
        // If the ArrayList is empty, the user gets the prompt that it is empty.
        if (contracts.size() == 0) 
        {
            System.out.println("The file is empty.");
        }
    }
}