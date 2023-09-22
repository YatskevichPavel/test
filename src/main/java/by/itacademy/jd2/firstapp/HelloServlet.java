package by.itacademy.jd2.firstapp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet {
    @WebServlet(urlPatterns = "/hello_ses")
    public class HelloWithNameServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException {
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/plain; charset=utf-8");
            //resp.setHeader("Content-Type", "text/plain; charset=utf-8");

//            String firstName = req.getParameter("firstName");
//            String lastName = req.getParameter("lastName");

            HttpSession session = req.getSession();
            String firstName = (String) session.getAttribute("firstName");
            String lastName = (String) session.getAttribute("lastName");

            


            PrintWriter writer = resp.getWriter();
            writer.write(session.getMaxInactiveInterval());
            writer.write("Hello, " + lastName + " " + firstName + "!");
        }
    }
}
