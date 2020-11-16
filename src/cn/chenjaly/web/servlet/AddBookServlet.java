package cn.chenjaly.web.servlet;

import cn.chenjaly.web.bean.Book;
import cn.chenjaly.web.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
    private  static final long serialVersionUID  = 1L;

    public AddBookServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        double price = Double.parseDouble(request.getParameter("price"));
        DBUtil<Book> dbUtil = new DBUtil<Book>();
        int i = dbUtil.update("insert into book value(null,?,?,?)",name,author,price);
        if (i>0){
            response.sendRedirect("BookListServlet");
        }
    }
}
