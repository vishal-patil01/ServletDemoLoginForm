package com.servletdemo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        description = "Login Servlet Testing",
        urlPatterns = {"/LoginServlet"},
        initParams = {
                @WebInitParam(name = "userName", value = "Vishal"),
                @WebInitParam(name = "password", value = "BridgeLab")
        }
)
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName=request.getParameter("userName");
        String pwd=request.getParameter("password");

        String userId=getServletConfig().getInitParameter("userName");
        String password=getServletConfig().getInitParameter("password");
        if (userId.equals(userName) && password.equals(pwd)){
            request.setAttribute("userName",userName);
            request.getRequestDispatcher("/LoginSuccess.jsp").forward(request,response);
        }
        else {
            RequestDispatcher rd=getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out=response.getWriter();
            out.println("<font color=red> Either User Name Or Password Is Wrong</font>");
            rd.include(request,response);
        }
    }
}
