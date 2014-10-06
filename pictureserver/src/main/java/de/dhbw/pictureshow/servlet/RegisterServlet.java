package de.dhbw.pictureshow.servlet;

import de.dhbw.pictureshow.database.Transaction;
import de.dhbw.pictureshow.database.dao.BildDao;
import de.dhbw.pictureshow.database.dao.UserDao;
import de.dhbw.pictureshow.domain.User;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

/**
 * Created by poetterm on 28.09.2014.
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Inject
    UserDao userDao;
    @Inject
    Transaction transaction;
    @Inject
    BildDao bildDao;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        transaction.begin();
        Collection<User> users = userDao.list();

        User user = new User();
        user.setName(request.getParameter("user"));
        user.setEmail(request.getParameter("email"));
        user.setNachname(request.getParameter("nachname"));
        user.setVorname(request.getParameter("vorname"));
        user.setPassword(request.getParameter("password"));
        userDao.persist(user);


       transaction.commit();




       PrintWriter out = response.getWriter();
        String title = "Herzlich Willkommen! Sie haben sich erfolgreich bei MixMaPix registriert";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " +
                        "transitional//en\">\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +

                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "  <li><b>Vorname</b>: "
                + request.getParameter("vorname") + "\n" +
                "  <li><b>Nachname</b>: "
                + request.getParameter("nachname") + "\n" +
                "<li><b>E-mail</b>: "
                + request.getParameter("email") + "\n" +
                 "<li><b>Benutzername</b>: "
                + request.getParameter("user") + "\n" +
                "</ul>\n" +
                "</body></html>");

    }
}

