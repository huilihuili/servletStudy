package top.leagle.servlet1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadCookies extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ReadCookies() {
		super();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookie = null;
		Cookie[] cookies = null;
		// 获取与该域相关的 Cookie 的数组
		cookies = request.getCookies();

		PrintWriter out = response.getWriter();
		String title = "Read Cookie Example";
		String docType = "<!DOCTYPE html>\n";
		out.println(
				docType + "<html>\n" + "<head><title>" + title + "</title></head>\n" + "<body bgcolor=\"#f0f0f0\">\n");
		if (cookies != null) {
			out.println("<h2>Cookie 名称和值</h2>");
			for (int i = 0; i < cookies.length; i++) {
				cookie = cookies[i];
				out.print("名称：" + cookie.getName() + "，");
				out.print("值：" + URLDecoder.decode(cookie.getValue(), "utf-8") + " <br/>");
			}
		} else {
			out.println("<h2 class=\"tutheader\">No Cookie founds</h2>");
		}
		out.println("</body>");
		out.println("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
