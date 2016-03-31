/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junglespeed.service;

import java.util.Random;
import javax.servlet.http.Part;
import junglespeed.entity.Joueur;
import junglespeed.entity.Partie;
import junglespeed.enumeration.StatutPartie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class ScheduledService {

    @Autowired
    private PartieCrudService partieCrudService;

    @Autowired
    private JoueurCrudService joueurCrudService;

    @Scheduled(fixedDelay = 1000)
    public void creerPartie() {
        while (partieCrudService.countByStatutPartie(StatutPartie.disponible) < 4) {
            Partie p = new Partie(StatutPartie.disponible);
            partieCrudService.save(p);
        }
    }

    @Scheduled(fixedDelay = 3000)
    public void retournerCarte() {

        for (Partie p : partieCrudService.findAll()) {
            Joueur j1 = p.getJoueurs().get(0);
            Joueur j2 = p.getJoueurs().get(1);

            String tabCouleur[] = {"red", "blue", "yellow", "green", "pink"};

            Random r = new Random();
            String couleurAleatoire = tabCouleur[r.nextInt(tabCouleur.length)];
            j1.setCouleur(couleurAleatoire);
            joueurCrudService.save(j1);

            Random r2 = new Random();
            String couleurAleatoire2 = tabCouleur[r.nextInt(tabCouleur.length)];
            j2.setCouleur(couleurAleatoire2);
            joueurCrudService.save(j2);
        }
    }
}
