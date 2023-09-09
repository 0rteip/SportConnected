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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Shoe;

public class ShoeTableController extends AbstractSceneController {

    @FXML
    private Button addShoeButton;
    @FXML
    private Button deleteShoeButton;
    @FXML
    private ChoiceBox<String> choiceShoeBox;
    @FXML
    private Tab addShoePage;
    @FXML
    private Tab deleteShoePage;
    @FXML
    private TableView<Shoe> shoeTable;
    private TableColumn<Shoe, Integer> IdUtenteColumn;
    private TableColumn<Shoe, String> ModelloColumn;
    private TableColumn<Shoe, String> NicknameColumn;
    private TableColumn<Shoe, Integer> IdMarcaColumn;
    @FXML
    private TextField deleteShoeNickField;
    @FXML
    private TextField deleteShoeUserField;
    @FXML
    private TextField modelShoeField;
    @FXML
    private TextField nameShoeField;
    @FXML
    private TextField nickShoeField;
    private Connection conn;

    @FXML
    private boolean addShoe() {
        final String query = "INSERT INTO SCARPE (IdUtente, Modello, Nickname, IdMarca) VALUE (?, ?, ?, ?)";
        try (final PreparedStatement statement = this.conn.prepareStatement(query)) {

            if (this.nameShoeField.getText() == "" || this.modelShoeField.getText() == "" ||
                    Objects.isNull(this.choiceShoeBox.getValue()) || this.nickShoeField.getText() == "" ||
                    !this.getUserList().contains(this.nameShoeField.getText())) {
                return false;
            }
            statement.setString(1, this.nameShoeField.getText());
            statement.setString(2, this.modelShoeField.getText());
            statement.setString(3, this.nickShoeField.getText());
            statement.setInt(4, this.getBrandId());
            
            statement.executeUpdate();
            this.refreshTable();

            return true;
        } catch (final SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private int getBrandId() {
        String query = "SELECT IdMarca FROM MARCHE WHERE Nome = '" + this.choiceShoeBox.getValue() + "'";
        try (final Statement st = this.conn.createStatement()) {
            ResultSet resultset = st.executeQuery(query);

            Integer id = 0;

            try {
                while (resultset.next()) {
                    id = resultset.getInt("IdMarca");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return id;
        } catch (final SQLException e) {
            throw new IllegalStateException(e);
        
        }
    }

    @FXML
    private boolean deleteShoe() {
        final String query = "DELETE FROM SCARPE WHERE IdUtente = ? AND Nickname = ?";
        try (final PreparedStatement statement = this.conn.prepareStatement(query)) {

            if (this.deleteShoeUserField.getText() == "" || this.deleteShoeNickField.getText() == "") {
                return false;
            }
            statement.setInt(1, Integer.parseInt(this.deleteShoeUserField.getText()));
            statement.setString(2, this.deleteShoeNickField.getText());

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
        this.populateShoeBox();
        this.createShoeTable();
        this.refreshTable();
    }

    private void populateShoeBox() {
        final String query = "SELECT Nome FROM MARCHE";
        try (final Statement statement = this.conn.createStatement()) {
            // Execute and save result
            final ResultSet resultSet = statement.executeQuery(query);
            try {
                List<String> l = new LinkedList<>();
                // (IdUtente, Nome, Cognome, DataDiNascita, Sesso,
                // FotoProfilo, Biografia, Res_Citta, Res_Provincia, Peso, Altezza)
                while (resultSet.next()) {
                    l.add(resultSet.getString("Nome"));
                }

                this.choiceShoeBox.getItems().addAll(l);
                this.choiceShoeBox.setValue(l.get(0));

            } catch (SQLException e) {
                e.printStackTrace();
            }
            // return readStudentsFromResultSet(resultSet);
        } catch (final SQLException e) {
            throw new IllegalStateException(e);
        }

        
    }

    private void refreshTable() {
        final String query = "SELECT * FROM SCARPE";
        try (final Statement statement = this.conn.createStatement()) {
            // Execute and save result
            final ResultSet resultSet = statement.executeQuery(query);
            try {
                ObservableList<Shoe> data = FXCollections.observableArrayList();
                // (IdUtente, Nome, Cognome, DataDiNascita, Sesso,
                // FotoProfilo, Biografia, Res_Citta, Res_Provincia, Peso, Altezza)
                while (resultSet.next()) {
                    Shoe s = new Shoe(
                            resultSet.getInt("IdUtente"),
                            resultSet.getString("Modello"),
                            resultSet.getString("Nickname"),
                            resultSet.getInt("IdMarca"));
                    data.add(s);
                }

                // Imposta i dati nella TableView
                this.shoeTable.setItems(data);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            // return readStudentsFromResultSet(resultSet);
        } catch (final SQLException e) {
            throw new IllegalStateException(e);
        }

    }

    private void createShoeTable() {
        IdUtenteColumn = new TableColumn<>("ID Utente");
        IdUtenteColumn.setCellValueFactory(new PropertyValueFactory<>("IdUtente"));
        ModelloColumn = new TableColumn<>("Modello");
        ModelloColumn.setCellValueFactory(new PropertyValueFactory<>("Modello"));
        NicknameColumn = new TableColumn<>("Nickname");
        NicknameColumn.setCellValueFactory(new PropertyValueFactory<>("Nickname"));
        IdMarcaColumn = new TableColumn<>("Id marca");
        IdMarcaColumn.setCellValueFactory(new PropertyValueFactory<>("IdMarca"));

        // Configura le colonne direttamente nel codice

        this.shoeTable.getColumns().addAll(IdUtenteColumn,
                ModelloColumn,
                NicknameColumn,
                IdMarcaColumn);
    }

    List<String> getUserList(){
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
