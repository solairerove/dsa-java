package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0271_EncodeAndDecodeStringsTest {

    private static void assertRoundTrip(List<String> strs) {
        assertEquals(strs, P0271_EncodeAndDecodeStrings.decode(P0271_EncodeAndDecodeStrings.encode(strs)));
    }

    @Test
    void encode_example1() {
        assertEquals("5#hello5#world", P0271_EncodeAndDecodeStrings.encode(List.of("hello", "world")));
    }

    @Test
    void encode_emptyList() {
        assertEquals("", P0271_EncodeAndDecodeStrings.encode(List.of()));
    }

    @Test
    void encode_emptyStrings() {
        assertEquals("0#0#0#", P0271_EncodeAndDecodeStrings.encode(List.of("", "", "")));
    }

    @Test
    void encode_stringWithDelimiter() {
        assertEquals("4#a#b#", P0271_EncodeAndDecodeStrings.encode(List.of("a#b#")));
    }

    @Test
    void decode_example1() {
        assertEquals(List.of("hello", "world"), P0271_EncodeAndDecodeStrings.decode("5#hello5#world"));
    }

    @Test
    void decode_emptyString() {
        assertEquals(List.of(), P0271_EncodeAndDecodeStrings.decode(""));
    }

    @Test
    void decode_emptyStrings() {
        assertEquals(List.of("", "", ""), P0271_EncodeAndDecodeStrings.decode("0#0#0#"));
    }

    @Test
    void roundTrip_example1() {
        assertRoundTrip(List.of("lint", "code", "love", "you"));
    }

    @Test
    void roundTrip_example2() {
        assertRoundTrip(List.of("we", "say", ":", "yes"));
    }

    @Test
    void roundTrip_singleString() {
        assertRoundTrip(List.of("neetcode"));
    }

    @Test
    void roundTrip_stringsContainingDelimiter() {
        assertRoundTrip(List.of("#", "##", "a#b", "3#c", "#4#"));
    }

    @Test
    void roundTrip_stringsThatLookLikeEncoding() {
        assertRoundTrip(List.of("5#hello", "0#", "12#abc"));
    }

    @Test
    void roundTrip_emptyAndNonEmptyMixed() {
        assertRoundTrip(List.of("", "a", "", "bc", ""));
    }

    @Test
    void roundTrip_unicodeAndWhitespace() {
        assertRoundTrip(List.of("привет мир", "  ", "\n\t", "🙂"));
    }

    @Test
    void roundTrip_longString() {
        assertRoundTrip(List.of("x".repeat(1000), "y".repeat(12345), ""));
    }

    @Test
    void roundTrip_randomStrings() {
        Random random = new Random(271);
        List<String> strs = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            int len = random.nextInt(20);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < len; j++) {
                sb.append("ab#0123 ".charAt(random.nextInt(8)));
            }
            strs.add(sb.toString());
        }

        assertRoundTrip(strs);
    }
}
