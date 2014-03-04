package org.jboss.tools.gwt.shared.autosuggester;

import java.io.Serializable;


public class Settings implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Boolean analyzing;
	private Boolean fuzzy;
	private Boolean standard;
	private Boolean keyword;

	public Settings() {
	}

	public Settings(Boolean analyzing, Boolean fuzzy, Boolean standard,
			Boolean keyword) {
		this.analyzing = analyzing;
		this.fuzzy = fuzzy;
		this.standard = standard;
		this.keyword = keyword;
	}

	public Boolean getAnalyzing() {
		return analyzing;
	}

	public void setAnalyzing(Boolean analyzing) {
		this.analyzing = analyzing;
	}

	public Boolean getFuzzy() {
		return fuzzy;
	}

	public void setFuzzy(Boolean fuzzy) {
		this.fuzzy = fuzzy;
	}

	public Boolean getStandard() {
		return standard;
	}

	public void setStandard(Boolean standard) {
		this.standard = standard;
	}

	public Boolean getKeyword() {
		return keyword;
	}

	public void setKeyword(Boolean keyword) {
		this.keyword = keyword;
	}
}
