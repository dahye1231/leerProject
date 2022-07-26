package com.leer.member.model.service;

import static com.leer.common.JDBCTemplate.close;
import static com.leer.common.JDBCTemplate.commit;
import static com.leer.common.JDBCTemplate.getConnection;
import static com.leer.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.leer.member.model.dao.MemberDao;
import com.leer.member.model.vo.Member;

public class MemberService {
	

	public Member loginMember(String memId, String memPwd) {
		
		Connection conn = getConnection();
		
		Member m = new MemberDao().loginMember(conn, memId, memPwd);
		
		close(conn);
		
		return m;
	}
	
	
	
	public int insertMember(Member m) {
		
		Connection conn = getConnection();
		
		int result = new MemberDao().insertMember(conn, m);
		
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	
	
	public Member updateMember(Member m) {
		
		Connection conn = getConnection();
		
		int result = new MemberDao().updateMember(conn, m);
		
		
		Member updateMem = null;
		
		if(result > 0) {
			commit(conn);
			
			updateMem = new MemberDao().selectMember(conn, m.getMemId());
			
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return updateMem;
		
	}
	
	
	
	public Member updatePwdMember(String memId, String memPwd, String updatePwd) {
		
		Connection conn = getConnection();
		
		int result = new MemberDao().updatePwdMember(conn, memId, memPwd, updatePwd);
		
		Member updateMem = null;
		if(result > 0) {
			commit(conn);
			
			updateMem = new MemberDao().selectMember(conn, memId);
			
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return updateMem;
	}
	
	
	
	public int deleteMember(String memId) {
		
		Connection conn = getConnection();
		
		int result = new MemberDao().deleteMember(conn, memId);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	
	public int idCheck(String checkId) {
		
		Connection conn = getConnection();
		
		int count = new MemberDao().idCheck(conn, checkId);
		
		close(conn);
		
		return count;
	}
	
	
}
