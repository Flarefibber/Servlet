package net.servlet.controller.Manufacturer;

import net.servlet.DaoSingleton;
import net.servlet.model.Manufacturer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListAllManufacturerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");

        //Get all Manufacturer
        List<Manufacturer> manufacturers = DaoSingleton.getINSTANCE().getManufacturerDAO().getAll();

        String finalLink =
                "<TABLE BORDER >" +
                        "<TR>" +
                        "<h2>LIST OF ALL MANUFACTURERS</h2>" +
                        "</TR>";

        //Print all manufacturers as link
        for (Manufacturer manufacturer : manufacturers) {
            String manufacturerText = manufacturer.getName();

            String editLinkManufacturer = "<a href=\"/editM?manufacturer_id=" + manufacturer.getId() + "\">EDIT</a>";

            String deleteLinkManufacturer = "<a href=\"/deleteM?manufacturer_id=" + manufacturer.getId() + "\">DELETE</a>";

            String showLinkManufacturer = "<a href=\"/manufacturer?manufacturer_id=" + manufacturer.getId() + "\">SHOW</a>";

            finalLink = finalLink +
                    "<TR height=\"50\">" +
                    "<TD ALIGN=\"center\" width=\"100\">" +
                    manufacturerText +
                    "</TD>" +
                    "<TD ALIGN=\"center\"width=\"100\">" +
                    editLinkManufacturer +
                    "</TD>" +
                    "<TD ALIGN=\"center\"width=\"100\">" +
                    deleteLinkManufacturer +
                    "</TD>" +
                    "<TD ALIGN=\"center\"width=\"100\">" +
                    showLinkManufacturer +
                    "</TD>" +
                    "</TR>";

        }
        finalLink = finalLink +"</TABLE>";
        resp.getWriter().println(finalLink);
        resp.getWriter().println("<br><br>");
        String addManufacturerLink = "<form action=\"addM\">\n" +
                "<p><input type=\"submit\" value=\"Add new manufacturer\"></p>";

        String welcomePageText = "<a href=\"/welcome\">Welcome page</a>";

        resp.getWriter().println(addManufacturerLink + "<br>" + welcomePageText);

    }

}
