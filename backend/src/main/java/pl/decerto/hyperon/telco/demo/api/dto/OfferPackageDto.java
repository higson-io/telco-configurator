package pl.decerto.hyperon.telco.demo.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

/**
 * @author Maciej Główka on 11.03.2019
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OfferPackageDto {
	private String id;
	@JsonProperty("package")
	private String packageCode;
	private int duration;
	private List<HardwareDto> hardware;
	private List<ExtraChannelDto> extraChannels;
	private List<ExtraServiceDto> extraServices;
	private BigDecimal activationPrice;
	private BigDecimal activationPriceAfterDiscounts;
	private BigDecimal price;
	private BigDecimal priceAfterDiscounts;
	private InvoiceDto invoice;
}
