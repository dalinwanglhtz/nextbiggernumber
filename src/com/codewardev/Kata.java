package com.codewardev;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

// https://www.codewars.com/kata/next-bigger-number-with-the-same-digits/train/java

public class Kata {

	public static long nextBiggerNumber(long n) {
		//long highest = getHighest(n);
		System.out.println("N is: "+n);
		int[] num = Arrays.stream(String.valueOf(n).split("")).mapToInt(Integer::parseInt).toArray();
		long nextBigNum = -1;
		boolean found=false;
		int[] newNum = new int[num.length];
		for(int i=num.length-1; i>=0; i--) {
			int j=1;
			while(j<num.length) {
				if(num[i]>num[i-j]) {
					for(int k=0; k<i-j; k++) {
						newNum[k] = num[k];
					}
					newNum[i-j] = num[i];
					for(int l=i-j+1; l<num.length; l++) {
						newNum[l] = num[l-1];
					}
					nextBigNum = Long.parseLong(Arrays.stream(newNum).mapToObj(String::valueOf).collect(Collectors.joining()));
					found = true;
					break;
				}
				j++;
			}
			if(found) break;
		}
		return nextBigNum;
	}

	private static long getHighest(long n) {
		return Long.parseLong(Arrays.stream(String.valueOf(n).split(""))
				.mapToInt(Integer::parseInt)
				.boxed()
				.sorted(Collections.reverseOrder())
				.map(String::valueOf)
				.collect(Collectors.joining()));
	}

}
