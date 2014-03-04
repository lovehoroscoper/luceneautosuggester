package org.jboss.tools.gwt.client.autosuggester.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class AutosuggestPlace extends Place {
	public static class Tokenizer implements PlaceTokenizer<AutosuggestPlace> {
		@Override
		public AutosuggestPlace getPlace(String token) {
			return new AutosuggestPlace(token);
		}

		@Override
		public String getToken(AutosuggestPlace place) {
			return place.getHelloName();
		}

	}

	private String helloName;

	public AutosuggestPlace(String token) {
		this.helloName = token;
	}

	public String getHelloName() {
		return helloName;
	}

}
