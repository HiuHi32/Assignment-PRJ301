/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clothes_shop.dal.impl;

import com.clothes_shop.dal.GenericDAO;
import com.clothes_shop.entity.ProductTypes;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class ProductTypeDAO extends GenericDAO<ProductTypes> {

    @Override
    public List<ProductTypes> findAll() {
        return queryGenericDAO(ProductTypes.class);
    }

    @Override
    public int insert(ProductTypes t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
