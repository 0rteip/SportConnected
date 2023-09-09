package model.message;

/**
 * Type of Message.
 */
public enum MessageType {
    /**
     * News Message.
     */
    OK("All ok"),
    /**
     * Catastrophe Message.
     */
    NOT_OK("Something went wrong");

    private final String title;

    MessageType(final String title) {
        this.title = title;
    }

    /**
     * Returns the title.
     * 
     * @return
     *         title
     */
    public String getTitle() {
        return this.title;
    }

}
