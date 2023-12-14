package com.layer.product;

import com.layer.product.basket.BasketProductService;
import com.layer.product.basket.ProductDto;
import com.layer.product.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl  implements ProductService, BasketProductService {

    private final ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }


    @Override
    public ProductDto getProductInfo(Long productId) {
        return productRepo.findById(productId).map(ProductDto::new).orElse(new ProductDto());
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        return new ProductDto(productRepo.save(new Product(productDto)));
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        return createProduct(productDto);
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepo.deleteById(productId);
    }

    @Override
    public List<ProductDto> getBasketProductsInfo(List<Long> productIds) {
        return productRepo.findAllById(productIds).stream().map(ProductDto::new).collect(Collectors.toList());
    }

    @Override
    public Product getById(long productId) {
        return productRepo.findById(productId).orElse(new Product());
    }

    @Override
    public int getStock(long productId) {
        return getProductInfo(productId).getStock();
    }
}
