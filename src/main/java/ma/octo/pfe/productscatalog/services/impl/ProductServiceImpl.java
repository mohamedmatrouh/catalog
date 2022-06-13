package ma.octo.pfe.productscatalog.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.octo.pfe.productscatalog.dtos.product.ProductDto;
import ma.octo.pfe.productscatalog.dtos.product.ProductPageDto;
import ma.octo.pfe.productscatalog.mappers.ProductMapper;
import ma.octo.pfe.productscatalog.model.ProductBo;
import ma.octo.pfe.productscatalog.repository.ProductRepository;
import ma.octo.pfe.productscatalog.services.PricingService;
import ma.octo.pfe.productscatalog.services.ProductService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final PricingService pricingService;

    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        // TODO: validation
        ProductBo productBo = ProductMapper.fromDtoToBo(productDto);
        pricingService.addPricing(productBo.getPeriodicPrice());
        log.info(String.format("save product %s", productBo.getName()));
        return ProductMapper.fromBoToDto(productRepository.save(productBo));
    }

    @Override
    public ProductPageDto listProducts(int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        return ProductMapper.fromBoPageToDtoPage(productRepository.findAll(paging));
    }
}
