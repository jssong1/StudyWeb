package bitcamp.java142.ch5.jswjf;

import java.util.ArrayList;

import bitcamp.java142.ch5.jswjf.dao.JswMemberDAO;
import bitcamp.java142.ch5.jswjf.dao.JswMemberDAOImpl;
import bitcamp.java142.ch5.jswjf.vo.JswMemberVO;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("(log)--- 메인 함수 START>>>>>");
		
		 
		String id = "SSONGS5"; 
		String pw = "song5555"; 
		System.out.println("id >>> : " + id); 
		System.out.println("pw >>> : " + pw);

		JswMemberDAO jdao = new JswMemberDAOImpl();
		JswMemberVO jvo = null;
		jvo = new JswMemberVO();
		jvo.setJid(id);
		jvo.setJpw(pw);
		
		ArrayList<JswMemberVO> aList = jdao.loginJswMember(jvo);
		System.out.println("aList.size >>> : " + aList.size());
		
		int aListSize = aList.size();
		if(aListSize == 1){
			System.out.println("로그인 성공성공");
			for(int i =0; i<aListSize;i++){ //aList.size()); 배열리스트묶음의 개수(길이) //aList의 size함수로 길이구하기 (static없음; 리턴값int;매개변수()없음) 
				JswMemberVO jvo1 = (JswMemberVO)aList.get(i); //ArrayList클래스의 get함수를 이용하여 첨자(i)번째의 데이터를 출력하기// 첨자가 0부터 배열의 길이값까지 1씩증가하며 반복수행
				System.out.print(""+i+"번째 for >>> : " + jvo1.getJid());
				System.out.println(" " + jvo1.getJpw());				
			}//for문 끝	
		}else{
			System.out.println("로그인 실패실패");			
		}//if-else 끝
		
		
		System.out.println("(log)--- 메인 함수 END>>>>>");
	}//메인함수 끝

}//클래스 끝
