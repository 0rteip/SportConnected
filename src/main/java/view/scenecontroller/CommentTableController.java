package view.scenecontroller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Comment;

public class CommentTableController extends AbstractSceneController {

    @FXML
    private Button addCommentButton;
    @FXML
    private Button deleteCommentButton;
    @FXML
    private Tab addCommPage;
    @FXML
    private Tab deleteCOmmPage;
    @FXML
    private TableView<Comment> commentTable;
    private TableColumn<Comment, Integer> IdSportColumn;
    private TableColumn<Comment, Integer> IdAttivitaColumn;
    private TableColumn<Comment, Integer> IdCommentoColumn;
    private TableColumn<Comment, Integer> TestoColumn;
    private TableColumn<Comment, Integer> LikesColumn;
    private TableColumn<Comment, Integer> IdUtenteColumn;
    @FXML
    private TextArea textCommArea;
    @FXML
    private TextField deleteCommActivityField;
    @FXML
    private TextField deleteCommSportField;
    @FXML
    private TextField sportCommField;
    @FXML
    private TextField deleteCommCommField;
    @FXML
    private TextField activityCOmmField;
    @FXML
    private TextField userIdCommField;
    private Connection conn;

    @FXML
    private boolean addComment() {
        final String query = "INSERT INTO COMMENTI (IdSport, IdAttivita, IdCommento, Testo, Likes, IdUtente) VALUE (?, ?, ?, ?, ?, ?)";
        try (final PreparedStatement statement = this.conn.prepareStatement(query)) {

            if (this.sportCommField.getText() == "" || this.activityCOmmField.getText() == ""
                    || this.userIdCommField.getText() == "" || this.textCommArea.getText() == "") {
                return false;
            }
            if (!this.existActivity()) {
                return false;
            }

            statement.setInt(1, Integer.parseInt(this.sportCommField.getText()));
            statement.setInt(2, Integer.parseInt(this.activityCOmmField.getText()));
            statement.setInt(3, this.getNextCommentId());
            statement.setString(4, this.textCommArea.getText());
            statement.setInt(5, 0);
            statement.setInt(6, Integer.parseInt(this.userIdCommField.getText()));

            statement.executeUpdate();

            this.refreshTable();

            return true;
        } catch (final SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private int getNextCommentId() {
        final String query = "SELECT IdCommento FROM COMMENTI WHERE IdSport = ? AND IdAttivita = ? ORDER BY IdCommento DESC LIMIT 1";
        try (final PreparedStatement statement = this.conn.prepareStatement(query)) {
            // Execute and save result
            final Integer sportId = Integer.parseInt(this.sportCommField.getText());
            final Integer actId = Integer.parseInt(this.activityCOmmField.getText());

            statement.setInt(1, sportId);
            statement.setInt(2, actId);

            final ResultSet result = statement.executeQuery();

            Integer id = 0;

            try {
                while (result.next()) {
                    id = result.getInt("IdCommento");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return id + 1;
        } catch (final SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    private boolean existActivity() {
        final String query = "SELECT IdSport, IdAttivita FROM ATTIVITA WHERE IdSport = ? AND IdAttivita = ?";
        try (final PreparedStatement statement = this.conn.prepareStatement(query)) {

            final Integer sportId = Integer.parseInt(this.sportCommField.getText());
            final Integer actId = Integer.parseInt(this.activityCOmmField.getText());

            statement.setInt(1, sportId);
            statement.setInt(2, actId);

            // Execute and save result
            final ResultSet resultSet = statement.executeQuery();
            try {
                // final Map<Integer, Integer> act =
                // (IdUtente, Nome, Cognome, DataDiNascita, Sesso,
                // FotoProfilo, Biografia, Res_Citta, Res_Provincia, Peso, Altezza)
                while (resultSet.next()) {
                    if (resultSet.getInt("IdSport") == sportId && resultSet.getInt("IdAttivita") == actId) {
                        return true;
                    }
                }

                // Imposta i dati nella TableView
                return false;
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            // return readStudentsFromResultSet(resultSet);
        } catch (final SQLException e) {
            throw new IllegalStateException(e);
        }
        return false;
    }

    @FXML
    private boolean deleteComment() {
        final String query = "DELETE FROM COMMENTI WHERE IdSport = ? AND IdAttivita = ? AND IdCommento = ?";
        try (final PreparedStatement statement = this.conn.prepareStatement(query)) {

            if (this.deleteCommSportField.getText() == "" || this.deleteCommActivityField.getText() == ""
                    || this.deleteCommCommField.getText() == "") {
                return false;
            }
            statement.setInt(1, Integer.parseInt(this.deleteCommSportField.getText()));
            statement.setInt(2, Integer.parseInt(this.deleteCommActivityField.getText()));
            statement.setInt(3, Integer.parseInt(this.deleteCommCommField.getText()));

            statement.executeUpdate();

            this.refreshTable();

            return true;
        } catch (final SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void init(Connection conn) {
        this.conn = Objects.requireNonNull(conn);
        this.createCommentTable();
        this.refreshTable();
    }

    private void refreshTable() {
        final String query = "SELECT * FROM COMMENTI";
        try (final Statement statement = this.conn.createStatement()) {
            // Execute and save result
            final ResultSet resultSet = statement.executeQuery(query);
            try {
                ObservableList<Comment> data = FXCollections.observableArrayList();
                // (IdUtente, Nome, Cognome, DataDiNascita, Sesso,
                // FotoProfilo, Biografia, Res_Citta, Res_Provincia, Peso, Altezza)
                while (resultSet.next()) {
                    Comment s = new Comment(
                            resultSet.getInt("IdSport"),
                            resultSet.getInt("IdAttivita"),
                            resultSet.getInt("IdCommento"),
                            resultSet.getString("Testo"),
                            resultSet.getInt("Likes"),
                            resultSet.getInt("IdUtente"));
                    data.add(s);
                }

                // Imposta i dati nella TableView
                this.commentTable.setItems(data);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            // return readStudentsFromResultSet(resultSet);
        } catch (final SQLException e) {
            throw new IllegalStateException(e);
        }

    }

    private void createCommentTable() {

        IdUtenteColumn = new TableColumn<>("ID Utente");
        IdUtenteColumn.setCellValueFactory(new PropertyValueFactory<>("IdUtente"));
        IdSportColumn = new TableColumn<>("IdSport");
        IdSportColumn.setCellValueFactory(new PropertyValueFactory<>("IdSport"));
        IdAttivitaColumn = new TableColumn<>("Id Attivita");
        IdAttivitaColumn.setCellValueFactory(new PropertyValueFactory<>("IdAttivita"));
        IdCommentoColumn = new TableColumn<>("Id commento");
        IdCommentoColumn.setCellValueFactory(new PropertyValueFactory<>("IdCommento"));
        TestoColumn = new TableColumn<>("Testo");
        TestoColumn.setCellValueFactory(new PropertyValueFactory<>("Testo"));
        LikesColumn = new TableColumn<>("Likes");
        LikesColumn.setCellValueFactory(new PropertyValueFactory<>("Likes"));

        // Configura le colonne direttamente nel codice
        this.commentTable.getColumns().addAll(IdUtenteColumn,
                IdSportColumn,
                IdAttivitaColumn,
                IdCommentoColumn,
                TestoColumn,
                LikesColumn);
    }

    List<String> getUserList() {
        String query = """
                SELECT IdUtente
                FROM UTENTI
                    """;
        try (final Statement statement = this.conn.createStatement()) {
            // Execute and save result
            // Replace postmark
            final ResultSet resultSet = statement.executeQuery(query);
            List<String> l = new LinkedList<>();

            try {
                while (resultSet.next()) {
                    l.add(Integer.toString(resultSet.getInt("IdUtente")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return l;
        } catch (final SQLException e) {
            throw new IllegalStateException(e);
        }
    }

}
