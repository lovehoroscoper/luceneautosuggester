package org.jboss.tools.gwt.client.autosuggester.view;

import org.jboss.tools.gwt.client.autosuggester.AutosuggestServiceAsync;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;

public interface IClientFactory {

	AutosuggestServiceAsync getAutosuggestApi();

	EventBus getEventBus();

	IMainView getMainView();

	PlaceController getPlaceController();
}
