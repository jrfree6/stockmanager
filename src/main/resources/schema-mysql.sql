CREATE TABLE IF NOT EXISTS quote(
	id varchar(40) not null primary key,
	description varchar(40) default null
);

CREATE TABLE IF NOT EXISTS quotevalues(
	quote_id varchar(40) not null,
	quote_date varchar(12) not null, 
	quote_value varchar(10) not null,
	foreign key fk_quote_id(quote_id) references quote(id)
		on update cascade
		on delete cascade
);
