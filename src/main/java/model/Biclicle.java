package model;

public class Biclicle {
    private int IdUtente;
    private String Modello;
    private String Nickname;
    private int IdTipologia;

    public Biclicle(int idUtente, String modello, String nickname, int idTipologia) {
        IdUtente = idUtente;
        Modello = modello;
        Nickname = nickname;
        IdTipologia = idTipologia;
    }

    public int getIdUtente() {
        return IdUtente;
    }

    public String getModello() {
        return Modello;
    }

    public String getNickname() {
        return Nickname;
    }

    public int getIdTipologia() {
        return IdTipologia;
    }

}
