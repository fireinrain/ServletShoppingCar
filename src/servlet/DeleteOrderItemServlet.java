package servlet;

import bean.OrderItem;

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
public class DeleteOrderItemServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<OrderItem> orderItemList = (ArrayList<OrderItem>)req.getSession().getAttribute("orderitems");


        int OrderItemId = Integer.parseInt(req.getParameter("id"));
        for (OrderItem orderItem : orderItemList) {
            if (orderItem.getProduct().getId()==OrderItemId){
                orderItemList.remove(orderItem);
                break;
            }
        }
        req.getSession().setAttribute("orderitems",orderItemList);

        //req.getRequestDispatcher("listOrderItem.jsp").forward(req,resp);
        resp.sendRedirect("/listOrderItem.jsp");
    }
}
