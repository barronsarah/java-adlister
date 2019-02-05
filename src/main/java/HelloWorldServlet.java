import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//  the name in the servlet NEEDS to be the same as the class name
@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello-world")
  public class HelloWorldServlet extends HttpServlet {

  @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();

//      ASSIGNMENT 1:
//   Make the page say "Hello, <name>!" if name is passed as part of the query string (e.g. /hello?name=codeup), otherwise default to "Hello, World!".

    String name = request.getParameter("name");

    if(name == null){
      name = "World";
    }
      out.println("<h1>Hello, World!</h1>");
            }



    }
