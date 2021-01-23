package org.stockmanager.dao;

import java.util.List;

import org.stockmanager.model.QuoteModel;

public interface QuoteDao {
	
	List<QuoteModel> getAllQuote();
	QuoteModel quoteById(String id);
	void insertQuote(QuoteModel quote);
	void updateQuote(QuoteModel quote);

}
