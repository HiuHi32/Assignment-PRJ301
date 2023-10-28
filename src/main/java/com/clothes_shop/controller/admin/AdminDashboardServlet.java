/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package com.clothes_shop.controller.admin;

import com.clothes_shop.dal.GenericDAO;
import com.clothes_shop.dal.impl.ProductDAO;
import com.clothes_shop.entity.Products;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Huu Huy
 */
public class AdminDashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        GenericDAO<Products> productDAO = new ProductDAO();
        //GenericDAO<Category> categoryAO = new CategoryDAO();

        //tạo ra session
        HttpSession session = request.getSession();

        //get dữ liệu từ DB lên
        List<Products> listProduct = productDAO.findAll();
        //List<Category> listCategory = categoryAO.findAll();
        System.out.println(listProduct);
        //set listBook vaof session
        session.setAttribute("listProduct", listProduct);
        //session.setAttribute("listCategory", listCategory);
        request.getRequestDispatcher("../views/admin/dashboard/dashboard.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    }
}
