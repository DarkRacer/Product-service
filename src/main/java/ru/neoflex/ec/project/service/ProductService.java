package ru.neoflex.ec.project.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.neoflex.ec.project.entity.ProductEntity;
import ru.neoflex.ec.project.repository.ProductRepository;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductEntity> findByAvailable(){
        return productRepository.findByAvailable();
    }

    public List<ProductEntity> findByCount(Long id){
        return productRepository.findByCount(id);
    }
}
