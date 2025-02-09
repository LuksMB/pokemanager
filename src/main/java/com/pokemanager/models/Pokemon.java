package com.pokemanager.models;
import java.io.Serializable;

public class Pokemon implements Serializable{
    private static final long serialVersionUID = 1L;
    private String nickname;
    private String specie;
    private String type;

    public Pokemon(String nickname, String specie, String type) {
        this.nickname = nickname;
        this.specie = specie;
        this.type = type;
    }

    public String getNickname() {
        return nickname;
    }
    

    @Override
    public String toString() {
        return "Pokemon{" + "nickname='" + this.nickname + '\'' + ", specie=" + this.specie + '\'' + ", type=" + this.type + '}';
    }

}
