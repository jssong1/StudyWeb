package bitcamp.java142.ch5.jswjf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bitcamp.java142.ch5.jswjf.common.JswChaebunClass;
import bitcamp.java142.ch5.jswjf.common.JswConnProperty;
import bitcamp.java142.ch5.jswjf.sql.JswSqlQueryMap;
import bitcamp.java142.ch5.jswjf.vo.JswMemberVO;

public class JswMemberDAOImpl implements JswMemberDAO {

	@Override
	public boolean insertJswMember(JswMemberVO _jvo) {
		// TODO Auto-generated method stub
		System.out.println("(log)------------------------------------DAO.insertJswMember START>>>>>");
		Connection con = null;
		PreparedStatement pstmt = null;
		int nCnt=0;	
		
		
		try{
			con = JswConnProperty.getConnection();
			System.out.println("(log)--2>insertJswMember_con연결된 주소값 >>> : " + con);
			con.setAutoCommit(false);//-------?
			System.out.println("(log)----2.5>con.getAutoCommit()false나오면 굿 >>> : " + con.getAutoCommit());
			
			
			
			pstmt = con.prepareStatement(JswSqlQueryMap.getInsertQuery());
			System.out.println("(log)--3>insertJswMember_JswSqlQueryMap.getInsertQuery()로그>>> :"+ JswSqlQueryMap.getInsertQuery());
			System.out.println("(log)--4>insertJswMember_pstmt쿼리돌았음, pstmt 주소값 >>> : " + pstmt);
			
			pstmt.setString(1, JswChaebunClass.jswjfNo());
			pstmt.setString(2, _jvo.getJkname());
			pstmt.setString(3, _jvo.getJalias());
			pstmt.setString(4, _jvo.getJid());
			pstmt.setString(5, _jvo.getJpw());
			pstmt.setString(6, _jvo.getJgender());
			pstmt.setString(7, _jvo.getJhp());
			pstmt.setString(8, _jvo.getJbirth());
			pstmt.setString(9, _jvo.getJemail());
			pstmt.setString(10, _jvo.getJpostno());
			pstmt.setString(11, _jvo.getJaddr());
			pstmt.setString(12, "Y");
			nCnt = pstmt.executeUpdate();//select조회랑 차이점 ResultSet=>rsRs=pstmt.executeQuery();
			
			
			
			boolean b = !con.getAutoCommit();
			System.out.println("(log)b_AutoCommit true나오면 굿>>> : " + b);
			if(!con.getAutoCommit()) con.commit(); // db commit!!!! 밀어넣기)
			System.out.println("(log)--5>insertJswMember_nCnt잘 들어갔는가 몇 건? >>>> " + nCnt);
	
			JswConnProperty.conClose(con, pstmt);
			
		}catch(Exception e){
			System.out.println("(log) DAOImpl 에러났음 >>> : " + e.getMessage());
		}finally{
			JswConnProperty.conClose(con, pstmt);
		}//try-catch-finally 끝
		System.out.println("(log)------------------------------------DAO.insertJswMember END  >>>>>");
		if (nCnt==0) return false;
		return true;
		
	}//insertJswMember끝

	@Override
	public boolean updateJswMember(JswMemberVO _jvo) {
		// TODO Auto-generated method stub
		System.out.println("(log)------------------------------------DAO.updateJswMember START  >>>>>");
		Connection con = null;
		PreparedStatement pstmt = null;
		int nCnt=0;	
		
		//로직
		try{
			con = JswConnProperty.getConnection();
			System.out.println("(log)--2>updateJswMember_con연결된 주소값 >>> : " + con);
			con.setAutoCommit(false);//-------쌤거에는 딜리트는 없음?????????????????????????
			System.out.println("(log)----2.5>con.getAutoCommit() false나오면 굿 >>> : " + con.getAutoCommit());
			
			
			
			pstmt = con.prepareStatement(JswSqlQueryMap.getUpdateQuery());
			System.out.println("(log)--3>updateJswMember_JswSqlQueryMap.getUpdateQuery()로그>>> :"+ JswSqlQueryMap.getUpdateQuery());
			System.out.println("(log)--4>updateJswMember_pstmt쿼리돌았음, pstmt 주소값 >>> : " + pstmt);
			
			System.out.println("플레이스홀더에 바인딩할 매개변수깡통 데이터 >>>> : " +_jvo.getJmem() +", " +_jvo.getJkname());
			pstmt.setString(1, _jvo.getJkname());
			pstmt.setString(2, _jvo.getJmem());
			nCnt = pstmt.executeUpdate();//select조회랑 차이점 ResultSet=>rsRs=pstmt.executeQuery();
			
			
			boolean b = !con.getAutoCommit();
			System.out.println("(log)b_AutoCommit true나오면 굿 >>> : " + b);
			if(!con.getAutoCommit()) con.commit(); // db commit!!!! 밀어넣기)
			System.out.println("(log)--5>updateJswMember_nCnt잘 들어갔는가 몇 건? >>>> " + nCnt);
	
			JswConnProperty.conClose(con, pstmt);
		}catch(Exception e){
			System.out.println("(log) DAOImpl 에러났음 >>> : " + e.getMessage());
		}finally{
			JswConnProperty.conClose(con, pstmt);
		}
		
		System.out.println("(log)------------------------------------DAO.updateJswMember END  >>>>>");
		if (nCnt==0) return false;
		return true;
	}//updateJswMember끝

