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
		int temp=0;
		int j=1;
		boolean found=false;
		while(j<=num.length) {
			for(int i=num.length-1; i>=0; i--) {
				if(num[i]>num[i-j]) {
					temp = num[i];
					num[i] = num[i-j];
					num[i-j] = temp;
					nextBigNum = Long.parseLong(Arrays.stream(num).mapToObj(String::valueOf).collect(Collectors.joining()));
					found = true;
					break;
				}
			}
			if(found) break;
			j++;
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
