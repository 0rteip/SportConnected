package model;

import java.sql.Date;

public class Activity {
    private int IdSport;
    private int IdAttivita;
    private int IdPercorso;
    private String Titolo;
    private boolean Visibilita;
    private Date Giorno;
    private int Distanza;
    private int TempoMovimento;
    private float VelocitaMedia;
    private int CalorieBruciate;
    private int Likes;
    private int DislivelloPositivo;
    private int DislivelloNegativo;
    private int AltitudineMax;
    private int TempoVascaMinore;
    private int IdUtente;

    public Activity(int idSport, int idAttivita, int idPercorso, String titolo, boolean visibilita, Date giorno,
            int distanza, int tempoMovimento, float velocitaMedia, int calorieBruciate, int likes,
            int dislivelloPositivo, int dislivelloNegativo, int altitudineMax, int tempoVascaMinore, int idUtente) {
        IdSport = idSport;
        IdAttivita = idAttivita;
        IdPercorso = idPercorso;
        Titolo = titolo;
        Visibilita = visibilita;
        Giorno = giorno;
        Distanza = distanza;
        TempoMovimento = tempoMovimento;
        VelocitaMedia = velocitaMedia;
        CalorieBruciate = calorieBruciate;
        Likes = likes;
        DislivelloPositivo = dislivelloPositivo;
        DislivelloNegativo = dislivelloNegativo;
        AltitudineMax = altitudineMax;
        TempoVascaMinore = tempoVascaMinore;
        IdUtente = idUtente;
    }

    public int getIdSport() {
        return IdSport;
    }

    public int getIdAttivita() {
        return IdAttivita;
    }

    public int getIdPercorso() {
        return IdPercorso;
    }

    public String getTitolo() {
        return Titolo;
    }

    public boolean isVisibilita() {
        return Visibilita;
    }

    public Date getGiorno() {
        return Giorno;
    }

    public int getDistanza() {
        return Distanza;
    }

    public int getTempoMovimento() {
        return TempoMovimento;
    }

    public float getVelocitaMedia() {
        return VelocitaMedia;
    }

    public int getCalorieBruciate() {
        return CalorieBruciate;
    }

    public int getLikes() {
        return Likes;
    }

    public int getDislivelloPositivo() {
        return DislivelloPositivo;
    }

    public int getDislivelloNegativo() {
        return DislivelloNegativo;
    }

    public int getAltitudineMax() {
        return AltitudineMax;
    }

    public int getTempoVascaMinore() {
        return TempoVascaMinore;
    }

    public int getIdUtente() {
        return IdUtente;
    }

    @Override
    public String toString() {
        return "Activity [IdSport=" + IdSport + ", IdAttivita=" + IdAttivita + ", IdPercorso=" + IdPercorso
                + ", Titolo=" + Titolo + ", Visibilita=" + Visibilita + ", Giorno=" + Giorno + ", Distanza=" + Distanza
                + ", TempoMovimento=" + TempoMovimento + ", VelocitaMedia=" + VelocitaMedia + ", CalorieBruciate="
                + CalorieBruciate + ", Likes=" + Likes + ", DislivelloPositivo=" + DislivelloPositivo
                + ", DislivelloNegativo=" + DislivelloNegativo + ", AltitudineMax=" + AltitudineMax
                + ", TempoVascaMinore=" + TempoVascaMinore + ", IdUtente=" + IdUtente + "]";
    }

    

}
