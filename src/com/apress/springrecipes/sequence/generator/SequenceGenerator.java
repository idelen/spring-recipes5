package com.apress.springrecipes.sequence.generator;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.atomic.AtomicInteger;

public class SequenceGenerator {

	@Autowired
	private PrefixGenerator prefixGenerator;

	private String prefix;
	private String suffix;
	private int initial;
	private final AtomicInteger counter = new AtomicInteger();

	public SequenceGenerator() {

	}

	public SequenceGenerator(PrefixGenerator prefixGenerators, String suffix, int initial) {
		this.prefixGenerator = prefixGenerators;
		this.suffix = suffix;
		this.initial = initial;
	}

	@Autowired
	public void setPrefixGenerator(PrefixGenerator prefixGenerator) {
		this.prefixGenerator = prefixGenerator;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public void setInitial(int initial) {
		this.initial = initial;
	}

	public String getSequence() {
		StringBuilder builder = new StringBuilder();
		builder.append(prefix)
			.append(initial)
			.append(counter.getAndIncrement())
			.append(suffix);
		return builder.toString();
	}

}
