package org.launchcode.givewise.Controller;

import lombok.extern.slf4j.Slf4j;
import org.launchcode.givewise.models.Product;
import org.launchcode.givewise.models.data.ProductRepository;
import org.launchcode.givewise.request.ProductRequest;
import org.launchcode.givewise.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody ProductRequest productDto){
        Product product = productService.addProduct(productDto);

        log.info("Product added: {}", product);
        return ResponseEntity.ok(product);
    }
    @GetMapping()
    public ResponseEntity<List<Product>> getProduct(){
        List<Product> products = productRepository.getAllProducts();

        return ResponseEntity.ok(products);
    };




}
