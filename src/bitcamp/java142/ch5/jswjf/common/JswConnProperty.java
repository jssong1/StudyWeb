package bitcamp.java142.ch5.jswjf.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class JswConnProperty {

	public static final String ORACLE11G_JDBCDRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String ORACLE11G_URL = "jdbc:oracle:thin:@127.0.0.1:1521:orclKBW";
	public static final String ORACLE11G_USER = "scott";
	public static final String ORACLE11G_PASS = "tiger";
	
	public static Connection getConnection() throws Exception{
		System.out.println("(log)--1-------------<<<<<<<<<<<<계정연결 시작 ");
		Connection conn = null;
		Class.forName(ORACLE11G_JDBCDRIVER);
		conn = DriverManager.getConnection(ORACLE11G_URL, ORACLE11G_USER, ORACLE11G_PASS);
		System.out.println("(log)--1------------->>>>>>>>>>>>계정연결 conn리턴 ");
		return conn;
	}
	
	public static void conClose (Connection conn
								,PreparedStatement pstmt
								,ResultSet rsRs){
		try{
			if(rsRs != null) try{ rsRs.close(); rsRs = null; }catch(Exception ex){}
			if(pstmt != null) try{ pstmt.close(); pstmt =null; }catch(Exception ex){}
			if(conn != null) try{ conn.close(); conn =null; }catch(Exception ex){}
			}catch(Exception e2){}		
	} //conClose끝
			
	public static void conClose (Connection conn, PreparedStatement pstmt){ //conClose가 두개네 오버로딩?
		try{
			if(pstmt != null) try{ pstmt.close(); pstmt =null; }catch(Exception ex){}
			if(conn != null) try{ conn.close(); conn =null; }catch(Exception ex){}
			}catch(Exception e2){}		
	} //conClose끝

}
