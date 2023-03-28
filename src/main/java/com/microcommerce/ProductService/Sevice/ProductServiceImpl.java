package com.microcommerce.ProductService.Sevice;

import com.microcommerce.ProductService.Entity.Product;
import com.microcommerce.ProductService.Model.ProductRequest;
import com.microcommerce.ProductService.Repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public long addProduct(ProductRequest productRequest) {
        log.info("adding Product");
        Product product =
                Product.builder()
                        .productName(productRequest.getName())
                        .quantity(productRequest.getQuantity())
                        .price(productRequest.getPrice())
                        .build();
        productRepository.save(product);
   log.info("product added..");
    return product.getProductId();

    }
}
