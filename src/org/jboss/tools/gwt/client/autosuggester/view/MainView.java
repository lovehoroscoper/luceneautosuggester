package org.jboss.tools.gwt.client.autosuggester.view;

import java.util.Collection;
import java.util.List;

import org.jboss.tools.gwt.client.autosuggester.AutosuggestServiceAsync;
import org.jboss.tools.gwt.shared.autosuggester.PhraseCount;
import org.jboss.tools.gwt.shared.autosuggester.Settings;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;

public class MainView extends Composite implements HasText, IMainView {

	interface MainViewUiBinder extends UiBinder<Widget, MainView> {
	}

	private static MainViewUiBinder uiBinder = GWT
			.create(MainViewUiBinder.class);

	@UiField
	Button button;

	private ListDataProvider<PhraseCount> provider;

	private Presenter presenter;

	@UiField(provided = true)
	SuggestBox suggestBox;

	@UiField(provided = true)
	SimplePager pager;

	@UiField
	CellTable<PhraseCount> cellTable;

	@UiField
	RadioButton analyzing;

	@UiField
	RadioButton fuzzy;

	@UiField
	RadioButton keyword;

	@UiField
	RadioButton standard;

	public MainView(AutosuggestServiceAsync autosuggestServiceAsync) {
		AutosuggestOracle oracle = new AutosuggestOracle(
				autosuggestServiceAsync);
		suggestBox = new SuggestBox(oracle);
		pager = new SimplePager(TextLocation.CENTER);
		pager.setPageSize(20);
		initWidget(uiBinder.createAndBindUi(this));
		provider = new ListDataProvider<PhraseCount>();
		provider.addDataDisplay(cellTable);
		analyzing.setValue(true);
		standard.setValue(true);
		TextColumn<PhraseCount> phraseColumn = new TextColumn<PhraseCount>() {
			@Override
			public String getValue(PhraseCount phraseCount) {
				return phraseCount.getPhrase();
			}
		};

		cellTable.addColumn(phraseColumn, "Query");

		TextColumn<PhraseCount> countColumn = new TextColumn<PhraseCount>() {
			@Override
			public String getValue(PhraseCount phraseCount) {
				return phraseCount.getCount() + "";
			}
		};

		cellTable.addColumn(countColumn, "Query frequency");

		pager.setDisplay(cellTable);
	}

	@Override
	public String getText() {
		return button.getText();
	}

	@UiHandler("button")
	void onClick(ClickEvent e) {
		presenter.addQuery(suggestBox.getText());
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void setText(String text) {
		button.setText(text);
	}

	@Override
	public void populateTable(Collection<PhraseCount> phrases) {
		java.util.Collections.sort((List<PhraseCount>) phrases);
		provider.setList((List<PhraseCount>) phrases);
	}

	@UiHandler("analyzing")
	void onAnalyzingSuggesterSelection(ClickEvent e) {
		presenter.changeSuggester(new Settings(analyzing.getValue(), fuzzy.getValue(),
				standard.getValue(), keyword.getValue()));
	}

	@UiHandler("fuzzy")
	void onFuzzySuggesterSelection(ClickEvent e) {
		presenter.changeSuggester(new Settings(analyzing.getValue(), fuzzy.getValue(),
				standard.getValue(), keyword.getValue()));
	}

	@UiHandler("keyword")
	void onKeywordAnalyzerSelection(ClickEvent e) {
		presenter.changeSuggester(new Settings(analyzing.getValue(), fuzzy.getValue(),
				standard.getValue(), keyword.getValue()));
	}

	@UiHandler("standard")
	void onStandardAnalyzerSelection(ClickEvent e) {
		presenter.changeSuggester(new Settings(analyzing.getValue(), fuzzy.getValue(),
				standard.getValue(), keyword.getValue()));
	}

}
