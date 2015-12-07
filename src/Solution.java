import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
    	
    	int k = 1;
    	k = (k=4) + ++k;
    	System.out.println(k);
        chuckCodeGenerator("hh");
        
    }
    
   	private static String getBits(String letter) {
		byte[] bytes = letter.getBytes();
		StringBuilder binary = new StringBuilder();
		for (byte b : bytes) {
			int val = b;
			for (int i = 0; i < 8; i++) {
				binary.append((val & 128) == 0 ? 0 : 1);
				val <<= 1;
			}

		}
		return String.valueOf(binary);
	}

	private static void chuckCodeGenerator(String sentence) {
		String binarySentence = "";
		char[] digitArray = sentence.toCharArray();
		for (int i = 0; i < sentence.length(); i++) {
			String binaryLetter = getBits(String.valueOf(digitArray[i]));
			if (binaryLetter.charAt(0) == '0'){
				binarySentence += binaryLetter.substring(1);
			}
			else {
				binarySentence += binaryLetter;
			}
		}
		String chuckCode = getSeries(binarySentence);
		System.out.println(chuckCode);

	}

	private static String getSeries(String binarySentence) {
		char[] digitsArray = binarySentence.toCharArray();
		boolean serieEnded = true;
		boolean ones = false;
		String code = "";
		for (int i = 0; i < digitsArray.length; i++) {

			int counter = i;
			if (serieEnded) {
				if (digitsArray[i] == '0') {
					ones = false;
					code += "00 0";

				} else {
					ones = true;
					code += "0 0";
				}
				serieEnded = false;
			}
			while (!serieEnded) {
			    if (counter < digitsArray.length - 1){
    				counter++;
    				if (ones) {
    					if (digitsArray[counter] == '1') {
    						code += "0";
    					} else {
    						i = counter - 1;
    						serieEnded = true;
    						code += " ";
    						break;
    					}
    				} else {
    					if (digitsArray[counter] == '0') {
    						code += "0";
    					} else {
    						i = counter - 1;
    						serieEnded = true;
    						code += " ";
    						break;
    					}
    				}
			    }
			    else {
				    serieEnded = true;
				    i = digitsArray.length;
				    break;
				}
			}
		}
			
        return code;
		
	}
}