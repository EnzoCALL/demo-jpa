package fr.diginamic.entities;

import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name="emprunt")
public class Emprunt {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "DATE_DEBUT")
    private LocalDate dateDeb;

    @Column(name = "DATE_FIN")
    private LocalDate dateFin;

    @Column(name = "DELAI")
    private int delai;

    @ManyToOne //------------------------ Plusieurs emprunts par client possibles
    @JoinColumn(name="ID_CLIENT")
    private Client client;

    @ManyToMany
    @JoinTable(name="Compo",
            joinColumns = @JoinColumn(name="ID_EMP", referencedColumnName="ID"),
            inverseJoinColumns = @JoinColumn(name="ID_LIV", referencedColumnName="ID")
    )
    private Set<Livre> livres;


    public Emprunt() {
    }

    public Emprunt(int id, LocalDate dateDeb, LocalDate dateFin, int delai, int idClient) {
        this.id = id;
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
        this.delai = delai;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDateDeb() {
        return dateDeb;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public int getDelai() { return delai; }

    public void setId(int id) {
        this.id = id;
    }

    public void setDateDeb(LocalDate dateDeb) {
        this.dateDeb = dateDeb;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public void setDelai(int delai) {
        this.delai = delai;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setLivres(Set<Livre> livres) {
        this.livres = livres;
    }

    public Set<Livre> getLivres() {
        return livres;
    }

    @Override
    public String toString() {
        return "Numero de l'emprunt: " + id + " -- " + client;
    }
}