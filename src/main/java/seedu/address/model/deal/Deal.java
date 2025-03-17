package seedu.address.model.deal;

import seedu.address.model.client.ClientName;
import seedu.address.model.commons.Price;
import seedu.address.model.property.PropertyName;

/**
 * Represents a Deal in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Deal {

    private PropertyName propertyName;
    private ClientName buyer;
    private ClientName seller;
    private Price price;
    private DealStatus status; // default status is PENDING

    /**
     * TODO: Modify this.
     */
    public boolean isSameDeal(Deal otherDeal) {
        return false;
    }

    public PropertyName getPropertyName() {
        return propertyName;
    }

    public ClientName getBuyer() {
        return buyer;
    }

    public ClientName getSeller() {
        return seller;
    }

    public Price getPrice() {
        return price;
    }

    public DealStatus getStatus() {
        return status;
    }

    /**
     * Returns true if both deals have the same property, buyer, and seller.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Deal otherDeal)) {
            return false;
        }

        return propertyName.equals(otherDeal.propertyName)
                && buyer.equals(otherDeal.buyer)
                && seller.equals(otherDeal.seller);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Property: ")
                .append(propertyName.fullName)
                .append(" Buyer: ")
                .append(buyer.fullName)
                .append(" Seller: ")
                .append(seller.fullName)
                .append(" Price: ")
                .append(price.value)
                .append(" Status: ")
                .append(status);
        return builder.toString();
    }
}
