package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0049_GroupAnagramsTest {

    private static Set<Set<String>> asSetOfSets(List<List<String>> groups) {
        return groups.stream().map(HashSet::new).collect(Collectors.toSet());
    }

    @Test
    void groupsAnagramsTogether() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> result = P0049_GroupAnagrams.groupAnagrams(strs);

        Set<Set<String>> expected = Set.of(
                Set.of("eat", "tea", "ate"),
                Set.of("tan", "nat"),
                Set.of("bat")
        );
        assertEquals(expected, asSetOfSets(result));
    }

    @Test
    void singleEmptyString() {
        String[] strs = {""};

        List<List<String>> result = P0049_GroupAnagrams.groupAnagrams(strs);

        assertEquals(Set.of(Set.of("")), asSetOfSets(result));
    }

    @Test
    void singleCharacterStrings() {
        String[] strs = {"a"};

        List<List<String>> result = P0049_GroupAnagrams.groupAnagrams(strs);

        assertEquals(Set.of(Set.of("a")), asSetOfSets(result));
    }

    @Test
    void emptyAndNonEmptyStringsSeparate() {
        String[] strs = {"", "b", ""};

        List<List<String>> result = P0049_GroupAnagrams.groupAnagrams(strs);

        assertEquals(2, result.size());
        assertEquals(Set.of(Set.of(""), Set.of("b")), asSetOfSets(result));
    }

    @Test
    void keepsDuplicatesInGroup() {
        String[] strs = {"abc", "abc", "cba"};

        List<List<String>> result = P0049_GroupAnagrams.groupAnagrams(strs);

        assertEquals(1, result.size());
        assertEquals(3, result.getFirst().size());
    }

    @Test
    void sameLettersDifferentCountsNotGrouped() {
        String[] strs = {"aab", "abb", "ab"};

        List<List<String>> result = P0049_GroupAnagrams.groupAnagrams(strs);

        assertEquals(Set.of(Set.of("aab"), Set.of("abb"), Set.of("ab")), asSetOfSets(result));
    }

    @Test
    void handlesLongRepeatedCharacters() {
        String a = "z".repeat(100);
        String[] strs = {a, a, "z".repeat(99) + "y"};

        List<List<String>> result = P0049_GroupAnagrams.groupAnagrams(strs);

        assertEquals(2, result.size());
    }
}
