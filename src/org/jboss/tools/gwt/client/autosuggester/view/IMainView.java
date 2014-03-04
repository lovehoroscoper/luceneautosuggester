package org.jboss.tools.gwt.client.autosuggester.view;

import java.util.Collection;

import org.jboss.tools.gwt.shared.autosuggester.PhraseCount;
import org.jboss.tools.gwt.shared.autosuggester.Settings;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface IMainView extends IsWidget {

	public interface Presenter {
		void addQuery(String query);

		void goTo(Place place);

		void changeSuggester(Settings settings);

	}

	void setPresenter(Presenter presenter);

	void populateTable(Collection<PhraseCount> phrases);
}
