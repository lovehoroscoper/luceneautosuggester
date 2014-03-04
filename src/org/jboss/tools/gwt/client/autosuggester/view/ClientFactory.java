package org.jboss.tools.gwt.client.autosuggester.view;

import org.jboss.tools.gwt.client.autosuggester.AutosuggestService;
import org.jboss.tools.gwt.client.autosuggester.AutosuggestServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;

public class ClientFactory implements IClientFactory {

	private AutosuggestServiceAsync autosuggestServiceAsync;
	private final EventBus eventBus = new SimpleEventBus();
	private IMainView mainView;
	private PlaceController placeController = new PlaceController(eventBus);

	public ClientFactory() {
		autosuggestServiceAsync = GWT.create(AutosuggestService.class);
	}

	@Override
	public AutosuggestServiceAsync getAutosuggestApi() {
		return autosuggestServiceAsync;
	}

	@Override
	public EventBus getEventBus() {
		return eventBus;
	}

	@Override
	public IMainView getMainView() {
		if (mainView == null) {
			mainView = new MainView(autosuggestServiceAsync);
			return mainView;
		} else {
			return mainView;
		}
	}

	@Override
	public PlaceController getPlaceController() {
		return placeController;
	}

	public void setPlaceController(PlaceController placeController) {
		this.placeController = placeController;
	}

}
