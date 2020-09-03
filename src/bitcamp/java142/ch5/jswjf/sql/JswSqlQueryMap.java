package bitcamp.java142.ch5.jswjf.sql;

public abstract class JswSqlQueryMap {
	
	public static final String JSWSC_WORK_ENUM_CHAEBUN = 
			  " SELECT  /*+ INDEX_DESC(A SYS_C0011399) */ "
	        + " NVL(MAX(SUBSTR(A.JMEM, -4)), 0) + 1 JMEM FROM JSW_MEMBER A ";
						
	public static String getInsertQuery(){
		StringBuffer sb = new StringBuffer();
	
		sb.append("\n");
		sb.append("INSERT INTO JSW_MEMBER(					\n");
		sb.append("							JMEM, 			\n");
		sb.append("							JKNAME, 		\n");
		sb.append("							JALIAS,			\n");
		sb.append("							JID, 			\n");
		sb.append("							JPW, 			\n");
		sb.append("							JGENDER, 		\n");
		sb.append("							JHP,			\n"); 
		sb.append("							JBIRTH, 		\n");
		sb.append("							JEMAIL, 		\n");
		sb.append("							JPOSTNO,		\n");
		sb.append("							JADDR,			\n");
		sb.append("							JDELETEYN,		\n");
		sb.append("							JINSERTDATE,	\n");
		sb.append("							JUPDATEDATE		\n");
		sb.append(")VALUES(									\n");
		sb.append("			?, ?, ?, ?, ?, ?,				\n");
		sb.append("  		?, ?, ?, ?, ?, ?,		 		\n");
		sb.append("			SYSDATE,SYSDATE    )			\n");
			
		return sb.toString();
	}//getInsertQuery()³¡
	public static String getUpdateQuery(){
		StringBuffer sb = new StringBuffer();
		sb.append("\n");
		sb.append("UPDATE 	JSW_MEMBER					\n");
		sb.append("SET 		JKNAME		 	= ? 		\n");
		sb.append("    	  , JUPDATEDATE 	= SYSDATE	\n");
		sb.append("WHERE	JMEM 			= ?			\n");
		sb.append("AND  	JDELETEYN 		= 'Y'		\n");		
		return sb.toString();
		
	}
	
	public static String getDeleteQuery(){
		StringBuffer sb = new StringBuffer();
		sb.append("\n");
		sb.append("UPDATE 	JSW_MEMBER					\n");
		sb.append("SET 		JDELETEYN 		= 'N' 		\n");
		sb.append("    	  , JUPDATEDATE 	= SYSDATE	\n");
		sb.append("WHERE	JMEM 			= ?			\n");
		sb.append("AND  	JDELETEYN 		= 'Y'		\n");		
		return sb.toString();
	}//getDeleteQuery()³¡
	
	public static String getSelectQuery(){
		StringBuffer sb = new StringBuffer();
		
		sb.append("\n");
		sb.append("SELECT															\n");
		sb.append("			A.JMEM									 JMEM, 			\n");
		sb.append("			A.JKNAME								 JKNAME,		\n");
		sb.append("			A.JALIAS								 JALIAS,  		\n");
		sb.append("			A.JID  									 JID, 			\n");
		sb.append("			A.JPW   								 JPW, 			\n");
		sb.append("			A.JGENDER								 JGENDER, 		\n");
		sb.append("			A.JHP 									 JHP, 			\n");
		sb.append("			A.JBIRTH 								 JBIRTH, 		\n");
		sb.append("			A.JEMAIL 								 JEMAIL, 		\n");
		sb.append("			A.JPOSTNO 								 JPOSTNO,		\n");
		sb.append("			A.JADDR									 JADDR,			\n");
		sb.append("			A.JDELETEYN		 						 JDELETEYN,		\n");
		sb.append("			TO_CHAR(A.JINSERTDATE, 'YYYY-MM-DD')	 JINSERTDATE,	\n");
		sb.append("			TO_CHAR(A.JUPDATEDATE, 'YYYY-MM-DD')	 JUPDATEDATE	\n");
		sb.append("FROM  	JSW_MEMBER	A									    \n");
		sb.append("WHERE   	1=1														\n");
		sb.append("AND     	A.JDELETEYN	 = 'Y'										\n");
		sb.append("ORDER BY 1														\n");
		return sb.toString();
																									
	}
	
