package bitcamp.java142.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bitcamp.java142.board.common.JswBoardChaebun;
import bitcamp.java142.board.common.JswConnProperty;
import bitcamp.java142.board.sql.HelloBoardSqlMap;
import bitcamp.java142.board.vo.HelloBoardVO;

public class HelloBoardDAOImpl implements HelloBoardDAO {

	@Override  
	public int insertJswBoard(HelloBoardVO _jbvo) {
		// TODO Auto-generated method stub

		System.out.println("(log)------------------------------------DAO.insertJswBoard START>>>>>");
		Connection con = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;

		try {
			con = JswConnProperty.getConnection();
			System.out.println("(log)--2>insertJswBoard_con����� �ּҰ� >>> : " + con);
			con.setAutoCommit(false);// -------?
			System.out.println("(log)----2.5>con.getAutoCommit()false������ �� >>> : " + con.getAutoCommit());

			pstmt = con.prepareStatement(HelloBoardSqlMap.getInsertQuery());
			System.out.println("(log)--3>insertJswBoard_HelloBoardSqlMap.getInsertQuery()�α�>>> :"
					+ HelloBoardSqlMap.getInsertQuery());
			System.out.println("(log)--4>insertJswBoard_pstmt����������, pstmt �ּҰ� >>> : " + pstmt);
			System.out.println("(log) �μ�Ʈ�Ұ� DAOImpl���� ���" + _jbvo.getJsubject()+" ," +_jbvo.getJname()+" ,"+_jbvo.getJpw()+" ," +_jbvo.getJmemo()+" ,"+ _jbvo.getJdeleteyn());
			pstmt.setString(1, JswBoardChaebun.jswbjNo());
			pstmt.setString(2, _jbvo.getJsubject());
			pstmt.setString(3, _jbvo.getJname());
			pstmt.setString(4, _jbvo.getJpw());
			pstmt.setString(5, _jbvo.getJmemo());
			pstmt.setString(6, _jbvo.getJdeleteyn());
			nCnt = pstmt.executeUpdate();// select��ȸ�� ������
											// ResultSet=>rsRs=pstmt.executeQuery();

			boolean b = !con.getAutoCommit();
			System.out.println("(log)b_AutoCommit true������ ��>>> : " + b);
			if (!con.getAutoCommit())
				con.commit(); // db commit!!!! �о�ֱ�)
			System.out.println("(log)--5>insertJswBoard_nCnt�� ���°� �� ��? >>>> " + nCnt);

			JswConnProperty.conClose(con, pstmt);

		} catch (Exception e) {
			System.out.println("(log) DAOImpl �������� >>> : " + e.getMessage());
		} finally {
			JswConnProperty.conClose(con, pstmt);
		} // try-catch-finally ��		
		if(nCnt == 0){
			return 0;}else{
				System.out.println("�����Ͱ� �ԷµǾ����ϴ�.");
				System.out.println("���ϵ� nCnt�� : "+nCnt);
				System.out.println("(log)------------------------------------DAO.insertJswBoard END  >>>>>");					
				return nCnt;}		
	}

