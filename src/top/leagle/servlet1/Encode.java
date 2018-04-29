package top.leagle.servlet1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Encode extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		System.out.println("Encode init ...");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = "GET 编码测试";
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		System.out.println(name);

		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		String docType = "<!DOCTYPE html>\n";
		out.println(
				docType + "<html>\n" + "<head><title>" + title + "</title></head>\n" + "<body bgcolor=\"#f0f0f0\">\n"
						+ "<h1 align=\"center\">" + title + "</h1>\n" + "<p>你的名字是：" + name + "</p>\n");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = "POST 编码测试";
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		System.out.println(name);

		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		String docType = "<!DOCTYPE html>\n";
		out.println(
				docType + "<html>\n" + "<head><title>" + title + "</title></head>\n" + "<body bgcolor=\"#f0f0f0\">\n"
						+ "<h1 align=\"center\">" + title + "</h1>\n" + "<p>你的名字是：" + name + "</p>\n");
	}
}
