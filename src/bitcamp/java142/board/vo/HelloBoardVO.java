package bitcamp.java142.board.vo;

public class HelloBoardVO {

	String jno;		
	String jsubject;
	String jname;
	String jpw;
	String jmemo;
	String jdeleteyn;
	String jinsertdate;
	String jupdatedate;
	
	public HelloBoardVO(){}
	public HelloBoardVO(String jno		
						,String jsubject
						,String jname
						,String jpw
						,String jmemo
						,String jdeleteyn
						,String jinsertdate
						,String jupdatedate){
				
		this.jno = jno;		
		this.jsubject = jsubject;
		this.jname = jname;
		this.jpw = jpw;
		this.jmemo = jmemo;
		this.jdeleteyn = jdeleteyn;
		this.jinsertdate = jinsertdate;
		this.jupdatedate = jupdatedate;
		
	}
	
	public String getJno() {
		return jno;
	}
	public String getJsubject() {
		return jsubject;
	}
	public String getJname() {
		return jname;
	}
	public String getJpw() {
		return jpw;
	}
	public String getJmemo() {
		return jmemo;
	}
	public String getJdeleteyn() {
		return jdeleteyn;
	}
	public String getJinsertdate() {
		return jinsertdate;
	}
	public String getJupdatedate() {
		return jupdatedate;
	}
	public void setJno(String jno) {
		this.jno = jno;
	}
	public void setJsubject(String jsubject) {
		this.jsubject = jsubject;
	}
	public void setJname(String jname) {
		this.jname = jname;
	}
	public void setJpw(String jpw) {
		this.jpw = jpw;
	}
	public void setJmemo(String jmemo) {
		this.jmemo = jmemo;
	}
	public void setJdeleteyn(String jdeleteyn) {
		this.jdeleteyn = jdeleteyn;
	}
	public void setJinsertdate(String jinsertdate) {
		this.jinsertdate = jinsertdate;
	}
	public void setJupdatedate(String jupdatedate) {
		this.jupdatedate = jupdatedate;
	}

}//HelloBoardVO 클래스끝
