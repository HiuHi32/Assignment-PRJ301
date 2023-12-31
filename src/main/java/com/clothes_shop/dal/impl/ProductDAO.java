/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clothes_shop.dal.impl;

import com.clothes_shop.constant.Constant;
import com.clothes_shop.dal.GenericDAO;
import com.clothes_shop.entity.Products;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Huu Huy
 */
public class ProductDAO extends GenericDAO<Products> {

    @Override
    public List<Products> findAll() {
        List<Products> list = queryGenericDAO(Products.class);
        return list;
    }

    public List<Products> findByProperty(String property, Object value) {
        String sql = "select * from Products\n"
                + " where " + property + "=?";

        parameterMap = new LinkedHashMap<>();
        parameterMap.put("property", value);
        List<Products> list = queryGenericDAO(Products.class, sql, parameterMap);
        return list;
    }

    public static void main(String[] args) {
        for (Products product : new ProductDAO().findAll()) {
            System.out.println(product);
        }
        System.out.println("=================");
        System.out.println(new ProductDAO().findByProperty("productID", 1));
    }

    @Override
    public int insert(Products products) {
        String sql = "INSERT INTO [dbo].[Products]\n"
                + "           ([typeID]\n"
                + "           ,[productName]\n"
                + "           ,[price]\n"
                + "           ,[stockQuantity]\n"
                + "           ,[image])\n"
                + "     VALUES\n"
                + "           (?, ?, ? ,? , ?)";
        parameterMap.put("typeID", products.getTypeID());
        parameterMap.put("productName", products.getProductName());
        parameterMap.put("price", products.getPrice());
        parameterMap.put("stockQuantity", products.getStockQuantity());
        parameterMap.put("image", products.getImage());
        return insertGenericDAO(products);
    }

    public List<Products> findContainsByProperty(String property, String keyword) {
        String sql = "select * from Products\n"
                + "where " + property + " like ?";
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("productName", "%" + keyword + "%");
        return queryGenericDAO(Products.class, sql, parameterMap);
    }

    public List<Products> findByPage(int page) {
        String sql = "select * from Products\n"
                + "order by productID\n"
                + "offset ? ROWS\n"
                + "FETCH NEXT ? ROWS ONLY";
        parameterMap = new HashMap<>();
        parameterMap.put("offset", (page - 1) * Constant.RECORD_PER_PAGE);
        parameterMap.put("fetch next", Constant.RECORD_PER_PAGE);
        return queryGenericDAO(Products.class, sql, parameterMap);
    }

    public int findTotalRecord() {
        return findTotalRecordGenericDAO(Products.class);
    }

    public void deleteById(int productID) {
        String sql = "DELETE FROM [dbo].[Products]\n"
                + "      WHERE productID = ?";
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("productID", productID);
        updateGenericDAO(sql, parameterMap);
    }

    public void updateproduct(Products products) {
        String sql = "UPDATE [dbo].[Products]\n"
                + "   SET [typeID] =?\n"
                + "      ,[image] = ?\n"
                + "      ,[stockQuantity] = ?\n"
                + "      ,[productName] = ?\n"
                + "      ,[price] = ?\n"
                + " WHERE productID = ?";
        parameterMap = new LinkedHashMap<>();

        parameterMap.put("typeID", products.getTypeID());
        parameterMap.put("image", products.getImage());
        parameterMap.put("quantity", products.getStockQuantity());
        parameterMap.put("name", products.getProductName());
        parameterMap.put("price", products.getPrice());
        parameterMap.put("productID", products.getProductID());
        updateGenericDAO(sql, parameterMap);
    }
}
