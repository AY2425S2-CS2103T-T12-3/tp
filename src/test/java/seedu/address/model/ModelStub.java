package seedu.address.model;

import java.nio.file.Path;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.model.client.Client;
import seedu.address.model.deal.Deal;
import seedu.address.model.property.Property;
import seedu.address.model.schedule.Schedule;

/**
 * A default model stub that have all of the methods failing.
 */
public class ModelStub implements Model {
    @Override
    public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public ReadOnlyUserPrefs getUserPrefs() {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public GuiSettings getGuiSettings() {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public Path getAddressBookFilePath() {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void setAddressBookFilePath(Path addressBookFilePath) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void addClient(Client client) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void setAddressBook(ReadOnlyAddressBook newData) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public ReadOnlyAddressBook getAddressBook() {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public boolean hasClient(Client client) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void deleteClient(Client target) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void setClient(Client target, Client editedClient) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public ObservableList<Client> getFilteredClientList() {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void updateFilteredClientList(Predicate<Client> predicate) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void updateFilteredDealList(Predicate<Deal> predicate) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void updateFilteredPropertyList(Predicate<Property> predicate) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void updateFilteredScheduleList(Predicate<Schedule> predicate) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public boolean hasDeal(Deal deal) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void addDeal(Deal deal) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public ObservableList<Deal> getFilteredDealList() {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public ObservableList<Property> getFilteredPropertyList() {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public ObservableList<Schedule> getFilteredScheduleList() {
        throw new AssertionError("This method should not be called.");
    }
}
