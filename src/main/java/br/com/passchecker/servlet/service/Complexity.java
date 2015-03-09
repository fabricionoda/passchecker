package br.com.passchecker.servlet.service;

import com.google.common.collect.ImmutableRangeMap;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;

public enum Complexity {

	TOO_SHORT("Too Short", Range.lessThan(1)),
    VERY_WEAK("Very Weak", Range.closedOpen(1, 20)),
    WEAK("Weak",  Range.closedOpen(20, 40)),
    GOOD("Good", Range.closedOpen(40, 60)),
    STRONG("Strong", Range.closedOpen(60, 80)),
    VERY_STRONG("Very Strong", Range.greaterThan(80));

    private static final RangeMap<Integer, Complexity> valueMap;

    static {
        ImmutableRangeMap.Builder<Integer, Complexity> builder = ImmutableRangeMap.builder();
        for (Complexity complexity : values()) {
            builder.put(complexity.getStrength(), complexity);
        }
        valueMap = builder.build();
    }

    private final String name;

    private final Range<Integer> strength;

	private Complexity(String name, Range<Integer> strength) {
		this.name = name;
        this.strength = strength;
	}

    public static Complexity fromStrength(Integer strength) {
        return valueMap.get(strength);
    }

    public Range<Integer> getStrength() {
        return strength;
    }

    public String toString() {
		return name;
	}
}
