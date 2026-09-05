package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static com.solairerove.dsa.problems.P0150_EvaluateReversePolishNotation.evalRPN;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0150_EvaluateReversePolishNotationTest {

    @Test
    void leetCodeExampleOne() {
        assertEquals(9, evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }

    @Test
    void leetCodeExampleTwo() {
        assertEquals(6, evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }

    @Test
    void leetCodeExampleThree() {
        assertEquals(22, evalRPN(new String[]{
                "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

    @Test
    void singleNumber() {
        assertEquals(42, evalRPN(new String[]{"42"}));
    }

    @Test
    void singleNegativeNumber() {
        assertEquals(-7, evalRPN(new String[]{"-7"}));
    }

    @Test
    void subtractionIsOrderSensitive() {
        assertEquals(-1, evalRPN(new String[]{"2", "3", "-"}));
    }

    @Test
    void divisionIsOrderSensitive() {
        assertEquals(0, evalRPN(new String[]{"3", "6", "/"}));
    }

    @Test
    void divisionTruncatesTowardZero() {
        assertEquals(-2, evalRPN(new String[]{"-7", "3", "/"}));
        assertEquals(2, evalRPN(new String[]{"7", "3", "/"}));
    }

    @Test
    void multiplicationWithNegative() {
        assertEquals(-12, evalRPN(new String[]{"4", "-3", "*"}));
    }

    @Test
    void allOperatorsChained() {
        assertEquals(5, evalRPN(new String[]{"1", "2", "+", "9", "*", "3", "/", "4", "-"}));
    }

    @Test
    void deeplyNestedExpression() {
        assertEquals(18, evalRPN(new String[]{"3", "4", "+", "2", "*", "7", "/", "5", "*", "8", "+"}));
    }
}
