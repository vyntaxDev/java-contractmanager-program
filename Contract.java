import java.io.*;
import java.util.Scanner;

/**
 * This class creates a Contract object for a landscaping company.
 */
public class Contract {
	// Private Variable
	
	// This adds a counter to the class and a new variable for the invoice number.
	private static int counter = 0;
	private int invoiceNumber;
	
	private String name;
	private String address;
	private int heavyCleanup;
	private int lightCleanup;
	private double squareYards;
	
	/**
	 * 
	 * @param name				Customer's name
	 * @param address			Customer's address
	 * @param heavyCleanup		Hours taken for heavy cleanup
	 * @param lightCleanup		Hours taken for light cleanup
	 * @param squareYards		The size of the yards for cleanup in square yards.
	 */
public Contract(String name, String address, int heavyCleanup,
				int lightCleanup, double squareYards) {
	this.name = name;
	this.address = address;
	this.heavyCleanup = heavyCleanup;
	this.lightCleanup = lightCleanup;
	this.squareYards = squareYards;
	// Adds +1 to the counter in this class. 
	this.invoiceNumber = ++Contract.counter;

}
/**
 * lightRate 		16.00/hr (2026 RI Min. Wage)
 * heavyRate		The lightRate multiplied by 1.5
 * mowingRate 		Rate charged by (light rate x 1.2) then multiplied by the (sqYards divided by 2000)
 * estimate			Takes the lightRate + heavyRate + mowingRate to produce an estimate
 * @return			The total estimate for the lawn service.
 */
public double getEstimate() {
	double lightRate = 16.00;
	double heavyRate = 16.00 * 1.5;
	double mowingRate = (lightRate * 1.2) * (this.squareYards/2000);
	double estimate = (lightRate * this.lightCleanup)+ (heavyRate * this.heavyCleanup) + mowingRate;
	return estimate;
}

/**
 * 
 * @return	invoiceNumber		Returns the number of the invoice.
 */
public int getInvoiceNumber() {
	return this.invoiceNumber;
}

/**
 * Allows for the return of a formatted string of the contract.
 */
public String toString() {
	return String.format(
			"Name:                    %-25s\n" + 
			"Address:                 %-25s\n" +
			"Invoice number:          %-25d\n" +
			"Heavy cleanup hours:     %-25d\n" +
			"Light cleanup hours:     %-25d\n" + 
			"Square yards:            %-25.2f", 
			this.name, this.address, this.invoiceNumber, this.heavyCleanup, this.lightCleanup, this.squareYards);
}
}
