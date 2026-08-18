# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Your role here

User writes own solutions. When given a solution:

- Create new file for it under `src/main/java/com/solairerove/dsa/problems/` (naming/convention rules below).
- Add tests under `src/test/java/com/solairerove/dsa/problems/`.
- No suggestions, no assumptions, no rewriting user's logic. Just place it and cover with tests.
- Critique the solution (style, idiomaticity, complexity) only when explicitly asked. Don't volunteer it. When asked to "critique"/"analyze", stay scoped to the current solution's style and idiomaticity — don't propose a different/more efficient algorithm unless separately asked for one.
- If code looks like it will hang or run forever (e.g. a loop condition that never advances toward termination), don't silently fix it — flag the issue and don't run `mvn test` against it. If user says to file it anyway, file it as-is and skip running the tests, note that they need to run/debug it themselves.
- User may ask for a second/alternate solution to the same problem living in the same file (e.g. `isAnagram` and `isAnagramArray`). Suffix the alt method name to describe the approach (`Array`, `TwoPointer`, etc). User may ask for just a stub (method returning a placeholder value like `false`/`0`/empty) with full mirrored test coverage added up front — add the stub and tests, do not implement the logic; some tests will fail until user fills it in, that's expected.

## Commands

- Build: `mvn compile`
- Run all tests: `mvn test`
- Run tests for one problem: `mvn test -Dtest=P0021_MergeTwoSortedListsTest`
- Package: `mvn package`

## Architecture

LeetCode solutions in Java, one file per problem under `src/main/java/com/solairerove/dsa/problems/`.

- Maven project (`pom.xml`), Java 21, JUnit 5 (Jupiter) for tests.
- `src/main/java/com/solairerove/dsa/problems/PNNNN_TitleCaseName.java` — one file per problem, numbered with the LeetCode problem ID (zero-padded to 4 digits), followed by the title in PascalCase (e.g. `P0021_MergeTwoSortedLists.java`). Contains a public class with the solution as a `public static` method. No `mod.rs`-style manual wiring needed — Maven/JUnit discover files by convention.
- `src/test/java/com/solairerove/dsa/problems/PNNNN_TitleCaseNameTest.java` — mirrors the solution file name with a `Test` suffix, in the same package, using JUnit 5 (`@Test`, `assertEquals`, etc). Test class is annotated `@SuppressWarnings("NewClassNamingConvention")` (silences the IDE inspection over the `PNNNN_` prefix).
- `src/main/java/com/solairerove/dsa/common/` — shared data structures/helpers reused across problems (e.g. `ListNode` for linked-list problems, with `fromList`/`toList` conversion helpers for building test fixtures).

### Conventions observed in existing solutions

- Solution methods use LeetCode's original signature/argument style (e.g. `ListNode` params/return for linked lists), not extra wrapper types.
- Strip LeetCode's outer `class Solution { ... }` name — the class is named after the problem (`PNNNN_TitleCaseName`), method stays as LeetCode named it (`mergeTwoLists`, `isAnagram`, etc), declared `public static`.
- A `// time O(...), space O(...)` complexity comment precedes each solution method.
- Tests use `fromList`/`toList` from `com.solairerove.dsa.common.ListNode` to convert between `List<Integer>` and linked-list fixtures.
