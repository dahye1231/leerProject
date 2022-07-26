package com.leer.terms.model.service;

import static com.leer.common.JDBCTemplate.close;
import static com.leer.common.JDBCTemplate.commit;
import static com.leer.common.JDBCTemplate.getConnection;
import static com.leer.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.leer.common.model.vo.Category2;
import com.leer.common.model.vo.PageInfo;
import com.leer.terms.model.dao.AdminTermsDao;
import com.leer.terms.model.vo.Terms;

public class AdminTermsService {
	
	// 관리자 이용약관리스트 조회
	// 작성자 김은지
	public ArrayList<Terms> selectTermsList(PageInfo pi){
		Connection conn = getConnection();
		
		ArrayList<Terms> list = new AdminTermsDao().selectTermsList(conn, pi);
		
		close(conn);
		return list;		
	}

	// 관리자 이용약관리스트 조회 페이징처리
	// 작성자 김은지
	public int selectTermsListCount() {
		Connection conn = getConnection();
		int listCount = new AdminTermsDao().selectTermsListCount(conn);
		close(conn);
		return listCount;
	}
	
	// 관리자 이용약관 상세조회
	// 작성자 김은지
	public Terms termsDetailList(int trmNo) {
		Connection conn = getConnection();
		Terms t = new AdminTermsDao().termsDetailList(conn, trmNo);
		close(conn);
		return t;
	}
	
	// 관리자 이용약관등록 카테고리조회
	// 작성자 김은지	
	public ArrayList<Category2> selectTermsCategoryList(){
		Connection conn = getConnection();
		ArrayList<Category2> list = new AdminTermsDao().selectTermsCategoryList(conn);
		close(conn);
		return list;
	}
	
	// 관리자 이용약관 등록요청
	// 작성자 김은지
	public int insertTerms(Terms t) {
		Connection conn = getConnection();
		
		int result = new AdminTermsDao().insertTerms(conn, t);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}	
	
	// 관리자 이용약관 삭제요청
	// 작성자 김은지
	public int deleteTerms(int trmNo) {
		Connection conn = getConnection();
		int result = new AdminTermsDao().deleteTerms(conn, trmNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

}



















