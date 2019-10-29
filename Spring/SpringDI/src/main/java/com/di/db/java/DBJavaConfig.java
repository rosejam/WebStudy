package com.di.db.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DBJavaConfig {
	
	@Bean
	public MySQLDataServiceImpl getMySQL() {
		MySQLDataServiceImpl mysql = new MySQLDataServiceImpl(11, 29);
		mysql.setDriver("driver_1");
		mysql.setUrl("url_1");
		return mysql;
	}
	
	@Bean
	public OracleDataServiceImpl getOracle() {
		OracleDataServiceImpl oracle = new OracleDataServiceImpl(1129, 1016);
		oracle.setDriver("driver_2");
		oracle.setUrl("url_2");
		return oracle;
	}
	
}






