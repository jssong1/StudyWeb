package bitcamp.java142.board;

import java.util.ArrayList;


import bitcamp.java142.board.dao.HelloBoardDAO;
import bitcamp.java142.board.dao.HelloBoardDAOImpl;
import bitcamp.java142.board.vo.HelloBoardVO;


public class TestBoard {
	
	//insert합수
	public int insertJswBoard( String jsubject, String jname , String jpw, String jmemo){
		
			System.out.println("(log)--I>>TestBoard.insertJswBoard 함수 START>>>>>");
			
			HelloBoardDAO jdao = new HelloBoardDAOImpl();
			
			HelloBoardVO jvo = null;
			jvo = new HelloBoardVO();
	
			jvo.setJsubject(jsubject) ;
			jvo.setJname(jname) ;
			jvo.setJpw(jpw) ;
			jvo.setJmemo(jmemo);
			jvo.setJdeleteyn("Y");
			
			System.out.println("(log)메인에서 받은 매개변수 >>>> : " +jvo.getJsubject()+" ," +jvo.getJname()+" ,"+jvo.getJpw()+" ," +jvo.getJmemo()+" ," +jvo.getJdeleteyn());
			int nCnt = jdao.insertJswBoard(jvo);
			
			System.out.println("(log) HelloBoardDAOImpl.insertJswMember()에서 리턴된 값 보기 (인서트성공 true)>>>>>" + nCnt);
			
			System.out.println("(log)--I>>TestBoard.insertJswBoard 함수 END>>>>>");
		return nCnt;
		
	}// TestBoard. insertJswBoard()
	
	
	//selectAll함수
	public ArrayList<HelloBoardVO> selectAllJswBoard(){
		System.out.println("(log)--SALL>>TestBoard.selectJswBoard() START>>>>>");
		
		HelloBoardDAO jdao = new HelloBoardDAOImpl();
		ArrayList<HelloBoardVO> aList = jdao.selectAllJswBoard();
		
		System.out.println("(log) HelloBoardDAOImpl.selectJswBoard에서 리턴된 값 보기>>>>>" +aList);
		System.out.println("(log)--SALL>>TestBoard.selectJswBoard() END>>>>>");
		return aList;
	}// TestBoard.selectJswBoard()
	
	
	//select함수
	public ArrayList<HelloBoardVO> selectJswBoard(String jno){
		System.out.println("(log)--SALL>>TestBoard.selectJswBoard() START>>>>>");
		

		HelloBoardDAO jdao = new HelloBoardDAOImpl();
		
		HelloBoardVO jbvo = null;
		jbvo = new HelloBoardVO();
		jbvo.setJno(jno);
		System.out.println("(log)메인에서 받은 매개변수 >>>> : " + jbvo.getJno());
		ArrayList<HelloBoardVO> aList = jdao.boardSelect(jbvo);
		
		System.out.println("(log)--SSEA>>jswMemberScr.searchJswMember 함수 END >>>>>");
		return aList;
	}// TestBoard.selectJswBoard()
	
	
	
