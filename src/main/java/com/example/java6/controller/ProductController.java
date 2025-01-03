package com.example.java6.controller;

import com.example.java6.entity.Product;
import com.example.java6.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController{
    @Autowired
    ProductService productService;

    @RequestMapping("/product/list")
    public String list(Model model, @RequestParam("cid") Optional<String> cid) {
        if(cid.isPresent()) {
            List<Product> list = productService.findByCategoryId(cid.get());
            model.addAttribute("items", list);
        }else{
            List<Product> list = productService.findAll();
            model.addAttribute("items", list);
        }
        System.out.println("Xuất dữ liệu thành công");
    return "product/list";
    }
    @RequestMapping("/product/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Product item = productService.findById(id);
        model.addAttribute("item", item);

        System.out.println("Xuất dữ liệu thành công");
        return "product/detail";
    }
    @GetMapping("/product/detail/cart/view")
    public String redirectToCartView() {
        // Chuyển hướng về trang /cart/view
        return "redirect:/product/cart/view";
    }


}
