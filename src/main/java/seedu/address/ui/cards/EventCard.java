package seedu.address.ui.cards;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.model.event.Event;
import seedu.address.ui.UiPart;

/**
 * A UI component that displays information of a {@code Event}.
 */
public class EventCard extends UiPart<Region> {

    private static final String FXML = "EventListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Event event;

    @FXML
    private HBox cardPane;
    @FXML
    private Label id;
    @FXML
    private Label eventType;
    @FXML
    private Label property;
    @FXML
    private Label client;
    @FXML
    private FlowPane dateTime;
    @FXML
    private Label note;

    /**
     * Creates a {@code EventCode} with the given {@code Event} and index to display.
     */
    public EventCard(Event event, int displayedIndex) {
        super(FXML);
        this.event = event;
        id.setText(displayedIndex + ". ");
        eventType.setText(event.getEventType().toFormattedString());
        property.setText("About: " + event.getPropertyName().fullName);
        client.setText("With: " + event.getClientName().fullName);
        dateTime.getChildren().add(new Label(event.getDateTime().format(ParserUtil.DATE_FORMAT_TEXT)));
        note.setText("Note: " + event.getNote().toString());
    }
}
