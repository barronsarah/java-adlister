import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LogoutServlet", urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {

  String logoutMessage;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.getSession().removeAttribute("user");
//      request.getSession().invalidate(); (use removeAttribute or invalidate)
      response.sendRedirect("/login");
  }

//  @Override
//  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//  }
}
