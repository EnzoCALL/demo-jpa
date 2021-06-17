package fr.diginamic;

import fr.diginamic.entities.Client;
import fr.diginamic.entities.Emprunt;
import fr.diginamic.entities.Livre;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ConnexionJpa {

    public static void main(String[] args) {
        //Je crée mon factory pour communiquer avec la base de données
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("biblio");
        EntityManager em = entityManagerFactory.createEntityManager();

        //Je débute la transaction
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        //Je cherche dans la base de donnéees le livre qui a pour ID 1 et j'affiche ses informations
        Livre livre = em.find(Livre.class, 1);
        System.out.println("Le livre trouvé est: " + livre.getTitre() + " écrit par " +livre.getAuteur());

        //Je vérifie tout les emprunts d'un client
        Client cli = em.find(Client.class, 1);
        for (Emprunt emp: cli.getEmprunts()) {
            System.out.println(emp);
        }

        //Je vérifie tout les livres d'un emprunt
        System.out.println("\n");

        Emprunt emp = em.find(Emprunt.class, 1);
        for (Livre liv: emp.getLivres()) {
            System.out.println(emp + " -- " + liv);
        }

        //J'arrête la transaction
        transaction.commit();
        em.close();
    }
}
