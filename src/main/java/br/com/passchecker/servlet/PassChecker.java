package br.com.passchecker.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.passchecker.servlet.PassStrengthResponse;

@WebServlet("/check")
public class PassChecker extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PassChecker() {
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		validate(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		validate(request, response);
	}

	protected void validate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pass = request.getParameter("pass");
		if (pass != null) {
			response.setContentType("text/html");
			response.getWriter().write(calculateComplexity(pass));
		}
	}

	private String calculateComplexity(String pass) {
		PassStrengthResponse passResponse = new PassStrengthResponse(pass);
		return new Gson().toJson(passResponse);
	}

}
