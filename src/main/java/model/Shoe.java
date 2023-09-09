package model;

public class Shoe {

    private int IdUtente;
    private String Modello;
    private String Nickname;
    private int IdMarca;

    //

    public int getIdUtente() {
        return IdUtente;
    }

    public Shoe(int idUtente, String modello, String nickname, int idMarca) {
        IdUtente = idUtente;
        Modello = modello;
        Nickname = nickname;
        IdMarca = idMarca;
    }

    public String getModello() {
        return Modello;
    }

    public String getNickname() {
        return Nickname;
    }

    public int getIdMarca() {
        return IdMarca;
    }

}
