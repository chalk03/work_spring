package com.koitt.java.tx;

import java.sql.Connection;

public class BoardService {

	private BoardDao dao = new BoardDao();
	
	public void add(Board board) {
		Connection conn = null;
		
		try {
			// 트랜잭션 처리영역 시작부분
			conn = DBUtil.getInstance().getConnection();
			
			/* 
			 * 자동 Commit을 막기 위해 false 설정
			 * Commit은 테이블에 최종적으로 SQL 실행한 결과를 반영하는 것
			 * false로 설정했기 때문에 우리가 직접 커밋을 호출해야한다.
			 */
			conn.setAutoCommit(false);
			Integer no = dao.getBoardNo(conn);
			board.setNo(no);
			dao.insert(conn, board);
			
			// 마지막으로 SQL 실행한 결과를 반영
			conn.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			if (conn != null) {
				try {
					conn.setAutoCommit(true);
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
