package org.stockmanager.model;

public class QuoteModel {
	
	private String id;
	
	private String description;
	
	private Object quote;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Object getQuote() {
		return quote;
	}

	public void setQuote(Object quote) {
		this.quote = quote;
	}
	

}
