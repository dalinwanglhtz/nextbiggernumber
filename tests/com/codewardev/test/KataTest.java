package com.codewardev.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.codewardev.Kata;

class KataTest {

	@Test
    public void basicTests() {
         assertEquals(21, Kata.nextBiggerNumber(12));
         assertEquals(531, Kata.nextBiggerNumber(513));
         assertEquals(2071, Kata.nextBiggerNumber(2017));
         assertEquals(441, Kata.nextBiggerNumber(414));
         assertEquals(414, Kata.nextBiggerNumber(144));
    }

}
