package pl.decerto.hyperon.telco.demo.domain;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Maciej Główka on 26.03.2019
 */
@Data
@NoArgsConstructor
public class ExtraService {
	private String code;
	private BigDecimal monthlyPrice;
	private BigDecimal monthlyPriceAfterDiscounts;
	private BigDecimal activationPrice;
	private OfferPackage offerPackage;
	private boolean selected;

	public ExtraService(String code) {
		this.code = code;
	}

	public ExtraService(String code, OfferPackage offer) {
		this.code = code;
		this.offerPackage = offer;
	}
}
