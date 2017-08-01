package servlet;

import bean.OrderItem;
import bean.Product;
import dao.ProductDAO;

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
public class OrderItemAddServlet  extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取提交提交的表单参数
        int num = Integer.parseInt(req.getParameter("num"));
        int pid = Integer.parseInt(req.getParameter("pid"));
        //System.out.println(num+"----"+pid);
        Product p = new ProductDAO().searchProduct(pid);

        OrderItem orderItem = new OrderItem();
        orderItem.setNum(num);
        orderItem.setProduct(p);

        List<OrderItem> orderItemList = (List<OrderItem>)req.getSession().getAttribute("orderitems");

        if (null==orderItemList){
            orderItemList = new ArrayList <OrderItem>();
            req.getSession().setAttribute("orderitems",orderItemList);
        }

        //是否购买已有的商品
        boolean found = false;
        for (OrderItem orderitem:orderItemList
             ) {
            //判断当前订单列表中是否有重复的订单
            if (orderitem.getProduct().getId()==orderItem.getProduct().getId()){
                orderitem.setNum(orderitem.getNum()+orderItem.getNum());
                found=true;
                break;
            }
        }

        if (!found){
            orderItemList.add(orderItem);
        }

        //System.out.println(orderItemList);
        resp.sendRedirect("/listOrderItem");
    }
}
