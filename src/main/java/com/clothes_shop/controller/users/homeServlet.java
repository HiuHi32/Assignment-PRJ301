
package com.clothes_shop.controller.users;

import com.clothes_shop.constant.Constant;
import com.clothes_shop.dal.GenericDAO;
import com.clothes_shop.dal.impl.ProductDAO;
import com.clothes_shop.entity.PageControll;
import com.clothes_shop.entity.Products;
import java.io.IOException;
import java.io.PrintWriter;
import static java.util.Collections.list;
import java.util.List;
import javafx.scene.control.Pagination;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;


public class homeServlet extends HttpServlet {
     ProductDAO productDAO = new ProductDAO();
    
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //set enconding UTF-8
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
         PageControll pageControll = new PageControll();
        //get du lieu tu db len
        List<Products> listProduct = productDAO.findAll();
       
        //tao ra session
        HttpSession session = request.getSession();
        //get action
        String action = request.getParameter("action");
         try {
             action = request.getParameter("action");
             if (action == null) {
                 action = "";
             }
         } catch (Exception e) {
             action="";
         }
         switch (action) {
             case "pagination":
                 pagination(request,request, session, pageControll);
                 break;
             default:
                 listProduct = productDAO.findAll();
                 break;
         }
                
        request.setAttribute("listProduct", listProduct);
        request.setAttribute("pageControll", pageControll);
         System.out.println(pageControll);
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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String URL = "home";
       //get ra action
       String action = request.getParameter("action");
       //perform function corressponding action
        switch (action) {
            case "search":
                searchByName(request,response);
                URL = "views/user/home_page/homePage.jsp";
                break;
            default:
                throw new AssertionError();
        }
        request.getRequestDispatcher(URL).forward(request, response);
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) {
        //get ra keyword
        String keyword = request.getParameter("keyword");
        //tao ra productDAO
        //get product by name
        List<Products> list = productDAO.findContainsByProperty("productName", keyword);
        System.out.println(list);
        //set list vao trong session
        HttpSession session = request.getSession();
        session.setAttribute("listProduct", list);
    }

    private List<Products> pagination(HttpServletRequest request, HttpServletRequest request0, HttpSession session, PageControll pageControll) {
        //get page
        String pageRaw = request.getParameter("page");
        int page;
        try{
            page = Integer.parseInt(pageRaw);
        } catch(Exception e){
            page = 1;
        }
        //tim kiem xem co bao nhieu record
        int totalRecord = productDAO.findTotalRecord();
        //tim kiem xem co tong bao nhieu page
        int totalPage = (totalRecord % Constant.RECORD_PER_PAGE) == 0 ? //Toan tu 3 ngoi : dieu kien --> gia tri dung/sai
                (totalRecord / Constant.RECORD_PER_PAGE): 
                (totalRecord / Constant.RECORD_PER_PAGE) + 1;
        //set vao pageControll
        pageControll.setPage(page);
        return productDAO.findByPage(page);      
    }


}
