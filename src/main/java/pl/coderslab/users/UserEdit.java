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
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet("/user/edit")
public class UserEdit extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setAttribute("users", userDao.findAll());
        String id = request.getParameter("id");
        String errMsg = request.getParameter("errMsg");
        if (!isEmpty(errMsg)) {
            request.setAttribute("errMsg", errMsg);
        }
        if (!isEmpty(id)) {
            UserDao userDao = new UserDao();
            User userToUpdate = userDao.read(Integer.parseInt(id));
            if (userToUpdate != null) {
//            request.setAttribute("id", id);
//            request.setAttribute("email", userToUpdate.getEmail());
//            request.setAttribute("username", userToUpdate.getUsername());
                request.setAttribute("userToUpdate", userToUpdate);
            }
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

        if (!isEmpty(id) && !isEmpty(userName) && !isEmpty(email) && !isEmpty(password)) {
            UserDao userDao = new UserDao();
            User userToUpdate = new User();
            userToUpdate.setId(Integer.parseInt(id));
            userToUpdate.setUsername(userName);
            userToUpdate.setEmail(email);
            userToUpdate.setPassword(password);
            //System.out.println("userToUpdate: " + userToUpdate);

            int updatedUsers = userDao.update(userToUpdate);

            if (updatedUsers > 0) {
                response.sendRedirect("/user/list");
            } else {
                String message = "Problem podczas edycji użytkownika. Popraw dane!";
                response.sendRedirect(request.getContextPath() + "?id="+id+"&errMsg=" + URLEncoder.encode(message, StandardCharsets.UTF_8));
            }
        }


    }

    boolean isEmpty(String text) {
        return text == null || "".equals(text);
    }

}
