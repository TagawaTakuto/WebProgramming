package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Userdao;
import model.User;



/**
 * Servlet implementation class UserCreate_servlet
 */
@WebServlet("/UserCreate_servlet")
public class UserCreate_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCreate_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/create_user.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		String loginId = request.getParameter("login_id");

		String Password = request.getParameter("password");

		String Kpass = request.getParameter("kakuninpassword");

		String nameData = request.getParameter("name");

		String birthDate =request.getParameter("birth_date");


		Userdao userdao = new Userdao();
		User newdata = userdao.findByNew(loginId,Password,nameData, birthDate);

		if( newdata == null && Kpass != Password) {
			request.setAttribute("errMsg", "入力された内容が正しくありません。");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/create_user.jsp");
			dispatcher.forward(request, response);
			return;
		}

		userdao.CU(loginId,nameData,birthDate,Password);

		response.sendRedirect("UserListservlet");

		}

	}


