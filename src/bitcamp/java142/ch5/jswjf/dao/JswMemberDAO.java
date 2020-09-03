package bitcamp.java142.ch5.jswjf.dao;

import java.util.ArrayList;

import bitcamp.java142.ch5.jswjf.vo.JswMemberVO;

public interface JswMemberDAO {
	public boolean insertJswMember(JswMemberVO jvo);
	public boolean updateJswMember(JswMemberVO jvo);
	public boolean deleteJswMember(JswMemberVO jvo);
	
	public ArrayList<JswMemberVO> selectJswMember();
	public ArrayList<JswMemberVO> searchJswMember(JswMemberVO jvo);
	public ArrayList<JswMemberVO> likeSearchJswMember(JswMemberVO jvo);
	
	
	//·Î±×ÀÎ
	public ArrayList<JswMemberVO> loginJswMember(JswMemberVO jvo);
}
