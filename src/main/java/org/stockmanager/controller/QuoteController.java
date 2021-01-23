package org.stockmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.stockmanager.model.QuoteModel;
import org.stockmanager.service.QuoteService;

import com.google.gson.Gson;

@RestController
public class QuoteController {
	
	@Autowired
	QuoteService quoteService;
	
	@RequestMapping(value = "/stock", method = RequestMethod.GET)
	public List<QuoteModel> getQuote() {
		return quoteService.getAllQuote();
	}
	
	@RequestMapping(value = "/stock/{id}", method = RequestMethod.GET)
	public QuoteModel getQuoteById(@PathVariable(value = "id") String id) {
		return quoteService.quoteById(id);
	}
	
	
	@RequestMapping(value = "/stock", method = RequestMethod.POST)
	public ResponseEntity<Object> insertQuote(@RequestBody String json) {
//		quoteService.insertEmployee(employee);
		
		Gson gson = new Gson();
//		JsonReader.setLenient(true)
		QuoteModel quote = gson.fromJson(json, QuoteModel.class);
		
		quoteService.insertQuote(quote);
		
		System.out.println("obj.getQuote().toString():"+quote.getQuote().toString());
		return new ResponseEntity<>(HttpStatus.OK);
		
		
	}
	
	

}
