package bitcamp.java142.ch5.jswjf;

import java.util.ArrayList;


import bitcamp.java142.ch5.jswjf.dao.JswMemberDAO;
import bitcamp.java142.ch5.jswjf.dao.JswMemberDAOImpl;
import bitcamp.java142.ch5.jswjf.vo.JswMemberVO;

public class JswMemberScr {

	//insert 함수
	public boolean insertJswMember(String 	jkname, 
								   String 	jalias, 
								   String 	jid, 
								   String 	jpw, 
								   String 	jgender, 
								   String 	jhp, 
								   String 	jbirth, 
								   String 	jemail, 
								   String 	jpostno, 
								   String 	jaddr){
		
		System.out.println("(log)--I>>jswMemberScr.insertJswMember 함수 START>>>>>");
		
		JswMemberDAO jdao = new JswMemberDAOImpl();
		
		JswMemberVO jvo = null;
		jvo = new JswMemberVO();

		jvo.setJkname(jkname);
		jvo.setJalias(jalias) ;
		jvo.setJid(jid) ;
		jvo.setJpw(jpw) ;
		jvo.setJgender(jgender);
		jvo.setJhp(jhp);
		jvo.setJbirth(jbirth) ;
		jvo.setJemail(jemail);
		jvo.setJpostno(jpostno);
		jvo.setJaddr(jaddr) ;

		System.out.println("(log)메인에서 받은 매개변수 >>>> : " + jvo.getJkname() +" ," +jvo.getJalias()+" ," +jvo.getJid()+" ," +jvo.getJpw()+" ," +jvo.getJgender()
		+" ," +jvo.getJhp()+" ," +jvo.getJbirth()+" ," +jvo.getJemail()+" ," +jvo.getJpostno()+" ," +jvo.getJaddr());
		boolean bFlag = jdao.insertJswMember(jvo);
		System.out.println("(log) JswMemberDAOImpl.insertJswMember()에서 리턴된 값 보기 (인서트성공 true)>>>>>" +bFlag);
		
		System.out.println("(log)--I>>jswMemberScr.insertJswMember 함수 END>>>>>");
		return bFlag;
	}
	//update 함수
	public boolean updateJswMember(String jkname, String jmem){
		JswMemberDAO jdao = new JswMemberDAOImpl();
		
		JswMemberVO jvo = null;
		jvo = new JswMemberVO();
		jvo.setJkname(jkname); 
		jvo.setJmem(jmem);
		System.out.println("(log)메인에서 받은 매개변수 >>>> : " + jvo.getJkname() +" ," +jvo.getJmem());
		boolean bFlag = jdao.updateJswMember(jvo);
		return bFlag;
	}
	
	//delete 함수
	public boolean deleteJswMember(String jmem){
		
		JswMemberDAO jdao = new JswMemberDAOImpl();
		
		JswMemberVO jvo = null;
		jvo = new JswMemberVO();
		jvo.setJmem(jmem);
		System.out.println("(log)메인에서 받은 매개변수 >>>> : " + jvo.getJmem());
		
		boolean bFlag = jdao.deleteJswMember(jvo);
		return bFlag;
	}
	
	//select 전체조회 함수
	public ArrayList<JswMemberVO> selectJswMember(){
		System.out.println("(log)--SALL>>jswMemberScr.selectJswMember 함수 START>>>>>");
		
		JswMemberDAO jdao = new JswMemberDAOImpl();
		ArrayList<JswMemberVO> aList = jdao.selectJswMember();
		
		System.out.println("(log) JswMemberDAOImpl.selectEci에서 리턴된 값 보기>>>>>" +aList);
		System.out.println("(log)--SALL>>jswMemberScr.selectJswMember 함수 END>>>>>");
		return aList;
	}
	
	
	//search 키워드함수 
	public ArrayList<JswMemberVO> searchJswMember(String jmem){
		System.out.println("(log)--SSEA>>jswMemberScr.searchJswMember 함수 START>>>>>");

		JswMemberDAO jdao = new JswMemberDAOImpl();
		
		JswMemberVO jvo = null;
		jvo = new JswMemberVO();
		jvo.setJmem(jmem);
		System.out.println("(log)메인에서 받은 매개변수 >>>> : " + jvo.getJmem());
		ArrayList<JswMemberVO> aList = jdao.searchJswMember(jvo);
		
		System.out.println("(log)--SSEA>>jswMemberScr.searchJswMember 함수 END >>>>>");
		return aList;
	}
	
