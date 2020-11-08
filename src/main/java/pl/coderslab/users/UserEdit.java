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

@WebServlet("/user/edit")
public class UserEdit extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
//        request.setAttribute("users", userDao.findAll());
        String id = request.getParameter("id");

        User userToUpdate = userDao.read(Integer.parseInt(id));
        if (userToUpdate != null) {
//            request.setAttribute("id", id);
//            request.setAttribute("email", userToUpdate.getEmail());
//            request.setAttribute("username", userToUpdate.getUsername());
            request.setAttribute("userToUpdate", userToUpdate);
        }

        getServletContext().getRequestDispatcher("/users/edit.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws IOException {

        String id = request.getParameter("id");
        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDao userDao = new UserDao();
        User userToUpdate = new User();
        userToUpdate.setId(Integer.parseInt(id));
        userToUpdate.setUsername(userName);
        userToUpdate.setEmail(email);
        userToUpdate.setPassword(password);

        //System.out.println("userToUpdate: " + userToUpdate);

        userDao.update(userToUpdate);

        response.sendRedirect("/user/list");
    }

}
