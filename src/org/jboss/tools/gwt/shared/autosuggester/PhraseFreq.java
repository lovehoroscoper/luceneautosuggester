package org.jboss.tools.gwt.shared.autosuggester;

import org.apache.lucene.util.BytesRef;

public class PhraseFreq {
	public long count;
	public BytesRef term;
	private String phrase;
	private long lastModifiedTimestamp;

	public PhraseFreq(BytesRef term, long count, long lastModifiedTimestamp) {
		this.term = term;
		this.count = count;
		this.lastModifiedTimestamp = lastModifiedTimestamp;
	}

	public PhraseFreq(String term, long count, long lastModifiedTimestamp) {
		this(new BytesRef(term), count, lastModifiedTimestamp);
		phrase = term;
	}

	public long getLastModifiedTimestamp() {
		return lastModifiedTimestamp;
	}

	public void setLastModifiedTimestamp(long lastModifiedTimestamp) {
		this.lastModifiedTimestamp = lastModifiedTimestamp;
	}

	public String getPhrase() {
		return phrase;
	}

	public int getCount() {
		return (int) count;
	}

}