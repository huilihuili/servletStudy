package top.leagle.servlet1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckBox extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String title = "读取复选框数据";
		String docType = "<!DOCTYPE html> \n";
		out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
				+ "<body bgcolor=\"#f0f0f0\">\n" + "<h1 align=\"center\">" + title + "</h1>\n" + "<ul>\n"
				+ "  <li><b>菜鸟按教程标识：</b>: " + request.getParameter("runoob") + "\n" + "  <li><b>Google 标识：</b>: "
				+ request.getParameter("google") + "\n" + "  <li><b>淘宝标识：</b>: " + request.getParameter("taobao") + "\n"
				+ "</ul>\n" + "</body></html>");
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
