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
		System.out.println("(log) �ƽ������� �ڸ���ä��� jswNO >>>> : " + commNO);
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
				System.out.println("(log)Chaebun1>> Connection ����");
				
				pstmt = conn.prepareStatement(HelloBoardSqlMap.JSW_BOARD_CHAEBUN);
					    		
				rsRs = pstmt.executeQuery();	
				System.out.println("(log)Chaebun2>> CAHBUN���� ����  ===> : \n" + HelloBoardSqlMap.JSW_BOARD_CHAEBUN);	
				
				if ( rsRs != null){
				  while (rsRs.next()){ 
					  Bjno = rsRs.getString("JCNO"); //�÷��̸��� ������;��� ä�� �����ʿ��� Ȯ��	
				  }
				}
				System.out.println("(log)Chaebun3>> �ƽ���+1 jswbjNo >>>> : " + Bjno);
				
				Bjno = GUBUN_B +  JswBoardChaebun.commNum(Bjno);
				System.out.println("(log)Chaebun4>> �������� ����jswbjNo >>>> : " + Bjno);
				
				JswConnProperty.conClose(conn, pstmt, rsRs);
				
			}catch(Exception e){
				System.out.println("(log) Chaebun DB ������ >>> :" + e.getMessage());
			}finally{
					JswConnProperty.conClose(conn, pstmt, rsRs);	
			}
			
			System.out.println("(log) jswbjNo() END----------- ");
			return Bjno;
		}


	public static void main(String[] args) {

		JswBoardChaebun.jswbjNo();

		
		
	}//main()��
} //JswChaebunClass Ŭ������
