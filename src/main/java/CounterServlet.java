import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

  @WebServlet(name = "CounterServlet", urlPatterns = "/counter")

public class CounterServlet extends HttpServlet {
  private int counter = 0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

      String reset = request.getParameter("reset");
      if(reset == null) {
        counter +=1;
      } else {
        counter = 0;
      }
    response.getWriter().println("<h1>The count is " + counter + ".</h1>");
    }
  }
