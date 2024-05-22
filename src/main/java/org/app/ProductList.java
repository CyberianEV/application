package org.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductList", urlPatterns = "/products")
public class ProductList extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(ProductList.class);
    private final String[][] products = {{"1", "Milk", "0.90"}, {"2", "Bread", "1.20"}, {"3", "Cheese", "3.10"},
            {"4", "Chicken", "5.95"}, {"5", "Eggs", "1.05"}, {"6", "Cucumber", "0.40"}, {"7", "Tomatoes", "0.85"},
            {"8", "Avocado", "2.10"}, {"9", "Rice", "0.90"}, {"10", "Beer", "1.20"}};

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("GET request received");
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().printf("<html><body>");
        for (int i = 0; i < products.length; i++) {
            Product product = new Product(products[i][0], products[i][1], products[i][2]);
            resp.getWriter().printf("<h1>%s  %s  -  %s</h1>", product.getId(), product.getTitle(), product.getCost());
        }
        resp.getWriter().printf("</body></html>");
        resp.getWriter().close();
    }

    @Override
    public void init() throws ServletException {
        logger.debug("Products servlet Init");
    }
}
