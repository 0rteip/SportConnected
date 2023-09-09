package view.scenecontroller;

import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import model.ActivitiFollow;
import model.TableNames;
import model.User;

public class UserTableController extends AbstractSceneController {

    @FXML
    private TextField userIdTotalActivityField;
    @FXML
    private TextField userIdFollowField;
    @FXML
    private TextField surnameField;
    @FXML
    private TextField provField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField heightField;
    @FXML
    private TextField genderField;
    @FXML
    private TextField weightField;
    @FXML
    private TextField deleteField;
    @FXML
    private TextField deleteUserField;
    @FXML
    private TextField cityField;
    @FXML
    private TextArea bioArea;
    @FXML
    private TableView<User> userTable;

    private TableColumn<User, Integer> IdUtenteColumn;
    private TableColumn<User, String> NomeColumn;
    private TableColumn<User, String> CognomeColumn;
    private TableColumn<User, Date> DataDiNascitaColumn;
    private TableColumn<User, String> SessoColumn;
    private TableColumn<User, String> FotoProfiloColumn;
    private TableColumn<User, String> BiografiaColumn;
    private TableColumn<User, String> Res_CittaColumn;
    private TableColumn<User, String> Res_ProvinciaColumn;
    private TableColumn<User, Float> PesoColumn;
    private TableColumn<User, Integer> AltezzaColumn;
    @FXML
    private Tab operationPage;
    @FXML
    private Tab deleteUserPage;
    @FXML
    private Tab addUserPage;
    @FXML
    private Label photoLabel;
    @FXML
    private DatePicker datePicker;
    @FXML
    private Button visualizeTotalDiistanceButton;
    @FXML
    private Button visualizeFollowActivitiesButton;
    @FXML
    private Button loadPhotoButton;
    @FXML
    private Button deleteUser;
    @FXML
    private Button addUserButton;
    @FXML
    private ChoiceBox<String> choiceGender;

    private Connection conn;

    @FXML
    private void loadPhoto() {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(userTable.getScene().getWindow());
        if (selectedFile != null) {
            this.photoLabel.setText(selectedFile.getName());
        }
    }

