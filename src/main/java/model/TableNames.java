package model;

/**
 * Table enum.
 */
public enum TableNames {
    /**
     * Initial menu scene.
     */
    USERS("UTENTI"),
    ACTIVITY("ATTIVITA");

    private final String table;

    TableNames(final String title) {
        this.table = title;
    }

    /**
     * @return the table name
     */
    public String getTableName() {
        return this.table;
    }
}
