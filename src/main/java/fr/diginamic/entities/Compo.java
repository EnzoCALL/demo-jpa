package fr.diginamic.entities;

import javax.persistence.*;

@Entity
@Table(name="compo")
public class Compo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "ID_LIV")
    private int idLiv;

    @Column(name = "ID_EMP")
    private int idEmp;

    public Compo() {
    }

    public Compo(int id, int idLiv, int idEmp) {
        this.id = id;
        this.idLiv = idLiv;
        this.idEmp = idEmp;
    }

    public int getId() {
        return id;
    }

    public int getIdLiv() {
        return idLiv;
    }

    public int getIdEmp() {
        return idEmp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdLiv(int idLiv) {
        this.idLiv = idLiv;
    }

    public void setIdEmp(int idEmp) {
        this.idEmp = idEmp;
    }
}