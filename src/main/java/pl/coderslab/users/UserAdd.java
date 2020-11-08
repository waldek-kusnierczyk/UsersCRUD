package pl.coderslab.users;

import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/user/add")
public class UserAdd extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        UserDao userDao = new UserDao();
//        request.setAttribute("users", userDao.findAll());

        getServletContext().getRequestDispatcher("/users/add.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDao userDao = new UserDao();
        User user = new User();
        user.setUsername(userName);
        user.setEmail(email);
        user.setPassword(password);
        User createdUser = userDao.create(user);
        if (createdUser != null) {
        request.setAttribute("users", userDao.findAll());
            getServletContext().getRequestDispatcher("/users/list.jsp")
                    .forward(request, response);
        } else {
            response.getWriter().append("Problem z tworzeniem użytkownika");
        }


    }
}
