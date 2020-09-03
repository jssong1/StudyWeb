package bitcamp.java142.ch5.eci.sql;

public abstract class EciSqlQueryMap {
	
	public static String getInsertQuery(){
		StringBuffer sb = new StringBuffer();
		sb.append("\n");
		sb.append(" INSERT INTO									\n");
		sb.append("		ECI_WORK(								\n");
		sb.append("					ENUM,						\n");
		sb.append("					ENAME,						\n");
		sb.append("					EAGE,						\n");
		sb.append("					EHP,						\n");
		sb.append("					EADDR,						\n");
		sb.append("					EDELETEYN,					\n");
		sb.append("					EINSERTDATE,				\n");
		sb.append("					EUPDATEDATE					\n");
		sb.append("					)							\n");
		sb.append(" VALUES (									\n");
		sb.append("				?,								\n");
		sb.append("				?,								\n");
		sb.append("				?,								\n");
		sb.append("				?,								\n");
		sb.append("				?,								\n");
		sb.append("				?,								\n");
		sb.append("				SYSDATE,						\n");
		sb.append("				SYSDATE)						\n");       
	
		return sb.toString();
	}//getInsertQuery()��
	
	public static String getUpdateQuery(){
		StringBuffer sb = new StringBuffer();
		sb.append("\n");
		sb.append(" UPDATE ECI_WORK								\n");
		sb.append(" SET 										\n");
		sb.append("			  EHP 		  = ?					\n");
		sb.append("    		, EUPDATEDATE = SYSDATE				\n");
		sb.append(" WHERE 	  ENUM        = ?					\n");
		sb.append(" AND       EDELETEYN   = 'Y'					\n");
		
		return sb.toString();	
	}//getUpdateQuery()
	
	public static String getDeleteQuery(){
		StringBuffer sb = new StringBuffer();
		sb.append("\n");
		sb.append("UPDATE 	ECI_WORK					\n");
		sb.append("SET 		EDELETEYN 		= 'N' 		\n");
		sb.append("    	  , EUPDATEDATE 	= SYSDATE	\n");
		sb.append("WHERE	ENUM 			= ?			\n");
		sb.append("AND  	EDELETEYN 		= 'Y'		\n");		
		return sb.toString();
	}//getDeleteQuery()
	
	public static String getSelectQuery() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n");
		sb.append("SELECT  	A.ENUM  					ENUM,  		\n");
		sb.append("		A.ENAME  					ENAME, 		\n");
		sb.append("		A.EAGE 						EAGE,  		\n");
		sb.append("		A.EHP 						EHP,   		\n");
		sb.append("		A.EADDR 					EADDR, 		\n");
		sb.append("		A.EDELETEYN 					EDELETEYN,		\n");
		sb.append("		TO_CHAR(A.EINSERTDATE, 'YYYY-MM-DD') 		INSERTDATE,	\n");
		sb.append("		TO_CHAR(A.EUPDATEDATE, 'YYYY-MM-DD') 		UPDATEDATE		\n");
		sb.append("FROM  	 	ECI_WORK A										    \n");
		sb.append("WHERE   	1=1													\n");
		sb.append("AND     	A.EDELETEYN = 'Y'									\n");
		sb.append("ORDER BY 1													\n");
		return sb.toString();
	}
	
	public static String getSearchQuery(){
		StringBuffer sb = new StringBuffer();
		sb.append("\n");
		sb.append("SELECT  	A.ENUM  					ENUM,  		\n");
		sb.append("		A.ENAME  					ENAME, 		\n");
		sb.append("		A.EAGE 						EAGE,  		\n");
		sb.append("		A.EHP 						EHP,   		\n");
		sb.append("		A.EADDR 					EADDR, 		\n");
		sb.append("		A.EDELETEYN 					EDELETEYN,		\n");
		sb.append("		TO_CHAR(A.EINSERTDATE, 'YYYY-MM-DD') 		INSERTDATE,	\n");
		sb.append("		TO_CHAR(A.EUPDATEDATE, 'YYYY-MM-DD') 		UPDATEDATE		\n");
		sb.append("FROM  	 	ECI_WORK A										    \n");
		sb.append("WHERE   	1=1													\n");
		sb.append("AND     	A.ENUM		= ?									\n");
		sb.append("AND     	A.EDELETEYN = 'Y'									\n");
		sb.append("ORDER BY 1													\n");
		return sb.toString();
	}
	
	public static String getLikeSearchQuery(){
		return "";
	}

}
