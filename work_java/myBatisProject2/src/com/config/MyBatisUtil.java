package com.config;
//세션을 생성해줌
import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
    // mybatis 환경 설정 파일 위치(경로)
    private final static String RESOURCE = "com/config/Configuration.xml"; 
    private static SqlSessionFactory factory = null;
    
    // MyBatis SqlSession을 얻는 메소드 //이 스태틱 메서드를 호출해서 얻어낸다.
    public static SqlSession getSqlSession() {
         if (factory == null) {
               Reader reader= null;
               
               try {
                     // mybatis.xml 자원을 얻는다.
                     reader = Resources.getResourceAsReader(RESOURCE); //설정파일에 입력 파이프 연결
                     factory = new SqlSessionFactoryBuilder().build(reader); //1. new로 직접 builder 생성//2. .build()로 factory생성 
                     
               } catch (IOException e) {
                     e.printStackTrace();
                     
               }finally {
            	   if(reader!=null) {
            		   try{reader.close();}catch(Exception e) {}
            	   }
               }
         }
         return factory.openSession(); //3. .openSession으로 session생성 -> Connection(네트워크 연결) 1개
    }
}

