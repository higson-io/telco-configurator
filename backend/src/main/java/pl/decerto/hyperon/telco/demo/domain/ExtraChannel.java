package pl.decerto.hyperon.telco.demo.domain;

import java.math.BigDecimal;
import java.util.Collections;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Maciej Główka on 11.03.2019
 */
@Data
@NoArgsConstructor
public class ExtraChannel {
	private String code;
	private BigDecimal price;
	private boolean selected;
	private OfferPackage offerPackage;

	public ExtraChannel(String code) {
		this.code = code;
	}

	public ExtraChannel(String code, OfferPackage offerPackage) {
		this.code = code;
		this.offerPackage = offerPackage;
		this.offerPackage.setExtraChannels(Collections.singletonList(this));
	}
}
