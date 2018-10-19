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
 * Servlet implementation class Userdelete
 */
@WebServlet("/Userdelete_servlet")
public class Userdelete_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Userdelete_servlet() {
        super();
    }
        // TODO Auto-generated constructor stub

     /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	request.setCharacterEncoding("UTF-8");

    	String Id = request.getParameter("id");

    	Userdao userdao = new Userdao();
    	User u = userdao.findByLoginId(Id);

    	HttpSession session =request.getSession();
		session.setAttribute("u",u);

    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_delete.jsp");
    	dispatcher.forward(request, response);

    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		String loginId = request.getParameter("login_id");

		Userdao userdao = new Userdao();
		userdao.UD(loginId);

		response.sendRedirect("UserListservlet");
	}

}
