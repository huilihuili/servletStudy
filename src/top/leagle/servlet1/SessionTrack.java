package top.leagle.servlet1;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionTrack extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 如果不存在 session 会话，则创建一个 session 对象
		HttpSession session = request.getSession(true);
		// 获取 session 创建时间
		Date createTime = new Date(session.getCreationTime());
		// 获取该网页的最后一次访问时间
		Date lastAccessTime = new Date(session.getLastAccessedTime());

		// 设置日期输出的格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String title = "Servlet Session 实例 - 菜鸟教程";
		Integer visitCount = new Integer(0);
		String visitCountKey = new String("visitCount");
		String userIDKey = new String("userID");
		String userID = new String("Runoob");

		// 检查网页上是否有新的访问者
		if (session.getAttribute(userIDKey) == null) {
			title = "你好，新用户";
			session.setAttribute(userIDKey, userID);
		} else {
			visitCount = (Integer) session.getAttribute(visitCountKey);
			visitCount = visitCount + 1;
		}
		session.setAttribute(visitCountKey, visitCount);

		PrintWriter out = response.getWriter();

		String docType = "<!DOCTYPE html>\n";
		out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
				+ "<body bgcolor=\"#f0f0f0\">\n" + "<h1 align=\"center\">" + title + "</h1>\n"
				+ "<h2 align=\"center\">Session 信息</h2>\n" + "<table border=\"1\" align=\"center\">\n"
				+ "<tr bgcolor=\"#949494\">\n" + "  <th>Session 信息</th><th>值</th></tr>\n" + "<tr>\n" + "  <td>id</td>\n"
				+ "  <td>" + session.getId() + "</td></tr>\n" + "<tr>\n" + "  <td>创建时间</td>\n" + "  <td>"
				+ df.format(createTime) + "  </td></tr>\n" + "<tr>\n" + "  <td>最后访问时间</td>\n" + "  <td>"
				+ df.format(lastAccessTime) + "  </td></tr>\n" + "<tr>\n" + "  <td>用户 ID</td>\n" + "  <td>" + userID
				+ "  </td></tr>\n" + "<tr>\n" + "  <td>访问统计：</td>\n" + "  <td>" + visitCount + "</td></tr>\n"
				+ "</table>\n" + "</body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