	@Override
	public ArrayList<HelloBoardVO> selectAllJswBoard() {
		// TODO Auto-generated method stub
		System.out.println("(log)------------------------------------DAO.selectJswBoard �Լ� START>>>>>");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<HelloBoardVO> aList = null;
		HelloBoardVO jvo = null;

		try {
			con = JswConnProperty.getConnection();
			System.out.println("(log)--2>selectJswBoard_con����� �ּҰ� >>> : " + con);
			pstmt = con.prepareStatement(HelloBoardSqlMap.getSelectAllQuery());
			System.out.println("(log)--3>selectJswBoard_HelloBoardSqlMap.getSelectQuery()�α� ����>>> :"
					+ HelloBoardSqlMap.getSelectAllQuery());
			System.out.println("(log)--4>selectJswBoard_pstmt����������, pstmt �ּҰ� >>> : " + pstmt);
			rsRs = pstmt.executeQuery();
			System.out.println("(log)--5>selectJswBoard_rsRs����� �ּҰ� >>> : " + rsRs);

			if (rsRs != null) {
				aList = new ArrayList<HelloBoardVO>();
				while (rsRs.next()) {
					jvo = new HelloBoardVO();
					jvo.setJno(rsRs.getString(1));
					jvo.setJsubject(rsRs.getString(2));
					jvo.setJname(rsRs.getString(3));
					jvo.setJpw(rsRs.getString(4));
					jvo.setJmemo(rsRs.getString(5));
					jvo.setJdeleteyn(rsRs.getString(6));
					jvo.setJinsertdate(rsRs.getString(7));
					jvo.setJupdatedate(rsRs.getString(8));
					aList.add(jvo);

					System.out.println("{log) while���鼭 aList�� add�Ǵ� �ּҰ��� >>> : " + aList);
				} // while ��
				System.out.println("(log) �迭����Ʈ aList ������ ���� >>>" + aList.size());
			} else {
				System.out.println("�����Ͱ� ���� ������~~ ?");
			} // if-else ��
			JswConnProperty.conClose(con, pstmt, rsRs);
		} catch (Exception e) {
			System.out.println("(log)DAO.selectJswBoard ������ >>> : " + e.getMessage());
		} finally {
			JswConnProperty.conClose(con, pstmt, rsRs);
		}//try-catch-finally ��
		System.out.println("(log)------------------------------------DAO.selectJswBoard �Լ� END >>>>>");
		return aList;
	}

	@Override
	public int updateJswBoard(HelloBoardVO _jbvo) {
		// TODO Auto-generated method stub
		
		System.out.println("(log)------------------------------------DAO.updateJswBoard START  >>>>>");
		Connection con = null;
		PreparedStatement pstmt = null;
		int nCnt=0;	
		
		//����
		try{
			con = JswConnProperty.getConnection();
			System.out.println("(log)--2>updateJswBoard_con����� �ּҰ� >>> : " + con);
			con.setAutoCommit(false);
			System.out.println("(log)----2.5>con.getAutoCommit() false������ �� >>> : " + con.getAutoCommit());
			
			
			
			pstmt = con.prepareStatement(HelloBoardSqlMap.getUpdateQuery());
			System.out.println("(log)--3>updateJswBoard_HelloBoardSqlMap.getSelectQuery()�α�>>> :"+ HelloBoardSqlMap.getUpdateQuery());
			System.out.println("(log)--4>updateJswBoard_pstmt����������, pstmt �ּҰ� >>> : " + pstmt);
			
			System.out.println("�÷��̽�Ȧ���� ���ε��� �Ű��������� ������ >>>> : "  + _jbvo.getJsubject() +" ," + _jbvo.getJname() +" ,"  + _jbvo.getJmemo()+" ," + _jbvo.getJno());
			pstmt.setString(1, _jbvo.getJsubject());
			pstmt.setString(2, _jbvo.getJname());
			pstmt.setString(3, _jbvo.getJmemo());
			pstmt.setString(4, _jbvo.getJno());
			nCnt = pstmt.executeUpdate();//select��ȸ�� ������ ResultSet=>rsRs=pstmt.executeQuery();
			
			
			boolean b = !con.getAutoCommit();
			System.out.println("(log)b_AutoCommit true������ �� >>> : " + b);
			if(!con.getAutoCommit()) con.commit(); // db commit!!!! �о�ֱ�)
			System.out.println("(log)--5>updateJswBoard_nCnt�� ���°� �� ��? >>>> " + nCnt);
	
			JswConnProperty.conClose(con, pstmt);
		}catch(Exception e){
			System.out.println("(log) DAOImpl �������� >>> : " + e.getMessage());
		}finally{
			JswConnProperty.conClose(con, pstmt);
		}
		
		System.out.println("(log)------------------------------------DAO.updateJswBoard END  >>>>>");
		return nCnt;
	}

