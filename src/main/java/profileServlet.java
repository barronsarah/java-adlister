import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;


@WebServlet(name="profileServlet", urlPatterns ="/profile")
public class profileServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    request.getRequestDispatcher("/profile.jsp").forward(request,response);
  }
}
