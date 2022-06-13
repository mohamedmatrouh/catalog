package ma.octo.pfe.productscatalog.controller;

import lombok.RequiredArgsConstructor;
import ma.octo.pfe.productscatalog.dtos.product.ProductDto;
import ma.octo.pfe.productscatalog.dtos.product.ProductPageDto;
import ma.octo.pfe.productscatalog.services.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static ma.octo.pfe.productscatalog.holders.ApiPaths.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(API + V1 + PRODUCTS)
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ProductDto saveProduct(@Valid @RequestBody ProductDto productDto) {
        return productService.saveProduct(productDto);
    }

    @GetMapping
    public ProductPageDto listProducts(@RequestParam int page, @RequestParam int size) {
        return productService.listProducts(page, size);
    }



}
