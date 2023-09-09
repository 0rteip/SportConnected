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
        return "ActivitiFollow [Utente=" + UNome + ", Sport=" + SNome + ", Percorso=" + PNome + "]"
                + " Activity [IdSport=" + getIdSport() + ", IdAttivita=" + getIdAttivita() + ", IdPercorso="
                + getIdPercorso()
                + ", Titolo=" + getTitolo() + ", Visibilita=" + isVisibilita() + ", Giorno=" + getGiorno()
                + ", Distanza=" + getDistanza()
                + ", TempoMovimento=" + getTempoMovimento() + ", VelocitaMedia=" + getVelocitaMedia()
                + ", CalorieBruciate="
                + getCalorieBruciate() + ", Likes=" + getLikes() + ", DislivelloPositivo=" + getDislivelloPositivo()
                + ", DislivelloNegativo=" + getDislivelloNegativo() + ", AltitudineMax=" + getAltitudineMax()
                + ", TempoVascaMinore=" + getTempoVascaMinore() + ", IdUtente=" + getIdUtente() + "]";
    }

}
