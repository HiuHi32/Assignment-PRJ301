/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clothes_shop.dal.impl;

import com.clothes_shop.constant.Constant;
import com.clothes_shop.dal.GenericDAO;
import com.clothes_shop.entity.Customer;
import java.util.LinkedHashMap;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Huu Huy
 */
public class CustomerDAO extends GenericDAO {

    @Override
    public List findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int insert(Object t) {
        return insertGenericDAO(t);
    }

    public Customer findByCustomerNamePassword(Customer customer) {
        String sql = "SELECT * FROM [Customer]\n"
                + "WHERE CustomerName = ? and Password = ?";
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("username", customer.getCustomerName());
        parameterMap.put("password", customer.getPassword());

        List<Customer> list = queryGenericDAO(Customer.class, sql, parameterMap);
        if (list.isEmpty()) {
            return null;
        } else {
            return list.get(0);
        }
    }

    public boolean findByUsername(String username) {
        String sql = "SELECT * FROM [Customer]\n"
                + "WHERE CustomerName = ?";
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("username", username);
        

        List<Customer> list = queryGenericDAO(Customer.class, sql,
                parameterMap);
        return !list.isEmpty();                             
    }
}
