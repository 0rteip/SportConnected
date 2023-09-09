package model;

import java.sql.Date;

public class ActivitiFollow extends Activity {

    private String UNome;
    private String SNome;
    private String PNome;

    public ActivitiFollow(int idSport, int idAttivita, int idPercorso, String titolo, boolean visibilita, Date giorno,
            int distanza, int tempoMovimento, float velocitaMedia, int calorieBruciate, int likes,
            int dislivelloPositivo, int dislivelloNegativo, int altitudineMax, int tempoVascaMinore, int idUtente,
            String uNome, String sNome, String pNome) {
        super(idSport, idAttivita, idPercorso, titolo, visibilita, giorno, distanza, tempoMovimento, velocitaMedia,
                calorieBruciate, likes, dislivelloPositivo, dislivelloNegativo, altitudineMax, tempoVascaMinore,
                idUtente);
        UNome = uNome;
        SNome = sNome;
        PNome = pNome;
    }

    public String getUNome() {
        return UNome;
    }

    public String getSNome() {
        return SNome;
    }

    public String getPNome() {
        return PNome;
    }

    @Override
    public String toString() {
        return "Info Generali\n"
                + "\t- Utente: " + UNome + "\n"
                + "\t- Sport: " + SNome + "\n"
                + "\t- Percorso: " + PNome + "\n"
                + "\tSpecifiche attivita\n"
                + "\t\t- IdSport: " + getIdSport() + "\n"
                + "\t\t- IdAttivita: " + getIdAttivita() + "\n"
                + "\t\t- IdPercorso: " + getIdPercorso() + "\n"
                + "\t\t- Titolo: " + getTitolo() + "\n"
                + "\t\t- Visibilita: " + isVisibilita() + "\n"
                + "\t\t- Giorno: " + getGiorno() + "\n"
                + "\t\t- Distanza: " + getDistanza() + "\n"
                + "\t\t- TempoMovimento: " + getTempoMovimento() + "\n"
                + "\t\t- VelocitaMedia: " + getVelocitaMedia() + "\n"
                + "\t\t- CalorieBruciate: " + getCalorieBruciate() + "\n"
                + "\t\t- Likes: " + getLikes() + "\n"
                + "\t\t- DislivelloPositivo: " + getDislivelloPositivo() + "\n"
                + "\t\t- DislivelloNegativo: " + getDislivelloNegativo() + "\n"
                + "\t\t- AltitudineMax: " + getAltitudineMax() + "\n"
                + "\t\t- TempoVascaMinore: " + getTempoVascaMinore() + "\n"
                + "\t\t- IdUtente: " + getIdUtente();

    }

}
