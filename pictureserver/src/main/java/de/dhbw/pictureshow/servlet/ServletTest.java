package de.dhbw.pictureshow.servlet;

import de.dhbw.pictureshow.database.Transaction;
import de.dhbw.pictureshow.database.dao.BildDao;
import de.dhbw.pictureshow.database.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Created by poetterm on 25.09.2014.
 */


import de.dhbw.pictureshow.database.Transaction;
        import de.dhbw.pictureshow.database.dao.BildDao;
        import de.dhbw.pictureshow.database.dao.UserDao;
        import de.dhbw.pictureshow.domain.Build;
        import de.dhbw.pictureshow.domain.User;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;

        import javax.inject.Inject;
        import javax.servlet.RequestDispatcher;
        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;
        import java.io.PrintWriter;
        import java.util.ArrayList;
        import java.util.Collection;
        import java.util.List;

/**
 *
 */
@WebServlet("/test")
public class ServletTest extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(UserServlet.class);

    @Inject
    UserDao userDao;
    @Inject
    Transaction transaction;
    @Inject
    BildDao bildDao;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("UserServlet get");

        transaction.begin();
        Collection<User> users = userDao.list();

        User user = new User();
        user.setName("User " + users.size());
        userDao.persist(user);

        response.setContentType("text/html");
        response.setBufferSize(8192);
        try (PrintWriter out = response.getWriter()) {
            out.println("<html lang=\"en\"><head><title>Servlet Hello</title></head>");

            // then write the data of the response
            out.println("<body  bgcolor=\"#ffffff\">"
                    + "<h2>Angemeldete User:</h2>");

            for (User u : users) {
                out.println(u + "<br/>");
                List<Build> bilder = bildDao.findByUser(user);
                for (Build b : bilder) {
                    out.println("------" + b.getTitel());

                }

                String username = request.getParameter("username");
                if (username != null && username.length() > 0) {
                    RequestDispatcher dispatcher =
                            getServletContext().getRequestDispatcher("/response");

                    if (dispatcher != null) {
                        dispatcher.include(request, response);
                    }
                }
                out.println("</body></html>");
            }
        }
    }
}
