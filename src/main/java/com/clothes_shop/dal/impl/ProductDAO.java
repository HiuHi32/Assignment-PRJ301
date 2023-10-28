/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clothes_shop.dal.impl;

import com.clothes_shop.dal.GenericDAO;
import com.clothes_shop.entity.Products;
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
    
    public List<Products> findByProperty(String property, Object value){
        String sql = "select * from Products\n"
                + " where " + property + "=?";
        
       parameterMap = new LinkedHashMap<>();
       parameterMap.put("property", value);
       List<Products> list = queryGenericDAO(Products.class, sql, parameterMap);
       return list;
    }
    
    public static void main(String[] args) {
        for(Products product : new ProductDAO().findAll()){
            System.out.println(product);
        }
        System.out.println("=================");
        System.out.println( new ProductDAO().findByProperty("productID", 1));
    }

    @Override
    public int insert(Products t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