	//update 함수
	public int updateJswBoard(String jsubject, String jname, String jmemo,String jno){
		System.out.println("(log)--U>>TestBoard.updateJswBoard() START>>>>>");
		HelloBoardDAO jdao = new HelloBoardDAOImpl();
		
		HelloBoardVO jbvo = null;
		jbvo = new HelloBoardVO();
		jbvo.setJsubject(jsubject);
		jbvo.setJname(jname); 
		jbvo.setJmemo(jmemo);
		jbvo.setJno(jno);
		System.out.println("(log)메인에서 받은 매개변수 >>>> : " + jbvo.getJsubject() +" ," + jbvo.getJname() +" ,"  +jbvo.getJmemo()+" ," +jbvo.getJno());
		int nCnt = jdao.updateJswBoard(jbvo);
		System.out.println("(log)--U>>TestBoard.updateJswBoard() END>>>>>");
		return nCnt;
	}


	
	//display
	private static void displayFun(ArrayList<HelloBoardVO> aList) {
		// TODO Auto-generated method stub
		int aListSize = aList.size();
		for(int i =0; i<aListSize;i++){
			HelloBoardVO jvo = (HelloBoardVO)aList.get(i);

			System.out.print(""+i+"번째 for >>> : " + jvo.getJno());	
			System.out.print(" " + jvo.getJsubject());
			System.out.print(" " + jvo.getJname());
			System.out.print(" " + jvo.getJpw());
			System.out.print(" " + jvo.getJmemo());
			System.out.print(" " + jvo.getJdeleteyn());
			System.out.print(" " + jvo.getJinsertdate());
			System.out.println(" " + jvo.getJupdatedate());
			
		}//for문 끝	
	}// TestBoarddisplayFun()
	
	
	public int deleteJswBoard(String jno){
		System.out.println("(log)--D>>TestBoard.deleteJswBoard() START>>>>>");
		HelloBoardDAO jdao = new HelloBoardDAOImpl();
		
		HelloBoardVO jbvo = null;
		jbvo = new HelloBoardVO();
		jbvo.setJno(jno);
		System.out.println("(log)메인에서 받은 매개변수 >>>> : " +  jbvo.getJno());
		int nCnt = jdao.deleteJswBoard(jbvo);
		System.out.println("(log)--U>>TestBoard.deleteJswBoard() END>>>>>");
		
		return nCnt;
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sFlag = "U";
		
		
		//INSERT
		if("I".equals(sFlag)){
			System.out.println("(log)TestBoard.main INSERT START>>>>>");
			
       
			 String jsubject = "soCngF3";
			 String jname = "s1222ET2D";
			 String jpw = "w2222SDFSSD"; 
			 String jmemo = "23DFF1324F";
	
			 TestBoard es = new TestBoard();
			int nCnt = es.insertJswBoard( jsubject, jname , jpw, jmemo);
			
			if ( nCnt >=1 ){
				System.out.println("(log) 데이터 INSERT 완료 >>> : ");
				
				TestBoard tb = new TestBoard();
				ArrayList<HelloBoardVO> aList = tb.selectAllJswBoard();
				int aListSize = aList.size();
				if(aListSize > 0){
					TestBoard.displayFun(aList); 
				}
				
			}else{
				System.out.println("(log) 데이터 INSERT 실패 >>> : ");				
			}// 출력if-else 끝
			System.out.println("(log)TestBoard.main INSERT END>>>>>");
		}//if(I)끝
		
		//SALL
		if ("SALL".equals(sFlag)){
			System.out.println("(log)TestBoard.main 전체조회 SELECT ALL START>>>>>");
			TestBoard es = new TestBoard();
			ArrayList<HelloBoardVO> aList = es.selectAllJswBoard();
			
			int aListSize = aList.size();
			if (aListSize > 0){
				TestBoard.displayFun(aList);				
			
			}//작은 if끝
			System.out.println("(log)TestBoard.main 전체조회 SELECT ALL END>>>>>");	
		}//if(SALL) 끝
		
		//키워드 검색 메인
		if ("SSEA".equals(sFlag)){
			System.out.println("(log)---키워드 검색 SEARCH 메인 함수 START>>>>>");
			String jno = "B0004";
			TestBoard tb = new TestBoard();
			ArrayList<HelloBoardVO> aList = tb.selectJswBoard(jno);
			
			int aListSize = aList.size();
			if (aListSize > 0){
				TestBoard.displayFun(aList);				
			
			}//작은 if끝
		System.out.println("(log)---키워드 검색 SEARCH 메인 함수END>>>>>");
		}//if(SSEA) 끝
		
		//update
		if("U".equals(sFlag)){
			System.out.println("(log)---UPDATE 메인 함수 START>>>>>");
			String jsubject = "good";
			String jname = "정송튜";
			String jmemo = "thanks";
			String jno = "B0002";
					
			TestBoard es = new TestBoard();
			int rCnt = es.updateJswBoard(jsubject, jname,jmemo, jno);
			
			if (rCnt >=1 ){
				System.out.println("(log)데이터 UPDATE 완료 >>> : ");
				
				TestBoard tbd = new TestBoard();//입력잘되었으니까 전체조회를 위해 다시 인스턴스고고해서 출력
				ArrayList<HelloBoardVO> aList = tbd.selectAllJswBoard();
				int aListSize = aList.size();
				if(aListSize > 0){
					TestBoard.displayFun(aList);
				}
				
			}else{
				System.out.println("(log)데이터 UPDATE 실패 >>> : ");				
			}// 출력if-else 끝
			
			System.out.println("(log)---UPDATE 메인 함수 END >>>>>");
		}//if(U)끝
		
		//delete	
		if("D".equals(sFlag)){
			System.out.println("(log)---DELETE 메인 함수 START>>>>>");
			String jno = "B0005";
			 
			TestBoard es = new TestBoard();
			int rCnt = es.deleteJswBoard(jno);
			
			if (rCnt >=1){
				System.out.println("(log)데이터 DELETE 완료 >>> : ");
				
				TestBoard tbd = new TestBoard();//입력잘되었으니까 전체조회를 위해 다시 인스턴스고고해서 출력
				ArrayList<HelloBoardVO> aList = tbd.selectAllJswBoard();
				int aListSize = aList.size();
				if(aListSize > 0){
					TestBoard.displayFun(aList);
				}
				
			}else{
				System.out.println("(log)데이터 DELETE 실패 >>> : ");				
			}// 출력if-else 끝
			System.out.println("(log)---DELETE 메인 함수 END >>>>>");
			
		}//if(D) 끝
		
	}


}
