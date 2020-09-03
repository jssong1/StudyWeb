package bitcamp.java142.board;

import java.util.ArrayList;


import bitcamp.java142.board.dao.HelloBoardDAO;
import bitcamp.java142.board.dao.HelloBoardDAOImpl;
import bitcamp.java142.board.vo.HelloBoardVO;


public class TestBoard {
	
	//insert�ռ�
	public int insertJswBoard( String jsubject, String jname , String jpw, String jmemo){
		
			System.out.println("(log)--I>>TestBoard.insertJswBoard �Լ� START>>>>>");
			
			HelloBoardDAO jdao = new HelloBoardDAOImpl();
			
			HelloBoardVO jvo = null;
			jvo = new HelloBoardVO();
	
			jvo.setJsubject(jsubject) ;
			jvo.setJname(jname) ;
			jvo.setJpw(jpw) ;
			jvo.setJmemo(jmemo);
			jvo.setJdeleteyn("Y");
			
			System.out.println("(log)���ο��� ���� �Ű����� >>>> : " +jvo.getJsubject()+" ," +jvo.getJname()+" ,"+jvo.getJpw()+" ," +jvo.getJmemo()+" ," +jvo.getJdeleteyn());
			int nCnt = jdao.insertJswBoard(jvo);
			
			System.out.println("(log) HelloBoardDAOImpl.insertJswMember()���� ���ϵ� �� ���� (�μ�Ʈ���� true)>>>>>" + nCnt);
			
			System.out.println("(log)--I>>TestBoard.insertJswBoard �Լ� END>>>>>");
		return nCnt;
		
	}// TestBoard. insertJswBoard()
	
	
	//selectAll�Լ�
	public ArrayList<HelloBoardVO> selectAllJswBoard(){
		System.out.println("(log)--SALL>>TestBoard.selectJswBoard() START>>>>>");
		
		HelloBoardDAO jdao = new HelloBoardDAOImpl();
		ArrayList<HelloBoardVO> aList = jdao.selectAllJswBoard();
		
		System.out.println("(log) HelloBoardDAOImpl.selectJswBoard���� ���ϵ� �� ����>>>>>" +aList);
		System.out.println("(log)--SALL>>TestBoard.selectJswBoard() END>>>>>");
		return aList;
	}// TestBoard.selectJswBoard()
	
	
	//select�Լ�
	public ArrayList<HelloBoardVO> selectJswBoard(String jno){
		System.out.println("(log)--SALL>>TestBoard.selectJswBoard() START>>>>>");
		

		HelloBoardDAO jdao = new HelloBoardDAOImpl();
		
		HelloBoardVO jbvo = null;
		jbvo = new HelloBoardVO();
		jbvo.setJno(jno);
		System.out.println("(log)���ο��� ���� �Ű����� >>>> : " + jbvo.getJno());
		ArrayList<HelloBoardVO> aList = jdao.boardSelect(jbvo);
		
		System.out.println("(log)--SSEA>>jswMemberScr.searchJswMember �Լ� END >>>>>");
		return aList;
	}// TestBoard.selectJswBoard()
	
	
	
