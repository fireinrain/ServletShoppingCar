package servlet;

import bean.Product;
import dao.ProductDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/7/31.
 */
public class ProductListServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = new ProductDAO().listProduct();
        //System.out.println(products.toString());
        resp.setCharacterEncoding("UTF-8");
        req.setAttribute("products",products);
        req.getRequestDispatcher("listProduct.jsp").forward(req,resp);
    }
}