	@Override
	public boolean deleteJswMember(JswMemberVO _jvo) {
		// TODO Auto-generated method stub
		System.out.println("(log)------------------------------------DAO.deleteJswMember START  >>>>>");
		Connection con = null;
		PreparedStatement pstmt = null;
		int nCnt=0;	
		
		//로직
		try{
			con = JswConnProperty.getConnection();
			System.out.println("(log)--2>deleteJswMember_con연결된 주소값 >>> : " + con);
			con.setAutoCommit(false);//-------쌤거에는 딜리트는 없음?????????????????????????
			System.out.println("(log)----2.5>con.getAutoCommit() false나오면 굿 >>> : " + con.getAutoCommit());
			
			
			
			pstmt = con.prepareStatement(JswSqlQueryMap.getDeleteQuery());
			System.out.println("(log)--3>deleteJswMember_JswSqlQueryMap.getDeleteQuery()로그>>> :"+ JswSqlQueryMap.getDeleteQuery());
			System.out.println("(log)--4>deleteJswMember_pstmt쿼리돌았음, pstmt 주소값 >>> : " + pstmt);
			
			System.out.println("플레이스홀더에 바인딩할 매개변수깡통 데이터 >>>> :" +_jvo.getJmem());
			pstmt.setString(1, _jvo.getJmem());
			nCnt = pstmt.executeUpdate();//select조회랑 차이점 ResultSet=>rsRs=pstmt.executeQuery();
			
			
			boolean b = !con.getAutoCommit();
			System.out.println("(log)b_AutoCommit true나오면 굿 >>> : " + b);
			if(!con.getAutoCommit()) con.commit(); // db commit!!!! 밀어넣기)
			System.out.println("(log)--5>insertJswMember_nCnt잘 들어갔는가 몇 건? >>>> " + nCnt);
	
			JswConnProperty.conClose(con, pstmt);
		}catch(Exception e){
			System.out.println("(log) DAOImpl 에러났음 >>> : " + e.getMessage());
		}finally{
			JswConnProperty.conClose(con, pstmt);
		}
		
		System.out.println("(log)------------------------------------DAO.deleteJswMember END  >>>>>");
		if (nCnt==0) return false;
		return true;
	}

