package one.digitalinnovation.personapi.exception;

public class PeopleNotFoundException extends EntityNotFoundException {

    private static final long serialVersionUID = 1L;
    private static final String MSG_PEOPLE_NOT_FOUND = "People with id %d not found";

    public PeopleNotFoundException(String message) {
        super(message);
    }

    public PeopleNotFoundException(Long peopleId) {
        this(String.format(MSG_PEOPLE_NOT_FOUND, peopleId));
    }

}
