package com.leer.review.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import static com.leer.common.JDBCTemplate.*;

import com.leer.common.model.vo.Attachment;
import com.leer.member.model.vo.Member;
import com.leer.mypage.model.dao.MypageDao;
import com.leer.review.model.vo.Review;

public class ReviewDao {

	private Properties prop = new Properties();
	
public ReviewDao() {
		
		String filePath = ReviewDao.class.getResource("/db/sql/review-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Review> WriteReviewView(Connection conn, int memNo){
		
		ArrayList<Review> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("WriteReviewView");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, memNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add( new Review (
							rset.getString("p_name"),
							rset.getInt("price"),
							rset.getString("image_url1"),
							rset.getDate("or_date"),
							rset.getString("or_no"),
							rset.getString("p_code")
						));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}	
		
		return list;
	}
	
public ArrayList<Review> WriteReviewHistory(Connection conn, int memNo){
		
		ArrayList<Review> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("WriteReviewHistory");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, memNo);
			rset = pstmt.executeQuery();
					
			
			while(rset.next()) {
				list.add( new Review (
							rset.getString("p_name"),
							rset.getInt("review_Scope"),
							rset.getString("review_Content"),
							rset.getInt("price"),
							rset.getString("image_url1"),
							rset.getDate("or_date"),				
							rset.getString("p_code"),
							rset.getInt("review_no")
						));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}	
		
		return list;
	}

	public Review WriteReview(Connection conn, int memNo, String orNo, String p_code) {
		
		Review r = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("WriteReview");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, memNo);
			pstmt.setString(2, orNo);
			pstmt.setString(3, p_code);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				r = new Review(
							rset.getString("image_url1"),
							rset.getString("p_Name"),
							rset.getDate("or_date"),
							rset.getInt("price"),
							rset.getString("p_code")
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return r;
	}
	
	public int WriteReviewComplete(Connection conn,Review r) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("WriteReviewComplete");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, r.getMemNo());
			pstmt.setString(2, r.getpName());
			pstmt.setString(3, r.getP_code());
			pstmt.setInt(4, r.getReviewScope());
			pstmt.setString(5, r.getReviewContent());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public int insertAttachment(Connection conn, Attachment at) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, at.getOriginName());
			pstmt.setString(2, at.getChangeName());
			pstmt.setString(3, at.getFilePath());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public int ReviewCancle(Connection conn,int memNo,int reviewNo, String p_code) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("ReviewCancle");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memNo);
			pstmt.setInt(2, reviewNo);
			pstmt.setString(3, p_code);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
		
	}
	
	public int PointTriger(Connection conn,Review r) {
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("PointTriger");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, r.getMemNo());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return 1;
		
	}
	
	
}
