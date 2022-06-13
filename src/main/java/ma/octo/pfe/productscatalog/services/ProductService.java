package ma.octo.pfe.productscatalog.services;

import ma.octo.pfe.productscatalog.dtos.product.ProductDto;
import ma.octo.pfe.productscatalog.dtos.product.ProductPageDto;

public interface ProductService {
    ProductDto saveProduct(ProductDto productDto);
    ProductPageDto listProducts(int page, int size);
}
