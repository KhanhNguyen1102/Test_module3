//package controller;
//
//import model.Category;
//import model.Product;
//import service.ProductDAO;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.List;
//
//public class ProductServlet extends HttpServlet {
//    ProductDAO productDAO = new ProductDAO();
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action = request.getParameter("action");
//        if(action==null){
//            action="";
//        }
//        switch (action){
//            case "delete":
//                try {
//                    delete(request,response);
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//                break;
//            case "edit":
//                showEditForm(request,response);
//                break;
//            case "create":
//                showCreateForm(request,response);
//                break;
//            default:
//                showlist(request,response);
//        }
//    }
//    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Category> categories = productDAO.findAllCategory();
//        request.setAttribute("categories",categories);
//        request.getRequestDispatcher("product/create.jsp").forward(request,response);
//    }
//
//    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int id= Integer.parseInt(request.getParameter("id"));
//        Product product = productDAO.findById(id);
//        List<Category> categories = productDAO.findAllCategory();
//        request.setAttribute("categories",categories);
//        request.setAttribute("product",product);
//        request.getRequestDispatcher("product/edit.jsp").forward(request,response);
//    }
//
//    private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        productDAO.delete(id);
//        response.sendRedirect("/products");
//    }
//    private void showlist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String key = request.getParameter("key");
//        List<Product> products;
//        if (key == null) {
//            products = productDAO.findAll();
//        } else {
//            products = productDAO.findByName(key);
//        }
//        List<Category> categories = productDAO.findCategoryByBlogs(products);
//        request.setAttribute("products",products);
//        request.setAttribute("categories",categories);
//        request.getRequestDispatcher("product/list.jsp").forward(request,response);
//    }
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action = request.getParameter("action");
//        if(action==null){
//            action="";
//        }
//        switch (action) {
//            case "edit":
//                try {
//                    Edit(request, response);
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//                break;
//            case "create":
//                try {
//                    Save(request, response);
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//                break;
//        }
//    }
//    private void Save(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
//        String name =request.getParameter("name");
//        double price = Double.parseDouble(request.getParameter("price"));
//        int quantity = Integer.parseInt(request.getParameter("quantity"));
//        String color =request.getParameter("color");
//        String description =request.getParameter("description");
//        int categoryId = Integer.parseInt(request.getParameter("categoryName"));
//        productDAO.add(new Product(1,name,price,quantity,color,description,categoryId));
//        response.sendRedirect("/products");
//    }
//
//    private void Edit(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
//        int id = Integer.parseInt(request.getParameter("id")) ;
//        String name =request.getParameter("name");
//        double price = Double.parseDouble(request.getParameter("price"));
//        int quantity = Integer.parseInt(request.getParameter("quantity"));
//        String color =request.getParameter("color");
//        String description =request.getParameter("description");
//        int categoryId = Integer.parseInt(request.getParameter("categoryName"));
//        Product product = new Product(id,name,price,quantity,color,description,categoryId);
//        productDAO.edit(product);
//        response.sendRedirect("/products");
//    }
//}
