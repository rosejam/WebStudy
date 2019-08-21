package com.ssafy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public interface IBookDAO {
	Connection getConnection();//
	void close(Connection connection);//
	void close(Statement statement);//
	//void close(PreparedStatement preparedstatement);//
	void close(ResultSet resultset);//
	void insertBook(Book book);//
	void updateBook(Book book);//
	void delete(String isbn);//
	Book findBook(String isbn);//
	List<Book> listBooks();//
	int count();//
}
