package model;

public class Track {

    private String Descrizione;
    private int IdPercorso;
    private String Traccia;
    private String Nome;

    public Track(String descrizione, int idPercorso, String traccia, String nome) {
        Descrizione = descrizione;
        IdPercorso = idPercorso;
        Traccia = traccia;
        Nome = nome;
    }

    public String getDescrizione() {
        return Descrizione;
    }

    public int getIdPercorso() {
        return IdPercorso;
    }

    public String getTraccia() {
        return Traccia;
    }

    public String getNome() {
        return Nome;
    }

}
