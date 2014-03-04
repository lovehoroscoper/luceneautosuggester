package org.jboss.tools.gwt.client.autosuggester;

import java.util.Collection;

import org.jboss.tools.gwt.shared.autosuggester.PhraseCount;
import org.jboss.tools.gwt.shared.autosuggester.Settings;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>AutosuggestService</code>.
 */
public interface AutosuggestServiceAsync {
	void getSuggestions(String query, AsyncCallback<Collection<String>> callback)
			throws IllegalArgumentException;
	void search(String query, AsyncCallback<Collection<PhraseCount>> callback);
	void settingsUpdated(Settings settings, AsyncCallback<Void> callback);
}
