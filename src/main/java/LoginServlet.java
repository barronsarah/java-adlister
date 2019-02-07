import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession ourSession = request.getSession();

        if(ourSession.getAttribute("user") !=null
//                && (Boolean)ourSession.getAttribute("user")==true
        ){
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean validAttempt = username.equals("admin") && password.equals("password");

        HttpSession ourSession = request.getSession();
        if (validAttempt) {
            ourSession.setAttribute("user", username);
            response.sendRedirect("/profile");

        } else {
            response.sendRedirect("/login");
//            ourSession.setAttribute("null", false);
        }
    }
}

//    In your LoginServlet, when a user successfully logs in, set a key named "user" in the session.
//    Use this key to redirect unauthorized users that try to visit the /profile page.
//    If a user is already logged in and they visit /login, instead redirect them to their profile page