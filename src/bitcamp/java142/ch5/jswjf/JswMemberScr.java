package bitcamp.java142.ch5.jswjf;

import java.util.ArrayList;


import bitcamp.java142.ch5.jswjf.dao.JswMemberDAO;
import bitcamp.java142.ch5.jswjf.dao.JswMemberDAOImpl;
import bitcamp.java142.ch5.jswjf.vo.JswMemberVO;

public class JswMemberScr {

	//insert �Լ�
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
		
		System.out.println("(log)--I>>jswMemberScr.insertJswMember �Լ� START>>>>>");
		
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

		System.out.println("(log)���ο��� ���� �Ű����� >>>> : " + jvo.getJkname() +" ," +jvo.getJalias()+" ," +jvo.getJid()+" ," +jvo.getJpw()+" ," +jvo.getJgender()
		+" ," +jvo.getJhp()+" ," +jvo.getJbirth()+" ," +jvo.getJemail()+" ," +jvo.getJpostno()+" ," +jvo.getJaddr());
		boolean bFlag = jdao.insertJswMember(jvo);
		System.out.println("(log) JswMemberDAOImpl.insertJswMember()���� ���ϵ� �� ���� (�μ�Ʈ���� true)>>>>>" +bFlag);
		
		System.out.println("(log)--I>>jswMemberScr.insertJswMember �Լ� END>>>>>");
		return bFlag;
	}
	//update �Լ�
	public boolean updateJswMember(String jkname, String jmem){
		JswMemberDAO jdao = new JswMemberDAOImpl();
		
		JswMemberVO jvo = null;
		jvo = new JswMemberVO();
		jvo.setJkname(jkname); 
		jvo.setJmem(jmem);
		System.out.println("(log)���ο��� ���� �Ű����� >>>> : " + jvo.getJkname() +" ," +jvo.getJmem());
		boolean bFlag = jdao.updateJswMember(jvo);
		return bFlag;
	}
	
	//delete �Լ�
	public boolean deleteJswMember(String jmem){
		
		JswMemberDAO jdao = new JswMemberDAOImpl();
		
		JswMemberVO jvo = null;
		jvo = new JswMemberVO();
		jvo.setJmem(jmem);
		System.out.println("(log)���ο��� ���� �Ű����� >>>> : " + jvo.getJmem());
		
		boolean bFlag = jdao.deleteJswMember(jvo);
		return bFlag;
	}
	
	//select ��ü��ȸ �Լ�
	public ArrayList<JswMemberVO> selectJswMember(){
		System.out.println("(log)--SALL>>jswMemberScr.selectJswMember �Լ� START>>>>>");
		
		JswMemberDAO jdao = new JswMemberDAOImpl();
		ArrayList<JswMemberVO> aList = jdao.selectJswMember();
		
		System.out.println("(log) JswMemberDAOImpl.selectEci���� ���ϵ� �� ����>>>>>" +aList);
		System.out.println("(log)--SALL>>jswMemberScr.selectJswMember �Լ� END>>>>>");
		return aList;
	}
	
	
	//search Ű�����Լ� 
	public ArrayList<JswMemberVO> searchJswMember(String jmem){
		System.out.println("(log)--SSEA>>jswMemberScr.searchJswMember �Լ� START>>>>>");

		JswMemberDAO jdao = new JswMemberDAOImpl();
		
		JswMemberVO jvo = null;
		jvo = new JswMemberVO();
		jvo.setJmem(jmem);
		System.out.println("(log)���ο��� ���� �Ű����� >>>> : " + jvo.getJmem());
		ArrayList<JswMemberVO> aList = jdao.searchJswMember(jvo);
		
		System.out.println("(log)--SSEA>>jswMemberScr.searchJswMember �Լ� END >>>>>");
		return aList;
	}
	
	public ArrayList<JswMemberVO> likeSearchJswMember(String jaddr){
		System.out.println("(log)--SLIK>>jswMemberScr.likeSearchJswMember �Լ� START>>>>>");
		JswMemberDAO jdao = new JswMemberDAOImpl();
		
		JswMemberVO jvo = null;
		jvo = new JswMemberVO();
		jvo.setJaddr(jaddr);
		System.out.println("(log)���ο��� ���� �Ű����� >>>> : " + jvo.getJaddr());
		ArrayList<JswMemberVO> aList = jdao.likeSearchJswMember(jvo);
		System.out.println("(log)--SLIK>>jswMemberScr.likeSearchJswMember �Լ� END>>>>>");
		return aList;
	}
	
