package seedu.address.model.deal;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Represents a list of deals in the address book.
 * Guarantees: mutable; allows duplicate deals
 */
public class DealList {
    private final ObservableList<Deal> internalList = FXCollections.observableArrayList();

    /**
     * Adds a deal to the list.
     */
    public void add(Deal toAdd) {
        internalList.add(toAdd);
    }

    /**
     * Returns the backing list as an unmodifiable list.
     */
    public List<Deal> asUnmodifiableList() {
        return List.copyOf(internalList);
    }

    /**
     * Returns an unmodifiable observable list of deals.
     */
    public ObservableList<Deal> asUnmodifiableObservableList() {
        return FXCollections.unmodifiableObservableList(internalList);
    }

    /**
     * Returns true if the list contains an equivalent deal as the given argument.
     */
    public boolean contains(Deal toCheck) {
        return internalList.stream().anyMatch(toCheck::equals);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof DealList otherDealList)) {
            return false;
        }

        return internalList.equals(otherDealList.internalList);
    }
    @Override
    public int hashCode() {
        return internalList.hashCode();
    }
}
