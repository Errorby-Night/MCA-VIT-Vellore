/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author srija
 */
@WebServlet(urlPatterns = {"/convert"})
public class convert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve client's name and location from cookies
        String clientName = null;
        String location = null;

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("clientName")) {
                    clientName = cookie.getValue();
                } else if (cookie.getName().equals("location")) {
                    location = cookie.getValue();
                }
            }
        }

        if (clientName == null || location == null) {
            // First visit or missing cookies: Display form to input name and location
            out.println("<h1>Welcome to our e-commerce web page</h1>");
            out.println("<form method='post'>");
            out.println("<label for='clientName'>Enter Your Name:</label>");
            out.println("<input type='text' id='clientName' name='clientName'><br><br>");
            out.println("<label for='location'>Enter Your Location:</label>");
            out.println("<input type='text' id='location' name='location'><br><br>");
            out.println("<input type='submit' value='Submit'>");
            out.println("</form>");
        } else {
            // Subsequent visits: Display personalized welcome message
            out.println("<h1>Hi " + clientName + " from " + location + "!! Welcome back..</h1>");
        }
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get user-input values for clientName and location
        String clientName = request.getParameter("clientName");
        String location = request.getParameter("location");

        // Set cookies with the provided values
        Cookie nameCookie = new Cookie("clientName", clientName);
        Cookie locationCookie = new Cookie("location", location);

        response.addCookie(nameCookie);
        response.addCookie(locationCookie);

        // Redirect to doGet for subsequent processing
        response.sendRedirect(request.getRequestURI());
	}

}
