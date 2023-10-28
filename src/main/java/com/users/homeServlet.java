
package com.users;

import com.clothes_shop.dal.GenericDAO;
import com.clothes_shop.dal.impl.ProductDAO;
import com.clothes_shop.entity.Products;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class homeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        GenericDAO<Products> ProductDAO = new ProductDAO();
        HttpSession session = request.getSession();
        List<Products> listProduct = ProductDAO.findAll();
        //String Page = request.getParameter("Page");
        //switch (Page){
        //    case "":
                
        //        break;
        //    default:
                request.getRequestDispatcher("views/user/home_page/homePage.jsp").forward(request,response);
        //        break;
        //}
    } 

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       
    }


}
