package ma.octo.pfe.productscatalog.dtos.product;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductPageDto {
    private Long totalItems;
    private int totalPages;
    private int currentPage;
    private List<ProductDto> products;
}
