package model;

public class Comment {
    private Integer IdSport;
    private Integer IdAttivita;
    private Integer IdCommento;
    private String Testo;
    private Integer Likes;
    private Integer IdUtente;

    public Comment(Integer idSport, Integer idAttivita, Integer idCommento, String testo, Integer likes,
            Integer idUtente) {
        IdSport = idSport;
        IdAttivita = idAttivita;
        IdCommento = idCommento;
        Testo = testo;
        Likes = likes;
        IdUtente = idUtente;
    }

    public Integer getIdSport() {
        return IdSport;
    }

    public Integer getIdAttivita() {
        return IdAttivita;
    }

    public Integer getIdCommento() {
        return IdCommento;
    }

    public String getTesto() {
        return Testo;
    }

    public Integer getLikes() {
        return Likes;
    }

    public Integer getIdUtente() {
        return IdUtente;
    }

}