	public ArrayList<JswMemberVO> likeSearchJswMember(String jaddr){
		System.out.println("(log)--SLIK>>jswMemberScr.likeSearchJswMember 함수 START>>>>>");
		JswMemberDAO jdao = new JswMemberDAOImpl();
		
		JswMemberVO jvo = null;
		jvo = new JswMemberVO();
		jvo.setJaddr(jaddr);
		System.out.println("(log)메인에서 받은 매개변수 >>>> : " + jvo.getJaddr());
		ArrayList<JswMemberVO> aList = jdao.likeSearchJswMember(jvo);
		System.out.println("(log)--SLIK>>jswMemberScr.likeSearchJswMember 함수 END>>>>>");
		return aList;
	}
	
public static void displayFun(ArrayList<JswMemberVO> aList){
		
		int aListSize = aList.size();
		
		
		for(int i =0; i<aListSize;i++){ //aList.size()); 배열리스트묶음의 개수(길이) //aList의 size함수로 길이구하기 (static없음; 리턴값int;매개변수()없음) 
			JswMemberVO jvo = (JswMemberVO)aList.get(i); //ArrayList클래스의 get함수를 이용하여 첨자(i)번째의 데이터를 출력하기// 첨자가 0부터 배열의 길이값까지 1씩증가하며 반복수행
			System.out.print(""+i+"번째 for >>> : " + jvo.getJmem());	
			System.out.print(" " + jvo.getJkname());
			System.out.print(" " + jvo.getJalias());
			System.out.print(" " + jvo.getJid());
			System.out.print(" " + jvo.getJpw());
			System.out.print(" " + jvo.getJgender());
			System.out.print(" " + jvo.getJhp());
			System.out.print(" " + jvo.getJbirth());
			System.out.print(" " + jvo.getJemail());
			System.out.print(" " + jvo.getJpostno());
			System.out.print(" " + jvo.getJaddr());
			System.out.print(" " + jvo.getJdeleteYN());
			System.out.print(" " + jvo.getJinsertdate());
			System.out.println(" " + jvo.getJupdatedate());
			
		}//for문 끝	
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
//		System.out.println("실행명령어를 사용하시오 >>> (ex.S): "); 
//		Scanner sc = new Scanner(System.in); //Scanner를 이용하여 콘솔에서 데이터를 받아온다 
//		String genNo = sc.nextLine();//String타입의 변수를 선언하여 nextLine()함수를 이용 문자열 전체 입력 받기 (입력값에 공백을 받는다)

		String sFlag = "SALL";
		
		
		//INSERT
		if("I".equals(sFlag)){
			System.out.println("(log)---INSERT 메인 함수 START>>>>>");
			
			 String jkname = "정송육";        
			 String jalias = "SSONG6";
			 String jid = "SSONGS6";
			 String jpw = "song6666"; 
			 String jgender = "F";
			 String jhp = "01066665530";
			 String jbirth = "66660918";
			 String jemail = "ssong6@song.com";
			 String jpostno = "66666";
			 String jaddr = "대전광역시 서구 둔산동 66길 66";
			 
			JswMemberScr es = new JswMemberScr();
			boolean bFlag = es.insertJswMember(jkname, jalias, jid, jpw, jgender, jhp, jbirth, jemail, jpostno, jaddr);
			
			if (bFlag){
				System.out.println("(log) 데이터 INSERT 완료 >>> : ");
				
				JswMemberScr jms = new JswMemberScr();
				ArrayList<JswMemberVO> aList = jms.selectJswMember();
				int aListSize = aList.size();
				if(aListSize > 0){
					JswMemberScr.displayFun(aList); 
				}
				
			}else{
				System.out.println("(log) 데이터 INSERT 실패 >>> : ");				
			}// 출력if-else 끝
			System.out.println("(log)---INSERT 메인 함수 END>>>>>");
		}//if(I)끝
		
		//update
		if("U".equals(sFlag)){
			System.out.println("(log)---UPDATE 메인 함수 START>>>>>");
			String jkname = "정송튜";
			String jmem = "M201912050002";
					
			JswMemberScr es = new JswMemberScr();
			boolean bFlag = es.updateJswMember(jkname, jmem);
			
			if (bFlag){
				System.out.println("(log)데이터 UPDATE 완료 >>> : ");
				
				JswMemberScr jms = new JswMemberScr();//입력잘되었으니까 전체조회를 위해 다시 인스턴스고고해서 출력
				ArrayList<JswMemberVO> aList = jms.selectJswMember();
				int aListSize = aList.size();
				if(aListSize > 0){
					JswMemberScr.displayFun(aList);
				}
				
			}else{
				System.out.println("(log)데이터 UPDATE 실패 >>> : ");				
			}// 출력if-else 끝
			
			System.out.println("(log)---UPDATE 메인 함수 END >>>>>");
		}//if(U)끝
		
		//delete	
		if("D".equals(sFlag)){
			System.out.println("(log)---DELETE 메인 함수 START>>>>>");
			String jmem = "M201912060009";
			 
			JswMemberScr es = new JswMemberScr();
			boolean bFlag = es.deleteJswMember(jmem);
			
			if (bFlag){
				System.out.println("(log)데이터 DELETE 완료 >>> : ");
				
				JswMemberScr jms = new JswMemberScr();//입력잘되었으니까 전체조회를 위해 다시 인스턴스고고해서 출력
				ArrayList<JswMemberVO> aList = jms.selectJswMember();
				int aListSize = aList.size();
				if(aListSize > 0){
					JswMemberScr.displayFun(aList);
				}
				
			}else{
				System.out.println("(log)데이터 DELETE 실패 >>> : ");				
			}// 출력if-else 끝
			System.out.println("(log)---DELETE 메인 함수 END >>>>>");
			
		}//if(D) 끝
		
		
		//전체조회메인
		if ("SALL".equals(sFlag)){
			System.out.println("(log)---전체조회 SELECT ALL 메인 함수 START>>>>>");
			JswMemberScr es = new JswMemberScr();
			ArrayList<JswMemberVO> aList = es.selectJswMember();
			
			int aListSize = aList.size();
			if (aListSize > 0){
				JswMemberScr.displayFun(aList);				
			
			}//작은 if끝
		System.out.println("(log)---전체조회 SELECT ALL 메인 함수 END>>>>>");	
		}//if(SALL) 끝
		
		//키워드 검색 메인
		if ("SSEA".equals(sFlag)){
			System.out.println("(log)---키워드 검색 SEARCH 메인 함수 START>>>>>");
			String jmem = "M201912050003";
			JswMemberScr es = new JswMemberScr();
			ArrayList<JswMemberVO> aList = es.searchJswMember(jmem);
			
			int aListSize = aList.size();
			if (aListSize > 0){
				JswMemberScr.displayFun(aList);				
			
			}//작은 if끝
		System.out.println("(log)---키워드 검색 SEARCH 메인 함수END>>>>>");
		}//if(SSEA) 끝		
		
		//Like 검색 메인
		if ("SLIK".equals(sFlag)){
			System.out.println("(log)---LIKE 검색 메인 함수 START>>>>>");
			String jaddr = "김천시"; 
			JswMemberScr es = new JswMemberScr();
			ArrayList<JswMemberVO> aList = es.likeSearchJswMember(jaddr);
			
			int aListSize = aList.size();
			if (aListSize > 0){
				JswMemberScr.displayFun(aList);						
			}//작은 if끝
		System.out.println("(log)---LIKE 검색 메인 함수END>>>>>");
		}//if(SSEA) 끝	
	}//메인끝

}//클래스끝
