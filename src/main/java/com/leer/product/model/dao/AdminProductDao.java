package com.leer.product.model.dao;

import static com.leer.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.leer.common.model.vo.Attachment;
import com.leer.common.model.vo.PageInfo;
import com.leer.product.model.vo.Inquiry;
import com.leer.product.model.vo.Product;

public class AdminProductDao {
	
	private Properties prop = new Properties();
	
	public AdminProductDao() {
		try {
			prop.loadFromXML(new FileInputStream(ProductDao.class.getResource("/db/sql/admin-product-mapper.xml").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/* [제품관리 - 상품조회]
	 * 상품 전체 조회
	 * 작성자 김지애
	 */
	public ArrayList<Product>selectProductList(Connection conn, PageInfo pi){
		ArrayList<Product>list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectProductList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage()-1) * pi.getBoardLimit()+1;
			int endRow = startRow + pi.getBoardLimit()-1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery(); 
			
			while(rset.next()) {
				list.add(new Product(rset.getString("p_name"),
									 rset.getInt("category_no"),
									 rset.getString("p_code"),
									 rset.getString("publisher"),
									 rset.getDate("publish_month"),
									 rset.getInt("price"),
									 rset.getDate("enroll_date"),
									 rset.getInt("p_stock")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	/* [제품관리 - 상품조회]
	 * 상품전체조회 페이지 : 페이징 처리
	 * 작성자 김지애
	 */
	public int selectProductListCount(Connection conn) {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectProductListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	
	/* [제품관리 - 상품조회]
	 * 상품전체조회 페이지 : 수정버튼 클릭 시 수정페이지 요청
	 * 작성자 김지애
	 */
	public Product selectProduct(Connection conn, String pCode) {
		// select문 => ResultSet (한행 : 관리자가 선택한 한개의 상품) => Notice객체에 담아 반환
		Product p = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pCode);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				p = new Product(rset.getString("p_name"),
								rset.getInt("category_no"),
								rset.getString("p_code"),
								rset.getString("publisher"),
								rset.getDate("publish_month"),
								rset.getInt("price"),
								rset.getDate("enroll_date"),
								rset.getInt("p_stock")
								);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return p;
	} 

	/* [제품관리 - 상품조회]
	 * 상품전체조회 페이지 : 삭제버튼
	 * 작성자 김지애
	 */
	public int deleteProduct(Connection conn, String pCode) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pCode);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	/* [제품관리 - 상품등록]
	 * 상품 등록
	 * 작성자 김지애
	 */
	public int insertProduct(Connection conn, Product p) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getpName());
			pstmt.setString(2, p.getPublishMonth2());
			pstmt.setString(3, p.getPublisher());
			pstmt.setInt(4, p.getCategoryNo());
			pstmt.setString(5, p.getpCode());
			pstmt.setInt(6, p.getPrice());
			pstmt.setInt(7, p.getpStock());
			pstmt.setInt(8, p.getDeliFee());
			pstmt.setInt(9, p.getPoint());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	/* [제품관리 - 상품등록]
	 * 상품 등록 : 첨부파일 3개
	 * 작성자 김지애
	 */
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

	/* [제품관리 - 상품등록]
	 * 상품 수정
	 * 작성자 김지애
	 */
	public int updateProduct(Connection conn, Product p) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getpCode());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}


	
	
}