	public static String getSearchQuery(){
		StringBuffer sb = new StringBuffer();
		
		sb.append("\n");
		sb.append("SELECT															\n");
		sb.append("			A.JMEM									 JMEM, 			\n");
		sb.append("			A.JKNAME								 JKNAME,		\n");
		sb.append("			A.JALIAS								 JALIAS,  		\n");
		sb.append("			A.JID  									 JID, 			\n");
		sb.append("			A.JPW   								 JPW, 			\n");
		sb.append("			A.JGENDER								 JGENDER, 		\n");
		sb.append("			A.JHP 									 JHP, 			\n");
		sb.append("			A.JBIRTH 								 JBIRTH, 		\n");
		sb.append("			A.JEMAIL 								 JEMAIL, 		\n");
		sb.append("			A.JPOSTNO 								 JPOSTNO,		\n");
		sb.append("			A.JADDR									 JADDR,			\n");
		sb.append("			A.JDELETEYN		 						 JDELETEYN,		\n");
		sb.append("			TO_CHAR(A.JINSERTDATE, 'YYYY-MM-DD')	 JINSERTDATE,	\n");
		sb.append("			TO_CHAR(A.JUPDATEDATE, 'YYYY-MM-DD')	 JUPDATEDATE	\n");
		sb.append("FROM  	JSW_MEMBER	A										    \n");
		sb.append("WHERE   	1=1														\n");
		sb.append("AND     	A.JMEM		 = ?										\n");
		sb.append("AND     	A.JDELETEYN	 = 'Y'										\n");
		sb.append("ORDER BY 1														\n");
		return sb.toString();
																									
	}
	
	
	public static String getLikeSearchQuery(){
		StringBuffer sb = new StringBuffer();
		
		sb.append("\n");
		sb.append("SELECT															\n");
		sb.append("			A.JMEM									 JMEM, 			\n");
		sb.append("			A.JKNAME								 JKNAME,		\n");
		sb.append("			A.JALIAS								 JALIAS,  		\n");
		sb.append("			A.JID  									 JID, 			\n");
		sb.append("			A.JPW   								 JPW, 			\n");
		sb.append("			A.JGENDER								 JGENDER, 		\n");
		sb.append("			A.JHP 									 JHP, 			\n");
		sb.append("			A.JBIRTH 								 JBIRTH, 		\n");
		sb.append("			A.JEMAIL 								 JEMAIL, 		\n");
		sb.append("			A.JPOSTNO 								 JPOSTNO,		\n");
		sb.append("			A.JADDR									 JADDR,			\n");
		sb.append("			A.JDELETEYN		 						 JDELETEYN,		\n");
		sb.append("			TO_CHAR(A.JINSERTDATE, 'YYYY-MM-DD')	 JINSERTDATE,	\n");
		sb.append("			TO_CHAR(A.JUPDATEDATE, 'YYYY-MM-DD')	 JUPDATEDATE	\n");
		sb.append("FROM  	JSW_MEMBER	A										    \n");
		sb.append("WHERE   	1=1														\n");
		sb.append("AND     	A.JADDR LIKE  '%'|| ? || '%'							\n");
		sb.append("AND     	A.JDELETEYN	 = 'Y'										\n");
		sb.append("ORDER BY 1														\n");
		return sb.toString();
																									
	}
	
	
	public static String getLoginQuery(){
		StringBuffer sb = new StringBuffer();
		
		sb.append("\n");
		sb.append("SELECT															\n");
		sb.append("			A.JID									 JID, 			\n");
		sb.append("			A.JPW									 JPW,			\n");
		sb.append("			A.JDELETEYN		 						 JDELETEYN		\n");
		sb.append("FROM   	JSW_MEMBER								A				\n");
		sb.append("WHERE   	1=1														\n");
		sb.append("AND     	A.JID = ?  												\n");
		sb.append("AND     	A.JPW = ?												\n");
		sb.append("AND     	A.JDELETEYN	 = 'Y'										\n");

		return sb.toString();																
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
