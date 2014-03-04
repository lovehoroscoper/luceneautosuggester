package org.jboss.tools.gwt.client.autosuggester.activities;

import java.util.Collection;

import org.jboss.tools.gwt.client.autosuggester.AutosuggestServiceAsync;
import org.jboss.tools.gwt.client.autosuggester.view.IClientFactory;
import org.jboss.tools.gwt.client.autosuggester.view.IMainView;
import org.jboss.tools.gwt.shared.autosuggester.PhraseCount;
import org.jboss.tools.gwt.shared.autosuggester.Settings;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class AutosuggestActivity extends AbstractActivity implements
		IMainView.Presenter {

	private AutosuggestServiceAsync autosuggestServiceAsync;

	private final IClientFactory clientFactory;

	private IMainView mainView;

	public AutosuggestActivity(IClientFactory clientFactory,
			IMainView mainView, AutosuggestServiceAsync autosuggestServiceAsync) {
		this.clientFactory = clientFactory;
		this.mainView = mainView;
		this.autosuggestServiceAsync = autosuggestServiceAsync;
		addQuery("");
	}

	@Override
	public void addQuery(String query) {
		autosuggestServiceAsync.search(query, new AsyncCallback<Collection<PhraseCount>>() {

			@Override
			public void onFailure(Throwable arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(Collection<PhraseCount> phrases) {
				mainView.populateTable(phrases);
				
			}

		});
	}

	@Override
	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);

	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		mainView.setPresenter(this);
		panel.setWidget(mainView.asWidget());
	}

	@Override
	public void changeSuggester(Settings settings) {
		autosuggestServiceAsync.settingsUpdated(settings, new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(Void arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}


}