	@Override
	public ArrayList<JswMemberVO> selectJswMember() {
		// TODO Auto-generated method stub
		System.out.println("(log)------------------------------------DAO.selectJswMember 함수 START>>>>>");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<JswMemberVO> aList = null;
		JswMemberVO jvo = null;
		
		try{
			con = JswConnProperty.getConnection();
			System.out.println("(log)--2>selectJswMember_con연결된 주소값 >>> : " + con);
			pstmt = con.prepareStatement(JswSqlQueryMap.getSelectQuery());
			System.out.println("(log)--3>selectJswMember_JswSqlQueryMap.getSelectQuery()로그 찍어보기>>> :"+ JswSqlQueryMap.getSelectQuery());
			System.out.println("(log)--4>selectJswMember_pstmt쿼리돌았지, pstmt 주소값 >>> : " + pstmt);
			rsRs = pstmt.executeQuery();
			System.out.println("(log)--5>selectJswMember_rsRs실행된 주소값 >>> : " + rsRs);
			
				if(rsRs != null){
					aList = new ArrayList<JswMemberVO>();
					while(rsRs.next()){
						jvo = new JswMemberVO();
						jvo.setJmem(rsRs.getString(1));
						jvo.setJkname(rsRs.getString(2));
						jvo.setJalias(rsRs.getString(3));
						jvo.setJid(rsRs.getString(4));
						jvo.setJpw(rsRs.getString(5));
						jvo.setJgender(rsRs.getString(6));
						jvo.setJhp(rsRs.getString(7));
						jvo.setJbirth(rsRs.getString(8));
						jvo.setJemail(rsRs.getString(9));
						jvo.setJpostno(rsRs.getString(10));
						jvo.setJaddr(rsRs.getString(11));
						jvo.setJdeleteYN(rsRs.getString(12));
						jvo.setJinsertdate(rsRs.getString(13));
						jvo.setJupdatedate(rsRs.getString(14));
						aList.add(jvo);
						
						System.out.println("{log) while돌면서 aList에 add되는 주소값들 >>> : " + aList);
					}//while 끝
					System.out.println("(log) 배열리스트 aList 묶음의 개수 >>>"+aList.size());									
				}else{
					System.out.println("데이터가 없는 이유를~~ ?");
				}//if-else 끝
				JswConnProperty.conClose(con, pstmt, rsRs);		
			}catch(Exception e){
				System.out.println("(log)DAO.selectJswMember 에러가 >>> : " + e.getMessage());
			}finally{
				JswConnProperty.conClose(con, pstmt, rsRs);
			}
		System.out.println("(log)------------------------------------DAO.selectJswMember 함수 END >>>>>");
		return aList;
	}

