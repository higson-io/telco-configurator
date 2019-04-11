package pl.decerto.hyperon.telco.demo.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import org.smartparam.engine.util.Separator;

/**
 * @author Maciej Główka on 11.03.2019
 */
@Data
public class OfferPackage {
	@Setter(AccessLevel.NONE)
	private String id;
	@Setter(AccessLevel.NONE)
	private String packageCode;
	@Setter
	private int duration;
	private List<Hardware> hardware = new ArrayList<>();
	private List<ExtraChannel> extraChannels = new ArrayList<>();
	private List<ExtraService> extraServices = new ArrayList<>();
	@Setter
	private BigDecimal overallPrice;
	@Setter
	private BigDecimal overallPriceAfterDiscounts;
	@Setter
	private BigDecimal monthlyPrice;
	@Setter
	private BigDecimal activationPrice;
	@Setter
	private BigDecimal activationPriceAfterDiscounts;
	@Setter
	private Invoice invoice;

	public OfferPackage(String packageCode) {
		this.packageCode = packageCode;
	}

	public OfferPackage(String packageCode, int duration) {
		this(null, packageCode, duration);
	}

	public OfferPackage(String id, String packageCode, int duration) {
		this.id = id;
		this.packageCode = packageCode;
		this.duration = duration;
	}

	public void setHardware(List<Hardware> hardware) {
		this.hardware = hardware;
		hardware.forEach(h -> h.setOfferPackage(this));
	}

	public void setExtraChannels(List<ExtraChannel> extraChannels) {
		this.extraChannels = extraChannels;
		extraChannels.forEach(ec -> ec.setOfferPackage(this));
	}

	public void setExtraServices(List<ExtraService> extraServices) {
		this.extraServices = extraServices;
		extraServices.forEach(ec -> ec.setOfferPackage(this));
	}

	public String print() {
		StringBuilder sb = new StringBuilder();
		line(sb, "===========  Offer  begin ===========");
		line(sb, "package:" + packageCode + ", duration:" + duration);
		for (Hardware hw : hardware) {
			line(sb, "- hardware [" + hw.getCode() + ", " + hw.getMonthlyPayment() + "] ");
		}

		for (ExtraChannel ec : extraChannels) {
			line(sb, "- extra channel [" + ec.getCode() + ", " + ec.getPrice() + "] ");
		}

		for (ExtraService es : extraServices) {
			line(sb,
				"- extra service [" + es.getCode() + ", activation price:" + es.getActivationPrice() +
					", monthly price:" + es.getMonthlyPriceAfterDiscounts() + "] ");
		}

		line(sb, "overall price:" + overallPrice + ", overall price after discounts:" + overallPriceAfterDiscounts);
		line(sb, "activation price:" + activationPrice + ", activation price after discounts:" + activationPriceAfterDiscounts);
		line(sb, "===========  Offer  end   ===========");

		return sb.toString();
	}

	private static void line(StringBuilder sb, String str) {
		sb.append(str).append(Separator.DEFAULT.getValue());
	}

}
