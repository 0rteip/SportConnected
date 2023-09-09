package view.scenecontroller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Activity;
import model.TableNames;

/**
 * Controller for activityTab.
 */
public class ActivityTableController extends AbstractSceneController {

    @FXML
    private TextField velMeanActivityField;
    @FXML
    private TextField titleActivityField;
    @FXML
    private TextField positiveActivityField;
    @FXML
    private TextField negativeActivityField;
    @FXML
    private TextField distanceActivityField;
    @FXML
    private TextField minSwimField;
    @FXML
    private TextField maxAltField;
    @FXML
    private TextField kalActivityField;
    @FXML
    private TextField userActivityField;
    @FXML
    private TextField deleteActivitySportField;
    @FXML
    private TextField deleteActivityActField;
    @FXML
    private TextField timeActivityField;
    @FXML
    private TableView<Activity> activityTable;

    private TableColumn<Activity, Integer> idSportColumn;
    private TableColumn<Activity, Integer> idAttivitaColumn;
    private TableColumn<Activity, Integer> idPercorsoColumn;
    private TableColumn<Activity, String> titoloColumn;
    private TableColumn<Activity, Boolean> visibilitaColumn;
    private TableColumn<Activity, Date> giornoColumn;
    private TableColumn<Activity, Integer> distanzaColumn;
    private TableColumn<Activity, Integer> tempoMovimentoColumn;
    private TableColumn<Activity, Float> velocitaMediaColumn;
    private TableColumn<Activity, Integer> calorieBruciateColumn;
    private TableColumn<Activity, Integer> likesColumn;
    private TableColumn<Activity, Integer> dislivelloPositivoColumn;
    private TableColumn<Activity, Integer> dislivelloNegativoColumn;
    private TableColumn<Activity, Integer> altitudineMaxColumn;
    private TableColumn<Activity, Integer> tempoVascaMinoreColumn;
    private TableColumn<Activity, Integer> idUtenteColumn;
    @FXML
    private Tab deleteActivityPage;
    @FXML
    private Tab addActivityPage;
    @FXML
    private Tab activityOperationPage;
    @FXML
    private DatePicker choiceToDate;
    @FXML
    private DatePicker choiceFromDate;
    @FXML
    private ChoiceBox<Integer> choiceTrackBox;
    @FXML
    private ChoiceBox<String> choiceSportBox;
    @FXML
    private ChoiceBox<String> activityChoiceBox;
    @FXML
    private CheckBox privateActivityBox;
    @FXML
    private Button visualizeActivityButton;
    @FXML
    private Button deleteActivityButton;

    @FXML
    private Button addActivity;
    private Connection conn;

