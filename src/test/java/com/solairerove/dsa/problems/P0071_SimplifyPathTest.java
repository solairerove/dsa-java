package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static com.solairerove.dsa.problems.P0071_SimplifyPath.simplifyPath;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0071_SimplifyPathTest {

    @Test
    void leetcodeExampleOne() {
        assertEquals("/home", simplifyPath("/home/"));
    }

    @Test
    void leetcodeExampleTwo() {
        assertEquals("/home/foo", simplifyPath("/home//foo/"));
    }

    @Test
    void leetcodeExampleThree() {
        assertEquals("/home/user/Pictures", simplifyPath("/home/user/Documents/../Pictures"));
    }

    @Test
    void leetcodeExampleFour() {
        assertEquals("/", simplifyPath("/../"));
    }

    @Test
    void leetcodeExampleFive() {
        assertEquals("/.../b/d", simplifyPath("/.../a/../b/c/../d/"));
    }

    @Test
    void rootStaysRoot() {
        assertEquals("/", simplifyPath("/"));
    }

    @Test
    void singleDirectory() {
        assertEquals("/a", simplifyPath("/a"));
    }

    @Test
    void currentDirectoryIgnored() {
        assertEquals("/a", simplifyPath("/a/./"));
    }

    @Test
    void mixOfDotsAndParents() {
        assertEquals("/c", simplifyPath("/a/./b/../../c/"));
    }

    @Test
    void parentsBeyondRootClampToRoot() {
        assertEquals("/", simplifyPath("/a/../../../"));
    }

    @Test
    void tripleDotIsValidName() {
        assertEquals("/...", simplifyPath("/..."));
    }

    @Test
    void longDotRunIsValidName() {
        assertEquals("/.....", simplifyPath("/....."));
    }

    @Test
    void dotNameAfterDirectory() {
        assertEquals("/abc/...", simplifyPath("/abc/..."));
    }

    @Test
    void repeatedSlashesCollapse() {
        assertEquals("/a/b/c", simplifyPath("/a//b////c/d//././/.."));
    }

    @Test
    void onlyDots() {
        assertEquals("/", simplifyPath("/./././"));
    }

    @Test
    void hiddenFileNamePreserved() {
        assertEquals("/a/.hidden", simplifyPath("/a/.hidden/"));
    }
}
