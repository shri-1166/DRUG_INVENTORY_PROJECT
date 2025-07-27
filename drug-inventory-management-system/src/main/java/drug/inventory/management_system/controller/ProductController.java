package drug.inventory.management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import drug.inventory.management_system.Entity.Product;
import drug.inventory.management_system.service.ProductService;

@RestController
@RequestMapping("/api/admin")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/products")
    public ResponseEntity<Product> addProduct(
            @RequestPart("product") Product product,
            @RequestPart(value = "image", required = false) MultipartFile image) throws Exception {
        Product savedProduct = productService.addProduct(product, image);
        return ResponseEntity.ok(savedProduct);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable Long id,
            @RequestPart("product") Product product,
            @RequestPart(value = "image", required = false) MultipartFile image) throws Exception {
        Product updatedProduct = productService.updateProduct(id, product, image);
        return ResponseEntity.ok(updatedProduct);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(productService.getProductById(id));
    }
}