    @FXML
    private boolean deleteActivity() {
        final String query = "DELETE FROM ATTIVITA WHERE IdSport = ? AND IdAttivita = ?";
        try (final PreparedStatement statement = this.conn.prepareStatement(query)) {

            if (this.deleteActivityActField.getText() == "" || this.deleteActivitySportField.getText() == "") {
                return false;
            }
            statement.setString(2, this.deleteActivityActField.getText());
            statement.setString(1, this.deleteActivitySportField.getText());

            statement.executeUpdate();

            this.refreshAll();

            return true;
        } catch (final SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @FXML
    private boolean addActivity() {
        final String query = """
                INSERT INTO ATTIVITA (IdSport, IdAttivita, IdPercorso, Titolo, Visibilita, Giorno, Distanza, TempoMovimento, VelocitaMedia, CalorieBruciate, Likes,
                IdUtente, DislivelloPositivo, DislivelloNegativo, AltitudineMax, TempoVascaMinore)
                VALUE (?, ?, ?, ?, ?, now(), ?, ?, ?, ?, 0, ?, ?, ?, ?, ?);
                    """;
        try (final PreparedStatement statement = this.conn.prepareStatement(query)) {
            if (this.titleActivityField.getText() == ""
                    || this.distanceActivityField.getText() == ""
                    || this.timeActivityField.getText() == ""
                    || this.velMeanActivityField.getText() == ""
                    || this.kalActivityField.getText() == ""
                    || this.userActivityField.getText() == "") {
                return false;
            }
            statement.setInt(1, this.getIdSport());
            statement.setInt(2, this.getActivityId());
            statement.setInt(3, this.choiceTrackBox.getValue());
            statement.setString(4, this.titleActivityField.getText());
            statement.setBoolean(5, this.privateActivityBox.isSelected());
            statement.setInt(6, Integer.parseInt(this.distanceActivityField.getText()));
            statement.setInt(7, Integer.parseInt(this.timeActivityField.getText()));
            statement.setFloat(8, Float.parseFloat(this.velMeanActivityField.getText()));
            statement.setInt(9, Integer.parseInt(this.kalActivityField.getText()));
            statement.setInt(10, Integer.parseInt(this.userActivityField.getText()));

            if (this.positiveActivityField.getText() == "") {
                statement.setNull(11, Types.INTEGER);
            } else {
                statement.setInt(11, Integer.parseInt(this.positiveActivityField.getText()));
            }

            if (this.negativeActivityField.getText() == "") {
                statement.setNull(12, Types.INTEGER);
            } else {
                statement.setInt(12, Integer.parseInt(this.negativeActivityField.getText()));
            }

            if (this.maxAltField.getText() == "") {
                statement.setNull(13, Types.INTEGER);
            } else {
                statement.setInt(13, Integer.parseInt(this.maxAltField.getText()));
            }

            if (this.minSwimField.getText() == "") {
                statement.setNull(14, Types.INTEGER);
            } else {
                statement.setInt(14, Integer.parseInt(this.minSwimField.getText()));
            }

            // if () {
            // return false;
            // }
            // statement.setInt(1, this.lastTrackId()+1);
            // statement.setString(2, this.percDescArea.getText());
            // statement.setString(3, this.trackLabel.getText());
            // statement.setString(4, this.namePercField.getText());

            statement.executeQuery();
            this.refreshAll();

            // statement.executeUpdate();
            // this.refreshTable();

            return true;
        } catch (final SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private int getActivityId() {
        final String query = "SELECT IdAttivita FROM ATTIVITA WHERE IdSport = " + this.getIdSport()
                + " ORDER BY IdAttivita DESC LIMIT 1";
        try (final Statement statement = this.conn.createStatement()) {
            // Execute and save result
            final ResultSet result = statement.executeQuery(query);

            Integer id = 0;

            try {
                while (result.next()) {
                    id = result.getInt("IdAttivita");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return id + 1;
        } catch (final SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    private int getIdSport() {
        final String query = "SELECT IdSport FROM SPORT WHERE Nome = '" + this.choiceSportBox.getValue() + "'";
        try (final Statement statement = this.conn.createStatement()) {
            // Execute and save result
            final ResultSet resultSet = statement.executeQuery(query);
            try {
                // (IdUtente, Nome, Cognome, DataDiNascita, Sesso,
                // FotoProfilo, Biografia, Res_Citta, Res_Provincia, Peso, Altezza)
                while (resultSet.next()) {
                    return resultSet.getInt("IdSport");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            // return readStudentsFromResultSet(resultSet);
        } catch (final SQLException e) {
            throw new IllegalStateException(e);
        }
        throw new IllegalStateException();
    }

    @FXML
    private boolean visualizeActivity() {
        final String query = """
                SELECT A.*
                FROM ATTIVITA A, SPORT S
                WHERE A.IdSport=S.IdSport
                AND S.Nome=?
                AND A.Giorno BETWEEN ? AND ?
                        """;
        try (final PreparedStatement statement = this.conn.prepareStatement(query)) {
            // Execute and save result
            // Replace postmark
            if (Objects.isNull(this.choiceToDate.getValue()) || Objects.isNull(this.choiceFromDate.getValue())) {
                return false;
            }

            statement.setString(1, this.activityChoiceBox.getValue());
            statement.setDate(2, Date.valueOf(this.choiceFromDate.getValue()));
            statement.setDate(3, Date.valueOf(this.choiceToDate.getValue()));

            // Execute and save result
            final ResultSet resultSet = statement.executeQuery();
            // Inside a loop you should:

            System.out.println("\n" + //
                    ">>> \nAttività di " + this.activityChoiceBox.getValue() + " svolte tra il "
                    + this.choiceFromDate.getValue() + " e il " + this.choiceToDate.getValue() + ": ");
            try {
                while (resultSet.next()) {

                    Activity activity = new Activity(
                            resultSet.getInt("A.IdSport"),
                            resultSet.getInt("A.IdAttivita"),
                            resultSet.getInt("A.IdPercorso"),
                            resultSet.getString("A.Titolo"),
                            resultSet.getBoolean("A.visibilita"),
                            resultSet.getDate("A.Giorno"),
                            resultSet.getInt("A.Distanza"),
                            resultSet.getInt("A.TempoMovimento"),
                            resultSet.getFloat("A.VelocitaMedia"),
                            resultSet.getInt("A.CalorieBruciate"),
                            resultSet.getInt("A.Likes"),
                            resultSet.getInt("A.DislivelloPositivo"),
                            resultSet.getInt("A.DislivelloNegativo"),
                            resultSet.getInt("A.AltitudineMax"),
                            resultSet.getInt("A.TempoVascaMinore"),
                            resultSet.getInt("A.IdUtente"));

                    System.out.println(activity);
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

        this.populateTrackBox();
        this.populateSportBox();
        this.createActivityTable();
        this.refreshTable();
    }

    @FXML
    private void refreshAll() {
        this.refreshTable();
        this.populateTrackBox();
        this.populateSportBox();
    }

    private void populateTrackBox() {
        final String query = "SELECT P.IdPercorso FROM PERCORSI P LEFT OUTER JOIN ATTIVITA A ON (A.IdPercorso=P.IdPercorso) WHERE A.Titolo IS NULL";
        try (final Statement statement = this.conn.createStatement()) {
            // Execute and save result
            final ResultSet resultSet = statement.executeQuery(query);
            try {
                List<Integer> l = new LinkedList<>();
                // (IdUtente, Nome, Cognome, DataDiNascita, Sesso,
                // FotoProfilo, Biografia, Res_Citta, Res_Provincia, Peso, Altezza)
                while (resultSet.next()) {
                    l.add(Integer.parseInt(resultSet.getString("P.IdPercorso")));
                }

                this.choiceTrackBox.getItems().clear();
                this.choiceTrackBox.getItems().addAll(l);
                if (!l.isEmpty()) {
                    this.choiceTrackBox.setValue(l.get(0));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            // return readStudentsFromResultSet(resultSet);
        } catch (final SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    private void populateSportBox() {
        final String query = "SELECT Nome FROM SPORT";
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

                this.choiceSportBox.getItems().clear();
                this.choiceSportBox.getItems().addAll(l);

                this.activityChoiceBox.getItems().clear();
                this.activityChoiceBox.getItems().addAll(l);
                if (!l.isEmpty()) {
                    this.choiceSportBox.setValue(l.get(0));
                    this.activityChoiceBox.setValue(l.get(0));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            // return readStudentsFromResultSet(resultSet);
        } catch (final SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    private void populateUserIdBox() {
        final String query = "SELECT Nome FROM SPORT";
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

                this.activityChoiceBox.getItems().clear();
                this.activityChoiceBox.getItems().addAll(l);
                if (!l.isEmpty()) {
                    this.activityChoiceBox.setValue(l.get(0));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            // return readStudentsFromResultSet(resultSet);
        } catch (final SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    private void createActivityTable() {
        idSportColumn = new TableColumn<>("ID Sport");
        idSportColumn.setCellValueFactory(new PropertyValueFactory<>("IdSport"));
        idAttivitaColumn = new TableColumn<>("ID Attivita");
        idAttivitaColumn.setCellValueFactory(new PropertyValueFactory<>("IdAttivita"));
        idPercorsoColumn = new TableColumn<>("ID Percorso");
        idPercorsoColumn.setCellValueFactory(new PropertyValueFactory<>("IdPercorso"));
        titoloColumn = new TableColumn<>("Titolo");
        titoloColumn.setCellValueFactory(new PropertyValueFactory<>("Titolo"));
        visibilitaColumn = new TableColumn<>("Visibilita");
        visibilitaColumn.setCellValueFactory(new PropertyValueFactory<>("Visibilita"));
        giornoColumn = new TableColumn<>("Giorno");
        giornoColumn.setCellValueFactory(new PropertyValueFactory<>("Giorno"));
        distanzaColumn = new TableColumn<>("Distanza");
        distanzaColumn.setCellValueFactory(new PropertyValueFactory<>("Distanza"));
        tempoMovimentoColumn = new TableColumn<>("TempoMoviemnto");
        tempoMovimentoColumn.setCellValueFactory(new PropertyValueFactory<>("TempoMovimento"));
        velocitaMediaColumn = new TableColumn<>("Vel Media");
        velocitaMediaColumn.setCellValueFactory(new PropertyValueFactory<>("VelocitaMedia"));
        calorieBruciateColumn = new TableColumn<>("cal bruciate");
        calorieBruciateColumn.setCellValueFactory(new PropertyValueFactory<>("CalorieBruciate"));
        likesColumn = new TableColumn<>("likes");
        likesColumn.setCellValueFactory(new PropertyValueFactory<>("Likes"));
        dislivelloPositivoColumn = new TableColumn<>("dislivello pos");
        dislivelloPositivoColumn.setCellValueFactory(new PropertyValueFactory<>("DislivelloPositivo"));
        dislivelloNegativoColumn = new TableColumn<>("dislivello neg");
        dislivelloNegativoColumn.setCellValueFactory(new PropertyValueFactory<>("DislivelloNegativo"));
        altitudineMaxColumn = new TableColumn<>("alt max");
        altitudineMaxColumn.setCellValueFactory(new PropertyValueFactory<>("AltitudineMax"));
        tempoVascaMinoreColumn = new TableColumn<>("tempo vasca minore");
        tempoVascaMinoreColumn.setCellValueFactory(new PropertyValueFactory<>("TempoVascaMinore"));
        idUtenteColumn = new TableColumn<>("ID utente");
        idUtenteColumn.setCellValueFactory(new PropertyValueFactory<>("IdUtente"));
        // Aggiungi altre colonne qui...

        // Aggiungi colonne alla TableView
        this.activityTable.getColumns().addAll(
                idSportColumn,
                idAttivitaColumn,
                idPercorsoColumn,
                titoloColumn,
                visibilitaColumn,
                giornoColumn,
                distanzaColumn,
                tempoMovimentoColumn,
                velocitaMediaColumn,
                calorieBruciateColumn,
                likesColumn,
                dislivelloPositivoColumn,
                dislivelloNegativoColumn,
                altitudineMaxColumn,
                tempoVascaMinoreColumn,
                idUtenteColumn);
    }

    private void refreshTable() {
        final String query = "SELECT * FROM " + TableNames.ACTIVITY.getTableName();
        try (final Statement statement = this.conn.createStatement()) {
            // Execute and save result
            final ResultSet resultSet = statement.executeQuery(query);
            try {
                ObservableList<Activity> data = FXCollections.observableArrayList();

                while (resultSet.next()) {
                    Activity activity = new Activity(resultSet.getInt("IdSport"), resultSet.getInt("IdAttivita"),
                            resultSet.getInt("IdPercorso"), resultSet.getString("Titolo"),
                            resultSet.getBoolean("visibilita"), resultSet.getDate("Giorno"),
                            resultSet.getInt("Distanza"),
                            resultSet.getInt("TempoMovimento"), resultSet.getFloat("VelocitaMedia"),
                            resultSet.getInt("CalorieBruciate"),
                            resultSet.getInt("Likes"),
                            resultSet.getInt("DislivelloPositivo"),
                            resultSet.getInt("DislivelloNegativo"),
                            resultSet.getInt("AltitudineMax"),
                            resultSet.getInt("TempoVascaMinore"),
                            resultSet.getInt("IdUtente"));
                    data.add(activity);
                }

                // Imposta i dati nella TableView
                this.activityTable.setItems(data);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            // return readStudentsFromResultSet(resultSet);
        } catch (final SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    List<Integer> getUserList() {
        String query = """
                SELECT IdUtente
                FROM UTENTI
                    """;
        try (final Statement statement = this.conn.createStatement()) {
            // Execute and save result
            // Replace postmark
            final ResultSet resultSet = statement.executeQuery(query);
            List<Integer> l = new LinkedList<>();

            try {
                while (resultSet.next()) {
                    l.add(resultSet.getInt("IdUtente"));
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
