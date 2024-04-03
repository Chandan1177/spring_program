package com.agriconnect.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.agriconnect.dto.UserDTO;
import com.agriconnect.dto.VendorDTO;
import com.agriconnect.encryption_dcryption.EncryptorDcryptor;
import com.agriconnect.util.ConnectionFactory;

public class UserDAO {

	public boolean saveUser(UserDTO userDTO) {		
		Connection con=ConnectionFactory.getConnection();
		String query="INSERT INTO tbl_user (FirstName, MiddleName,LastName,Address,Email,Mobile,Gender,Age,Password)"
				+ " VALUES (?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt= con.prepareStatement(query);
			pstmt.setString(1, userDTO.getFirstName());
			pstmt.setString(2, userDTO.getMiddleName());
			pstmt.setString(3, userDTO.getLastName());
			pstmt.setString(4, userDTO.getAddress());
			pstmt.setString(5, userDTO.getEmail());
			pstmt.setString(6, userDTO.getMobile());
			pstmt.setString(7, userDTO.getGender());
			pstmt.setString(8, userDTO.getAge());
			pstmt.setString(9, EncryptorDcryptor.encodePassword(userDTO.getPassword()));
			
			return pstmt.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean isRegisteredUser(UserDTO dto) {
		Connection con=ConnectionFactory.getConnection();
		String query="select password from tbl_user where email=?";
		try {
			PreparedStatement pstmt= con.prepareStatement(query);
			pstmt.setString(1, dto.getEmail());
			
			ResultSet rs=pstmt.executeQuery();
			rs.next();
			return (EncryptorDcryptor.verifyPassword(dto.getPassword(),rs.getString("Password")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean isRegisteredVendor(VendorDTO dto) {
		Connection con=ConnectionFactory.getConnection();
		String query="select * from tbl_vendor where email=?";
		try {
			PreparedStatement pstmt= con.prepareStatement(query);
			pstmt.setString(1, dto.getEmail());
			
			ResultSet rs=pstmt.executeQuery();
			
			rs.next();
			return (EncryptorDcryptor.verifyPassword(dto.getPassword(),rs.getString("Password")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean saveVendor(VendorDTO dto) {
		Connection con=ConnectionFactory.getConnection();
		String query="INSERT INTO tbl_vendor (FirstName, MiddleName,LastName,Address,Email,Mobile,Age,Password,role)"
				+ " VALUES (?, ?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt= con.prepareStatement(query);
			pstmt.setString(1, dto.getFirstName());
			pstmt.setString(2, dto.getMiddleName());
			pstmt.setString(3, dto.getLastName());
			pstmt.setString(4, dto.getAddress());
			pstmt.setString(5, dto.getEmail());
			pstmt.setString(6, dto.getMobile());
			pstmt.setString(7, dto.getAge());
			pstmt.setString(8, EncryptorDcryptor.encodePassword(dto.getPassword()));
			pstmt.setString(9, dto.getRole());
			
			return pstmt.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
