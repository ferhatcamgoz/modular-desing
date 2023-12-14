package com.layer.product;

import com.layer.product.basket.ProductDto;

public interface ProductService {

    ProductDto getProductInfo(Long productId);

    ProductDto createProduct(ProductDto productDto);

    ProductDto updateProduct(ProductDto productDto);

    void deleteProduct(Long productId);


}
