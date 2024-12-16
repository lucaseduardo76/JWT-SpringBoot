package jwt.projectjwt.service;

import jwt.projectjwt.domain.product.Product;
import jwt.projectjwt.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServices {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(Long id){
        return productRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Product not found"));
    }
}
