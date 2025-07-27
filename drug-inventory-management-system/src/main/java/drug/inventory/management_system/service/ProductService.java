package drug.inventory.management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import drug.inventory.management_system.Entity.Product;
import drug.inventory.management_system.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private FileUploadService fileUploadService;

    public Product addProduct(Product product, MultipartFile image) throws Exception {
        if (image != null && !image.isEmpty()) {
            String imagePath = fileUploadService.uploadImage(image);
            product.setImagePath(imagePath);
        }
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product updatedProduct, MultipartFile image) throws Exception {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new Exception("Product not found with id: " + id));
        product.setName(updatedProduct.getName());
        product.setCategory(updatedProduct.getCategory());
        product.setQuantity(updatedProduct.getQuantity());
        product.setPrice(updatedProduct.getPrice());
        product.setDescription(updatedProduct.getDescription());
        product.setExpiryDate(updatedProduct.getExpiryDate());
        product.setSupplier(updatedProduct.getSupplier());
        if (image != null && !image.isEmpty()) {
            String imagePath = fileUploadService.uploadImage(image);
            product.setImagePath(imagePath);
        }
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) throws Exception {
        return productRepository.findById(id)
                .orElseThrow(() -> new Exception("Product not found with id: " + id));
    }
}