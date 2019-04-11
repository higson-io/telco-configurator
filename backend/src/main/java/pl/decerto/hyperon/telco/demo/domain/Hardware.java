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
public class Hardware {
	private String code;
	private BigDecimal monthlyPayment;
	private BigDecimal activationPrice;
	private boolean multiRoom;
	private boolean selected;
	private OfferPackage offerPackage;

	public Hardware(String code) {
		this.code = code;
	}

	public Hardware(String code, OfferPackage offerPackage) {
		this.code = code;
		this.offerPackage = offerPackage;
		this.offerPackage.setHardware(Collections.singletonList(this));
	}
}
