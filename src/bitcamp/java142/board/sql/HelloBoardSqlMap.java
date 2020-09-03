package bitcamp.java142.board.sql;

public abstract class HelloBoardSqlMap {

	public static final String JSW_BOARD_CHAEBUN = 
			  " SELECT  /*+ INDEX_DESC(A SYS_C0011391) */ "
	        + " NVL(MAX(SUBSTR(B.JNO, -4)), 0)+1 JCNO FROM JSWHELLOBOARD B ";
	

	public static String getInsertQuery(){
		StringBuffer sb = new StringBuffer();
	
		sb.append("\n");
		sb.append("INSERT INTO JSWHELLOBOARD(				\n");
		sb.append("							JNO, 			\n");
		sb.append("							JSUBJECT, 		\n");
		sb.append("							JNAME,			\n");
		sb.append("							JPW, 			\n");
		sb.append("							JMEMO, 			\n");
		sb.append("							JDELETEYN,		\n");
		sb.append("							JINSERTDATE,	\n");
		sb.append("							JUPDATEDATE		\n");
		sb.append(")VALUES(									\n");
		sb.append("			?, ?, ?,  						\n");
		sb.append("  		?, ?, ?, 	 			 		\n");
		sb.append("			SYSDATE,SYSDATE    )			\n");
			
		return sb.toString();
	}//getInsertQuery()³¡
	
	
	
	public static String getSelectAllQuery(){
		StringBuffer sb = new StringBuffer();
		
		sb.append("\n");
		sb.append("SELECT															\n");
		sb.append("			A.JNO									JNO, 			\n");
		sb.append("			A.JSUBJECT							    JSUBJECT, 		\n");
		sb.append("			A.JNAME					   				JNAME,			\n");
		sb.append("			A.JPW									JPW, 			\n");
		sb.append("			A.JMEMO									JMEMO, 			\n");
		sb.append("			A.JDELETEYN		 						JDELETEYN,		\n");
		sb.append("			TO_CHAR(A.JINSERTDATE, 'YYYY-MM-DD')	JINSERTDATE,	\n");
		sb.append("			TO_CHAR(A.JUPDATEDATE, 'YYYY-MM-DD')	JUPDATEDATE	\n");
		sb.append("FROM  	JSWHELLOBOARD	A										    \n");
		sb.append("WHERE   	1=1														\n");
		sb.append("AND     	A.JDELETEYN	 = 'Y'										\n");
		sb.append("ORDER BY 1														\n");
		return sb.toString();
																									
	}
	
	
	public static String getUpdateQuery(){
		StringBuffer sb = new StringBuffer();
		sb.append("\n");
		sb.append("UPDATE 	JSWHELLOBOARD				\n");
		sb.append("SET 		JSUBJECT		= ? 		\n");
		sb.append(" 		,JNAME		 	= ? 		\n");
		sb.append(" 		,JMEMO		 	= ? 		\n");
		sb.append("    	    ,JUPDATEDATE 	= SYSDATE	\n");
		sb.append("WHERE	JNO 			= ?			\n");
		sb.append("AND  	JDELETEYN 		= 'Y'		\n");		
		return sb.toString();
	}
	
	
	public static String getDeleteQuery(){
		StringBuffer sb = new StringBuffer();
		sb.append("\n");
		sb.append("UPDATE 	JSWHELLOBOARD				\n");
		sb.append("SET 		JDELETEYN 		= 'N' 		\n");
		sb.append("    	  , JUPDATEDATE 	= SYSDATE	\n");
		sb.append("WHERE	JNO 			= ?			\n");
		sb.append("AND  	JDELETEYN 		= 'Y'		\n");		
		return sb.toString();
		
	}
	
	
	public static String getSelectQuery(){
		StringBuffer sb = new StringBuffer();
		
		sb.append("\n");
		sb.append("SELECT															\n");
		sb.append("			A.JNO									JNO, 			\n");
		sb.append("			A.JSUBJECT							    JSUBJECT, 		\n");
		sb.append("			A.JNAME					   				JNAME,			\n");
		sb.append("			A.JPW									JPW, 			\n");
		sb.append("			A.JMEMO									JMEMO, 			\n");
		sb.append("			A.JDELETEYN		 						JDELETEYN,		\n");
		sb.append("			TO_CHAR(A.JINSERTDATE, 'YYYY-MM-DD')	JINSERTDATE,	\n");
		sb.append("			TO_CHAR(A.JUPDATEDATE, 'YYYY-MM-DD')	JUPDATEDATE	\n");
		sb.append("FROM  	JSWHELLOBOARD	A									    \n");
		sb.append("WHERE   	1=1														\n");
		sb.append("AND     	A.JNO		 = ?										\n");
		sb.append("AND     	A.JDELETEYN	 = 'Y'										\n");
		sb.append("ORDER BY 1														\n");
		return sb.toString();
																									
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
