package com.codewardev.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.codewardev.Kata;

class KataTest {

	@Test
    public void basicTests() {
		assertEquals(1211521923, Kata.nextBiggerNumber(1211521392));
		assertEquals(1234567908, Kata.nextBiggerNumber(1234567890));
         assertEquals(21, Kata.nextBiggerNumber(12));
         assertEquals(531, Kata.nextBiggerNumber(513));
         assertEquals(2071, Kata.nextBiggerNumber(2017));
         assertEquals(441, Kata.nextBiggerNumber(414));
         assertEquals(414, Kata.nextBiggerNumber(144));
    }

}