public static void displayFun(ArrayList<JswMemberVO> aList){
		
		int aListSize = aList.size();
		
		
		for(int i =0; i<aListSize;i++){ //aList.size()); �迭����Ʈ������ ����(����) //aList�� size�Լ��� ���̱��ϱ� (static����; ���ϰ�int;�Ű�����()����) 
			JswMemberVO jvo = (JswMemberVO)aList.get(i); //ArrayListŬ������ get�Լ��� �̿��Ͽ� ÷��(i)��°�� �����͸� ����ϱ�// ÷�ڰ� 0���� �迭�� ���̰����� 1�������ϸ� �ݺ�����
			System.out.print(""+i+"��° for >>> : " + jvo.getJmem());	
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
			
		}//for�� ��	
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
//		System.out.println("�����ɾ ����Ͻÿ� >>> (ex.S): "); 
//		Scanner sc = new Scanner(System.in); //Scanner�� �̿��Ͽ� �ֿܼ��� �����͸� �޾ƿ´� 
//		String genNo = sc.nextLine();//StringŸ���� ������ �����Ͽ� nextLine()�Լ��� �̿� ���ڿ� ��ü �Է� �ޱ� (�Է°��� ������ �޴´�)

		String sFlag = "SALL";
		
		
		//INSERT
		if("I".equals(sFlag)){
			System.out.println("(log)---INSERT ���� �Լ� START>>>>>");
			
			 String jkname = "������";        
			 String jalias = "SSONG6";
			 String jid = "SSONGS6";
			 String jpw = "song6666"; 
			 String jgender = "F";
			 String jhp = "01066665530";
			 String jbirth = "66660918";
			 String jemail = "ssong6@song.com";
			 String jpostno = "66666";
			 String jaddr = "���������� ���� �л굿 66�� 66";
			 
			JswMemberScr es = new JswMemberScr();
			boolean bFlag = es.insertJswMember(jkname, jalias, jid, jpw, jgender, jhp, jbirth, jemail, jpostno, jaddr);
			
			if (bFlag){
				System.out.println("(log) ������ INSERT �Ϸ� >>> : ");
				
				JswMemberScr jms = new JswMemberScr();
				ArrayList<JswMemberVO> aList = jms.selectJswMember();
				int aListSize = aList.size();
				if(aListSize > 0){
					JswMemberScr.displayFun(aList); 
				}
				
			}else{
				System.out.println("(log) ������ INSERT ���� >>> : ");				
			}// ���if-else ��
			System.out.println("(log)---INSERT ���� �Լ� END>>>>>");
		}//if(I)��
		
		//update
		if("U".equals(sFlag)){
			System.out.println("(log)---UPDATE ���� �Լ� START>>>>>");
			String jkname = "����Ʃ";
			String jmem = "M201912050002";
					
			JswMemberScr es = new JswMemberScr();
			boolean bFlag = es.updateJswMember(jkname, jmem);
			
			if (bFlag){
				System.out.println("(log)������ UPDATE �Ϸ� >>> : ");
				
				JswMemberScr jms = new JswMemberScr();//�Է��ߵǾ����ϱ� ��ü��ȸ�� ���� �ٽ� �ν��Ͻ�����ؼ� ���
				ArrayList<JswMemberVO> aList = jms.selectJswMember();
				int aListSize = aList.size();
				if(aListSize > 0){
					JswMemberScr.displayFun(aList);
				}
				
			}else{
				System.out.println("(log)������ UPDATE ���� >>> : ");				
			}// ���if-else ��
			
			System.out.println("(log)---UPDATE ���� �Լ� END >>>>>");
		}//if(U)��
		
		//delete	
		if("D".equals(sFlag)){
			System.out.println("(log)---DELETE ���� �Լ� START>>>>>");
			String jmem = "M201912060009";
			 
			JswMemberScr es = new JswMemberScr();
			boolean bFlag = es.deleteJswMember(jmem);
			
			if (bFlag){
				System.out.println("(log)������ DELETE �Ϸ� >>> : ");
				
				JswMemberScr jms = new JswMemberScr();//�Է��ߵǾ����ϱ� ��ü��ȸ�� ���� �ٽ� �ν��Ͻ�����ؼ� ���
				ArrayList<JswMemberVO> aList = jms.selectJswMember();
				int aListSize = aList.size();
				if(aListSize > 0){
					JswMemberScr.displayFun(aList);
				}
				
			}else{
				System.out.println("(log)������ DELETE ���� >>> : ");				
			}// ���if-else ��
			System.out.println("(log)---DELETE ���� �Լ� END >>>>>");
			
		}//if(D) ��
		
		
		//��ü��ȸ����
		if ("SALL".equals(sFlag)){
			System.out.println("(log)---��ü��ȸ SELECT ALL ���� �Լ� START>>>>>");
			JswMemberScr es = new JswMemberScr();
			ArrayList<JswMemberVO> aList = es.selectJswMember();
			
			int aListSize = aList.size();
			if (aListSize > 0){
				JswMemberScr.displayFun(aList);				
			
			}//���� if��
		System.out.println("(log)---��ü��ȸ SELECT ALL ���� �Լ� END>>>>>");	
		}//if(SALL) ��
		
		//Ű���� �˻� ����
		if ("SSEA".equals(sFlag)){
			System.out.println("(log)---Ű���� �˻� SEARCH ���� �Լ� START>>>>>");
			String jmem = "M201912050003";
			JswMemberScr es = new JswMemberScr();
			ArrayList<JswMemberVO> aList = es.searchJswMember(jmem);
			
			int aListSize = aList.size();
			if (aListSize > 0){
				JswMemberScr.displayFun(aList);				
			
			}//���� if��
		System.out.println("(log)---Ű���� �˻� SEARCH ���� �Լ�END>>>>>");
		}//if(SSEA) ��		
		
		//Like �˻� ����
		if ("SLIK".equals(sFlag)){
			System.out.println("(log)---LIKE �˻� ���� �Լ� START>>>>>");
			String jaddr = "��õ��"; 
			JswMemberScr es = new JswMemberScr();
			ArrayList<JswMemberVO> aList = es.likeSearchJswMember(jaddr);
			
			int aListSize = aList.size();
			if (aListSize > 0){
				JswMemberScr.displayFun(aList);						
			}//���� if��
		System.out.println("(log)---LIKE �˻� ���� �Լ�END>>>>>");
		}//if(SSEA) ��	
	}//���γ�

}//Ŭ������
