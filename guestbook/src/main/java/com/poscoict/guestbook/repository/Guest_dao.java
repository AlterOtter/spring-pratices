package com.poscoict.guestbook.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.poscoict.guestbook.vo.GuestbookVO;

@Repository
public class Guest_dao {
	public boolean insert(GuestbookVO vo) {
		boolean result = true;
		Connection conn = ConnectionDB.connect();
		try (PreparedStatement pstmt = conn.prepareStatement("INSERT INTO `webdb`.`guestbook` (`name`, `password`, `message`, `reg_date`) VALUES (?, ?, ?, now());");){
			pstmt.setString(1,vo.getName());
			pstmt.setString(2,vo.getPassword());
			pstmt.setString(3,vo.getMessage());
			pstmt.executeUpdate();			
		}catch(SQLException e){
			result = false;
			e.printStackTrace();
		}
		ConnectionDB.close(conn);
		return result;
	}
	
	

	public List<GuestbookVO> select() {
		List<GuestbookVO> volist = new ArrayList<>();
		Connection conn = ConnectionDB.connect();
		try (PreparedStatement pstmt = conn.prepareStatement("select * from guestbook order by no desc;");){
			ResultSet rs=pstmt.executeQuery();	
			while(rs.next()) {
				GuestbookVO vo =new GuestbookVO();
				vo.setNo(rs.getInt("no"));
				vo.setName(rs.getString("name"));
				vo.setPassword(rs.getString("password"));
				vo.setMessage(rs.getString("message"));
				vo.setReg_date(rs.getString("reg_date"));
			
				volist.add(vo);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		ConnectionDB.close(conn);
		return volist;
	}
	
	public boolean delete(GuestbookVO vo) {
		boolean result = true;
		Connection conn = ConnectionDB.connect();
		try (PreparedStatement pstmt = conn.prepareStatement("DELETE FROM `webdb`.`guestbook` WHERE (`no` = ? and `password`=?);");){
			pstmt.setInt(1, vo.getNo());
			pstmt.setString(2, vo.getPassword());
			pstmt.executeUpdate();	
			
		}catch(SQLException e){
			result =false;
			e.printStackTrace();
		}
		ConnectionDB.close(conn);
		return result;
	}
}