	//update �Լ�
	public int updateJswBoard(String jsubject, String jname, String jmemo,String jno){
		System.out.println("(log)--U>>TestBoard.updateJswBoard() START>>>>>");
		HelloBoardDAO jdao = new HelloBoardDAOImpl();
		
		HelloBoardVO jbvo = null;
		jbvo = new HelloBoardVO();
		jbvo.setJsubject(jsubject);
		jbvo.setJname(jname); 
		jbvo.setJmemo(jmemo);
		jbvo.setJno(jno);
		System.out.println("(log)���ο��� ���� �Ű����� >>>> : " + jbvo.getJsubject() +" ," + jbvo.getJname() +" ,"  +jbvo.getJmemo()+" ," +jbvo.getJno());
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

			System.out.print(""+i+"��° for >>> : " + jvo.getJno());	
			System.out.print(" " + jvo.getJsubject());
			System.out.print(" " + jvo.getJname());
			System.out.print(" " + jvo.getJpw());
			System.out.print(" " + jvo.getJmemo());
			System.out.print(" " + jvo.getJdeleteyn());
			System.out.print(" " + jvo.getJinsertdate());
			System.out.println(" " + jvo.getJupdatedate());
			
		}//for�� ��	
	}// TestBoarddisplayFun()
	
	
	public int deleteJswBoard(String jno){
		System.out.println("(log)--D>>TestBoard.deleteJswBoard() START>>>>>");
		HelloBoardDAO jdao = new HelloBoardDAOImpl();
		
		HelloBoardVO jbvo = null;
		jbvo = new HelloBoardVO();
		jbvo.setJno(jno);
		System.out.println("(log)���ο��� ���� �Ű����� >>>> : " +  jbvo.getJno());
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
				System.out.println("(log) ������ INSERT �Ϸ� >>> : ");
				
				TestBoard tb = new TestBoard();
				ArrayList<HelloBoardVO> aList = tb.selectAllJswBoard();
				int aListSize = aList.size();
				if(aListSize > 0){
					TestBoard.displayFun(aList); 
				}
				
			}else{
				System.out.println("(log) ������ INSERT ���� >>> : ");				
			}// ���if-else ��
			System.out.println("(log)TestBoard.main INSERT END>>>>>");
		}//if(I)��
		
		//SALL
		if ("SALL".equals(sFlag)){
			System.out.println("(log)TestBoard.main ��ü��ȸ SELECT ALL START>>>>>");
			TestBoard es = new TestBoard();
			ArrayList<HelloBoardVO> aList = es.selectAllJswBoard();
			
			int aListSize = aList.size();
			if (aListSize > 0){
				TestBoard.displayFun(aList);				
			
			}//���� if��
			System.out.println("(log)TestBoard.main ��ü��ȸ SELECT ALL END>>>>>");	
		}//if(SALL) ��
		
		//Ű���� �˻� ����
		if ("SSEA".equals(sFlag)){
			System.out.println("(log)---Ű���� �˻� SEARCH ���� �Լ� START>>>>>");
			String jno = "B0004";
			TestBoard tb = new TestBoard();
			ArrayList<HelloBoardVO> aList = tb.selectJswBoard(jno);
			
			int aListSize = aList.size();
			if (aListSize > 0){
				TestBoard.displayFun(aList);				
			
			}//���� if��
		System.out.println("(log)---Ű���� �˻� SEARCH ���� �Լ�END>>>>>");
		}//if(SSEA) ��
		
		//update
		if("U".equals(sFlag)){
			System.out.println("(log)---UPDATE ���� �Լ� START>>>>>");
			String jsubject = "good";
			String jname = "����Ʃ";
			String jmemo = "thanks";
			String jno = "B0002";
					
			TestBoard es = new TestBoard();
			int rCnt = es.updateJswBoard(jsubject, jname,jmemo, jno);
			
			if (rCnt >=1 ){
				System.out.println("(log)������ UPDATE �Ϸ� >>> : ");
				
				TestBoard tbd = new TestBoard();//�Է��ߵǾ����ϱ� ��ü��ȸ�� ���� �ٽ� �ν��Ͻ�����ؼ� ���
				ArrayList<HelloBoardVO> aList = tbd.selectAllJswBoard();
				int aListSize = aList.size();
				if(aListSize > 0){
					TestBoard.displayFun(aList);
				}
				
			}else{
				System.out.println("(log)������ UPDATE ���� >>> : ");				
			}// ���if-else ��
			
			System.out.println("(log)---UPDATE ���� �Լ� END >>>>>");
		}//if(U)��
		
		//delete	
		if("D".equals(sFlag)){
			System.out.println("(log)---DELETE ���� �Լ� START>>>>>");
			String jno = "B0005";
			 
			TestBoard es = new TestBoard();
			int rCnt = es.deleteJswBoard(jno);
			
			if (rCnt >=1){
				System.out.println("(log)������ DELETE �Ϸ� >>> : ");
				
				TestBoard tbd = new TestBoard();//�Է��ߵǾ����ϱ� ��ü��ȸ�� ���� �ٽ� �ν��Ͻ�����ؼ� ���
				ArrayList<HelloBoardVO> aList = tbd.selectAllJswBoard();
				int aListSize = aList.size();
				if(aListSize > 0){
					TestBoard.displayFun(aList);
				}
				
			}else{
				System.out.println("(log)������ DELETE ���� >>> : ");				
			}// ���if-else ��
			System.out.println("(log)---DELETE ���� �Լ� END >>>>>");
			
		}//if(D) ��
		
	}


}
