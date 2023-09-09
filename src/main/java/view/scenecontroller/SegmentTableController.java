package view.scenecontroller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Segment;

public class SegmentTableController extends AbstractSceneController {

    @FXML
    private Button addSegmentButton;
    @FXML
    private Button loadSegmentButton;
    @FXML
    private Button visualizeTopOnSegmentButton;
    @FXML
    private Button visualizeTopSegmentButton;
    @FXML
    private CheckBox privateSegmCheck;
    @FXML
    private ChoiceBox<Integer> choiceIdSport;
    @FXML
    private ChoiceBox<Integer> choiceIdSegment;
    @FXML
    private Label segmentLabel;
    @FXML
    private Tab addSegmentTab;
    @FXML
    private Tab operationSegmentTab;
    @FXML
    private TableView<Segment> segmentTable;
    private TableColumn<Segment, Boolean> VisibilitaColumn;
    private TableColumn<Segment, Integer> IdSegmentoColumn;
    private TableColumn<Segment, String> TracciaColumn;
    private TableColumn<Segment, String> NomeColumn;
    private TableColumn<Segment, Integer> IdSportColumn;
    private TableColumn<Segment, Integer> IdCaratteristicaColumn;
    @FXML
    private TextField nameSegmentField;
    @FXML
    private TextField userIdSegmentField;
    @FXML
    private TextField userIdTopField;
    private Connection conn;

    @FXML
    private void loadSegment() {
    }

    @FXML
    private void addSegment() {
    }

    @FXML
    private boolean visualizeTopSegment() {
        final String query = """
                SELECT A.IdUtente, SP.IdSegmento, S.Nome, min(SP.TempoPercorrenza) TempoMinimo, count(SP.TempoPercorrenza) NumVoltePercorso
                FROM ATTIVITA A, SEGMENTI_PERCORSI SP, SEGMENTI S
                WHERE A.IdSport=SP.IdSport
                AND A.IdAttivita=SP.IdAttivita
                AND S.IdSegmento=SP.IdSegmento
                AND A.IdUtente=?
                GROUP BY SP.IdSegmento, A.IdUtente, S.Nome
                ORDER BY A.IdUtente
                """;
        try (final PreparedStatement statement = this.conn.prepareStatement(query)) {
            // Execute and save result
            // Replace postmark
            if (this.userIdSegmentField.getText() == "") {
                return false;
            }
            statement.setInt(1, Integer.parseInt(this.userIdSegmentField.getText()));
            // Execute and save result
            final ResultSet resultSet = statement.executeQuery();
            // Inside a loop you should:

            System.out.println("\n" + //
                    ">>> \nMigliori tempi fatti da: " + this.userIdSegmentField.getText());
            try {
                while (resultSet.next()) {
                    System.out.println("Id Utente: " + resultSet.getInt("A.Idutente") + " - Id Segmento: "
                            + resultSet.getInt("SP.IdSegmento") + " - TempoMinimo: "
                            + this.formatTime(resultSet.getInt("TempoMinimo"))
                            + " - Volte Percorso: " + resultSet.getInt("NumVoltePercorso"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return true;
        } catch (final SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @FXML
    private boolean visualizeTopOnSegment() {
        final String query = """
                SELECT A.IdUtente, TempoPercorrenza
                FROM SEGMENTI_PERCORSI SP, ATTIVITA A
                WHERE A.IdSport=SP.IdSport
                AND A.IdAttivita=SP.IdAttivita
                AND SP.IdSegmento=?
                ORDER BY SP.TempoPercorrenza
                LIMIT 1;
                    """;
        try (final PreparedStatement statement = this.conn.prepareStatement(query)) {
            // Execute and save result
            // Replace postmark
            if (this.userIdTopField.getText() == "") {
                return false;
            }
            statement.setInt(1, Integer.parseInt(this.userIdTopField.getText()));
            // Execute and save result
            final ResultSet resultSet = statement.executeQuery();
            // Inside a loop you should:

            System.out.println("\n" + //
                    ">>> \nMiglior tempo fatto sul segmento: " + this.userIdTopField.getText());
            try {
                while (resultSet.next()) {
                    System.out.println("Id Utente: " + resultSet.getInt("A.Idutente") + " - Tempo: "
                            + this.formatTime(resultSet.getInt("TempoPercorrenza")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return true;
        } catch (final SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public void init(Connection conn) {
        this.conn = conn;

        this.createSegmentTable();
        this.refreshTable();
    }

    private void refreshTable() {
        final String query = "SELECT * FROM SEGMENTI";
        try (final Statement statement = this.conn.createStatement()) {
            // Execute and save result
            final ResultSet resultSet = statement.executeQuery(query);
            try {
                ObservableList<Segment> data = FXCollections.observableArrayList();
                // (IdUtente, Nome, Cognome, DataDiNascita, Sesso,
                // FotoProfilo, Biografia, Res_Citta, Res_Provincia, Peso, Altezza)
                while (resultSet.next()) {
                    Segment s = new Segment(
                            resultSet.getBoolean("Visibilita"),
                            resultSet.getInt("IdSegmento"),
                            resultSet.getString("Traccia"),
                            resultSet.getString("Nome"),
                            resultSet.getInt("IdSport"),
                            resultSet.getInt("IdCaratteristica"));
                    data.add(s);
                }

                // Imposta i dati nella TableView
                this.segmentTable.setItems(data);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            // return readStudentsFromResultSet(resultSet);
        } catch (final SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    private void createSegmentTable() {

        VisibilitaColumn = new TableColumn<>("Visibilita");
        VisibilitaColumn.setCellValueFactory(new PropertyValueFactory<>("Visibilita"));
        IdSegmentoColumn = new TableColumn<>("Id Segmento");
        IdSegmentoColumn.setCellValueFactory(new PropertyValueFactory<>("IdSegmento"));
        TracciaColumn = new TableColumn<>("Traccia");
        TracciaColumn.setCellValueFactory(new PropertyValueFactory<>("Traccia"));
        NomeColumn = new TableColumn<>("Nome");
        NomeColumn.setCellValueFactory(new PropertyValueFactory<>("Nome"));
        IdSportColumn = new TableColumn<>("Id Sport");
        IdSportColumn.setCellValueFactory(new PropertyValueFactory<>("IdSport"));
        IdCaratteristicaColumn = new TableColumn<>("Id Caratteristica");
        IdCaratteristicaColumn.setCellValueFactory(new PropertyValueFactory<>("IdCaratteristica"));

        // Configura le colonne direttamente nel codice

        this.segmentTable.getColumns().addAll(
                IdSegmentoColumn,
                TracciaColumn,
                NomeColumn,
                IdSportColumn,
                VisibilitaColumn,
                IdCaratteristicaColumn);
    }

    // Funzione per la formattazione del tempo da secondi a "h:mm:ss"
    private String formatTime(int seconds) {
        int ore = seconds / 3600;
        int minuti = (seconds % 3600) / 60;
        int secondi = seconds % 60;

        return String.format("%02d:%02d:%02d", ore, minuti, secondi);
    }

}
