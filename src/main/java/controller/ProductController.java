package controller;
import model.Category;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.ProductDAO;

import java.sql.SQLException;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductDAO productDAO;
    @GetMapping("/")
    public String showList(Model model,@RequestParam(defaultValue = "") String key) {
        List<Product> products;
        if (key == "") {
            products = productDAO.findAll();
        } else {
            products = productDAO.findByName(key);
        }
        model.addAttribute("products",products);
        List<Category> categories = productDAO.findCategoryByBlogs(products);
        model.addAttribute("categories",categories) ;
        return "list";
    }
    @GetMapping("/create")
    public String showCreateForm(Model model){
        List<Category> categories = productDAO.findAllCategory();
        model.addAttribute("categories",categories) ;
        return "create";
    }
    @PostMapping("/create")
    public String create (Model model,@RequestParam String name,@RequestParam double price,@RequestParam int quantity,@RequestParam String color,@RequestParam String description,@RequestParam int categoryName) throws SQLException {
        productDAO.add(new Product(1,name,price,quantity,color,description,categoryName));
        List<Product> products = productDAO.findAll();
        model.addAttribute("products",products);
        List<Category> categories = productDAO.findCategoryByBlogs(products);
        model.addAttribute("categories",categories) ;
        return "list";
    }
    @GetMapping("/delete")
    public String delete (Model model,@RequestParam int id) throws SQLException {
        productDAO.delete(id);
        List<Product> products = productDAO.findAll();
        model.addAttribute("products",products);
        List<Category> categories = productDAO.findCategoryByBlogs(products);
        model.addAttribute("categories",categories) ;
        return "list";
    }
    @GetMapping("/edit")
        public String showEditForm(Model model ,@RequestParam int id){
        List<Category> categories = productDAO.findAllCategory();
        model.addAttribute("categories",categories) ;
        model.addAttribute("id",id);
         return "edit";
        }
    @PostMapping("/edit")
    public String edit(Model model,@RequestParam int id,@RequestParam String name,@RequestParam double price,@RequestParam int quantity,@RequestParam String color,@RequestParam String description,@RequestParam int categoryName) throws SQLException {
        productDAO.edit(new Product(id,name,price,quantity,color,description,categoryName));
        List<Product> products = productDAO.findAll();
        model.addAttribute("products",products);
        List<Category> categories = productDAO.findCategoryByBlogs(products);
        model.addAttribute("categories",categories) ;
        return "list";
    }
}
