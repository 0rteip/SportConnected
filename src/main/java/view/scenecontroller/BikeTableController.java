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
import model.Biclicle;

public class BikeTableController extends AbstractSceneController {

    @FXML
    private Button addBikeButton;
    @FXML
    private Button deleteBikeButton;
    @FXML
    private ChoiceBox<String> choiceBikeBox;
    @FXML
    private Tab addBikePage;
    @FXML
    private Tab deleteBikePage;
    @FXML
    private TableView<Biclicle> bikeTable;
    private TableColumn<Biclicle, Integer> IdUtenteColumn;
    private TableColumn<Biclicle, String> ModelloColumn;
    private TableColumn<Biclicle, String> NicknameColumn;
    private TableColumn<Biclicle, Integer> IdTipologiaColumn;
    @FXML
    private TextField deleteBikeNickField;
    @FXML
    private TextField deleteBikeUserField;
    @FXML
    private TextField modelBikeField;
    @FXML
    private TextField nameBikeField;
    @FXML
    private TextField nickBikeField;
    private Connection conn;

    @FXML
    private boolean addBike() {
        final String query = "INSERT INTO BICICLETTE (IdUtente, Modello, Nickname, IdTipologia) VALUE (?, ?, ?, ?)";
        try (final PreparedStatement statement = this.conn.prepareStatement(query)) {

            if (this.nameBikeField.getText() == "" || this.modelBikeField.getText() == "" ||
                    Objects.isNull(this.choiceBikeBox.getValue()) || this.nickBikeField.getText() == "" ||
                    !this.getUserList().contains(this.nameBikeField.getText())) {
                return false;
            }
            statement.setString(1, this.nameBikeField.getText());
            statement.setString(2, this.modelBikeField.getText());
            statement.setString(3, this.nickBikeField.getText());
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
        String query = "SELECT IdTipologia FROM TIPOLOGIE WHERE Nome = '" + this.choiceBikeBox.getValue() + "'";
        try (final Statement st = this.conn.createStatement()) {
            ResultSet resultset = st.executeQuery(query);

            Integer id = 0;

            try {
                while (resultset.next()) {
                    id = resultset.getInt("IdTipologia");
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
    private boolean deleteBike() {
        final String query = "DELETE FROM BICICLETTE WHERE IdUtente = ? AND Nickname = ?";
        try (final PreparedStatement statement = this.conn.prepareStatement(query)) {

            if (this.deleteBikeUserField.getText() == "" || this.deleteBikeNickField.getText() == "") {
                return false;
            }
            statement.setInt(1, Integer.parseInt(this.deleteBikeUserField.getText()));
            statement.setString(2, this.deleteBikeNickField.getText());

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
        this.populateBikeBox();
        this.createBikeTable();
        this.refreshTable();
    }

    private void populateBikeBox() {
        final String query = "SELECT Nome FROM TIPOLOGIE";
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

                this.choiceBikeBox.getItems().addAll(l);
                this.choiceBikeBox.setValue(l.get(0));

            } catch (SQLException e) {
                e.printStackTrace();
            }
            // return readStudentsFromResultSet(resultSet);
        } catch (final SQLException e) {
            throw new IllegalStateException(e);
        }

        
    }

    private void refreshTable() {
        final String query = "SELECT * FROM BICICLETTE";
        try (final Statement statement = this.conn.createStatement()) {
            // Execute and save result
            final ResultSet resultSet = statement.executeQuery(query);
            try {
                ObservableList<Biclicle> data = FXCollections.observableArrayList();
                // (IdUtente, Nome, Cognome, DataDiNascita, Sesso,
                // FotoProfilo, Biografia, Res_Citta, Res_Provincia, Peso, Altezza)
                while (resultSet.next()) {
                    Biclicle s = new Biclicle(
                            resultSet.getInt("IdUtente"),
                            resultSet.getString("Modello"),
                            resultSet.getString("Nickname"),
                            resultSet.getInt("IdTipologia"));
                    data.add(s);
                }

                // Imposta i dati nella TableView
                this.bikeTable.setItems(data);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            // return readStudentsFromResultSet(resultSet);
        } catch (final SQLException e) {
            throw new IllegalStateException(e);
        }

    }

    private void createBikeTable() {
        IdUtenteColumn = new TableColumn<>("ID Utente");
        IdUtenteColumn.setCellValueFactory(new PropertyValueFactory<>("IdUtente"));
        ModelloColumn = new TableColumn<>("Modello");
        ModelloColumn.setCellValueFactory(new PropertyValueFactory<>("Modello"));
        NicknameColumn = new TableColumn<>("Nickname");
        NicknameColumn.setCellValueFactory(new PropertyValueFactory<>("Nickname"));
        IdTipologiaColumn = new TableColumn<>("Id marca");
        IdTipologiaColumn.setCellValueFactory(new PropertyValueFactory<>("IdTipologia"));

        // Configura le colonne direttamente nel codice

        this.bikeTable.getColumns().addAll(IdUtenteColumn,
                ModelloColumn,
                NicknameColumn,
                IdTipologiaColumn);
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
