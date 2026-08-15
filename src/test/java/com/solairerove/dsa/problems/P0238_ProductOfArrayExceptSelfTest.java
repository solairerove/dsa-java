package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SuppressWarnings("NewClassNamingConvention")
class P0238_ProductOfArrayExceptSelfTest {

    @Test
    void productExceptSelf_example1() {
        assertArrayEquals(new int[]{24, 12, 8, 6}, P0238_ProductOfArrayExceptSelf.productExceptSelf(new int[]{1, 2, 3, 4}));
    }

    @Test
    void productExceptSelf_example2() {
        assertArrayEquals(new int[]{0, 0, 9, 0, 0}, P0238_ProductOfArrayExceptSelf.productExceptSelf(new int[]{-1, 1, 0, -3, 3}));
    }

    @Test
    void productExceptSelf_commentWalkthrough() {
        assertArrayEquals(new int[]{48, 24, 12, 8}, P0238_ProductOfArrayExceptSelf.productExceptSelf(new int[]{1, 2, 4, 6}));
    }

    @Test
    void productExceptSelf_twoElements() {
        assertArrayEquals(new int[]{7, 3}, P0238_ProductOfArrayExceptSelf.productExceptSelf(new int[]{3, 7}));
    }

    @Test
    void productExceptSelf_singleZero() {
        assertArrayEquals(new int[]{0, 0, 24, 0}, P0238_ProductOfArrayExceptSelf.productExceptSelf(new int[]{2, 3, 0, 4}));
    }

    @Test
    void productExceptSelf_twoZeros() {
        assertArrayEquals(new int[]{0, 0, 0, 0}, P0238_ProductOfArrayExceptSelf.productExceptSelf(new int[]{2, 0, 0, 4}));
    }

    @Test
    void productExceptSelf_allNegative() {
        assertArrayEquals(new int[]{-24, -12, -8, -6}, P0238_ProductOfArrayExceptSelf.productExceptSelf(new int[]{-1, -2, -3, -4}));
    }

    @Test
    void productExceptSelf_mixedSigns() {
        assertArrayEquals(new int[]{-6, 6, 3, -2}, P0238_ProductOfArrayExceptSelf.productExceptSelf(new int[]{-1, 1, 2, -3}));
    }

    @Test
    void productExceptSelf_allOnes() {
        assertArrayEquals(new int[]{1, 1, 1, 1}, P0238_ProductOfArrayExceptSelf.productExceptSelf(new int[]{1, 1, 1, 1}));
    }

    @Test
    void productExceptSelf_singleElement() {
        assertArrayEquals(new int[]{1}, P0238_ProductOfArrayExceptSelf.productExceptSelf(new int[]{9}));
    }

    @Test
    void productExceptSelf_doesNotMutateInput() {
        int[] nums = {1, 2, 3, 4};

        var res = P0238_ProductOfArrayExceptSelf.productExceptSelf(nums);
        assertNotNull(res);

        assertArrayEquals(new int[]{1, 2, 3, 4}, nums);
    }

    @Test
    void productExceptSelf_matchesBruteForceOnRandomInput() {
        Random random = new Random(238);
        for (int t = 0; t < 200; t++) {
            int[] nums = randomArray(random);

            assertArrayEquals(bruteForce(nums), P0238_ProductOfArrayExceptSelf.productExceptSelf(nums));
        }
    }

    private static int[] randomArray(Random random) {
        int[] nums = new int[2 + random.nextInt(15)];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(9) - 4;
        }

        return nums;
    }

    private static int[] bruteForce(int[] nums) {
        int[] expected = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                    product *= nums[j];
                }
            }
            expected[i] = product;
        }

        return expected;
    }
}
