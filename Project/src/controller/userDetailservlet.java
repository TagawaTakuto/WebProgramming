package controller;

import java.io.IOException;

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
 * Servlet implementation class userDetailservlet
 */
@WebServlet("/userDetailservlet")
public class userDetailservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public userDetailservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");

		System.out.println(id);


		Userdao userdao = new Userdao();
		User userd= userdao.findByLoginId(id);


		HttpSession session =request.getSession();
		session.setAttribute("userd",userd);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_page.jsp");
		dispatcher.forward(request, response);


	}
}
