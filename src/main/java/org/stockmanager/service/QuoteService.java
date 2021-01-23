package org.stockmanager.service;

import java.util.List;

import org.stockmanager.model.QuoteModel;

public interface QuoteService {
	
	List<QuoteModel> getAllQuote();
	QuoteModel quoteById(String id);
	void insertQuote(QuoteModel quote);
	void updateQuote(QuoteModel quote);

}
