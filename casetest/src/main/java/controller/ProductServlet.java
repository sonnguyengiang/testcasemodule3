package controller;

import dao.CRUD_Product;
import model.Product;
import services.ProductServices;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/product"})
public class ProductServlet extends HttpServlet {
    ProductServices productServices = new ProductServices();
    RequestDispatcher dispatcher;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }

        switch (action){
            case"create":
                resp.sendRedirect("/view/CreateProduct.jsp");
                break;
            case "delete":
                int index = Integer.parseInt(req.getParameter("index"));
                productServices.delete(index);
                resp.sendRedirect("/product");
                break;
            case "edit":
                int index_edit = Integer.parseInt(req.getParameter("index"));
                req.setAttribute("editProduct", productServices.list.get(index_edit));
                dispatcher = req.getRequestDispatcher("/view/EditProduct.jsp");
                dispatcher.forward(req, resp);
                break;
            case "find":
                String name_find = req.getParameter("name_find");
                ArrayList<Product> list = null;
                try {
                    list = CRUD_Product.find(name_find);
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
                req.setAttribute("productList", list);
                dispatcher = req.getRequestDispatcher("/view/ShowProduct.jsp");
                dispatcher.forward(req, resp);
                break;
            default:
                productServices.Create();
                req.setAttribute("productList", productServices.list);
                dispatcher = req.getRequestDispatcher("/view/ShowProduct.jsp");
                dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                String name = req.getParameter("name");
                float price = Float.parseFloat(req.getParameter("price"));
                int quantity = Integer.parseInt(req.getParameter("quantity"));
                String color = req.getParameter("color");
                int id_type = Integer.parseInt(req.getParameter("type"));
                String mota = req.getParameter("mota");
                Product product = new Product(name, price, quantity, color, id_type, mota);
                productServices.createProduct(product);
                resp.sendRedirect("/product");
                break;
            case "edit":
                int index_edit = Integer.parseInt(req.getParameter("index"));
                String name_edit = req.getParameter("name");
                float price_edit = Float.parseFloat(req.getParameter("price"));
                int quantity_edit = Integer.parseInt(req.getParameter("quantity"));
                String color_edit = req.getParameter("color");
                int id_type_edit = Integer.parseInt(req.getParameter("type"));
                String mota_edit = req.getParameter("mota");
                Product product_edit = new Product(name_edit, price_edit, quantity_edit, color_edit, id_type_edit, mota_edit);
                productServices.edit(product_edit, index_edit);
                resp.sendRedirect("/product");
                break;
            case "find":
                String name_find = req.getParameter("name_find");
                ArrayList<Product> list = null;
                try {
                    list = CRUD_Product.find(name_find);
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
                req.setAttribute("productList", list);
                dispatcher = req.getRequestDispatcher("/view/ShowProduct.jsp");
                dispatcher.forward(req, resp);
                break;
            default:
                productServices.Create();
                req.setAttribute("productList", productServices.list);
                dispatcher = req.getRequestDispatcher("/view/ShowProduct.jsp");
                dispatcher.forward(req, resp);
        }
    }
}
