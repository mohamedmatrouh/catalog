package ma.octo.pfe.productscatalog.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductBo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double setupPrice = 0.0;
    @OneToOne
    private PricingBo periodicPrice;

}
