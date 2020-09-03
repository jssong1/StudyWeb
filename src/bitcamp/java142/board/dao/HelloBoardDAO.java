package bitcamp.java142.board.dao;

import java.util.ArrayList;

import bitcamp.java142.board.vo.HelloBoardVO;

public interface HelloBoardDAO {

	public int insertJswBoard(HelloBoardVO jbvo);

	public ArrayList<HelloBoardVO> selectAllJswBoard();
	public ArrayList<HelloBoardVO> boardSelect(HelloBoardVO jbvo);
	 
	public int updateJswBoard(HelloBoardVO jbvo);
	public int deleteJswBoard(HelloBoardVO jbvo);



}//interface HelloBoardDAO ³¡
