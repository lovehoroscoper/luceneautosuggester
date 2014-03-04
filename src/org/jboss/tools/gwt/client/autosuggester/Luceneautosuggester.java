package org.jboss.tools.gwt.client.autosuggester;

import org.jboss.tools.gwt.client.autosuggester.mvp.AppActivityMapper;
import org.jboss.tools.gwt.client.autosuggester.mvp.AppPlaceHistoryMapper;
import org.jboss.tools.gwt.client.autosuggester.places.AutosuggestPlace;
import org.jboss.tools.gwt.client.autosuggester.view.ClientFactory;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Luceneautosuggester implements EntryPoint {

	static final int width = 500;
	private SimplePanel appWidget = new SimplePanel();

	private Place defaultPlace = new AutosuggestPlace("main");

	/**
	 * This is the entry point method.
	 */
	@Override
	public void onModuleLoad() {
		ClientFactory clientFactory = GWT.create(ClientFactory.class);
		EventBus eventBus = clientFactory.getEventBus();
		PlaceController placeController = clientFactory.getPlaceController();

		Window.enableScrolling(true);
		// Start ActivityManager for the main widget with our ActivityMapper
		ActivityMapper activityMapper = new AppActivityMapper(clientFactory);
		ActivityManager activityManager = new ActivityManager(activityMapper,
				eventBus);
		activityManager.setDisplay(appWidget);

		// Start PlaceHistoryHandler with our PlaceHistoryMapper
		AppPlaceHistoryMapper historyMapper = GWT
				.create(AppPlaceHistoryMapper.class);
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(
				historyMapper);
		historyHandler.register(placeController, eventBus, defaultPlace);

		// Add it to the root panel.
		RootLayoutPanel.get().add(appWidget);
		// Goes to the place represented on URL else default place
		historyHandler.handleCurrentHistory();

	}
}
