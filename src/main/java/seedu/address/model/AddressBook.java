package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javafx.collections.ObservableList;
import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.client.Client;
import seedu.address.model.client.UniqueClientList;
import seedu.address.model.deal.Deal;
import seedu.address.model.deal.UniqueDealList;
import seedu.address.model.event.Event;
import seedu.address.model.event.UniqueEventList;
import seedu.address.model.property.Property;
import seedu.address.model.property.UniquePropertyList;

/**
 * Wraps all data at the address-book level
 * Duplicates are not allowed (by .isSameClient comparison)
 */
public class AddressBook implements ReadOnlyAddressBook {

    private final UniqueClientList clients;
    private final UniqueDealList deals;
    private final UniqueEventList events;
    private final UniquePropertyList properties;

    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */

    {
        clients = new UniqueClientList();
        deals = new UniqueDealList();
        events = new UniqueEventList();
        properties = new UniquePropertyList();
    }

    public AddressBook() {}

    /**
     * Creates an AddressBook using the Clients in the {@code toBeCopied}
     */
    public AddressBook(ReadOnlyAddressBook toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    //// list overwrite operations

    /**
     * Replaces the contents of the client list with {@code clients}.
     * {@code clients} must not contain duplicate clients.
     */
    public void setClients(List<Client> clients) {
        this.clients.setClients(clients);
    }

    /**
     * Replaces the contents of the deal list with {@code deals}.
     * {@code deals} must not contain duplicate deals.
     */
    public void setDeals(List<Deal> deals) {
        this.deals.setDeals(deals);
    }

    /**
     * Replaces the contents of the property list with {@code properties}.
     * {@code properties} must not contain duplicate properties.
     */
    public void setProperties(List<Property> properties) {
        this.properties.setProperties(properties);
    }

    /**
     * Resets the existing data of this {@code AddressBook} with {@code newData}.
     */
    public void resetData(ReadOnlyAddressBook newData) {
        requireNonNull(newData);

        setClients(newData.getClientList());
        setDeals(newData.getDealList());
        setEvents(newData.getEventList());
        setProperties(newData.getPropertyList());
    }

    //// client-level operations

    /**
     * Returns true if a client with the same identity as {@code client} exists in REconnect.
     */
    public boolean hasClient(Client client) {
        requireNonNull(client);
        return clients.contains(client);
    }

    /**
     * Returns true if a client with the same identity as {@code client} exists in REconnect.
     */
    public boolean hasClient(Client client, Index index) {
        requireNonNull(client);
        return clients.contains(client, index);
    }

    /**
     * Adds a client to REconnect.
     * The client must not already exist in REconnect.
     */
    public void addClient(Client p) {
        clients.add(p);
    }

    /**
     * Replaces the given client {@code target} in the list with {@code editedClient}.
     * {@code target} must exist in REconnect.
     * The client identity of {@code editedClient} must not be the same as another existing client in REconnect.
     */
    public void setClient(Client target, Client editedClient) {
        requireNonNull(editedClient);

        clients.setClient(target, editedClient);
    }

    /**
     * Removes {@code key} from this {@code AddressBook}.
     * {@code key} must exist in REconnect.
     */
    public void removeClient(Client key) {
        clients.remove(key);
    }

    //// event operations
    /**
     * Returns true if an event with the same identity as {@code event} exists in REconnect.
     */
    public boolean hasEvent(Event event) {
        requireNonNull(event);
        return events.contains(event);
    }
    /**
     * Adds an event to REconnect.
     */
    public void addEvent(Event event) {
        requireNonNull(event);
        events.add(event);
    }

    /**
     * Removes an event from REconnect.
     */
    public void removeEvent(Event event) {
        requireNonNull(event);
        events.remove(event);
    }

    public void setEvents(List<Event> events) {
        this.events.setEvents(events);
    }

    //// property-level operations

    /**
     * Returns true if a property with the same identity as {@code property} exists in REconnect.
     */
    public boolean hasProperty(Property property) {
        requireNonNull(property);
        return properties.contains(property);
    }

    /**
     * Adds a property to REconnect.
     * The property must not already exist in REconnect.
     */
    public void addProperty(Property property) {
        properties.add(property);
    }

    /**
     * Replaces the given property {@code target} in the list with {@code editedProperty}.
     * {@code target} must exist in REconnect.
     * The property identity of {@code editedProperty} must not be the same as
     * another existing property in REconnect.
     */
    public void setProperty(Property target, Property editedProperty) {
        requireNonNull(editedProperty);

        properties.setProperty(target, editedProperty);
    }

    /**
     * Removes {@code key} from this {@code AddressBook}.
     * {@code key} must exist in REconnect.
     */
    public void removeProperty(Property key) {
        properties.remove(key);
    }

    //// deal-level operations

    /**
     * Returns true if a deal with the same identity as {@code deal} exists in REconnect.
     */
    public boolean hasDeal(Deal deal) {
        requireNonNull(deal);
        return deals.contains(deal);
    }

    /**
     * Adds a deal to REconnect.
     * The deal must not already exist in REconnect.
     */
    public void addDeal(Deal deal) {
        deals.add(deal);
    }

    /**
     * Replaces the given deal {@code target} in the list with {@code editedDeal}.
     * {@code target} must exist in REconnect.
     * The deal identity of {@code editedDeal} must not be the same as another existing deal in REconnect.
     */
    public void setDeal(Deal target, Deal editedDeal) {
        requireNonNull(editedDeal);

        deals.setDeal(target, editedDeal);
    }

    /**
     * Removes {@code key} from this {@code AddressBook}.
     * {@code key} must exist in REconnect.
     */
    public void removeDeal(Deal key) {
        deals.remove(key);
    }

    //// util methods

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("clients", clients)
                .add("deals", deals)
                .add("properties", properties)
                .add("events", events)
                .toString();
    }

    @Override
    public ObservableList<Client> getClientList() {
        return clients.asUnmodifiableObservableList();
    }

    @Override
    public ObservableList<Event> getEventList() {
        return events.asUnmodifiableObservableList();
    }

    @Override
    public ObservableList<Deal> getDealList() {
        return deals.asUnmodifiableObservableList();
    }

    @Override
    public ObservableList<Property> getPropertyList() {
        return properties.asUnmodifiableObservableList();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof AddressBook)) {
            return false;
        }

        AddressBook otherAddressBook = (AddressBook) other;
        return clients.equals(otherAddressBook.clients)
                && deals.equals(otherAddressBook.deals)
                && events.equals(otherAddressBook.events)
                && properties.equals(otherAddressBook.properties);
    }

    @Override
    public int hashCode() {
        return clients.hashCode() + deals.hashCode() + events.hashCode() + properties.hashCode();
    }
}
