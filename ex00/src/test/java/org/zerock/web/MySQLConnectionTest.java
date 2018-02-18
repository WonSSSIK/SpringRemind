package org.zerock.web;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class MySQLConnectionTest {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	//MySQL Driver 6.0
	
	private static final String URL = "jdbc:mysql://192.168.226.141:3306/book_ex?useSSL=false&sererTimezone=Asia/Seoul";

	private static final String USER="zerock";
	private static final String PW="1234";
	
	@Test
	public void testConnection() throws Exception{
		Class.forName(DRIVER);
		
		try(Connection con = DriverManager.getConnection(URL,USER,PW)){
			System.out.println(con);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
