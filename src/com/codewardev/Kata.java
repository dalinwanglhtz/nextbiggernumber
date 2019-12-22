package com.codewardev;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// https://www.codewars.com/kata/next-bigger-number-with-the-same-digits/train/java

public class Kata {

	public static long nextBiggerNumber(long n) {
		//long highest = getHighest(n);
		System.out.println("N is: "+n);
		int[] num = Arrays.stream(String.valueOf(n).split("")).mapToInt(Integer::parseInt).toArray();

		boolean found = false;
		int digit4Insert = -1;
		int index4Insert = -1;
		int origIndex = -1;
		// Go over the array from right most digit
		for(int i=num.length-1; i>=0; i--) {
		// Find number at index x that's smaller than number at x-1;
			if(i-1 >= 0 && num[i]>num[i-1]) {
				// Find the number at index greater than x-1 that immediately bigger than number at index x
				for(int j=num.length-1; j>=i; j--) {
					if(num[j]>num[i-1]) {
						found = true;
						digit4Insert = num[j];
						origIndex = j;
						index4Insert = i-1;
						break;
					}
				}
			}
			if(found) break;
		}
		// Insert the y at index x
		if(digit4Insert != -1) {
			int[] newNum = insertElemToArray(num, digit4Insert, index4Insert, origIndex);
			
			// Get final result from array
			return Long.parseLong(Arrays.stream(newNum).mapToObj(String::valueOf).collect(Collectors.joining()));
		} else {
			return -1;
		}
	}

	private static int[] insertElemToArray(int[] num, int digit4Insert, int j, int orig) {
		int[] newNum = Arrays.copyOf(num, num.length);
		
		newNum[orig] = newNum[j];
		newNum[j] = digit4Insert;
		
		int[] array1 = Arrays.copyOfRange(newNum, 0, j+1);
		int[] array2 = Arrays.copyOfRange(newNum, j+1, newNum.length);
		List<Integer> newArray = Arrays.stream(array1).boxed().collect(Collectors.toList());
		
		// Sort in ascending order all numbers at index greater than index of y
		newArray.addAll(Arrays.stream(array2).boxed().sorted().collect(Collectors.toList()));
		
		// Merge the new integer array
		return newArray.stream().mapToInt(Integer::intValue).toArray();
	}

}
