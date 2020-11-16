package cn.chenjaly.web.servlet;

import cn.chenjaly.web.bean.Book;
import cn.chenjaly.web.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateBookServlet")
public class UpdateBookServlet extends HttpServlet {
    private  static final long serialVersionUID  = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        int id = Integer.parseInt(request.getParameter("id"));
        String author = request.getParameter("author");
        double price = Double.parseDouble(request.getParameter("price"));
        System.out.println(11);
        DBUtil<Book> dbUtil = new DBUtil<Book>();
        System.out.println(111);
        int i = dbUtil.update("update book set name = ?,author = ?,price = ? where id = ?",name,author,price,id);
        response.sendRedirect("BookListServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
