package com.apress.springrecipes.sequence.domain;

public interface SequenceDao {
	public Sequence getSequence(String sequenceId);
	public int getNextValue(String sequenceId);
}
