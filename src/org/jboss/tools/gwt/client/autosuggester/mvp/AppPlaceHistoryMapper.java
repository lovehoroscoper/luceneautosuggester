package org.jboss.tools.gwt.client.autosuggester.mvp;

import org.jboss.tools.gwt.client.autosuggester.places.AutosuggestPlace;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;


@WithTokenizers({ AutosuggestPlace.Tokenizer.class })
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {

}
