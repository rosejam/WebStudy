package com.mybatis;

import java.io.Reader; //입출력 파이프 Reader
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources; //Resources
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CustomerTest {

	public static void main(String[] args) {
		String conf = "res/Configuration.xml"; //myBatis 설정파일 경로
		Reader reader;
		SqlSession session = null; //myBatis로 쿼리 작업을 위해 필요한 객체

		try {
			reader = Resources.getResourceAsReader(conf);// read conf xml file //설정파일에 입력 파이프 연결
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder(); //1. new로 직접 builder 생성
			SqlSessionFactory factory = builder.build(reader); //2. .build()로 factory생성 
			session = factory.openSession(); //3. .openSession으로 session생성 -> Connection(네트워크 연결) 1개
			List<Customer> list;
			
			// 1. select all data:
			// selectList: 여러개의 데이터 가져올 때
			list = session.selectList("selectAll"); // session.사용할메서드("mapper file안의 query id"); //namespace 생략
			//list = session.selectList("Customer.selectAll"); //Mapper file의 "namespace"를 생략하지 않고 적어주었다. 어느 테이블을 사용하는지 명시
			//list = session.selectList("Board.selectAll"); 
			for (Customer rec : list) {
				System.out.println(rec.getNum() + "--" + rec.getName() + "--" + rec.getAddress());
			}
			
			System.out.println("-----------------------------------------------------");
			
			//2. select one
			//selectOne: 한개의 데이터 가져올 때
			Customer c = session.selectOne("Customer.selectOne", "111"); //(쿼리 id, 파라메터);
			System.out.println(c.getNum() + "--" + c.getName() + "--" + c.getAddress());
			
			System.out.println("-----------------------------------------------------");
			
/*			session.insert("Customer.insert", new Customer("901","william","seoul"));
			session.commit(); //dml(insert/delete/update)는 자동으로 commit이 되지 않는다! - 커밋안하면 자동 롤백됨
			
			session.delete("Customer.delete", "901");
			session.commit();*/
			
/*			//901번 레코드의 주소를 singapore로 수정
			Customer u = session.selectOne("selectOne","901");
			u.setAddress("singapore");
			session.update("update", u);
			session.commit();*/
						
/*			//901번 레코드의 주소를 firenze로 수정 (map을 사용해서)
			HashMap<String,String> map = new HashMap<>();
			map.put("num", "901");
			map.put("address", "firenze");
			session.update("update2", map);
			session.commit();*/
			
			//주소가 seoul인 레코드
			list = session.selectList("findAddress", "seoul");
			for (Customer rec : list) {
				System.out.println(rec.getNum() + "--" + rec.getName() + "--" + rec.getAddress());
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}
	}

}
