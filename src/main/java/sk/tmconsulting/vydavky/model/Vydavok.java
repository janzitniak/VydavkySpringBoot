package sk.tmconsulting.vydavky.model;


import jakarta.persistence.*;

import java.sql.Date;

@Entity(name = "cena")
@Table(name="vydavky")
public class Vydavok {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "popis") // odkazujeme sa, resp. vytvarame nazov stlpca v databaze
    private String popis;
    @Column(name = "cena", nullable = false) // odkazujeme sa, resp. vytvarame nazov stlpca v databaze
    private double cena;
    @Column(name = "kategoria", nullable = false)
    private String kategoria;
    @Column(name = "datum")
    private Date datum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPopis() {
        return popis;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }
}