	@Override
	public ArrayList<JswMemberVO> searchJswMember(JswMemberVO _jvo) {
		// TODO Auto-generated method stub
		System.out.println("(log)------------------------------------DAO.searchJswMember 함수 START>>>>>");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<JswMemberVO> aList = null;
		JswMemberVO jvo = null;
		
		//로직
		try{
			con = JswConnProperty.getConnection();
			System.out.println("(log)--2>searchJswMember_con연결된 주소값 >>> : " + con);
			pstmt = con.prepareStatement(JswSqlQueryMap.getSearchQuery());
			System.out.println("(log)--3>searchJswMember_JswSqlQueryMap.getSelectQuery()로그 찍어보기>>> :"+ JswSqlQueryMap.getSearchQuery());
			System.out.println("(log)--4>searchJswMember_pstmt쿼리돌았지, pstmt 주소값 >>> : " + pstmt);
			
			System.out.println("플레이스홀더에 바인딩할 매개변수깡통 데이터 >>>> :" +_jvo.getJmem());
			pstmt.setString(1, _jvo.getJmem());
			
			
			rsRs = pstmt.executeQuery();
			System.out.println("(log)--5>searchJswMember_rsRs실행된 주소값 >>> : " + rsRs);
			
			if(rsRs != null){
				aList = new ArrayList<JswMemberVO>();
				while(rsRs.next()){
					jvo = new JswMemberVO();
					jvo.setJmem(rsRs.getString(1));
					jvo.setJkname(rsRs.getString(2));
					jvo.setJalias(rsRs.getString(3));
					jvo.setJid(rsRs.getString(4));
					jvo.setJpw(rsRs.getString(5));
					jvo.setJgender(rsRs.getString(6));
					jvo.setJhp(rsRs.getString(7));
					jvo.setJbirth(rsRs.getString(8));
					jvo.setJemail(rsRs.getString(9));
					jvo.setJpostno(rsRs.getString(10));
					jvo.setJaddr(rsRs.getString(11));
					jvo.setJdeleteYN(rsRs.getString(12));
					jvo.setJinsertdate(rsRs.getString(13));
					jvo.setJupdatedate(rsRs.getString(14));
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
		System.out.println("(log)------------------------------------DAO.searchJswMember 함수 END>>>>>");
		return aList;
	}

	@Override
	public ArrayList<JswMemberVO> likeSearchJswMember(JswMemberVO _jvo) {
		// TODO Auto-generated method stub
		
		System.out.println("(log)------------------------------------DAO.likesearchJswMember 함수 START>>>>>");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<JswMemberVO> aList = null;
		JswMemberVO jvo = null;
		
		//로직
		try{
			con = JswConnProperty.getConnection();
			System.out.println("(log)--2>likesearchJswMember_con연결된 주소값 >>> : " + con);
			pstmt = con.prepareStatement(JswSqlQueryMap.getLikeSearchQuery());
			System.out.println("(log)--3>likesearchJswMember_JswSqlQueryMap.getSelectQuery()로그 찍어보기>>> :"+ JswSqlQueryMap.getLikeSearchQuery());
			System.out.println("(log)--4>likesearchJswMember_pstmt쿼리돌았지, pstmt 주소값 >>> : " + pstmt);
			
			System.out.println("플레이스홀더에 바인딩할 매개변수깡통 데이터 >>>> :" +_jvo.getJaddr());
			pstmt.setString(1, _jvo.getJaddr());
			
			
			rsRs = pstmt.executeQuery();
			System.out.println("(log)--5>likesearchJswMember_rsRs실행된 주소값 >>> : " + rsRs);
			
			if(rsRs != null){
				aList = new ArrayList<JswMemberVO>();
				while(rsRs.next()){
					jvo = new JswMemberVO();
					jvo.setJmem(rsRs.getString(1));
					jvo.setJkname(rsRs.getString(2));
					jvo.setJalias(rsRs.getString(3));
					jvo.setJid(rsRs.getString(4));
					jvo.setJpw(rsRs.getString(5));
					jvo.setJgender(rsRs.getString(6));
					jvo.setJhp(rsRs.getString(7));
					jvo.setJbirth(rsRs.getString(8));
					jvo.setJemail(rsRs.getString(9));
					jvo.setJpostno(rsRs.getString(10));
					jvo.setJaddr(rsRs.getString(11));
					jvo.setJdeleteYN(rsRs.getString(12));
					jvo.setJinsertdate(rsRs.getString(13));
					jvo.setJupdatedate(rsRs.getString(14));
					aList.add(jvo);
					
					System.out.println("{log) while돌면서 aList에 add되는 주소값들 >>> : " + aList);
				}//while 끝
				System.out.println("(log) 배열리스트 aList 묶음의 개수 >>>"+aList.size());									
			}else{
				System.out.println("(log)데이터가 없는 이유를~~ ?");
			}//if-else 끝
			JswConnProperty.conClose(con, pstmt, rsRs);
			
			
		}catch(Exception e){
			System.out.println("(log)DAOImpl 에러남 >>> : " + e.getMessage());
		}finally{
			JswConnProperty.conClose(con, pstmt, rsRs);	
		}
		System.out.println("(log)------------------------------------DAO.likesearchJswMember 함수 END>>>>>");
		return aList;
	}
	
	@Override
	public ArrayList<JswMemberVO> loginJswMember(JswMemberVO _jvo) {
		// TODO Auto-generated method stub
		System.out.println("(log)------------------------------------DAO.loginJswMember 함수 START>>>>>");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<JswMemberVO> aList = null;
		JswMemberVO jvo = null;
		
		try{
			con = JswConnProperty.getConnection();
			System.out.println("(log)--2>loginJswMember_con연결된 주소값 >>> : " + con);
			pstmt = con.prepareStatement(JswSqlQueryMap.getLoginQuery());
			System.out.println("(log)--3>loginJswMember_JswSqlQueryMap.getLoginQuery()로그 찍어보기>>> :"+ JswSqlQueryMap.getLoginQuery());
			System.out.println("(log)--4>loginJswMember_pstmt쿼리돌았지, pstmt 주소값 >>> : " + pstmt);
			
			System.out.println("플레이스홀더에 바인딩할 매개변수깡통 데이터 >>>> :" +_jvo.getJid() +" & "+ _jvo.getJpw());
			pstmt.setString(1, _jvo.getJid());
			pstmt.setString(2, _jvo.getJpw());
			
			rsRs = pstmt.executeQuery();
			System.out.println("(log)--5>loginJswMember_rsRs실행된 주소값 >>> : " + rsRs);
			
				if(rsRs != null){
					aList = new ArrayList<JswMemberVO>();
					while(rsRs.next()){
						jvo = new JswMemberVO();
						jvo.setJid(rsRs.getString(1));
						jvo.setJpw(rsRs.getString(2));
						aList.add(jvo);
						System.out.println("{log) while돌면서 aList에 add되는 주소값들 >>> : " + aList);
					}//while 끝
					System.out.println("(log) 배열리스트 aList 묶음의 개수 >>>"+aList.size());									
				}else{
					System.out.println("데이터가 없는 이유를~~ ?");
				}//if-else 끝
				JswConnProperty.conClose(con, pstmt, rsRs);		
			}catch(Exception e){
				System.out.println("(log)DAO.loginJswMember 에러가 >>> : " + e.getMessage());
			}finally{
				JswConnProperty.conClose(con, pstmt, rsRs);
			}
		System.out.println("(log)------------------------------------DAO.loginJswMember 함수 END >>>>>");
		return aList;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


}
