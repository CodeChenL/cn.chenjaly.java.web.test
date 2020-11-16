package cn.chenjaly.web.servlet;

import cn.chenjaly.web.bean.Book;
import cn.chenjaly.web.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/GetBookByIdServlet")
public class GetBookByIdServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        DBUtil<Book> dbUtil = new DBUtil<Book>();
        List<Book> query = dbUtil.query("select * from book where id = ?",id);
        if (!query.isEmpty()){
            Book book = query.get(0);
            request.setAttribute("book",book);
            request.getRequestDispatcher("update.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
