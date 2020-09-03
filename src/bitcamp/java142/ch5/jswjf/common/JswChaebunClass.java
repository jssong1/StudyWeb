package bitcamp.java142.ch5.jswjf.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import bitcamp.java142.ch5.jswjf.sql.JswSqlQueryMap;


public abstract class JswChaebunClass {

	
	public static final String JAVA_GUBUN_M = "M";
	
	public static String ymdFormat(){
		
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		String date = sdf.format(d);
		System.out.println("yyyyMMdd------------ " +date);
		return date;
	}
	
	public static String commNum(String commNO){
		
		if (1 == commNO.length()){
			commNO = "000" + commNO;			
		}
		if (2 == commNO.length()){
			commNO = "00" + commNO;
		}	
		if (3 == commNO.length()){
			commNO = "0" + commNO;
		}			
		System.out.println("commNO >>>> : " + commNO);
		System.out.println("(log) 맥스값에서 자리수채우기 jswNO >>>> : " + commNO);
		return commNO;
	}
	
	public static String jswjfNo(){
		
		Connection conn         = null;
		PreparedStatement pstmt = null;
		ResultSet  rsRs         = null;	
		
		String jswNO    = "";	
		System.out.println("(log)JswChaebunClass() START------------ ");
		try{
			
			conn = JswConnProperty.getConnection();
			System.out.println("(log)Chaebun1>> Connection 성공");
			
			pstmt = conn.prepareStatement(JswSqlQueryMap.JSWSC_WORK_ENUM_CHAEBUN);
				    		
			rsRs = pstmt.executeQuery();	
			System.out.println("(log)Chaebun2>> CAHBUN쿼리 실행  ===> : \n" + JswSqlQueryMap.JSWSC_WORK_ENUM_CHAEBUN);	
			
			if ( rsRs != null){
			  while (rsRs.next()){
				  jswNO = rsRs.getString("JMEM");	
			  }
			}
			System.out.println("(log)Chaebun3>> 맥스값+1 jswNO >>>> : " + jswNO);
			
			jswNO = JAVA_GUBUN_M + JswChaebunClass.ymdFormat()+  JswChaebunClass.commNum(jswNO);
			System.out.println("(log)Chaebun4>> 구분형식 넣은 jswNO >>>> : " + jswNO);
			
			JswConnProperty.conClose(conn, pstmt, rsRs);
			
		}catch(Exception e){
			System.out.println("(log) Chaebun DB 에러남 >>> :" + e.getMessage());
		}finally{
				JswConnProperty.conClose(conn, pstmt, rsRs);	
		}
		
		System.out.println("(log) JswChaebunClass() END----------- ");
		return jswNO;
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JswChaebunClass.ymdFormat();
		JswChaebunClass.jswjfNo();
		System.out.println("(log)Chaebun5>> 결과 jswsjfNo >>> : " + jswjfNo());
//		String jswjfMem = JswChaebunClass.jswjfNo();
//		System.out.println("jswsjfNo >>> : " + jswjfMem);
	}

}
