package pl.coderslab.users;

import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

@WebServlet("/user/add")
public class UserAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        UserDao userDao = new UserDao();
//        request.setAttribute("users", userDao.findAll());
        String errMsg = request.getParameter("errMsg");
        if (!isEmpty(errMsg)) {
            request.setAttribute("errMsg", errMsg);
        }

        getServletContext().getRequestDispatcher("/users/add.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (!isEmpty(userName) && !isEmpty(email) && !isEmpty(password)) {
            UserDao userDao = new UserDao();
            User user = new User();
            user.setUsername(userName);
            user.setEmail(email);
            user.setPassword(password);
            User createdUser = userDao.create(user);
            if (createdUser != null) {
                //request.setAttribute("users", userDao.findAll());
                //getServletContext().getRequestDispatcher("/users/list.jsp")
                //        .forward(request, response);
                response.sendRedirect(request.getContextPath() + "/user/list");
            } else {
                String message = "Problem podczas dodawania użytkownika. Popraw dane!";
                //response.sendRedirect(request.getContextPath() + "?errMsg=\"Problem podczas dodawania użytkownika\"");
                response.sendRedirect(request.getContextPath() + "?errMsg=" + URLEncoder.encode(message, StandardCharsets.UTF_8));
            }
        }


    }

    boolean isEmpty(String text) {
        return text == null || "".equals(text);
    }
}
