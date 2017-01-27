package edu.matc.controller;

import edu.matc.persistence.UserData;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
//import java.lang.System;
import org.apache.log4j.*;


/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet(
        urlPatterns = {"/searchUser"}
)

public class SearchUser extends HttpServlet {
    private final Logger logger = Logger.getLogger( this.getClass() );

    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType( "text/html" ) ;
        PrintWriter out = resp.getWriter();

        // log lastname entered on form (replaces System.out.println() )
        logger.info( "SearchUser.doGet() Search String = " + req.getParameter("inputLast") );
        // simple logging test of all the levels:
        logger.trace( "Trace Message!" );
        logger.debug( "Debug Message!" );
        logger.info( "Info Message!" );
        logger.warn( "Warn Message!" );
        logger.error( "Error Message!" );
        logger.fatal( "Fatal Message!" );

        UserData userData = new UserData();
        //TODO add "list all" button to form, or some other logic to dump all rows?
//        req.setAttribute("users", userData.getAllUsers() );
        req.setAttribute("users", userData.getUsersByLastName( req.getParameter("inputLast") ) );

        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }
}