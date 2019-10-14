package com.config;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	// mybatis.xml 위치  //myBatis 설정파일 경로
    private final static String RESOURCE = "com/config/Configuration.xml";
    private static SqlSessionFactory factory = null;
    
    // MyBatis 세션을 얻는 메소드
    public static SqlSession getSqlSession() {
         if (factory == null) {
               Reader reader= null;
               
               try {
                     // mybatis.xml 자원을 얻는다.
                     reader = Resources.getResourceAsReader(RESOURCE);
                     factory = new SqlSessionFactoryBuilder().build(reader);
                     
               } catch (IOException e) {
                     e.printStackTrace();
                     
               }finally {
            	   if(reader!=null) {
            		   try{reader.close();}catch(Exception e) {}
            	   }
               }
         }
         return factory.openSession();
    }
}

