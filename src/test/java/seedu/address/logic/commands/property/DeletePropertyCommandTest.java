package seedu.address.logic.commands.property;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.CommandTestUtil.showPropertyAtIndex;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND;
import static seedu.address.testutil.TypicalProperties.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.property.Property;

/**
 * Contains integration tests (interaction with the Model) and unit tests for
 * {@code DeletePropertyCommand}.
 */
public class DeletePropertyCommandTest {

    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void execute_validIndexUnfilteredList_success() {
        Property propertyToDelete = model.getFilteredPropertyList().get(INDEX_FIRST.getZeroBased());
        DeletePropertyCommand deletePropertyCommand = new DeletePropertyCommand(INDEX_FIRST);

        String expectedMessage = String.format(DeletePropertyCommand.MESSAGE_DELETE_PROPERTY_SUCCESS,
                Messages.formatProperty(propertyToDelete));

        ModelManager expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
        expectedModel.deleteProperty(propertyToDelete);

        assertCommandSuccess(deletePropertyCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidIndexUnfilteredList_throwsCommandException() {
        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredPropertyList().size() + 1);
        DeletePropertyCommand deletePropertyCommand = new DeletePropertyCommand(outOfBoundIndex);

        assertCommandFailure(deletePropertyCommand, model, Messages.MESSAGE_INVALID_PROPERTY_DISPLAYED_INDEX);
    }

    @Test
    public void execute_validIndexFilteredList_success() {
        showPropertyAtIndex(model, INDEX_FIRST);

        Property propertyToDelete = model.getFilteredPropertyList().get(INDEX_FIRST.getZeroBased());
        DeletePropertyCommand deletePropertyCommand = new DeletePropertyCommand(INDEX_FIRST);

        String expectedMessage = String.format(DeletePropertyCommand.MESSAGE_DELETE_PROPERTY_SUCCESS,
                Messages.formatProperty(propertyToDelete));

        Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
        expectedModel.deleteProperty(propertyToDelete);
        showNoProperty(expectedModel);

        assertCommandSuccess(deletePropertyCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidIndexFilteredList_throwsCommandException() {
        showPropertyAtIndex(model, INDEX_FIRST);

        Index outOfBoundIndex = INDEX_SECOND;
        // ensures that outOfBoundIndex is still in bounds of address book list
        assertTrue(outOfBoundIndex.getZeroBased() < model.getAddressBook().getPropertyList().size());

        DeletePropertyCommand deletePropertyCommand = new DeletePropertyCommand(outOfBoundIndex);

        assertCommandFailure(deletePropertyCommand, model, Messages.MESSAGE_INVALID_PROPERTY_DISPLAYED_INDEX);
    }

    @Test
    public void equals() {
        DeletePropertyCommand deleteFirstCommand = new DeletePropertyCommand(INDEX_FIRST);
        DeletePropertyCommand deleteSecondCommand = new DeletePropertyCommand(INDEX_SECOND);

        // same object -> returns true
        assertTrue(deleteFirstCommand.equals(deleteFirstCommand));

        // same values -> returns true
        DeletePropertyCommand deleteFirstCommandCopy = new DeletePropertyCommand(INDEX_FIRST);
        assertTrue(deleteFirstCommand.equals(deleteFirstCommandCopy));

        // different types -> returns false
        assertFalse(deleteFirstCommand.equals(1));

        // null -> returns false
        assertFalse(deleteFirstCommand.equals(null));

        // different property -> returns false
        assertFalse(deleteFirstCommand.equals(deleteSecondCommand));
    }

    @Test
    public void toStringMethod() {
        Index targetIndex = Index.fromOneBased(1);
        DeletePropertyCommand deletePropertyCommand = new DeletePropertyCommand(targetIndex);
        String expected = DeletePropertyCommand.class.getCanonicalName() + "{targetIndex=" + targetIndex + "}";
        assertEquals(expected, deletePropertyCommand.toString());
    }

    /**
     * Updates {@code model}'s filtered list to show no property.
     */
    private void showNoProperty(Model model) {
        model.updateFilteredPropertyList(p -> false);

        assertTrue(model.getFilteredPropertyList().isEmpty());
    }
}
