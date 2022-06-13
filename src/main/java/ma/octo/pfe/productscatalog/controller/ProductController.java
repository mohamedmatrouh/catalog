package ma.octo.pfe.productscatalog.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.octo.pfe.productscatalog.dtos.product.ProductDto;
import ma.octo.pfe.productscatalog.dtos.product.ProductPageDto;
import ma.octo.pfe.productscatalog.services.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static ma.octo.pfe.productscatalog.holders.ApiPaths.*;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping(API + V1 + PRODUCTS)
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ProductDto saveProduct(@Valid @RequestBody ProductDto productDto) {
        log.info(String.format("saving product %s", productDto.getName()));
        return productService.saveProduct(productDto);
    }

    @GetMapping
    public ProductPageDto listProducts(@RequestParam int page, @RequestParam int size) {
        log.info(String.format("get product page %d with size %d", page, size));
        return productService.listProducts(page, size);
    }



}
