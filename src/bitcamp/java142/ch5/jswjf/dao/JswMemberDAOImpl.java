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
			System.out.println("(log)--2>insertJswMember_con����� �ּҰ� >>> : " + con);
			con.setAutoCommit(false);//-------?
			System.out.println("(log)----2.5>con.getAutoCommit()false������ �� >>> : " + con.getAutoCommit());
			
			
			
			pstmt = con.prepareStatement(JswSqlQueryMap.getInsertQuery());
			System.out.println("(log)--3>insertJswMember_JswSqlQueryMap.getInsertQuery()�α�>>> :"+ JswSqlQueryMap.getInsertQuery());
			System.out.println("(log)--4>insertJswMember_pstmt����������, pstmt �ּҰ� >>> : " + pstmt);
			
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
			nCnt = pstmt.executeUpdate();//select��ȸ�� ������ ResultSet=>rsRs=pstmt.executeQuery();
			
			
			
			boolean b = !con.getAutoCommit();
			System.out.println("(log)b_AutoCommit true������ ��>>> : " + b);
			if(!con.getAutoCommit()) con.commit(); // db commit!!!! �о�ֱ�)
			System.out.println("(log)--5>insertJswMember_nCnt�� ���°� �� ��? >>>> " + nCnt);
	
			JswConnProperty.conClose(con, pstmt);
			
		}catch(Exception e){
			System.out.println("(log) DAOImpl �������� >>> : " + e.getMessage());
		}finally{
			JswConnProperty.conClose(con, pstmt);
		}//try-catch-finally ��
		System.out.println("(log)------------------------------------DAO.insertJswMember END  >>>>>");
		if (nCnt==0) return false;
		return true;
		
	}//insertJswMember��

	@Override
	public boolean updateJswMember(JswMemberVO _jvo) {
		// TODO Auto-generated method stub
		System.out.println("(log)------------------------------------DAO.updateJswMember START  >>>>>");
		Connection con = null;
		PreparedStatement pstmt = null;
		int nCnt=0;	
		
		//����
		try{
			con = JswConnProperty.getConnection();
			System.out.println("(log)--2>updateJswMember_con����� �ּҰ� >>> : " + con);
			con.setAutoCommit(false);//-------�ܰſ��� ����Ʈ�� ����?????????????????????????
			System.out.println("(log)----2.5>con.getAutoCommit() false������ �� >>> : " + con.getAutoCommit());
			
			
			
			pstmt = con.prepareStatement(JswSqlQueryMap.getUpdateQuery());
			System.out.println("(log)--3>updateJswMember_JswSqlQueryMap.getUpdateQuery()�α�>>> :"+ JswSqlQueryMap.getUpdateQuery());
			System.out.println("(log)--4>updateJswMember_pstmt����������, pstmt �ּҰ� >>> : " + pstmt);
			
			System.out.println("�÷��̽�Ȧ���� ���ε��� �Ű��������� ������ >>>> : " +_jvo.getJmem() +", " +_jvo.getJkname());
			pstmt.setString(1, _jvo.getJkname());
			pstmt.setString(2, _jvo.getJmem());
			nCnt = pstmt.executeUpdate();//select��ȸ�� ������ ResultSet=>rsRs=pstmt.executeQuery();
			
			
			boolean b = !con.getAutoCommit();
			System.out.println("(log)b_AutoCommit true������ �� >>> : " + b);
			if(!con.getAutoCommit()) con.commit(); // db commit!!!! �о�ֱ�)
			System.out.println("(log)--5>updateJswMember_nCnt�� ���°� �� ��? >>>> " + nCnt);
	
			JswConnProperty.conClose(con, pstmt);
		}catch(Exception e){
			System.out.println("(log) DAOImpl �������� >>> : " + e.getMessage());
		}finally{
			JswConnProperty.conClose(con, pstmt);
		}
		
		System.out.println("(log)------------------------------------DAO.updateJswMember END  >>>>>");
		if (nCnt==0) return false;
		return true;
	}//updateJswMember��

	@Override
	public boolean deleteJswMember(JswMemberVO _jvo) {
		// TODO Auto-generated method stub
		System.out.println("(log)------------------------------------DAO.deleteJswMember START  >>>>>");
		Connection con = null;
		PreparedStatement pstmt = null;
		int nCnt=0;	
		
		//����
		try{
			con = JswConnProperty.getConnection();
			System.out.println("(log)--2>deleteJswMember_con����� �ּҰ� >>> : " + con);
			con.setAutoCommit(false);//-------�ܰſ��� ����Ʈ�� ����?????????????????????????
			System.out.println("(log)----2.5>con.getAutoCommit() false������ �� >>> : " + con.getAutoCommit());
			
			
			
			pstmt = con.prepareStatement(JswSqlQueryMap.getDeleteQuery());
			System.out.println("(log)--3>deleteJswMember_JswSqlQueryMap.getDeleteQuery()�α�>>> :"+ JswSqlQueryMap.getDeleteQuery());
			System.out.println("(log)--4>deleteJswMember_pstmt����������, pstmt �ּҰ� >>> : " + pstmt);
			
			System.out.println("�÷��̽�Ȧ���� ���ε��� �Ű��������� ������ >>>> :" +_jvo.getJmem());
			pstmt.setString(1, _jvo.getJmem());
			nCnt = pstmt.executeUpdate();//select��ȸ�� ������ ResultSet=>rsRs=pstmt.executeQuery();
			
			
			boolean b = !con.getAutoCommit();
			System.out.println("(log)b_AutoCommit true������ �� >>> : " + b);
			if(!con.getAutoCommit()) con.commit(); // db commit!!!! �о�ֱ�)
			System.out.println("(log)--5>insertJswMember_nCnt�� ���°� �� ��? >>>> " + nCnt);
	
			JswConnProperty.conClose(con, pstmt);
		}catch(Exception e){
			System.out.println("(log) DAOImpl �������� >>> : " + e.getMessage());
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
		System.out.println("(log)------------------------------------DAO.selectJswMember �Լ� START>>>>>");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<JswMemberVO> aList = null;
		JswMemberVO jvo = null;
		
		try{
			con = JswConnProperty.getConnection();
			System.out.println("(log)--2>selectJswMember_con����� �ּҰ� >>> : " + con);
			pstmt = con.prepareStatement(JswSqlQueryMap.getSelectQuery());
			System.out.println("(log)--3>selectJswMember_JswSqlQueryMap.getSelectQuery()�α� ����>>> :"+ JswSqlQueryMap.getSelectQuery());
			System.out.println("(log)--4>selectJswMember_pstmt����������, pstmt �ּҰ� >>> : " + pstmt);
			rsRs = pstmt.executeQuery();
			System.out.println("(log)--5>selectJswMember_rsRs����� �ּҰ� >>> : " + rsRs);
			
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
						
						System.out.println("{log) while���鼭 aList�� add�Ǵ� �ּҰ��� >>> : " + aList);
					}//while ��
					System.out.println("(log) �迭����Ʈ aList ������ ���� >>>"+aList.size());									
				}else{
					System.out.println("�����Ͱ� ���� ������~~ ?");
				}//if-else ��
				JswConnProperty.conClose(con, pstmt, rsRs);		
			}catch(Exception e){
				System.out.println("(log)DAO.selectJswMember ������ >>> : " + e.getMessage());
			}finally{
				JswConnProperty.conClose(con, pstmt, rsRs);
			}
		System.out.println("(log)------------------------------------DAO.selectJswMember �Լ� END >>>>>");
		return aList;
	}

	@Override
	public ArrayList<JswMemberVO> searchJswMember(JswMemberVO _jvo) {
		// TODO Auto-generated method stub
		System.out.println("(log)------------------------------------DAO.searchJswMember �Լ� START>>>>>");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<JswMemberVO> aList = null;
		JswMemberVO jvo = null;
		
		//����
		try{
			con = JswConnProperty.getConnection();
			System.out.println("(log)--2>searchJswMember_con����� �ּҰ� >>> : " + con);
			pstmt = con.prepareStatement(JswSqlQueryMap.getSearchQuery());
			System.out.println("(log)--3>searchJswMember_JswSqlQueryMap.getSelectQuery()�α� ����>>> :"+ JswSqlQueryMap.getSearchQuery());
			System.out.println("(log)--4>searchJswMember_pstmt����������, pstmt �ּҰ� >>> : " + pstmt);
			
			System.out.println("�÷��̽�Ȧ���� ���ε��� �Ű��������� ������ >>>> :" +_jvo.getJmem());
			pstmt.setString(1, _jvo.getJmem());
			
			
			rsRs = pstmt.executeQuery();
			System.out.println("(log)--5>searchJswMember_rsRs����� �ּҰ� >>> : " + rsRs);
			
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
		System.out.println("(log)------------------------------------DAO.searchJswMember �Լ� END>>>>>");
		return aList;
	}

	@Override
	public ArrayList<JswMemberVO> likeSearchJswMember(JswMemberVO _jvo) {
		// TODO Auto-generated method stub
		
		System.out.println("(log)------------------------------------DAO.likesearchJswMember �Լ� START>>>>>");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<JswMemberVO> aList = null;
		JswMemberVO jvo = null;
		
		//����
		try{
			con = JswConnProperty.getConnection();
			System.out.println("(log)--2>likesearchJswMember_con����� �ּҰ� >>> : " + con);
			pstmt = con.prepareStatement(JswSqlQueryMap.getLikeSearchQuery());
			System.out.println("(log)--3>likesearchJswMember_JswSqlQueryMap.getSelectQuery()�α� ����>>> :"+ JswSqlQueryMap.getLikeSearchQuery());
			System.out.println("(log)--4>likesearchJswMember_pstmt����������, pstmt �ּҰ� >>> : " + pstmt);
			
			System.out.println("�÷��̽�Ȧ���� ���ε��� �Ű��������� ������ >>>> :" +_jvo.getJaddr());
			pstmt.setString(1, _jvo.getJaddr());
			
			
			rsRs = pstmt.executeQuery();
			System.out.println("(log)--5>likesearchJswMember_rsRs����� �ּҰ� >>> : " + rsRs);
			
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
					
					System.out.println("{log) while���鼭 aList�� add�Ǵ� �ּҰ��� >>> : " + aList);
				}//while ��
				System.out.println("(log) �迭����Ʈ aList ������ ���� >>>"+aList.size());									
			}else{
				System.out.println("(log)�����Ͱ� ���� ������~~ ?");
			}//if-else ��
			JswConnProperty.conClose(con, pstmt, rsRs);
			
			
		}catch(Exception e){
			System.out.println("(log)DAOImpl ������ >>> : " + e.getMessage());
		}finally{
			JswConnProperty.conClose(con, pstmt, rsRs);	
		}
		System.out.println("(log)------------------------------------DAO.likesearchJswMember �Լ� END>>>>>");
		return aList;
	}
	
	@Override
	public ArrayList<JswMemberVO> loginJswMember(JswMemberVO _jvo) {
		// TODO Auto-generated method stub
		System.out.println("(log)------------------------------------DAO.loginJswMember �Լ� START>>>>>");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<JswMemberVO> aList = null;
		JswMemberVO jvo = null;
		
		try{
			con = JswConnProperty.getConnection();
			System.out.println("(log)--2>loginJswMember_con����� �ּҰ� >>> : " + con);
			pstmt = con.prepareStatement(JswSqlQueryMap.getLoginQuery());
			System.out.println("(log)--3>loginJswMember_JswSqlQueryMap.getLoginQuery()�α� ����>>> :"+ JswSqlQueryMap.getLoginQuery());
			System.out.println("(log)--4>loginJswMember_pstmt����������, pstmt �ּҰ� >>> : " + pstmt);
			
			System.out.println("�÷��̽�Ȧ���� ���ε��� �Ű��������� ������ >>>> :" +_jvo.getJid() +" & "+ _jvo.getJpw());
			pstmt.setString(1, _jvo.getJid());
			pstmt.setString(2, _jvo.getJpw());
			
			rsRs = pstmt.executeQuery();
			System.out.println("(log)--5>loginJswMember_rsRs����� �ּҰ� >>> : " + rsRs);
			
				if(rsRs != null){
					aList = new ArrayList<JswMemberVO>();
					while(rsRs.next()){
						jvo = new JswMemberVO();
						jvo.setJid(rsRs.getString(1));
						jvo.setJpw(rsRs.getString(2));
						aList.add(jvo);
						System.out.println("{log) while���鼭 aList�� add�Ǵ� �ּҰ��� >>> : " + aList);
					}//while ��
					System.out.println("(log) �迭����Ʈ aList ������ ���� >>>"+aList.size());									
				}else{
					System.out.println("�����Ͱ� ���� ������~~ ?");
				}//if-else ��
				JswConnProperty.conClose(con, pstmt, rsRs);		
			}catch(Exception e){
				System.out.println("(log)DAO.loginJswMember ������ >>> : " + e.getMessage());
			}finally{
				JswConnProperty.conClose(con, pstmt, rsRs);
			}
		System.out.println("(log)------------------------------------DAO.loginJswMember �Լ� END >>>>>");
		return aList;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


}
