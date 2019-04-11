package pl.decerto.hyperon.telco.demo.api.dto.dictionary;

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
public class OfferPackageDictionaryDto {
	private String publicName;
	private String code;
	private int channelsSum;
	private List<String> details;
	private BigDecimal monthlyPrice;
	private List<PromotionDictionaryDto> promos;
}
