package net.servlet.controller.Product;

import net.servlet.DaoSingleton;
import net.servlet.model.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListAllProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=utf-8");

        //Get all Products
        List<Product> products = DaoSingleton.getINSTANCE().getProductDAO().getAll();

        String finalLink =
                "<TABLE BORDER >" +
                        "<TR>" +
                        "<h2>LIST OF ALL PRODUCTS</h2>" +
                        "</TR>";

        //Print all products as link
        for (Product product : products) {
            String productText = product.getName();

            String editLinkProduct = "<a href=\"/editP?product_id=" + product.getId() + "\">EDIT</a>";

            String deleteLinkProduct = "<a href=\"/deleteP?product_id=" + product.getId() + "\">DELETE</a>";

            String showLinkProduct = "<a href=\"/product?product_id=" + product.getId() + "\">SHOW</a>";

            finalLink = finalLink +
                    "<TR height=\"50\">" +
                    "<TD ALIGN=\"center\" width=\"100\">" +
                    productText +
                    "</TD>" +
                    "<TD ALIGN=\"center\" width=\"100\">" +
                    editLinkProduct +
                    "</TD>" +
                    "<TD ALIGN=\"center\" width=\"100\">" +
                    deleteLinkProduct +
                    "</TD>" +
                    "<TD ALIGN=\"center\" width=\"100\">" +
                    showLinkProduct +
                    "</TD>" +
                    "</TR>";


        }
        finalLink = finalLink + "</TABLE>";
        resp.getWriter().println(finalLink);
        resp.getWriter().println("<br><br>");
        String addProductLink = "<form action=\"addP\">\n" +
                "<p><input type=\"submit\" value=\"Add new product\"></p>";

        String welcomePageText = "<a href=\"/welcome\">Welcome page</a>";

        resp.getWriter().println(addProductLink + "<br>" + welcomePageText);
    }
}
