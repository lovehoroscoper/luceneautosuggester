package org.jboss.tools.gwt.shared.autosuggester;

import java.io.Serializable;

public class PhraseCount implements Serializable,Comparable<PhraseCount> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String phrase;
	private int count;
	private long lastModifiedTimestamp;

	public long getLastModifiedTimestamp() {
		return lastModifiedTimestamp;
	}

	public void setLastModifiedTimestamp(long lastModifiedTimestamp) {
		this.lastModifiedTimestamp = lastModifiedTimestamp;
	}

	public PhraseCount() {

	}

	public PhraseCount(String phrase, int count, long lastModifiedTimestamp) {
		this.phrase = phrase;
		this.count = count;
		this.lastModifiedTimestamp = lastModifiedTimestamp;
	}

	public String getPhrase() {
		return phrase;
	}

	public void setPhrase(String phrase) {
		this.phrase = phrase;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public int compareTo(PhraseCount phraseCount) {
		if(this.lastModifiedTimestamp>phraseCount.getLastModifiedTimestamp()){
			return 0;
		}else{
			return 1;
		}
	}

}
