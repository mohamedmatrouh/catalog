package ma.octo.pfe.productscatalog.mappers;

import ma.octo.pfe.productscatalog.dtos.pricing.PricingDto;
import ma.octo.pfe.productscatalog.dtos.pricing.PricingPerRangeDto;
import ma.octo.pfe.productscatalog.dtos.pricing.PricingPerVolumeDto;
import ma.octo.pfe.productscatalog.model.PricingBo;
import ma.octo.pfe.productscatalog.model.PricingPerRange;
import ma.octo.pfe.productscatalog.model.PricingPerVolume;

import java.util.List;
import java.util.stream.Collectors;

public class PricingMapper {
    public static PricingDto fromBoToDto(PricingBo pricingBo){

        if (pricingBo == null)
            return null;

        if (pricingBo instanceof PricingPerRange)
            return fromPricingPerRangeBoToPricingPerRangeDto((PricingPerRange) pricingBo);

        if (pricingBo instanceof PricingPerVolume)
            return fromPricingPerVolumeBoToPricingPerVolumeDto((PricingPerVolume) pricingBo);

        return PricingDto.builder()
                .type(pricingBo.getType())
                .price(pricingBo.getPrice())
                .build();
    }

    public static PricingBo fromDtoToBo(PricingDto pricingDto){

        if (pricingDto == null)
            return null;

        if (pricingDto instanceof PricingPerRangeDto)
            return fromPricingPerRangeDtoToPricingPerRangeBo((PricingPerRangeDto) pricingDto);

        if (pricingDto instanceof PricingPerVolumeDto)
            return fromPricingPerVolumeDtoToPricingPerVolumeBo((PricingPerVolumeDto) pricingDto);

        return PricingBo.builder()
                .type(pricingDto.getType())
                .price(pricingDto.getPrice())
                .build();
    }

    private static PricingBo fromPricingPerVolumeDtoToPricingPerVolumeBo(PricingPerVolumeDto pricingDto) {

        if(pricingDto == null)
            return null;

        PricingPerVolume pricing = new PricingPerVolume();
        pricing.setPrice(pricingDto.getPrice());
        pricing.setType(pricingDto.getType());
        pricing.setVolume(pricingDto.getVolume());
        pricing.setUnit(pricingDto.getUnit());
        return pricing;
    }

    private static PricingBo fromPricingPerRangeDtoToPricingPerRangeBo(PricingPerRangeDto pricingDto) {

        if(pricingDto == null)
            return null;

        PricingPerRange pricing = new PricingPerRange();
        pricing.setPrice(pricingDto.getPrice());
        pricing.setType(pricingDto.getType());
        pricing.setMin(pricingDto.getMin());
        pricing.setMax(pricingDto.getMax());
        return pricing;
    }

    private static PricingDto fromPricingPerVolumeBoToPricingPerVolumeDto(PricingPerVolume pricingBo) {

        if(pricingBo == null)
            return null;

        PricingPerVolumeDto pricing = new PricingPerVolumeDto();
        pricing.setPrice(pricingBo.getPrice());
        pricing.setType(pricingBo.getType());
        pricing.setVolume(pricingBo.getVolume());
        pricing.setUnit(pricingBo.getUnit());
        return pricing;
    }

    private static PricingPerRangeDto fromPricingPerRangeBoToPricingPerRangeDto(PricingPerRange PricingPerRangeBo) {

        if(PricingPerRangeBo == null)
            return null;

        PricingPerRangeDto pricing = new PricingPerRangeDto();
        pricing.setPrice(PricingPerRangeBo.getPrice());
        pricing.setType(PricingPerRangeBo.getType());
        pricing.setMin(PricingPerRangeBo.getMin());
        pricing.setMax(PricingPerRangeBo.getMax());
        return pricing;
    }

    public static List<PricingDto> fromListBoToListDto(List<PricingBo> pricingBos){

        if (pricingBos == null)
            return null;

        return pricingBos.stream()
                .map(PricingMapper::fromBoToDto)
                .collect(Collectors.toList());
    }

}
