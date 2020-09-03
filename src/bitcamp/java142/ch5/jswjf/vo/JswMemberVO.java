package bitcamp.java142.ch5.jswjf.vo;

public class JswMemberVO {
    private String jmem;;	
    private String jkname;         //멤버변수에서 final하지 않은 이유: 멤버변수에서 변경하지 않는 소스가되어 생성자에서 에러남 초기화시켜야해 // 변수에 파이널이 있으면  -> 무조건 값이 있어야함
    private String jalias;
    private String jid;
    private String jpw;
    private String jgender;
    private String jhp;
    private String jbirth;
    private String jemail;
    private String jpostno;
    private String jaddr;
    private String jdeleteYN;
    private String jinsertdate;   
    private String jupdatedate;
    
 


	public JswMemberVO(){}


	public JswMemberVO(String jmem, String jkname, String jalias, String jid, String jpw, String jgender, String jhp,
			String jbirth, String jemail, String jpostno, String jaddr, String jdeleteYN, String jinsertdate,
			String jupdatedate) {
		this.jmem = jmem;
		this.jkname = jkname;
		this.jalias = jalias;
		this.jid = jid;
		this.jpw = jpw;
		this.jgender = jgender;
		this.jhp = jhp;
		this.jbirth = jbirth;
		this.jemail = jemail;
		this.jpostno = jpostno;
		this.jaddr = jaddr;
		this.jdeleteYN = jdeleteYN;
		this.jinsertdate = jinsertdate;
		this.jupdatedate = jupdatedate;
	}






	public String getJmem() {
		return jmem;
	}




	public String getJkname() {
		return jkname;
	}




	public String getJalias() {
		return jalias;
	}




	public String getJid() {
		return jid;
	}




	public String getJpw() {
		return jpw;
	}




	public String getJgender() {
		return jgender;
	}




	public String getJhp() {
		return jhp;
	}




	public String getJbirth() {
		return jbirth;
	}




	public String getJemail() {
		return jemail;
	}




	public String getJpostno() {
		return jpostno;
	}




	public String getJaddr() {
		return jaddr;
	}




	public String getJdeleteYN() {
		return jdeleteYN;
	}




	public String getJinsertdate() {
		return jinsertdate;
	}




	public String getJupdatedate() {
		return jupdatedate;
	}




	public void setJmem(String jmem) {
		this.jmem = jmem;
	}




	public void setJkname(String jkname) {
		this.jkname = jkname;
	}




	public void setJalias(String jalias) {
		this.jalias = jalias;
	}




	public void setJid(String jid) {
		this.jid = jid;
	}




	public void setJpw(String jpw) {
		this.jpw = jpw;
	}




	public void setJgender(String jgender) {
		this.jgender = jgender;
	}




	public void setJhp(String jhp) {
		this.jhp = jhp;
	}




	public void setJbirth(String jbirth) {
		this.jbirth = jbirth;
	}




	public void setJemail(String jemail) {
		this.jemail = jemail;
	}




	public void setJpostno(String jpostno) {
		this.jpostno = jpostno;
	}




	public void setJaddr(String jaddr) {
		this.jaddr = jaddr;
	}




	public void setJdeleteYN(String jdeleteYN) {
		this.jdeleteYN = jdeleteYN;
	}




	public void setJinsertdate(String jinsertdate) {
		this.jinsertdate = jinsertdate;
	}




	public void setJupdatedate(String jupdatedate) {
		this.jupdatedate = jupdatedate;
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
