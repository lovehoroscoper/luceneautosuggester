package org.jboss.tools.gwt.client.autosuggester.mvp;

import org.jboss.tools.gwt.client.autosuggester.activities.AutosuggestActivity;
import org.jboss.tools.gwt.client.autosuggester.places.AutosuggestPlace;
import org.jboss.tools.gwt.client.autosuggester.view.IClientFactory;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;


public class AppActivityMapper implements ActivityMapper {

	private final IClientFactory clientFactory;


	public AppActivityMapper(IClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public Activity getActivity(final Place place) {
		if(place instanceof AutosuggestPlace){
			return new AutosuggestActivity(clientFactory,clientFactory.getMainView(),clientFactory.getAutosuggestApi());
		}
		return null;
	}

}