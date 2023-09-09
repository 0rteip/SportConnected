package model;

import java.sql.Date;

//  IdUtente	int(11) PK
// 	Nome	varchar(20)
// 	Cognome	varchar(20)
// 	DataDiNascita	date
// 	Sesso	char(1)
// 	FotoProfilo	varchar(30)
// 	Biografia	varchar(300)
// 	Res_Citta	varchar(20)
// 	Res_Provincia	char(2)
// 	Peso	float
// 	Altezza	int(11)

public class User {
    private int IdUtente;
    private String Nome;
    private String Cognome;
    private Date DataDiNascita;
    private String Sesso;
    private String FotoProfilo;
    private String Biografia;
    private String Res_Citta;
    private String Res_Provincia;
    private float Peso;

    public User(int idUtente, String nome, String cognome, Date dataDiNascita, String sesso, String fotoProfilo,
            String biografia, String res_Citta, String res_Provincia, float peso, int altezza) {
        IdUtente = idUtente;
        Nome = nome;
        Cognome = cognome;
        DataDiNascita = dataDiNascita;
        Sesso = sesso;
        FotoProfilo = fotoProfilo;
        Biografia = biografia;
        Res_Citta = res_Citta;
        Res_Provincia = res_Provincia;
        Peso = peso;
        Altezza = altezza;
    }

    private int Altezza;

    public int getIdUtente() {
        return IdUtente;
    }

    public String getNome() {
        return Nome;
    }

    public String getCognome() {
        return Cognome;
    }

    public Date getDataDiNascita() {
        return DataDiNascita;
    }

    public String getSesso() {
        return Sesso;
    }

    public String getFotoProfilo() {
        return FotoProfilo;
    }

    public String getBiografia() {
        return Biografia;
    }

    public String getRes_Citta() {
        return Res_Citta;
    }

    public String getRes_Provincia() {
        return Res_Provincia;
    }

    public float getPeso() {
        return Peso;
    }

    public int getAltezza() {
        return Altezza;
    }

}
