package org.jboss.tools.gwt.client.autosuggester.view;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.jboss.tools.gwt.client.autosuggester.AutosuggestServiceAsync;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.SuggestOracle;

public class AutosuggestOracle extends SuggestOracle {

	private AutosuggestServiceAsync autosuggestServiceAsync;

	public AutosuggestOracle(AutosuggestServiceAsync autosuggestServiceAsync) {
		this.autosuggestServiceAsync = autosuggestServiceAsync;
	}

	@Override
	public void requestSuggestions(final Request request,
			final Callback callback) {
		autosuggestServiceAsync.getSuggestions(request.getQuery(),
				new AsyncCallback<Collection<String>>() {

					@Override
					public void onFailure(Throwable caught) {

					}

					@Override
					public void onSuccess(Collection<String> results) {
						Response response = new Response();
						List<Suggestion> suggestions = new ArrayList<Suggestion>();
						for (String result : results) {
							suggestions.add(new ItemSuggestion(result));
						}
						response.setSuggestions(suggestions);
						callback.onSuggestionsReady(request, response);
					}
				});
	}
}