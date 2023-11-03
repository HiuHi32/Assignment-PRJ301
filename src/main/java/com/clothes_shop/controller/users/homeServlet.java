package com.clothes_shop.controller.users;

import com.clothes_shop.constant.Constant;
import com.clothes_shop.dal.impl.ProductDAO;
import com.clothes_shop.entity.PageControll;
import com.clothes_shop.entity.Products;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class homeServlet extends HttpServlet {

    ProductDAO productDAO = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        //set enconding UTF-8
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PageControll pageControll = new PageControll();
        //get du lieu tu db len
        List<Products> listProduct = findProductDoGet(request, pageControll);

        session.setAttribute("listProduct", listProduct);
        request.setAttribute("pageControl", pageControll);
        request.getRequestDispatcher("views/user/home_page/homePage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    private List<Products> findProductDoGet(HttpServletRequest request, PageControll pageControl) {
        //get page
        String pageRaw = request.getParameter("page");
        //valid page
        int page;
        try {
            page = Integer.parseInt(pageRaw);
        } catch (NumberFormatException e) {
            page = 1;
        }

        List<Products> listProduct;
        //get về action:
        String action = request.getParameter("action") == null
                ? "defaultFindAll"
                : request.getParameter("action");
        //dựa theo giá trị action
        switch (action) {
            //tìm kiếm các quyển sách bằng từ khóa
            case "search":
                //get về keyword muốn tìm kiếm
                String keyword = request.getParameter("keyword");
                //tìm về các quyển sách dựa theo thuộc tính name và keyword muốn tìm kiếm
                listProduct = productDAO.findContainsByProperty("productName", keyword);
                break;
            //tìm về toàn bộ các quyển sách
            default:
                listProduct = productDAO.findAll();
                break;
        }
        //total Record
        int totalRecord = listProduct.size();
        //totalPage
        int totalPage = (totalRecord % Constant.RECORD_PER_PAGE) == 0
                ? (totalRecord / Constant.RECORD_PER_PAGE)
                : (totalRecord / Constant.RECORD_PER_PAGE) + 1;

        //set page vào pageControl
        pageControl.setPage(page);
        //set totalRecord vào pageControl
        pageControl.setTotalRecord(totalRecord);
        //set total page
        pageControl.setTotalPage(totalPage);
        return listProduct;
    }

}
