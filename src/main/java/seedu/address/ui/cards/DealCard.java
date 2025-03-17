package seedu.address.ui.cards;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.deal.Deal;
import seedu.address.ui.UiPart;

/**
 * An UI component that displays information of a {@code Deal}.
 */
public class DealCard extends UiPart<Region> {

    private static final String FXML = "DealListCard.fxml";

    public final Deal deal;

    @FXML
    private HBox cardPane;
    @FXML
    private Label id;
    @FXML
    private Label title;
    @FXML
    private Label propertyName;
    @FXML
    private Label price;
    @FXML
    private Label status;

    /**
     * Creates a {@code DealCode} with the given {@code Deal} and index to display.
     */
    public DealCard(Deal deal, int displayedIndex) {
        super(FXML);
        this.deal = deal;
        id.setText(displayedIndex + ". ");
        title.setText(String.format("%s -> %s", deal.getSeller().fullName, deal.getBuyer().fullName));
        propertyName.setText(deal.getPropertyName().fullName);
        price.setText("Price: " + deal.getPrice().value);
        status.setText(deal.getStatus().toString());
    }
}
