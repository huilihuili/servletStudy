package top.leagle.servlet1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Encode2 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		System.out.println("Encode init ...");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = "GET 编码测试";
		String name = req.getParameter("name");
		System.out.println(name);

		req.setAttribute("message", title + name);
		req.getServletContext().getRequestDispatcher("/message.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = "POST 编码测试";
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		System.out.println(name);

		req.setAttribute("message", title + name);
		req.getServletContext().getRequestDispatcher("/message.jsp").forward(req, resp);
	}
}
