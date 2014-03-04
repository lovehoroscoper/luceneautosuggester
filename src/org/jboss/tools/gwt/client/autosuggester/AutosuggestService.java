package org.jboss.tools.gwt.client.autosuggester;

import java.util.Collection;

import org.jboss.tools.gwt.shared.autosuggester.PhraseCount;
import org.jboss.tools.gwt.shared.autosuggester.Settings;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("autosuggest")
public interface AutosuggestService extends RemoteService {
	Collection<String> getSuggestions(String query)
			throws IllegalArgumentException;

	Collection<PhraseCount> search(String query) throws IllegalArgumentException;
	
	void settingsUpdated(Settings settings) throws IllegalArgumentException;
}
