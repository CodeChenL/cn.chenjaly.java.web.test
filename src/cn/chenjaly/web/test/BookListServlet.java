package cn.chenjaly.web.test;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import java.util.List;

@WebServlet("/book")
public class BookListServlet extends HttpServlet{
    private static final long  serialVersionUID = 1L;
    public BookListServlet() {
        super();
    }
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        DBUtil<Book> dbUtil = new DBUtil<Book>();
        List<Book> bookList = dbUtil.query("select * from book");
        request.setAttribute("bookList",bookList);
        for (Book book : bookList) {
            System.out.println(book);
        }
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
