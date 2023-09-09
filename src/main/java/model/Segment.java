package model;

public class Segment {
    private boolean Visibilita;
    private Integer IdSegmento;
    private String Traccia;
    private String Nome;
    private int IdSport;
    private int IdCaratteristica;

    public Segment(boolean visibilita, Integer idSegmento, String traccia, String nome, int idSport,
            int idCaratteristica) {
        Visibilita = visibilita;
        IdSegmento = idSegmento;
        Traccia = traccia;
        Nome = nome;
        IdSport = idSport;
        IdCaratteristica = idCaratteristica;
    }

    public boolean isVisibilita() {
        return Visibilita;
    }

    public Integer getIdSegmento() {
        return IdSegmento;
    }

    public String getTraccia() {
        return Traccia;
    }

    public String getNome() {
        return Nome;
    }

    public int getIdSport() {
        return IdSport;
    }

    public int getIdCaratteristica() {
        return IdCaratteristica;
    }

}
