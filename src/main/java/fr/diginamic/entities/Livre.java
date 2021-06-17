package fr.diginamic.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="livre")
public class Livre {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name="TITRE")
    private  String titre;

    @Column(name="AUTEUR")
    private String auteur;

    @ManyToMany
    @JoinTable(name="Compo",
            joinColumns = @JoinColumn(name="ID_LIV", referencedColumnName="ID"),
            inverseJoinColumns = @JoinColumn(name="ID_EMP", referencedColumnName="ID"))
    private Set<Emprunt> emprunts;

    public Livre() {
    }

    public Livre(int id, String titre, String auteur) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
    }

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public Set<Emprunt> getEmprunts() {
        return emprunts;
    }

    public void setEmprunts(Set<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }

    @Override
    public String toString() {
        return "Titre du livre: " + titre;
    }
}
