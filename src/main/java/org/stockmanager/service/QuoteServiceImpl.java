package org.stockmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stockmanager.dao.QuoteDao;
import org.stockmanager.model.QuoteModel;

@Service
public class QuoteServiceImpl implements QuoteService  {
	
	@Autowired
	QuoteDao quoteDao;

	@Override
	public List<QuoteModel> getAllQuote() {
		List<QuoteModel> quote = quoteDao.getAllQuote();
		return quote;
	}
	public QuoteModel quoteById(String id) {
		return quoteDao.quoteById(id);
		
	}

	@Override
	public void insertQuote(QuoteModel quote) {
		quoteDao.insertQuote(quote);
	}
	@Override
	public void updateQuote(QuoteModel quote) {
		quoteDao.updateQuote(quote);
	}


}
