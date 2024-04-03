package com.agriconnect.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;

import com.agriconnect.dao.UserDAO;
import com.agriconnect.dto.UserDTO;
import com.agriconnect.dto.VendorDTO;
import com.agriconnect.encryption_dcryption.EncryptorDcryptor;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterationHandler extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
				
		String result = null;
		
		String role = (String) req.getParameter("type");
		
		switch (role) {
		case "vendor": {
			result = vendorRegistration(req, resp);
			break;
		}
		case "user": {
			result = userRegistration(req, resp);
			break;
		}

		}

	}

	private String vendorRegistration(HttpServletRequest req, HttpServletResponse resp) {
		UserDAO dao = new UserDAO();
		VendorDTO dto = new VendorDTO();

		dto.setFirstName((String) req.getParameter("FirstName"));
		dto.setMiddleName((String) req.getParameter("MiddleName"));
		dto.setLastName((String) req.getParameter("LastName"));

		dto.setPassword(req.getParameter("Password"));

		dto.setAge((String) req.getParameter("Age"));
		dto.setMobile((String) req.getParameter("Mobile"));
		dto.setAddress((String) req.getParameter("Address"));
		dto.setEmail((String) req.getParameter("Email"));
		dto.setRole((String) req.getParameter("role"));

		boolean isRegistered = dao.isRegisteredVendor(dto);

		return isRegistered ? "Email address is already registered."
				: dao.saveVendor(dto) ? "Congratulations! Your account has been successfully registered."
						: "Oops! Something went wrong. Please try again later.";
	}

	private String userRegistration(HttpServletRequest req, HttpServletResponse resp) {
		UserDAO dao = new UserDAO();
		UserDTO dto = new UserDTO();
		
		dto.setFirstName((String) req.getParameter("FirstName"));
		dto.setMiddleName((String) req.getParameter("MiddleName"));
		dto.setLastName((String) req.getParameter("LastName"));

		dto.setPassword((String) req.getParameter("Password"));

		dto.setGender((String) req.getParameter("Gender"));
		dto.setAge((String) req.getParameter("Age"));
		dto.setMobile((String) req.getParameter("Mobile"));
		dto.setAddress((String) req.getParameter("Address"));
		dto.setEmail((String) req.getParameter("Email"));

		boolean isRegistered = dao.isRegisteredUser(dto);

		return isRegistered ? "Email address is already registered."
				: dao.saveUser(dto) ? "Congratulations! Your account has been successfully registered."
						: "Oops! Something went wrong. Please try again later.";
	}

}
