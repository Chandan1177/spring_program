package com.agriconnect.servlet;

import java.io.IOException;

import com.agriconnect.dao.UserDAO;
import com.agriconnect.dto.UserDTO;
import com.agriconnect.dto.VendorDTO;
import com.agriconnect.encryption_dcryption.EncryptorDcryptor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginHandler extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String result = null;

		String role = (String) req.getParameter("type");

		switch (role) {
		case "vendor": {
			vendorLogin(req, resp);
			break;
		}
		case "user": {
			userLogin(req, resp);
			break;
		}

		}
	}

	private void userLogin(HttpServletRequest req, HttpServletResponse resp) {
		UserDAO dao = new UserDAO();
		UserDTO dto = new UserDTO();
		dto.setEmail(req.getParameter("Email"));
		dto.setPassword((String) req.getParameter("Password"));

		boolean isValid = dao.isRegisteredUser(dto);
		
		if(isValid) {
			//code for home page
		}else {
			//code for redirect
		}
	}

	private void vendorLogin(HttpServletRequest req, HttpServletResponse resp) {
		UserDAO dao = new UserDAO();
		VendorDTO dto = new VendorDTO();
		dto.setEmail(req.getParameter("Email"));
		dto.setPassword((String) req.getParameter("Password"));

		boolean isValid = dao.isRegisteredVendor(dto);
		
		if(isValid) {
			//code for home page
		}else {
			//code for redirect
		}
	}

}
