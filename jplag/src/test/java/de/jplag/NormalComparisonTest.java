package de.jplag;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;

public class NormalComparisonTest extends TestBase {

    /**
     * The simple duplicate contains obvious plagiarism.
     */
    @Test
    public void testSimpleDuplicate() throws ExitException {
        JPlagResult result = runJPlagWithDefaultOptions("SimpleDuplicate");

        assertEquals(2, result.getNumberOfSubmissions());
        assertEquals(1, result.getComparisons().size());
        assertEquals(1, result.getComparisons().get(0).getMatches().size());
        assertEquals(1, result.getSimilarityDistribution()[6]);
        assertEquals(62.07f, result.getComparisons().get(0).similarity(), 0.1f);
    }

    /**
     * The classes in no duplicate have nearly nothing in common.
     */
    @Test
    public void testNoDuplicate() throws ExitException {
        JPlagResult result = runJPlagWithDefaultOptions("NoDuplicate");

        assertEquals(3, result.getNumberOfSubmissions());
        assertEquals(3, result.getComparisons().size());

        result.getAllComparisons().forEach(comparison -> {
            assertEquals(0f, comparison.similarity(), 0.1f);
        });
    }

    /**
     * This case is more complex and consists out of 5 submissions with different plagiarism.
     * A is the original code (coming from an older JPlag version)
     * B is a partial copy of that code
     * C is a full copy of that code
     * D is dumb plagiarism, e.g., changed variable names, additional unneeded code, ...
     * E is just a Hello World Java program
     */
    @Test
    public void testPartialPlagiarism() throws ExitException {
        JPlagResult result = runJPlagWithDefaultOptions("PartialPlagiarism");

        assertEquals(5, result.getNumberOfSubmissions());
        assertEquals(10, result.getAllComparisons().size());

        // All comparisons with E shall have no matches
        result.getAllComparisons()
                .stream()
                .filter(comparison ->
                        comparison.getSecondSubmission().getName().equals("E") ||
                                comparison.getFirstSubmission().getName().equals("E"))
                .forEach(comparison ->
                        assertEquals(0f, comparison.similarity(), 0.1f)
                );

        // Hard coded assertions on selected comparisons
        assertEquals(24.6f, getSelectedPercent(result, "A", "B"), 0.1f);
        assertEquals(99.7f, getSelectedPercent(result, "A", "C"), 0.1f);
        assertEquals(77.9f, getSelectedPercent(result, "A", "D"), 0.1f);
        assertEquals(24.6f, getSelectedPercent(result, "B", "C"), 0.1f);
        assertEquals(28.3f, getSelectedPercent(result, "B", "D"), 0.1f);
        assertEquals(77.9f, getSelectedPercent(result, "C", "D"), 0.1f);

        // More detailed assertions for the plagiarism in A-D
        var biggestMatch = getSelectedComparison(result, "A", "D");
        assertEquals(96.4f, biggestMatch.get().maximalSimilarity(), 0.1f);
        assertEquals(65.3f, biggestMatch.get().minimalSimilarity(), 0.1f);
        assertEquals(12, biggestMatch.get().getMatches().size());

    }

    // TODO SH: Methods like this should be moved to the API and also should accept wildcards
    private float getSelectedPercent(JPlagResult result, String nameA, String nameB) {
        return getSelectedComparison(result, nameA, nameB)
                .map(JPlagComparison::similarity)
                .orElse(-1f);
    }

    private Optional<JPlagComparison> getSelectedComparison(JPlagResult result, String nameA, String nameB) {
        return result.getAllComparisons().stream()
                .filter(comparison ->
                        comparison.getFirstSubmission().getName().equals(nameA) &&
                                comparison.getSecondSubmission().getName().equals(nameB) ||
                                comparison.getFirstSubmission().getName().equals(nameB) &&
                                        comparison.getSecondSubmission().getName().equals(nameA))
                .findFirst();
    }
}
