package com.example.quan_ly_shop.controller;

import com.example.quan_ly_shop.entity.Cart;
import com.example.quan_ly_shop.entity.Product;
import com.example.quan_ly_shop.service.IProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/shop")
@SessionAttributes("cart")
public class ProductController {
    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }
    @ModelAttribute("cart")
    public Cart createCart() {
        return new Cart();
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Integer id,
                            @ModelAttribute("cart") Cart cart,
                            @RequestParam("action") String action) {
        Product product = productService.findById(id);
        if (product == null) {
            System.out.println("addToCart: product null id=" + id);
            return "redirect:/shop";
        }
        cart.addProduct(product);

        // Debug output
        System.out.println("addToCart: added product id=" + id + " name=" + product.getName());
        System.out.println("Cart now has item count (entries): " + cart.countItemQuantity());
        System.out.println("Cart total quantity: " + cart.countProductQuantity());
        System.out.println("Cart total payment: " + cart.countTotalPayment());

        if ("view".equals(action)) {
            return "redirect:/shopping-cart";
        } else {
            return "redirect:/shop";
        }
    }

    @GetMapping("")
    public String listProducts(@ModelAttribute("cart") Cart cart,
                               Model model,
                               @RequestParam(defaultValue = "0") int page) {

        int size = 8;
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> productPage = productService.findAll(pageable);

        model.addAttribute("productPage", productPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", productPage.getTotalPages());
        model.addAttribute("pageSize", size);
        model.addAttribute("cart", cart);

        return "product/list";
    }

    @GetMapping("/detail/{id}")
    public String viewDetail(@PathVariable Integer id,
                             @ModelAttribute("cart") Cart cart,
                             Model model) {

        Product product = productService.findById(id);
        if (product == null) {
            return "redirect:/shop";
        }

        model.addAttribute("product", product);
        return "product/detail";
    }


}
