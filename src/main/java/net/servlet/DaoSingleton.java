package net.servlet;

import net.servlet.dao.ManufacturerDAO;
import net.servlet.dao.ProductDAO;
import net.servlet.dao.hibernate.ManufacturerDAOImpl;
import net.servlet.dao.hibernate.ProductDAOImpl;

public class DaoSingleton {
    private ManufacturerDAO manufacturerDAO;
    private ProductDAO productDAO;
    private static final DaoSingleton INSTANCE = new DaoSingleton();

    private DaoSingleton() {
        manufacturerDAO = new ManufacturerDAOImpl();
        productDAO = new ProductDAOImpl();
    }

    public ManufacturerDAO getManufacturerDAO() {
        return manufacturerDAO;
    }

    public ProductDAO getProductDAO() {
        return productDAO;
    }

    public static DaoSingleton getINSTANCE() {
        return INSTANCE;
    }
}
