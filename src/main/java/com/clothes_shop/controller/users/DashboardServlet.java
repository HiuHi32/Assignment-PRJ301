/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.clothes_shop.controller.users;

import com.clothes_shop.constant.Constant;
import com.clothes_shop.entity.Customer;
import com.clothes_shop.dal.impl.CustomerDAO;
import com.clothes_shop.dal.impl.OrderDAO;
import com.clothes_shop.dal.impl.OrderDetailsDAO;
import com.clothes_shop.entity.Order;
import com.clothes_shop.entity.OrderDetails;
import com.clothes_shop.entity.Products;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DashboardServlet extends HttpServlet {

    CustomerDAO customerDAO = new CustomerDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //set enconding UTF-8
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String page = request.getParameter("page") == null ? "" : request.getParameter("page");
        String url;
        //up    date lai account vao session
        HttpSession session = request.getSession();
        Customer account = (Customer) session.getAttribute(Constant.SESSION_CUSTOMER);
        if (account.getRoleId() == Constant.ROLE_ADMIN) {
            response.sendRedirect("admin/book");
            return;
        }
        setListPurchase(request, account);
        switch (page) {
            case "orderDetailsSearching":
                findListOrderDetails(request, response);
                url = "views/user/dashboard/orderDetailsSearching.jsp";
                break;
            default:
                url = "views/user/dashboard/dashboard.jsp";
                break;
        }
        request.getRequestDispatcher(url).forward(request, response);
    }

    private void setListPurchase(HttpServletRequest request, Customer customer) {
        OrderDAO orderDAO = new OrderDAO();
        List<Order> listOrder = orderDAO.findsByAccountId(customer.getId());
        HttpSession session = request.getSession();
        session.setAttribute("listOrder", listOrder);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //set enconding UTF-8
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String url = "";
        String action = request.getParameter("action") == null ? "" : request.getParameter("action");
        switch (action) {
            case "profile":
                updateProfileDoPost(request);
                url = "views/user/dashboard/profile.jsp";
                break;
            case "change-password":
                changePassword(request);
                url = "views/user/dashboard/change-password.jsp";
                break;
            default:
                url = "dashboard";
                break;
        }
        request.getRequestDispatcher(url).forward(request, response);
    }

    private void updateProfileDoPost(HttpServletRequest request) {
        String email = request.getParameter("email");
        String customername = request.getParameter("customerName");

        Customer customer = Customer.builder()
                .customerName(customername)
                .email(email)
                .build();
        customerDAO.updateProfile(customer);
        //update lai account vao session
        HttpSession session = request.getSession();
        Customer customerNew = (Customer) session.getAttribute(Constant.SESSION_CUSTOMER);
        customerNew.setEmail(email);
        session.setAttribute(Constant.SESSION_CUSTOMER, customerNew);

    }

    private void changePassword(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String newPassword = request.getParameter("newPassword");

        //lay ve account tu trong session
        HttpSession session = request.getSession();
        Customer accountSession = (Customer) session.getAttribute(Constant.SESSION_CUSTOMER);

        //kiem tra xem password co = password o trong session
        if (password.equals(accountSession.getPassword())) {
            customerDAO.updatePassword(username, password);
            accountSession.setPassword(password);
            session.setAttribute(Constant.SESSION_CUSTOMER, accountSession);
        } else {
            request.setAttribute("error", "Incorrect password");
        }
    }

    private void findListOrderDetails(HttpServletRequest request, HttpServletResponse response) {
        //get orderId
        int orderId = Integer.parseInt(request.getParameter("id"));
        
        //find List order details by order id
        List<OrderDetails> listOrderDetails = new OrderDetailsDAO().findByOrderId(orderId);
        //get list product tu sesison
        HttpSession session = request.getSession();
        List<Products> listProduct = (List<Products>) session.getAttribute("listProduct");
        //tao ra hashmap: key-OrderDetails - Value: Product
        Map<OrderDetails, Products> map = new LinkedHashMap<>();
        //them gia tri vao hashmap
        map = addMap(map, listOrderDetails, listProduct);
        //set vao request
        System.out.println(map);
        session.setAttribute("map", map);
    }

    private Map<OrderDetails, Products> addMap(Map<OrderDetails, Products> map,
            List<OrderDetails> listOrderDetails, List<Products> listProduct) {
        for (OrderDetails od : listOrderDetails) {
            for (Products products : listProduct) {
                if (od.getProductId() == products.getProductID()) {
                    map.put(od, products);
                }
            }
        }
        return map;
    }

}