	@Override
	public int deleteJswBoard(HelloBoardVO _jbvo) {
		// TODO Auto-generated method stub
		
		System.out.println("(log)------------------------------------DAO.deleteJswBoard START  >>>>>");
		Connection con = null;
		PreparedStatement pstmt = null;
		int nCnt=0;	
		
		//����
		try{
			con = JswConnProperty.getConnection();
			System.out.println("(log)--2>deleteJswBoard_con����� �ּҰ� >>> : " + con);
			con.setAutoCommit(false);//-------�ܰſ��� ����Ʈ�� ����?????????????????????????
			System.out.println("(log)----2.5>con.getAutoCommit() false������ �� >>> : " + con.getAutoCommit());
			
			
			
			pstmt = con.prepareStatement(HelloBoardSqlMap.getDeleteQuery());
			System.out.println("(log)--3>deleteJswBoard_HelloBoardSqlMap.getDeleteQuery()�α�>>> :"+ HelloBoardSqlMap.getDeleteQuery());
			System.out.println("(log)--4>deleteJswBoard_pstmt����������, pstmt �ּҰ� >>> : " + pstmt);
			
			System.out.println("�÷��̽�Ȧ���� ���ε��� �Ű��������� ������ >>>> :" +_jbvo.getJno());
			pstmt.setString(1, _jbvo.getJno());
			nCnt = pstmt.executeUpdate();//select��ȸ�� ������ ResultSet=>rsRs=pstmt.executeQuery();
			
			
			boolean b = !con.getAutoCommit();
			System.out.println("(log)b_AutoCommit true������ �� >>> : " + b);
			if(!con.getAutoCommit()) con.commit(); // db commit!!!! �о�ֱ�)
			System.out.println("(log)--5>deleteJswBoard_nCnt�� ���°� �� ��? >>>> " + nCnt);
	
			JswConnProperty.conClose(con, pstmt);
		}catch(Exception e){
			System.out.println("(log) DAOImpl �������� >>> : " + e.getMessage());
		}finally{
			JswConnProperty.conClose(con, pstmt);
		}
		
		System.out.println("(log)------------------------------------DAO.deleteJswBoard END  >>>>>");
		return nCnt;
	}

	@Override
	public ArrayList<HelloBoardVO> boardSelect(HelloBoardVO _jbvo) {
		// TODO Auto-generated method stub
		System.out.println("(log)------------------------------------DAO.selectJswBoard�Լ� START>>>>>");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<HelloBoardVO> aList = null;
		HelloBoardVO jvo = null;
		
		//����
		try{
			con = JswConnProperty.getConnection();
			System.out.println("(log)--2>selectJswBoard_con����� �ּҰ� >>> : " + con);
			pstmt = con.prepareStatement(HelloBoardSqlMap.getSelectQuery());
			System.out.println("(log)--3>selectJswBoard_HelloBoardSqlMap.getSelectQuery()�α� ����>>> :"+ HelloBoardSqlMap.getSelectQuery());
			System.out.println("(log)--4>selectJswBoard_pstmt����������, pstmt �ּҰ� >>> : " + pstmt);
			
			System.out.println("�÷��̽�Ȧ���� ���ε��� �Ű��������� ������ >>>> :" +_jbvo.getJno());
			pstmt.setString(1, _jbvo.getJno());
			
			
			rsRs = pstmt.executeQuery();
			System.out.println("(log)--5>selectJswBoard_rsRs����� �ּҰ� >>> : " + rsRs);
			
			if(rsRs != null){
				aList = new ArrayList<HelloBoardVO>();
				while(rsRs.next()){
					jvo = new HelloBoardVO();
					jvo.setJno(rsRs.getString(1));
					jvo.setJsubject(rsRs.getString(2));
					jvo.setJname(rsRs.getString(3));
					jvo.setJpw(rsRs.getString(4));
					jvo.setJmemo(rsRs.getString(5));
					jvo.setJdeleteyn(rsRs.getString(6));
					jvo.setJinsertdate(rsRs.getString(7));
					jvo.setJupdatedate(rsRs.getString(8));
					aList.add(jvo);
					
					System.out.println("{log) while���鼭 aList�� add�Ǵ� �ּҰ��� >>> : " + aList);
				}//while ��
				System.out.println("(log) �迭����Ʈ aList ������ ���� >>>"+aList.size());									
			}else{
				System.out.println("�����Ͱ� ���� ������~~ ?");
			}//if-else ��
			JswConnProperty.conClose(con, pstmt, rsRs);
			
			
		}catch(Exception e){
			System.out.println("(log)DAOImpl ������ >>> : " + e.getMessage());
		}finally{
			JswConnProperty.conClose(con, pstmt, rsRs);	
		}
		System.out.println("(log)------------------------------------DAO.selectJswBoard �Լ� END>>>>>");
		return aList;
	}

}
