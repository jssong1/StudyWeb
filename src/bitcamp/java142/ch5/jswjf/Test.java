package bitcamp.java142.ch5.jswjf;

import java.util.ArrayList;

import bitcamp.java142.ch5.jswjf.dao.JswMemberDAO;
import bitcamp.java142.ch5.jswjf.dao.JswMemberDAOImpl;
import bitcamp.java142.ch5.jswjf.vo.JswMemberVO;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("(log)--- ���� �Լ� START>>>>>");
		
		 
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
			System.out.println("�α��� ��������");
			for(int i =0; i<aListSize;i++){ //aList.size()); �迭����Ʈ������ ����(����) //aList�� size�Լ��� ���̱��ϱ� (static����; ���ϰ�int;�Ű�����()����) 
				JswMemberVO jvo1 = (JswMemberVO)aList.get(i); //ArrayListŬ������ get�Լ��� �̿��Ͽ� ÷��(i)��°�� �����͸� ����ϱ�// ÷�ڰ� 0���� �迭�� ���̰����� 1�������ϸ� �ݺ�����
				System.out.print(""+i+"��° for >>> : " + jvo1.getJid());
				System.out.println(" " + jvo1.getJpw());				
			}//for�� ��	
		}else{
			System.out.println("�α��� ���н���");			
		}//if-else ��
		
		
		System.out.println("(log)--- ���� �Լ� END>>>>>");
	}//�����Լ� ��

}//Ŭ���� ��
