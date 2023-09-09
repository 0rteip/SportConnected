package view.scenecontroller;

import java.io.File;
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
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import model.Track;

public class TrackTableController extends AbstractSceneController {

    @FXML
    private TableView<Track> percTable;
    private TableColumn<Track, Integer> DescrizioneColumn;
    private TableColumn<Track, Integer> IdPercorsoColumn;
    private TableColumn<Track, Integer> TracciaColumn;
    private TableColumn<Track, Integer> NomeColumn;
    @FXML
    private Tab addPercPage;
    @FXML
    private TextArea percDescArea;
    @FXML
    private TextField namePercField;
    @FXML
    private Button loadTrackButton;
    @FXML
    private Button addTrackButton;
    @FXML
    private Label trackLabel;
    private Connection conn;

    @FXML
    private void loadTrack() {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(percTable.getScene().getWindow());
        if (selectedFile != null) {
            this.trackLabel.setText(selectedFile.getName());
        }
    }

    @FXML
    private boolean addPerc() {
        final String query = "\n" + //
                "INSERT INTO PERCORSI (IdPercorso, Descrizione, Traccia, Nome) VALUES (?, ?, ?, ?)";
        try (final PreparedStatement statement = this.conn.prepareStatement(query)) {

            if (this.trackLabel.getText() == "..." || this.percDescArea.getText() == ""
             || this.namePercField.getText() == "") {
                return false;
            }
            statement.setInt(1, this.lastTrackId()+1);
            statement.setString(2, this.percDescArea.getText());
            statement.setString(3, this.trackLabel.getText());
            statement.setString(4, this.namePercField.getText());
            
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

        this.createTrackTable();
        this.refreshTable();
    }

    private void createTrackTable() {
        IdPercorsoColumn = new TableColumn<>("IdPercorso");
        IdPercorsoColumn.setCellValueFactory(new PropertyValueFactory<>("IdPercorso"));
        NomeColumn = new TableColumn<>("Nome");
        NomeColumn.setCellValueFactory(new PropertyValueFactory<>("Nome"));
        DescrizioneColumn = new TableColumn<>("Descrizione");
        DescrizioneColumn.setCellValueFactory(new PropertyValueFactory<>("Descrizione"));
        TracciaColumn = new TableColumn<>("Traccia");
        TracciaColumn.setCellValueFactory(new PropertyValueFactory<>("Traccia"));

        // Configura le colonne direttamente nel codice

        this.percTable.getColumns().addAll(
                IdPercorsoColumn,
                NomeColumn,
                DescrizioneColumn,
                TracciaColumn);
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

    private void refreshTable() {
        final String query = "SELECT * FROM PERCORSI";
        try (final Statement statement = this.conn.createStatement()) {
            // Execute and save result
            final ResultSet resultSet = statement.executeQuery(query);
            try {
                ObservableList<Track> data = FXCollections.observableArrayList();
                // (IdUtente, Nome, Cognome, DataDiNascita, Sesso,
                // FotoProfilo, Biografia, Res_Citta, Res_Provincia, Peso, Altezza)
                while (resultSet.next()) {
                    Track s = new Track(
                            resultSet.getString("Descrizione"),
                            resultSet.getInt("IdPercorso"),
                            resultSet.getString("Traccia"),
                            resultSet.getString("Nome"));
                    data.add(s);
                }

                // Imposta i dati nella TableView
                this.percTable.setItems(data);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            // return readStudentsFromResultSet(resultSet);
        } catch (final SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    private int lastTrackId() {
        final String query = "SELECT IdPercorso FROM PERCORSI ORDER BY IdPercorso DESC LIMIT 1";
        try (final Statement statement = this.conn.createStatement()) {
            // Execute and save result
            final ResultSet result = statement.executeQuery(query);

            Integer id = 0;

            try {
                while (result.next()) {
                    id = result.getInt("IdPercorso");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return id;
        } catch (final SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
