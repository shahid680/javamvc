package controller;

import dao.UserDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;


public class loginservlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {


        // Response Object
        response.setContentType("text/html;charset=UTF-8");


        try {

            // Request Object
            String username = request.getParameter("usr");
            String password = request.getParameter("pswd");


            // Calling DAO
            UserDAO dao = new UserDAO();

            User myuser = dao.login(username, password);


            if(myuser != null)
            {

                // ----------------------------
                // Session Object
                // ----------------------------
                HttpSession session = request.getSession();

                session.setAttribute("myusr",
                        myuser.getUsername());

                session.setAttribute("mypassword",
                        myuser.getPassword());



                // ----------------------------
                // Application Object
                // ServletContext
                // Count visitors
                // ----------------------------

                ServletContext application =
                        getServletContext();


                Integer count =
                    (Integer)application.getAttribute("visitorCount");


                if(count == null)
                {
                    count = 0;
                }


                count++;


                application.setAttribute(
                        "visitorCount",
                        count);



                // ----------------------------
                // ServletConfig Object
                // Read course name
                // ----------------------------

                ServletConfig config =
                        getServletConfig();


                String courseName =
                    config.getInitParameter("courseName");


                request.setAttribute(
                        "course",
                        courseName);



                // Forward to welcome page

                RequestDispatcher rd =
                    request.getRequestDispatcher("welcome.jsp");


                rd.forward(request, response);



            }
            else
            {

                // Invalid login

                request.setAttribute(
                        "error",
                        "Invalid Username or Password");


                RequestDispatcher rd =
                    request.getRequestDispatcher("login.jsp");


                rd.forward(request,response);

            }



        }
        catch(Exception e)
        {

            // Send error page

            request.setAttribute(
                    "errorMessage",
                    e.getMessage());


            RequestDispatcher rd =
                    request.getRequestDispatcher("error.jsp");


            rd.forward(request,response);

        }

    }



    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request,response);

    }



    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request,response);

    }



    @Override
    public String getServletInfo() {

        return "Login Servlet with JSP implicit objects demonstration";

    }

}