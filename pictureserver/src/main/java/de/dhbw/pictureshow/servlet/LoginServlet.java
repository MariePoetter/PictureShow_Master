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
import javax.servlet.http.HttpSession;
import java.io.IOException;
        import java.io.PrintWriter;
        import java.util.Collection;


/**
 * Created by poetterm on 02.10.2014.
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

    @Inject
    UserDao userDao;
    @Inject
    Transaction transaction;
    @Inject
    BildDao bildDao;



    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        transaction.begin();


        // Hier werden die Parameter aus dem Formular entgegengenommen
        String eingegebenerName = request.getParameter("user");
        String eingegebenesPasswort = request.getParameter("password");
        System.out.println(eingegebenerName);
        System.out.println(eingegebenesPasswort);
        System.out.println(userDao.findePasswort(eingegebenerName));

        //Hier wird geprüft, ob das Passwort richtig war
        if (eingegebenesPasswort.equals(userDao.findePasswort(eingegebenerName))) {

            HttpSession s = request.getSession(true);
            s.setAttribute("loggedin", true);
            s.setAttribute("userID", eingegebenerName);

            PrintWriter out = response.getWriter();
            String title = "Sie haben sich erfolgreich bei MixMaPix angemeldet";
            String docType =
                    "<!doctype html public \"-//w3c//dtd html 4.0 " +
                            "transitional//en\">\n";
            out.println(docType +
                    "<html>\n" +
                    "<head><title>" + title + "</title></head>\n" +
                    "<body bgcolor=\"#f0f0f0\">\n" +

                    "<h1 align=\"center\">" + title + "</h1>\n" +
                    "<ul>\n" +

                    "<li><b>Benutzername</b>: "
                    + request.getParameter("user") + "\n" +
                    "</ul>\n" +
                    "</body></html>");



            request.setAttribute("servletName", "servletToJsp");

            try {
                getServletConfig().getServletContext().getRequestDispatcher(
                        "/Verzeichnis.jsp").forward(request, response);

            } catch (ServletException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        else {
            HttpSession s = request.getSession(true);
            s.setAttribute("loggedin", false);

            PrintWriter out = response.getWriter();
            String title = "Leider konnte kein Login durchgeführt werden";
            String docType =
                    "<!doctype html public \"-//w3c//dtd html 4.0 " +
                            "transitional//en\">\n";
            out.println(docType +
                    "<html>\n" +
                    "<head><title>" + title + "</title></head>\n" +
                    "<body bgcolor=\"#f0f0f0\">\n" +

                    "<h1 align=\"center\">" + title + "</h1>\n" +
                    "<ul>\n" +
                    "</body></html>");

        }
        transaction.commit();
    }




}




