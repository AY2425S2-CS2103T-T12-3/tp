package seedu.address.model.client;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import seedu.address.model.commons.Name;

/**
 * Represents a Person's name in REconnect.
 * Guarantees: immutable; is valid as declared in {@link #isValidClientName Name(String)}
 */
public class ClientName implements Name<Client> {

    public static final String MESSAGE_CONSTRAINTS =
            "Names should only contain alphanumeric characters, the special characters /, \\, ' and spaces.\n"
                    + "It should not be blank nor exceed " + MAX_LENGTH + " characters";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} /'\\\\]*";

    public final String fullName;

    /**
     * Constructs a {@code ClientName}.
     *
     * @param name A valid name.
     */
    public ClientName(String name) {
        requireNonNull(name);
        checkArgument(isValidClientName(name), MESSAGE_CONSTRAINTS);
        fullName = name;
    }

    /**
     * Returns true if a given string is a valid name.
     */
    public static boolean isValidClientName(String test) {
        return test.length() <= MAX_LENGTH && test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return fullName;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof ClientName)) {
            return false;
        }

        ClientName otherName = (ClientName) other;
        return fullName.equals(otherName.fullName);
    }

    @Override
    public int hashCode() {
        return fullName.hashCode();
    }

}
