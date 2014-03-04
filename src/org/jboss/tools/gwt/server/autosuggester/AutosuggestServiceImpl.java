package org.jboss.tools.gwt.server.autosuggester;

import java.util.Collection;
import org.jboss.tools.gwt.client.autosuggester.AutosuggestService;
import org.jboss.tools.gwt.server.autosuggester.services.LuceneAutosuggestService;
import org.jboss.tools.gwt.shared.autosuggester.PhraseCount;
import org.jboss.tools.gwt.shared.autosuggester.Settings;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class AutosuggestServiceImpl extends RemoteServiceServlet implements
		AutosuggestService {

	private LuceneAutosuggestService luceneAutosuggestService = new LuceneAutosuggestService();

	@Override
	public Collection<String> getSuggestions(String query)
			throws IllegalArgumentException {
		return luceneAutosuggestService.getSuggestions(query, 10);
	}

	@Override
	public Collection<PhraseCount> search(String query)
			throws IllegalArgumentException {
		return luceneAutosuggestService.addQuery(query);
	}

	@Override
	public void settingsUpdated(Settings settings)
			throws IllegalArgumentException {
		luceneAutosuggestService.changeSettings(settings);
		
	}
}
