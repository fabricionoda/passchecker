package br.com.servlet.utils.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.servlet.utils.RegexUtils;
import br.com.servlet.utils.Sequence;

public class RegexUtilsTest {

	@Test
	public void testOccurrences() {
		assertEquals(2,RegexUtils.occurrences("dGF4f7d", "[0-9]+"));
	}

	@Test
	public void testHasOnly() {
		assertTrue(RegexUtils.match("fkdIsY", "[a-zA-Z]+\\.?"));
	}
	
	@Test
	public void testConsecutiveMatches() {
		assertEquals(3,RegexUtils.consecutiveMatches("DRTa#$JK", "[A-Z]"));
	}
	
	@Test
	public void consecutiveMatches3OccorrencesHeadAndTail() {
		assertEquals(4,RegexUtils.consecutiveMatches("fasFsrw", "[a-z]"));
	}
	
	@Test
	public void sequenceMatches() {
		assertEquals(2,RegexUtils.sequenceMatches("abcdT234", Sequence.ALPHABET));
	}
	@Test
	public void sequenceMatchesDontCountMiddle() {
		assertEquals(2,RegexUtils.sequenceMatches("abcdT2kl34", Sequence.ALPHABET));
	}
	@Test
	public void sequenceMatchesDontCountMiddleButEnd() {
		assertEquals(2,RegexUtils.sequenceMatches("T2kl34ABCD", Sequence.ALPHABET));
	}
}
