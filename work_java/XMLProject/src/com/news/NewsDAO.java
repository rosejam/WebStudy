package com.news;

import java.util.List;

public interface NewsDAO {
	public List<News> getNewsData(String url); //xml받아와서 parsing후 VO(News)에 담는다.
}
