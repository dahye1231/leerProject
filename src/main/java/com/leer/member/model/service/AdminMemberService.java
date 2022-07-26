package com.leer.member.model.service;

import static com.leer.common.JDBCTemplate.close;
import static com.leer.common.JDBCTemplate.commit;
import static com.leer.common.JDBCTemplate.getConnection;
import static com.leer.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.leer.common.model.vo.PageInfo;
import com.leer.member.model.dao.AdminMemberDao;
import com.leer.member.model.vo.Member;

public class AdminMemberService {
	
	// 관리자 회원리스트 조회
	// 작성자 김은지
	public ArrayList<Member> selectMemberList(PageInfo pi){ 
		Connection conn = getConnection();
		
		ArrayList<Member> list = new AdminMemberDao().selectMemberList(conn, pi); 
		
		close(conn);
		return list;
	}
		
	// 관리자 회원리스트 조회 페이징처리
	// 작성자 김은지
	public int selectMemberListCount() {
		Connection conn = getConnection();
		int listCount = new AdminMemberDao().selectMemberListCount(conn);
		close(conn);
		return listCount;
	}
	
	// 관리자 회원상세조회
	// 작성자 김은지
	public Member memberDatailList(int memNo) {
		Connection conn = getConnection();
		Member m = new AdminMemberDao().memberDatailList(conn, memNo);
		close(conn);
		return m;
	}
	
	// 관리자 회원정보 업데이트페이지
	// 작성자 김은지
	public Member updateMemberForm(int memNo) {
		Connection conn = getConnection();
		Member m = new AdminMemberDao().updateMemberForm(conn, memNo);
		close(conn);
		return m;
	}
	
	// 관리자 회원정보 변경
	// 작성자 김은지
	public int updateMember(Member m) {
		Connection conn = getConnection();
		int result = new AdminMemberDao().updateMember(conn, m);
		
		if(result > 0) {
			commit(conn);
			
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}	
	
	// 관리자 회원정보 삭제
	// 작성자 김은지
	public int deleteMember(int memNo) {
		Connection conn = getConnection();
		int result = new AdminMemberDao().deleteMember(conn, memNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	// 관리자 장기구독자리스트 조회
	// 작성자 김은지
	public ArrayList<Member> selectLongMemberList(PageInfo pi){
		Connection conn = getConnection();
		
		ArrayList<Member> list = new AdminMemberDao().selectLongMemberList(conn, pi);
		
		close(conn);
		return list;
	}
	
	// 관리자 장기구독자 조회 페이징처리
	// 작성자 김은지	
	public int selectLongMemberListCount() {
		Connection conn = getConnection();
		int listCount = new AdminMemberDao().selectLongMemberListCount(conn);
		close(conn);
		return listCount;
	}

	// 관리자 장기구독자 상세조회
	// 작성자 김은지	
	public Member memberLongDetailList(int orNo) {
		Connection conn = getConnection();
		Member m = new AdminMemberDao().memberLongDetailList(conn, orNo);
		close(conn);
		return m;
	}
	
}
