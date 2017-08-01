package servlet;

import bean.Order;
import bean.OrderItem;
import bean.User;
import dao.OrderDAO;
import dao.OrderItemDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/1.
 */
public class OrderCreateServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User)req.getSession().getAttribute("user");
        if (null==user){
            resp.sendRedirect("/login.jsp");
            return;
        }

        Order order = new Order();
        order.setUser(user);

        //保存订单
        new OrderDAO().insert(order);

        List<OrderItem> orderItemList = (ArrayList<OrderItem>)req.getSession().getAttribute("orderitems");
        for (OrderItem oi:orderItemList
             ) {
            oi.setOrder(order);
            new OrderItemDAO().insert(oi);
        }

        //清除session中的数据
        orderItemList.clear();

        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().println("订单创建成功");
    }
}