    @FXML
    private boolean deleteUser() {
        final String query = "DELETE FROM " + TableNames.USERS.getTableName() +
                " WHERE IdUtente = ? ";
        try (final PreparedStatement statement = this.conn.prepareStatement(query)) {

            if (this.deleteUserField.getText() == "") {
                return false;
            }
            statement.setString(1, this.deleteUserField.getText());

            System.out.println("delete");
            statement.executeUpdate();
            System.out.println("Agg");

            this.refreshTable();
            return true;
        } catch (final SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @FXML
    private boolean visualizeActivities() {
        String query = """
                SELECT U1.Nome, A.*, S.Nome Sport, P.Nome NomePercorso
                FROM  UTENTI U, FOLLOW F, UTENTI U1, ATTIVITA A, PERCORSI P, SPORT S
                WHERE F.IdUtente=U.IdUtente
                AND U1.IdUtente=F.Seg_IdUtente
                AND U1.IdUtente=A.IdUtente
                AND A.IdPercorso=P.IdPercorso
                AND A.IdSport=S.IdSport
                AND A.Visibilita=true
                AND U.IdUtente=?
                """;
        try (final PreparedStatement statement = this.conn.prepareStatement(query)) {
            // Execute and save result
            // Replace postmark
            if (this.userIdFollowField.getText() == "") {
                return false;
            }
            statement.setInt(1, Integer.parseInt(this.userIdFollowField.getText()));
            // Execute and save result
            final ResultSet resultSet = statement.executeQuery();

            final List<ActivitiFollow> act = new ArrayList<>();
            // Inside a loop you should:

            System.out.println("Attività svolte dai seguiti di: " + this.userIdFollowField.getText());
            try {
                while (resultSet.next()) {
                    final ActivitiFollow a = new ActivitiFollow(resultSet.getInt("A.IdSport"),
                            resultSet.getInt("A.IdAttivita"),
                            resultSet.getInt("A.IdPercorso"),
                            resultSet.getString("A.Titolo"),
                            resultSet.getBoolean("A.Visibilita"),
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
                            resultSet.getInt("A.IdUtente"),
                            resultSet.getString("U1.Nome"),
                            resultSet.getString("Sport"),
                            resultSet.getString("NomePercorso"));
                    System.out.println(a);
                    act.add(a);
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
    private boolean addUser() {
        System.out.println("Utente");
        final String query = "INSERT INTO " + TableNames.USERS.getTableName() +
                "(IdUtente, Nome, Cognome, DataDiNascita, Sesso, FotoProfilo, Biografia, Res_Citta, Res_Provincia, Peso, Altezza)"
                +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (final PreparedStatement statement = this.conn.prepareStatement(query)) {

            if (this.nameField.getText() == "" || this.surnameField.getText() == "" ||
                    Objects.isNull(this.datePicker.getValue())) {
                return false;
            }
            System.out.println("ok 1");
            statement.setInt(1, this.lastUserID() + 1);
            statement.setString(2, this.nameField.getText());
            statement.setString(3, this.surnameField.getText());
            statement.setDate(4, Date.valueOf(this.datePicker.getValue()));
            statement.setString(5, this.choiceGender.getValue());

            if (this.photoLabel.getText() == "") {
                statement.setNull(6, Types.CHAR);
            } else {
                statement.setString(6, this.photoLabel.getText());
            }

            statement.setString(7, this.bioArea.getText());

            if ((this.cityField.getText() == "" && this.provField.getText() != "")
                    || (this.cityField.getText() != "" && this.provField.getText() == "")) {
                System.out.println("ok 4");

                return false;
            } else {
                statement.setString(8, this.cityField.getText());
                statement.setString(9, this.provField.getText());
            }

            if (this.weightField.getText() != "") {
                statement.setInt(10, Integer.parseInt(this.weightField.getText()));
            } else {
                statement.setNull(10, Types.INTEGER);
            }

            if (this.heightField.getText() != "") {
                statement.setInt(11, Integer.parseInt(this.heightField.getText()));
            } else {
                statement.setNull(11, Types.INTEGER);
            }

            System.out.println("ok 2");
            statement.executeUpdate();

            this.refreshTable();
            return true;

        } catch (final SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @FXML
    private boolean visualizeTotalDistance() {
        String query = """
                SELECT U.IdUtente, U.Nome, sum(A.Distanza) DistanzaAnnuale
                FROM ATTIVITA A, UTENTI U
                WHERE U.IdUtente=A.IdUtente
                AND U.IdUtente=?
                AND year(A.Giorno)=year(now())
                GROUP BY U.IdUtente, U.Nome;
                    """;
        try (final PreparedStatement statement = this.conn.prepareStatement(query)) {
            // Execute and save result
            // Replace postmark
            if (this.userIdTotalActivityField.getText() == "") {
                return false;
            }
            statement.setInt(1, Integer.parseInt(this.userIdTotalActivityField.getText()));
            // Execute and save result
            final ResultSet resultSet = statement.executeQuery();

            System.out.println("Distanza totale percorsa quest'anno");
            try {
                while (resultSet.next()) {
                    System.out.println("IdUtente: " + resultSet.getString("U.IdUtente")
                            + " - Nome: " + resultSet.getString("U.Nome")
                            + " - Distanza: " + resultSet.getInt("DistanzaAnnuale"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return true;
        } catch (final SQLException e) {
            throw new IllegalStateException(e);
        }

    }

    public void init(final Connection conn) {
        this.conn = Objects.requireNonNull(conn);

        this.choiceGender.getItems().add("M");
        this.choiceGender.getItems().add("F");
        this.choiceGender.setValue("M");

        this.createUserTable();
        this.refreshTable();
    }

    private int lastUserID() {
        final String query = "SELECT IdUtente FROM "
                + TableNames.USERS.getTableName()
                + " ORDER BY IdUtente DESC LIMIT 1";
        try (final Statement statement = this.conn.createStatement()) {
            // Execute and save result
            final ResultSet result = statement.executeQuery(query);

            Integer id = 0;

            try {
                while (result.next()) {
                    id = result.getInt("IdUtente");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return id;
        } catch (final SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    private void refreshTable() {
        final String query = "SELECT * FROM " + TableNames.USERS.getTableName();
        try (final Statement statement = this.conn.createStatement()) {
            // Execute and save result
            final ResultSet resultSet = statement.executeQuery(query);
            try {
                ObservableList<User> data = FXCollections.observableArrayList();
                // (IdUtente, Nome, Cognome, DataDiNascita, Sesso,
                // FotoProfilo, Biografia, Res_Citta, Res_Provincia, Peso, Altezza)
                while (resultSet.next()) {
                    User user = new User(resultSet.getInt("IdUtente"),
                            resultSet.getString("Nome"),
                            resultSet.getString("Cognome"), resultSet.getDate("DataDiNascita"),
                            resultSet.getString("Sesso"),
                            resultSet.getString("FotoProfilo"),
                            resultSet.getString("Biografia"),
                            resultSet.getString("Res_Citta"),
                            resultSet.getString("Res_Provincia"), resultSet.getFloat("Peso"),
                            resultSet.getInt("Altezza"));

                    data.add(user);
                }

                // Imposta i dati nella TableView
                this.userTable.setItems(data);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            // return readStudentsFromResultSet(resultSet);
        } catch (final SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    private void createUserTable() {
        IdUtenteColumn = new TableColumn<>("ID Utente");
        IdUtenteColumn.setCellValueFactory(new PropertyValueFactory<>("IdUtente"));
        NomeColumn = new TableColumn<>("Nome");
        NomeColumn.setCellValueFactory(new PropertyValueFactory<>("Nome"));
        CognomeColumn = new TableColumn<>("Cognome");
        CognomeColumn.setCellValueFactory(new PropertyValueFactory<>("Cognome"));
        DataDiNascitaColumn = new TableColumn<>("Data");
        DataDiNascitaColumn.setCellValueFactory(new PropertyValueFactory<>("DataDiNascita"));
        SessoColumn = new TableColumn<>("Sesso");
        SessoColumn.setCellValueFactory(new PropertyValueFactory<>("Sesso"));
        FotoProfiloColumn = new TableColumn<>("Foto");
        FotoProfiloColumn.setCellValueFactory(new PropertyValueFactory<>("FotoProfilo"));
        BiografiaColumn = new TableColumn<>("Biografia");
        BiografiaColumn.setCellValueFactory(new PropertyValueFactory<>("Biografia"));
        Res_CittaColumn = new TableColumn<>("Citta");
        Res_CittaColumn.setCellValueFactory(new PropertyValueFactory<>("Res_Citta"));
        Res_ProvinciaColumn = new TableColumn<>("Prv");
        Res_ProvinciaColumn.setCellValueFactory(new PropertyValueFactory<>("Res_Provincia"));
        PesoColumn = new TableColumn<>("Peso");
        PesoColumn.setCellValueFactory(new PropertyValueFactory<>("Peso"));
        AltezzaColumn = new TableColumn<>("Altezza");
        AltezzaColumn.setCellValueFactory(new PropertyValueFactory<>("Altezza"));
        // Configura le colonne direttamente nel codice

        this.userTable.getColumns().addAll(IdUtenteColumn,
                NomeColumn,
                CognomeColumn,
                DataDiNascitaColumn,
                SessoColumn,
                FotoProfiloColumn,
                BiografiaColumn,
                Res_CittaColumn,
                Res_ProvinciaColumn,
                PesoColumn,
                AltezzaColumn);

    }

}
