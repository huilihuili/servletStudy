package top.leagle.servlet1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveCookie extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public SaveCookie() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 为名字和姓氏创建 Cookie
		Cookie name = new Cookie("name", request.getParameter("name")); // 中文转码
		Cookie url = new Cookie("url", request.getParameter("url"));

		// 为两个 Cookie 设置过期日期为 24 小时后
		name.setMaxAge(60 * 60 * 24);
		url.setMaxAge(60 * 60 * 24);

		// 在响应头中添加两个 Cookie
		response.addCookie(name);
		response.addCookie(url);

		// 设置响应内容类型
		response.setContentType("text/html;charset=UTF-8");
		System.out.println(request.getParameter("name"));
		PrintWriter out = response.getWriter();
		String title = "设置 Cookie 实例";
		String docType = "<!DOCTYPE html>\n";
		out.println(docType + "<html>\n" + "<head><meta charset=\"utf-8\"><title>" + title + "</title></head>\n"
				+ "<body bgcolor=\"#f0f0f0\">\n" + "<h1 align=\"center\">" + title + "</h1>\n" + "<ul>\n"
				+ "  <li><b>站点名：</b>：" + request.getParameter("name") + "\n</li>" + "  <li><b>站点 URL：</b>："
				+ request.getParameter("url") + "\n</li>" + "</ul>\n" + "</body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
