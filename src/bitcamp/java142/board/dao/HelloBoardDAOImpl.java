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
			System.out.println("(log)--2>insertJswBoard_con연결된 주소값 >>> : " + con);
			con.setAutoCommit(false);// -------?
			System.out.println("(log)----2.5>con.getAutoCommit()false나오면 굿 >>> : " + con.getAutoCommit());

			pstmt = con.prepareStatement(HelloBoardSqlMap.getInsertQuery());
			System.out.println("(log)--3>insertJswBoard_HelloBoardSqlMap.getInsertQuery()로그>>> :"
					+ HelloBoardSqlMap.getInsertQuery());
			System.out.println("(log)--4>insertJswBoard_pstmt쿼리돌았음, pstmt 주소값 >>> : " + pstmt);
			System.out.println("(log) 인서트할거 DAOImpl에서 재생" + _jbvo.getJsubject()+" ," +_jbvo.getJname()+" ,"+_jbvo.getJpw()+" ," +_jbvo.getJmemo()+" ,"+ _jbvo.getJdeleteyn());
			pstmt.setString(1, JswBoardChaebun.jswbjNo());
			pstmt.setString(2, _jbvo.getJsubject());
			pstmt.setString(3, _jbvo.getJname());
			pstmt.setString(4, _jbvo.getJpw());
			pstmt.setString(5, _jbvo.getJmemo());
			pstmt.setString(6, _jbvo.getJdeleteyn());
			nCnt = pstmt.executeUpdate();// select조회랑 차이점
											// ResultSet=>rsRs=pstmt.executeQuery();

			boolean b = !con.getAutoCommit();
			System.out.println("(log)b_AutoCommit true나오면 굿>>> : " + b);
			if (!con.getAutoCommit())
				con.commit(); // db commit!!!! 밀어넣기)
			System.out.println("(log)--5>insertJswBoard_nCnt잘 들어갔는가 몇 건? >>>> " + nCnt);

			JswConnProperty.conClose(con, pstmt);

		} catch (Exception e) {
			System.out.println("(log) DAOImpl 에러났음 >>> : " + e.getMessage());
		} finally {
			JswConnProperty.conClose(con, pstmt);
		} // try-catch-finally 끝		
		if(nCnt == 0){
			return 0;}else{
				System.out.println("데이터가 입력되었습니다.");
				System.out.println("리턴될 nCnt값 : "+nCnt);
				System.out.println("(log)------------------------------------DAO.insertJswBoard END  >>>>>");					
				return nCnt;}		
	}

	@Override
	public ArrayList<HelloBoardVO> selectAllJswBoard() {
		// TODO Auto-generated method stub
		System.out.println("(log)------------------------------------DAO.selectJswBoard 함수 START>>>>>");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<HelloBoardVO> aList = null;
		HelloBoardVO jvo = null;

		try {
			con = JswConnProperty.getConnection();
			System.out.println("(log)--2>selectJswBoard_con연결된 주소값 >>> : " + con);
			pstmt = con.prepareStatement(HelloBoardSqlMap.getSelectAllQuery());
			System.out.println("(log)--3>selectJswBoard_HelloBoardSqlMap.getSelectQuery()로그 찍어보기>>> :"
					+ HelloBoardSqlMap.getSelectAllQuery());
			System.out.println("(log)--4>selectJswBoard_pstmt쿼리돌았지, pstmt 주소값 >>> : " + pstmt);
			rsRs = pstmt.executeQuery();
			System.out.println("(log)--5>selectJswBoard_rsRs실행된 주소값 >>> : " + rsRs);

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

					System.out.println("{log) while돌면서 aList에 add되는 주소값들 >>> : " + aList);
				} // while 끝
				System.out.println("(log) 배열리스트 aList 묶음의 개수 >>>" + aList.size());
			} else {
				System.out.println("데이터가 없는 이유를~~ ?");
			} // if-else 끝
			JswConnProperty.conClose(con, pstmt, rsRs);
		} catch (Exception e) {
			System.out.println("(log)DAO.selectJswBoard 에러가 >>> : " + e.getMessage());
		} finally {
			JswConnProperty.conClose(con, pstmt, rsRs);
		}//try-catch-finally 끝
		System.out.println("(log)------------------------------------DAO.selectJswBoard 함수 END >>>>>");
		return aList;
	}

	@Override
	public int updateJswBoard(HelloBoardVO _jbvo) {
		// TODO Auto-generated method stub
		
		System.out.println("(log)------------------------------------DAO.updateJswBoard START  >>>>>");
		Connection con = null;
		PreparedStatement pstmt = null;
		int nCnt=0;	
		
		//로직
		try{
			con = JswConnProperty.getConnection();
			System.out.println("(log)--2>updateJswBoard_con연결된 주소값 >>> : " + con);
			con.setAutoCommit(false);
			System.out.println("(log)----2.5>con.getAutoCommit() false나오면 굿 >>> : " + con.getAutoCommit());
			
			
			
			pstmt = con.prepareStatement(HelloBoardSqlMap.getUpdateQuery());
			System.out.println("(log)--3>updateJswBoard_HelloBoardSqlMap.getSelectQuery()로그>>> :"+ HelloBoardSqlMap.getUpdateQuery());
			System.out.println("(log)--4>updateJswBoard_pstmt쿼리돌았음, pstmt 주소값 >>> : " + pstmt);
			
			System.out.println("플레이스홀더에 바인딩할 매개변수깡통 데이터 >>>> : "  + _jbvo.getJsubject() +" ," + _jbvo.getJname() +" ,"  + _jbvo.getJmemo()+" ," + _jbvo.getJno());
			pstmt.setString(1, _jbvo.getJsubject());
			pstmt.setString(2, _jbvo.getJname());
			pstmt.setString(3, _jbvo.getJmemo());
			pstmt.setString(4, _jbvo.getJno());
			nCnt = pstmt.executeUpdate();//select조회랑 차이점 ResultSet=>rsRs=pstmt.executeQuery();
			
			
			boolean b = !con.getAutoCommit();
			System.out.println("(log)b_AutoCommit true나오면 굿 >>> : " + b);
			if(!con.getAutoCommit()) con.commit(); // db commit!!!! 밀어넣기)
			System.out.println("(log)--5>updateJswBoard_nCnt잘 들어갔는가 몇 건? >>>> " + nCnt);
	
			JswConnProperty.conClose(con, pstmt);
		}catch(Exception e){
			System.out.println("(log) DAOImpl 에러났음 >>> : " + e.getMessage());
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
		
		//로직
		try{
			con = JswConnProperty.getConnection();
			System.out.println("(log)--2>deleteJswBoard_con연결된 주소값 >>> : " + con);
			con.setAutoCommit(false);//-------쌤거에는 딜리트는 없음?????????????????????????
			System.out.println("(log)----2.5>con.getAutoCommit() false나오면 굿 >>> : " + con.getAutoCommit());
			
			
			
			pstmt = con.prepareStatement(HelloBoardSqlMap.getDeleteQuery());
			System.out.println("(log)--3>deleteJswBoard_HelloBoardSqlMap.getDeleteQuery()로그>>> :"+ HelloBoardSqlMap.getDeleteQuery());
			System.out.println("(log)--4>deleteJswBoard_pstmt쿼리돌았음, pstmt 주소값 >>> : " + pstmt);
			
			System.out.println("플레이스홀더에 바인딩할 매개변수깡통 데이터 >>>> :" +_jbvo.getJno());
			pstmt.setString(1, _jbvo.getJno());
			nCnt = pstmt.executeUpdate();//select조회랑 차이점 ResultSet=>rsRs=pstmt.executeQuery();
			
			
			boolean b = !con.getAutoCommit();
			System.out.println("(log)b_AutoCommit true나오면 굿 >>> : " + b);
			if(!con.getAutoCommit()) con.commit(); // db commit!!!! 밀어넣기)
			System.out.println("(log)--5>deleteJswBoard_nCnt잘 들어갔는가 몇 건? >>>> " + nCnt);
	
			JswConnProperty.conClose(con, pstmt);
		}catch(Exception e){
			System.out.println("(log) DAOImpl 에러났음 >>> : " + e.getMessage());
		}finally{
			JswConnProperty.conClose(con, pstmt);
		}
		
		System.out.println("(log)------------------------------------DAO.deleteJswBoard END  >>>>>");
		return nCnt;
	}

	@Override
	public ArrayList<HelloBoardVO> boardSelect(HelloBoardVO _jbvo) {
		// TODO Auto-generated method stub
		System.out.println("(log)------------------------------------DAO.selectJswBoard함수 START>>>>>");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<HelloBoardVO> aList = null;
		HelloBoardVO jvo = null;
		
		//로직
		try{
			con = JswConnProperty.getConnection();
			System.out.println("(log)--2>selectJswBoard_con연결된 주소값 >>> : " + con);
			pstmt = con.prepareStatement(HelloBoardSqlMap.getSelectQuery());
			System.out.println("(log)--3>selectJswBoard_HelloBoardSqlMap.getSelectQuery()로그 찍어보기>>> :"+ HelloBoardSqlMap.getSelectQuery());
			System.out.println("(log)--4>selectJswBoard_pstmt쿼리돌았지, pstmt 주소값 >>> : " + pstmt);
			
			System.out.println("플레이스홀더에 바인딩할 매개변수깡통 데이터 >>>> :" +_jbvo.getJno());
			pstmt.setString(1, _jbvo.getJno());
			
			
			rsRs = pstmt.executeQuery();
			System.out.println("(log)--5>selectJswBoard_rsRs실행된 주소값 >>> : " + rsRs);
			
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
					
					System.out.println("{log) while돌면서 aList에 add되는 주소값들 >>> : " + aList);
				}//while 끝
				System.out.println("(log) 배열리스트 aList 묶음의 개수 >>>"+aList.size());									
			}else{
				System.out.println("데이터가 없는 이유를~~ ?");
			}//if-else 끝
			JswConnProperty.conClose(con, pstmt, rsRs);
			
			
		}catch(Exception e){
			System.out.println("(log)DAOImpl 에러남 >>> : " + e.getMessage());
		}finally{
			JswConnProperty.conClose(con, pstmt, rsRs);	
		}
		System.out.println("(log)------------------------------------DAO.selectJswBoard 함수 END>>>>>");
		return aList;
	}

}
