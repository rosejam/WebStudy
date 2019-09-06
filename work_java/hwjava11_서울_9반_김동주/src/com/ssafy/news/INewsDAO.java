package com.ssafy.news;

import java.util.List;

public interface INewsDAO {
	List<News> getNewsList(String url); //xml받아와서 parsing후 VO(News)에 담는다.
	public News search(int index);
}
