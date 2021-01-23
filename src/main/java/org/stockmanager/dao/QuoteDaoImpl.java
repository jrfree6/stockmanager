package org.stockmanager.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.stockmanager.helper.QuoteHelper;
import org.stockmanager.model.QuoteModel;
import org.stockmanager.model.QuoteValuesModel;

@Repository
public class QuoteDaoImpl extends JdbcDaoSupport implements QuoteDao {

	@Autowired
	DataSource dataSource;
	
	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}
	
	@Override
	public List<QuoteModel> getAllQuote() {
		
		String sql = "select * from quote";
		List<Map<String,Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<QuoteModel> result = new ArrayList<QuoteModel>();
		
		for( Map<String, Object> row : rows) {
			QuoteModel emp = new QuoteModel();
			
			emp.setId((String) row.get("id").toString());
			emp.setDescription((String) row.get("description"));
			
			emp.setQuote(getMapQuoteValues( row.get("id").toString() ));
			
			result.add(emp);
		}
		
		return result;
	}
	
	@Override
	public QuoteModel quoteById(String id) {
		
		String sql = "select * from quote where id=? ";
		List<Map<String,Object>> rows = getJdbcTemplate().queryForList(sql, new Object[] {id});
		
		QuoteModel emp = new QuoteModel();
		for( Map<String, Object> row : rows) {
			
			emp.setId((String) row.get("id").toString());
			emp.setDescription((String) row.get("description"));
			
			emp.setQuote(getMapQuoteValues( row.get("id").toString() ));
		}
		
		return emp;
	}
	
	
	public HashMap<String, String> getMapQuoteValues(String quote_id){
		
		String sql = "select * from quotevalues where quote_id=? ";
		
		List<Map<String,Object>> rows = getJdbcTemplate().queryForList(sql, new Object[] { quote_id});
		
		HashMap<String, String> values = new HashMap<String, String>();
		
		for( Map<String, Object> row : rows) {
			values.put((String) row.get("quote_date"), (String) row.get("quote_value"));
		}
		
		return values;

	}

	
	public List<QuoteValuesModel> getQuoteValues(String quote_id){
		
		String sql = "select * from quotevalues where quote_id=? ";
		
		List<Map<String,Object>> rows = getJdbcTemplate().queryForList(sql, new Object[] { quote_id});
		
		List<QuoteValuesModel> result = new ArrayList<QuoteValuesModel>();
		for( Map<String, Object> row : rows) {
			QuoteValuesModel emp = new QuoteValuesModel();
			
			emp.setDate((String) row.get("quote_date"));
			emp.setValue((String) row.get("quote_value"));
			
			result.add(emp);
		}
		return result;

	}

	@Override
	public void insertQuote(QuoteModel quote) {
		
		String sql = "insert into quote (id, description) values (?, ? ); ";
		getJdbcTemplate().update(sql, new Object[] { 
				quote.getId(), 
				quote.getDescription()
				});
		
		QuoteHelper helper = new QuoteHelper();
		List<QuoteValuesModel> list = helper.toObject(quote);
		for (QuoteValuesModel quoteValuesModel : list) {
			
			sql = "insert into quotevalues (quote_id, quote_date, quote_value) values (?, ?, ? ); ";
			getJdbcTemplate().update(sql, new Object[] { 
					quote.getId(),
					quoteValuesModel.getDate(),
					quoteValuesModel.getValue()
					});
			
		}
		
	}
	
	@Override
	public void updateQuote(QuoteModel quote) {

	}
		
	
	
}
