package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static com.solairerove.dsa.problems.P0394_DecodeString.decodeString;
import static com.solairerove.dsa.problems.P0394_DecodeString.decodeStringDeque;
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
    void dequeLeetcodeExampleOne() {
        assertEquals("aaabcbc", decodeStringDeque("3[a]2[bc]"));
    }

    @Test
    void dequeLeetcodeExampleTwo() {
        assertEquals("accaccacc", decodeStringDeque("3[a2[c]]"));
    }

    @Test
    void dequeLeetcodeExampleThree() {
        assertEquals("abcabccdcdcdef", decodeStringDeque("2[abc]3[cd]ef"));
    }

    @Test
    void dequeNoEncoding() {
        assertEquals("abc", decodeStringDeque("abc"));
    }

    @Test
    void dequeEmptyInput() {
        assertEquals("", decodeStringDeque(""));
    }

    @Test
    void dequeSingleRepeat() {
        assertEquals("x", decodeStringDeque("1[x]"));
    }

    @Test
    void dequeMultiDigitCount() {
        assertEquals("aaaaaaaaaa", decodeStringDeque("10[a]"));
    }

    @Test
    void dequeTripleNesting() {
        assertEquals("aaaaaaaa", decodeStringDeque("2[2[2[a]]]"));
    }

    @Test
    void dequeLiteralBeforeAndAfter() {
        assertEquals("abbc", decodeStringDeque("a2[b]c"));
    }

    @Test
    void dequeTrailingLiteral() {
        assertEquals("aaab", decodeStringDeque("3[a]b"));
    }

    @Test
    void dequeNestedAfterLiteralInside() {
        assertEquals("abcccabccc", decodeStringDeque("2[ab3[c]]"));
    }

    @Test
    void dequeNestedWithMultiDigitCounts() {
        assertEquals("ab".repeat(12), decodeStringDeque("3[4[ab]]"));
    }

    @Test
    void dequeLargeCount() {
        assertEquals("leetcode".repeat(100), decodeStringDeque("100[leetcode]"));
    }

    @Test
    void dequeTwoNestedSiblings() {
        assertEquals("xyyxyyzz", decodeStringDeque("2[x2[y]]2[z]"));
    }

    @Test
    void dequeDeepNestingWithSuffix() {
        assertEquals("accaccaccb", decodeStringDeque("3[a2[c]]b"));
    }
}
