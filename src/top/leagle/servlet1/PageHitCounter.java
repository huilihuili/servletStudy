package top.leagle.servlet1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageHitCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int hitCount;

	@Override
	public void init() {
		// 重置点击计数器
		hitCount = 0;
		System.out.println("hitCount ===> " + hitCount);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 增加 hitCount
		hitCount++;
		PrintWriter out = response.getWriter();
		String title = "总点击量";
		String docType = "<!DOCTYPE html> \n";
		out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
				+ "<body bgcolor=\"#f0f0f0\">\n" + "<h1 align=\"center\">" + title + "</h1>\n" + "<h2 align=\"center\">"
				+ hitCount + "</h2>\n" + "</body></html>");
	}

	@Override
	public void destroy() {
		// 这一步是可选的，但是如果需要，您可以把 hitCount 的值写入到数据库
	}

}