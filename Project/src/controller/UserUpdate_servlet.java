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
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/UserUpdate_servlet")
public class UserUpdate_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdate_servlet() {
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_update.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");

		System.out.println(id);

		String nameData = request.getParameter("name");

		String birthDate = request.getParameter("birth_date");

		String Password = request.getParameter("password");

		Userdao userdao = new Userdao();
		User update = userdao.findByUser(nameData, birthDate, Password);

		if( update == null) {
			request.setAttribute("errMsg", "入力された内容が正しくありません。");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_update.jsp");
			dispatcher.forward(request, response);
			return;
		}

	}

}
