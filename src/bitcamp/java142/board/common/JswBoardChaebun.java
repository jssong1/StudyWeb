package bitcamp.java142.board.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bitcamp.java142.board.sql.HelloBoardSqlMap;

public abstract class JswBoardChaebun {
	
	public static final String GUBUN_B = "B";

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
		
	public static String jswbjNo(){
			
			Connection conn         = null;
			PreparedStatement pstmt = null;
			ResultSet  rsRs         = null;	
			
			String Bjno    = "";	
			System.out.println("(log)jswbjNo() START------------ ");
			try{
				
				conn = JswConnProperty.getConnection();
				System.out.println("(log)Chaebun1>> Connection 성공");
				
				pstmt = conn.prepareStatement(HelloBoardSqlMap.JSW_BOARD_CHAEBUN);
					    		
				rsRs = pstmt.executeQuery();	
				System.out.println("(log)Chaebun2>> CAHBUN쿼리 실행  ===> : \n" + HelloBoardSqlMap.JSW_BOARD_CHAEBUN);	
				
				if ( rsRs != null){
				  while (rsRs.next()){ 
					  Bjno = rsRs.getString("JCNO"); //컬럼이름을 가지고와야해 채번 쿼리맵에서 확인	
				  }
				}
				System.out.println("(log)Chaebun3>> 맥스값+1 jswbjNo >>>> : " + Bjno);
				
				Bjno = GUBUN_B +  JswBoardChaebun.commNum(Bjno);
				System.out.println("(log)Chaebun4>> 구분형식 넣은jswbjNo >>>> : " + Bjno);
				
				JswConnProperty.conClose(conn, pstmt, rsRs);
				
			}catch(Exception e){
				System.out.println("(log) Chaebun DB 에러남 >>> :" + e.getMessage());
			}finally{
					JswConnProperty.conClose(conn, pstmt, rsRs);	
			}
			
			System.out.println("(log) jswbjNo() END----------- ");
			return Bjno;
		}


	public static void main(String[] args) {

		JswBoardChaebun.jswbjNo();

		
		
	}//main()끝
} //JswChaebunClass 클래스끝
