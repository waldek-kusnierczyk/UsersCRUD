package pl.coderslab.users;

import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user/delete")
public class UserDelete extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        String id = request.getParameter("id");

        User userToDelete = userDao.read(Integer.parseInt(id));
        if (userToDelete != null) {
            request.setAttribute("userToDelete", userToDelete);
        }

        getServletContext().getRequestDispatcher("/users/delete.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String type = request.getParameter("submitType");

        if ("ok".equals(type)) {
            String id = request.getParameter("id");
            UserDao userDao = new UserDao();
            userDao.delete(Integer.parseInt(id));
        }

        response.sendRedirect("/user/list");
    }

}
