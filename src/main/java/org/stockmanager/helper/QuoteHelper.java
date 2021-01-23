package org.stockmanager.helper;

import java.util.ArrayList;
import java.util.List;

import org.stockmanager.model.QuoteModel;
import org.stockmanager.model.QuoteValuesModel;

public class QuoteHelper {
	
	
	public List<QuoteValuesModel> toObject(QuoteModel quote) {
		
		QuoteValuesModel modelo;
		
		String values = quote.getQuote().toString().replace("{", "").replace("}", "");
		String valores[] = values.split(",");
		List<QuoteValuesModel> list = new ArrayList<QuoteValuesModel>();
		for (int i = 0; i < valores.length; i++) {
			String[] data = valores[i].split("=");
			
			QuoteValuesModel item = new QuoteValuesModel();
			item.setDate(data[0].toString());
			item.setValue(data[1]);
			
			list.add(item);
		}
		
		for (QuoteValuesModel quoteValues : list) {
			System.out.println("date:"+quoteValues.getDate()+" - value:"+quoteValues.getValue());
		}
		
		return list;
		
	}
	
	

}
