/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clothes_shop.dal.impl;

import com.clothes_shop.dal.GenericDAO;
import com.clothes_shop.entity.Order;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class OrderDAO extends GenericDAO<Order> {

    @Override
    public List<Order> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int insert(Order t) {
        String sql = "INSERT INTO [dbo].[Order]\n"
                + "           ([amount]\n"
                + "           ,[accountId])\n"
                + "     VALUES\n"
                + "           (?, ? )";
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("amount", t.getAmount());
        parameterMap.put("accountId", t.getAccountId());
        return insertGenericDAO(sql, parameterMap);
    }

    public List<Order> findsByAccountId(int id) {
        String sql = "SELECT *\n"
                + "  FROM [Order]\n"
                + "  where accountId = ?";
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("accountId", id);
        return queryGenericDAO(Order.class, sql, parameterMap);
    }
}
