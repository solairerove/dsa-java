package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static com.solairerove.dsa.problems.P0394_DecodeString.decodeString;
import static com.solairerove.dsa.problems.P0394_DecodeString.decodeStringTwoStacks;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0394_DecodeStringTest {

    @Test
    void leetcodeExampleOne() {
        assertEquals("aaabcbc", decodeString("3[a]2[bc]"));
    }

    @Test
    void leetcodeExampleTwo() {
        assertEquals("accaccacc", decodeString("3[a2[c]]"));
    }

    @Test
    void leetcodeExampleThree() {
        assertEquals("abcabccdcdcdef", decodeString("2[abc]3[cd]ef"));
    }

    @Test
    void noEncoding() {
        assertEquals("abc", decodeString("abc"));
    }

    @Test
    void emptyInput() {
        assertEquals("", decodeString(""));
    }

    @Test
    void singleRepeat() {
        assertEquals("x", decodeString("1[x]"));
    }

    @Test
    void multiDigitCount() {
        assertEquals("aaaaaaaaaa", decodeString("10[a]"));
    }

    @Test
    void tripleNesting() {
        assertEquals("aaaaaaaa", decodeString("2[2[2[a]]]"));
    }

    @Test
    void literalBeforeAndAfter() {
        assertEquals("abbc", decodeString("a2[b]c"));
    }

    @Test
    void trailingLiteral() {
        assertEquals("aaab", decodeString("3[a]b"));
    }

    @Test
    void nestedAfterLiteralInside() {
        assertEquals("abcccabccc", decodeString("2[ab3[c]]"));
    }

    @Test
    void nestedWithMultiDigitCounts() {
        assertEquals("ab".repeat(12), decodeString("3[4[ab]]"));
    }

    @Test
    void largeCount() {
        assertEquals("leetcode".repeat(100), decodeString("100[leetcode]"));
    }

    @Test
    void twoNestedSiblings() {
        assertEquals("xyyxyyzz", decodeString("2[x2[y]]2[z]"));
    }

    @Test
    void deepNestingWithSuffix() {
        assertEquals("accaccaccb", decodeString("3[a2[c]]b"));
    }

    @Test
    void twoStacksLeetcodeExampleOne() {
        assertEquals("aaabcbc", decodeStringTwoStacks("3[a]2[bc]"));
    }

    @Test
    void twoStacksLeetcodeExampleTwo() {
        assertEquals("accaccacc", decodeStringTwoStacks("3[a2[c]]"));
    }

    @Test
    void twoStacksLeetcodeExampleThree() {
        assertEquals("abcabccdcdcdef", decodeStringTwoStacks("2[abc]3[cd]ef"));
    }

    @Test
    void twoStacksNoEncoding() {
        assertEquals("abc", decodeStringTwoStacks("abc"));
    }

    @Test
    void twoStacksEmptyInput() {
        assertEquals("", decodeStringTwoStacks(""));
    }

    @Test
    void twoStacksSingleRepeat() {
        assertEquals("x", decodeStringTwoStacks("1[x]"));
    }

    @Test
    void twoStacksMultiDigitCount() {
        assertEquals("aaaaaaaaaa", decodeStringTwoStacks("10[a]"));
    }

    @Test
    void twoStacksTripleNesting() {
        assertEquals("aaaaaaaa", decodeStringTwoStacks("2[2[2[a]]]"));
    }

    @Test
    void twoStacksLiteralBeforeAndAfter() {
        assertEquals("abbc", decodeStringTwoStacks("a2[b]c"));
    }

    @Test
    void twoStacksTrailingLiteral() {
        assertEquals("aaab", decodeStringTwoStacks("3[a]b"));
    }

    @Test
    void twoStacksNestedAfterLiteralInside() {
        assertEquals("abcccabccc", decodeStringTwoStacks("2[ab3[c]]"));
    }

    @Test
    void twoStacksNestedWithMultiDigitCounts() {
        assertEquals("ab".repeat(12), decodeStringTwoStacks("3[4[ab]]"));
    }

    @Test
    void twoStacksLargeCount() {
        assertEquals("leetcode".repeat(100), decodeStringTwoStacks("100[leetcode]"));
    }

    @Test
    void twoStacksTwoNestedSiblings() {
        assertEquals("xyyxyyzz", decodeStringTwoStacks("2[x2[y]]2[z]"));
    }

    @Test
    void twoStacksDeepNestingWithSuffix() {
        assertEquals("accaccaccb", decodeStringTwoStacks("3[a2[c]]b"));
    }
}
