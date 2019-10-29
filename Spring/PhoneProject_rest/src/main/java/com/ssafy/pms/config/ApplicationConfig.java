package com.ssafy.pms.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
/*<context:component-scan base-package="com.ssafy.pms.repo, com.ssafy.pms.service"/>  */
@ComponentScan({ "com.mybatis.dao", "com.mybatis.service" })
/*<tx:annotation-driven transaction-manager="transactionManager"/>*/
@EnableTransactionManagement
public class ApplicationConfig {
	/* 	<!-- Connection Pool을 위한 DataSource 설정 -->
		<bean  id="dataSource" class="org.apache.commons.dbcp.BasicDataSource"  destroy-method="close">
			<property name="driverClassName"  	value="com.mysql.cj.jdbc.Driver" />
			<property name="url"  				value="jdbc:mysql://localhost:3306/ssafydb?serverTimezone=UTC;useSSL=false&amp;allowPublicKeyRetrieval=true" />
			<property name="username"  			value="ssafy" />
			<property name="password"  			value="ssafy" />
			<property name="maxActive"  		value="20" />
		</bean>*/
	@Bean
	public DataSource dataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/ssafydb?serverTimezone=UTC");
		ds.setUsername("ssafy");
		ds.setPassword("ssafy");
		ds.setMaxActive(20);
		return ds;
	}

	/*<!-- MyBatis 설정  -->
	<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="dataSource"  ref="dataSource"/>
		<!-- MyBatis 기본 설정 XML 등록 -->
		<property name="configLocation"  value="classpath:spring/SqlMapConfig.xml"/>
	</bean>
	
	<bean  id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
		<constructor-arg ref="sqlSessionFactory"/>		
	</bean> */
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory(DataSource ds) {
		SqlSessionFactoryBean sbean = new SqlSessionFactoryBean();
		sbean.setDataSource(ds);
		String configLoc = "classpath:spring/SqlMapConfig.xml";
		sbean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource(configLoc));

		return sbean;
	}

	@Bean
	public SqlSession sqlSession(SqlSessionFactoryBean sBean) throws Exception {
		return new SqlSessionTemplate(sBean.getObject());
	}

	/*	
		<!-- Transaction 관련 처리 추가 -->
		<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
			<property name="dataSource" ref="dataSource"></property>
		</bean>
	*/
	/*
	 * @Bean public PlatformTransactionManager transactionManager(DataSource ds) {
	 * return new DataSourceTransactionManager(ds); }
	 */
}
