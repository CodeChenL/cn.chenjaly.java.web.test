package cn.chenjaly.web.servlet;

import cn.chenjaly.web.bean.Book;
import cn.chenjaly.web.util.DBUtil;
import jdk.internal.org.objectweb.asm.commons.SerialVersionUIDAdder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteBookServlet")
public class DeleteBookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteBookServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        DBUtil<Book> dbUtil = new DBUtil<Book>();
        dbUtil.update("delete from book where id = ?",id);
        response.sendRedirect("BookListServlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
