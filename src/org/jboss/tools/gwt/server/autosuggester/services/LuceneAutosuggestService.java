package org.jboss.tools.gwt.server.autosuggester.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.lucene.analysis.core.KeywordAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.search.suggest.Lookup.LookupResult;
import org.apache.lucene.search.suggest.analyzing.AnalyzingSuggester;
import org.apache.lucene.search.suggest.analyzing.FuzzySuggester;
import org.apache.lucene.util.Version;
import org.jboss.tools.gwt.shared.autosuggester.GenericsUtils;
import org.jboss.tools.gwt.shared.autosuggester.PhraseCount;
import org.jboss.tools.gwt.shared.autosuggester.PhraseFreq;
import org.jboss.tools.gwt.shared.autosuggester.PhraseFreqArrayIterator;
import org.jboss.tools.gwt.shared.autosuggester.Settings;

public class LuceneAutosuggestService {

	private Map<String, PhraseFreq> queries = GenericsUtils.newMap();
	private AnalyzingSuggester suggester;

	public List<PhraseCount> addQuery(String query) {
		if (suggester == null) {
			populateWithInitialQueries();

		}
		if (!query.isEmpty()) {
			if (queries.containsKey(query)) {
				queries.get(query).count++;
				queries.get(query).setLastModifiedTimestamp(
						System.currentTimeMillis());

			} else {
				queries.put(query,
						new PhraseFreq(query, 1, System.currentTimeMillis()));
			}
			try {
				build();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		List<PhraseCount> phrasesCount = new ArrayList<PhraseCount>();
		for (PhraseFreq phraseFreq : queries.values()) {
			phrasesCount.add(new PhraseCount(phraseFreq.getPhrase(), phraseFreq
					.getCount(), phraseFreq.getLastModifiedTimestamp()));
		}
		return phrasesCount;
	}

	private void populateWithInitialQueries() {
		queries.put("collaboration",
				new PhraseFreq("collaboration", 1, System.currentTimeMillis()));
		queries.put("collaborate",
				new PhraseFreq("collaborate", 1, System.currentTimeMillis()));
		queries.put("collaborating",
				new PhraseFreq("collaborating", 1, System.currentTimeMillis()));
		queries.put("collaborations", new PhraseFreq("collaborations", 1,
				System.currentTimeMillis()));
		queries.put("college",
				new PhraseFreq("college", 1, System.currentTimeMillis()));
		queries.put("colleges",
				new PhraseFreq("colleges", 1, System.currentTimeMillis()));
		queries.put("collisions",
				new PhraseFreq("collisions", 1, System.currentTimeMillis()));
		queries.put("collaboration",
				new PhraseFreq("collaboration", 1, System.currentTimeMillis()));

		suggester = new AnalyzingSuggester(new StandardAnalyzer(
				Version.LUCENE_41));

		try {
			build();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void build() throws IOException {
		suggester
				.build(new PhraseFreqArrayIterator(queries.values().iterator()));
	}

	public Collection<String> getSuggestions(String query, int count) {
		List<LookupResult> lookupResults = suggester
				.lookup(query, false, count);
		Collection<String> results = new ArrayList<String>();
		for (LookupResult result : lookupResults) {
			results.add(result.key + "");
		}
		return results;
	}

	public void changeSettings(Settings settings) {
		if (settings.getAnalyzing() && settings.getStandard()) {
			suggester = new AnalyzingSuggester(new StandardAnalyzer(
					Version.LUCENE_41));
		} else if (settings.getAnalyzing() && settings.getKeyword()) {
			suggester = new AnalyzingSuggester(new KeywordAnalyzer());
		} else if (settings.getFuzzy() && settings.getKeyword()) {
			suggester = new FuzzySuggester(new KeywordAnalyzer());
		} else {
			suggester = new FuzzySuggester(new StandardAnalyzer(
					Version.LUCENE_41));
		}
		try {
			build();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
