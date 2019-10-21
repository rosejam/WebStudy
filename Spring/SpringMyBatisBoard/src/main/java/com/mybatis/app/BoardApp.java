package com.mybatis.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mybatis.service.BoardService;
import com.mybatis.vo.Board;

public class BoardApp {

	public static void main(String[] args) {
		//Container 생성
		ApplicationContext context = new ClassPathXmlApplicationContext("config/mybatis-db.xml");
		
		BoardService service = context.getBean("bod", BoardService.class); //interface타입에 받기
		
		List<Board> list = service.selectAll();
		for(Board b: list) {
			System.out.println(b.getNum() + "--" + b.getName() + "--" + b.getTitle() + "--" + b.getCount());
		}
		//selectOne
		try {
			Board bb = service.selectOne("3");
			System.out.println(bb.getNum() + "--" + bb.getName() + "--" + bb.getTitle() + "--" + bb.getCount());
		} catch (Exception e) {
			e.printStackTrace();
		}
/*		//insert
		service.insert(new Board(null,"서정진","지방으로 가자"));
		//delete
		service.delete("39");
		//findByAddress
		List<Board> list2 = service.findByTitle("지방");
		for(Board b: list2) {
			System.out.println(b.getNum() + "--" + b.getName() + "--" + b.getTitle() + "--" + b.getCount());
		}
		*/
	}

}
