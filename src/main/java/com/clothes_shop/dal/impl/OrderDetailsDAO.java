package com.clothes_shop.dal.impl;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.clothes_shop.dal.GenericDAO;
import com.clothes_shop.entity.OrderDetails;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class OrderDetailsDAO extends GenericDAO<OrderDetails> {

    @Override
    public List<OrderDetails> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int insert(OrderDetails t) {
        return insertGenericDAO(t);
    }

    public List<OrderDetails> findByOrderId(int orderId) {
        String sql = "SELECT *\n"
                + "  FROM [AssPRJ].[dbo].[OrderDetails]\n"
                + "  where [orderId] = ?";
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("orderId", orderId);
        return queryGenericDAO(OrderDetails.class, sql, parameterMap);
    }
}
