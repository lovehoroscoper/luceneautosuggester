package org.jboss.tools.gwt.shared.autosuggester;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

import org.apache.lucene.search.spell.TermFreqIterator;
import org.apache.lucene.util.BytesRef;

public final class PhraseFreqArrayIterator implements TermFreqIterator {
	private PhraseFreq current;
	private final Iterator<PhraseFreq> wordFreqIterator;

	public PhraseFreqArrayIterator(Iterator<PhraseFreq> wordFreqIterator) {
		this.wordFreqIterator = wordFreqIterator;
	}

	public PhraseFreqArrayIterator(PhraseFreq[] i) {
		this(Arrays.asList(i).iterator());
	}

	@Override
	public Comparator<BytesRef> getComparator() {
		return null;
	}

	@Override
	public BytesRef next() {
		if (wordFreqIterator.hasNext()) {
			current = wordFreqIterator.next();
			return current.term;
		}
		return null;
	}

	@Override
	public long weight() {
		return current.count;
	}
}