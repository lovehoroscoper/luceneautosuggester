package org.jboss.tools.gwt.client.autosuggester.view;

import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;

public class ItemSuggestion implements Suggestion {

	private String s;

	public ItemSuggestion(String s) {
		this.s = s;
	}

	@Override
	public String getDisplayString() {
		return s;
	}

	@Override
	public String getReplacementString() {
		return s;
	}

}
