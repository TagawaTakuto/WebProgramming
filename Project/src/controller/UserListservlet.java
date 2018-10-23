package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Userdao;
import model.User;

/**
 * Servlet implementation class UserListservlet
 */
@WebServlet("/UserListservlet")
public class UserListservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserListservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);

		if(session.getAttribute("userInfo") == null) {
			response.sendRedirect("Login_servlet");
			return;
		}


		session.getAttribute("userInfo");
		Userdao userdao = new Userdao();
		List<User> userList = userdao.findAll();

		request.setAttribute("userList",userList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userlist.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		String loginId = request.getParameter("login_id");
		String Name = request.getParameter("name");
		String birthDateS = request.getParameter("date_start");
		String birthDateE = request.getParameter("date_end");
		Userdao userdao = new Userdao();
		List<User> userList = userdao.findSearch(loginId,Name,birthDateS,birthDateE);
		request.setAttribute("userList",userList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userlist.jsp");
		dispatcher.forward(request, response);
	}

}
