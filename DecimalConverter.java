/*	DecimalConverter.java
 * 
 * The main purpose for this class is to convert a decimal integer, which is taken from
 * the user, and alter it into various forms.
 * First the user will enter a decimal integer value.
 * Then the number that is received will first be converted to a binary digit.
 * Then it will be converted to a octal digit.
 * Finally it will be converted into a hexadecimal digit. 
 * All of these conversions will obey the length of 16 bits.
 * 
 * 	Harnoor Singh
 * 	EECS 1510 - Intro to Object Oriented
 * 	Project 1 - Decimal Converter
 * 	Dr. Joseph Hobbs
 * 
 */

//import a scanner for user input.
import java.util.Scanner; 

public class DecimalConverter
{
	public static void main(String[] args)
	{
		//Initialize Scanner
		Scanner input = new Scanner(System.in);
		
		/*The input value from the user is created as a constant here so, the value 
		 * will remain the same throughout the execution of the code, even if it 
		 * is incremented, or decremented. 
		 */	
		final int DECIMAL_NUMBER = input.nextInt();
		
		//This is the conversion for Decimal to Binary.
		String binary = "";
		int tempNumber = DECIMAL_NUMBER;
		
		/*This loop will take the modulo of the decimal value out of two, and the 
		 * value of the remainder will be added to the string variable binary. 
		 * Then the value of the decimal integer is divided by two. This is to decrement
		 * the value until it reaches a value of 0 and the loop will terminate. 
		 */
		
		while(tempNumber != 0) 
		{
			binary = (tempNumber % 2) + binary;
			tempNumber /= 2;
		}
		
		/*The integer zero is created so the appropriate number of '0' can be placed
		 * in front of the binary digit. 
		 * Thus the for loop is created to repeat until all the the value of the binary
		 * digit is 16 bits, and all the 0's have accommodated for any extra space. 
		 */
		
		int zero = 16 - binary.length();
		
		/*i is set at a position in front of the binary digit, and will run until
		 * the length of the integer variable zero, is 16 digits long.
		*/
		
		for(int i = 0; i < zero; i++)
		{
			binary = "0" + binary;	
		}
		
		/*Thus this process is repeated for the octal and hexadecimal values, 
		 * replacing the modulo values with the correct ones (8 & 16), and adjusting the 
		 * for loop length, to account for the correct number of zeros placed in front of each 
		 * binary value. 
		 */
		
		/*This is the conversion for Decimal to Octal. This contains the same procedure as
		 * the binary conversion with decimal integer by two and th 
		 */
		
		String octal = "";
		tempNumber = DECIMAL_NUMBER;
		
		while(tempNumber != 0) 
		{
			octal = (tempNumber % 8) + octal;
			tempNumber /= 8;
		}
		
		zero = 6 - octal.length();
		for(int i = 0; i < zero; i++)
		{
			octal = "0" + octal;	
		}
	
		//This is the conversion for Decimal to Hexadecimal. 
		String hexadecimal = "";
		tempNumber = DECIMAL_NUMBER;
	
		while(tempNumber != 0) 
		{
			int remainder = tempNumber % 16;

	/*This nested if statement was created in the case that the modulo of 16
	 * is larger than one character, it is assigned to a letter. This way the 
	 * hexadecimal value of the decimal integer will remain 16 bits and not become
	 * longer or violate the 16 bit length. 
	 */
			if(remainder > 9) 
			{
				if (remainder == 10) 
				{
					hexadecimal = "A" + hexadecimal;
				} 
				else if(remainder == 11)
				{
					hexadecimal = "B" + hexadecimal;
				}
				else if(remainder == 12)
				{
					hexadecimal = "C" + hexadecimal;
				}
				else if(remainder == 13)
				{
					hexadecimal = "D" + hexadecimal;
				}
				else if(remainder == 14)
				{
					hexadecimal = "E" + hexadecimal;
				}
				else if(remainder == 15)
				{
					hexadecimal = "F" + hexadecimal;
				}
			
				tempNumber /= 16;
			}
			else
			{
				hexadecimal = (tempNumber % 16) + hexadecimal;	
				tempNumber /= 16;
			}
		}
		
		zero = 4 - hexadecimal.length();
		for(int i = 0; i < zero; i++)
		{
			hexadecimal = "0" + hexadecimal;
		}
	
	//Finally print out the decimal value entered, and the corresponding binary, octal, and hexadecimal values of the decimal integer input. 	
	System.out.println(DECIMAL_NUMBER + "\n" + binary + "\n" + octal + "\n" + hexadecimal);		
	}
}
