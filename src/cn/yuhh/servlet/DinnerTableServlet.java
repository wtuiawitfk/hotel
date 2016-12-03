package cn.yuhh.servlet;

import cn.yuhh.entity.DinnerTable;
import cn.yuhh.factory.BeanFactory;
import cn.yuhh.service.impl.DinnerTableService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Brill on 2016/12/3.
 */
@WebServlet(name = "DinnerTableServlet", urlPatterns = "DinnerTableServlet")

public class DinnerTableServlet extends HttpServlet {
    private static DinnerTableService service = BeanFactory.getInstance("DinnerTableService", DinnerTableService.class);

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        List<DinnerTable> tables = service.query();
        //把查询得到的数据传到域对象中
        config.getServletContext().setAttribute("table", tables);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("type/html,charset=utf-8");
    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<DinnerTable> list = service.query();
        request.setAttribute("list", list);

        //将信息交到前台进行显示
        request.getServletContext().setAttribute("list", list);
        //跳转
        request.getRequestDispatcher("/sys/board/boardList.jsp").forward(request, response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tableName = request.getParameter("tableName");
        if (tableName != null) {
            DinnerTable dt = new DinnerTable();
            dt.setTableName(tableName);
            service.add(dt);
            list(request, response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        service.delete(Integer.parseInt(id));
        list(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        service.changeState(Integer.parseInt(id));
        list(request, response);
    }
}
