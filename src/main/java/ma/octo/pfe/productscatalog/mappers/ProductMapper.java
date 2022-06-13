package ma.octo.pfe.productscatalog.mappers;

import ma.octo.pfe.productscatalog.dtos.pricing.PricingDto;
import ma.octo.pfe.productscatalog.dtos.product.ProductDto;
import ma.octo.pfe.productscatalog.dtos.product.ProductPageDto;
import ma.octo.pfe.productscatalog.model.ProductBo;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

    public static ProductDto fromBoToDto(ProductBo productBo){

        if (productBo == null)
            return null;

        return ProductDto.builder()
                .name(productBo.getName())
                .setupPrice(productBo.getSetupPrice())
                .periodicPrice(PricingMapper.fromBoToDto(productBo.getPeriodicPrice()))
                .build();
    }

    public static ProductBo fromDtoToBo(ProductDto productDto){

        if (productDto == null)
            return null;

        return ProductBo.builder()
                .name(productDto.getName())
                .setupPrice(productDto.getSetupPrice())
                .periodicPrice(PricingMapper.fromDtoToBo((PricingDto) productDto.getPeriodicPrice()))
                .build();
    }

    public static List<ProductDto> fromListBoToListDto(List<ProductBo> productBos){

        if (productBos == null)
            return null;

        return productBos.stream()
                .map(ProductMapper::fromBoToDto)
                .collect(Collectors.toList());
    }

    public static ProductPageDto fromBoPageToDtoPage(Page<ProductBo> productBoPage){

        if (productBoPage == null)
            return null;

        return ProductPageDto.builder()
                .totalItems(productBoPage.getTotalElements())
                .currentPage(productBoPage.getNumber())
                .totalPages(productBoPage.getTotalPages())
                .products(fromListBoToListDto(productBoPage.getContent()))
                .build();
    }

}
