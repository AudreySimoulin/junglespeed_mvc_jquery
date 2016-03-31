/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junglespeed.controller;

import java.util.Random;
import javax.servlet.http.HttpSession;
import junglespeed.entity.Joueur;
import junglespeed.entity.Partie;
import junglespeed.enumeration.StatutPartie;
import junglespeed.service.JoueurCrudService;
import junglespeed.service.PartieCrudService;
import junglespeed.service.ScheduledService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author admin
 */
@Controller
public class PartieController {

    @Autowired
    private PartieCrudService partieCrudService;

    @Autowired
    private JoueurCrudService joueurCrudService;
    
    @RequestMapping(value = "/listerParties", method = RequestMethod.GET)
    public String listerParties(Model model) {
        model.addAttribute("mesParties", partieCrudService.findByStatutPartie(StatutPartie.disponible));

        return "listeParties";
    }

    @RequestMapping(value = "/rejoindrePartieEcran/{idPartie}", method = RequestMethod.GET)
    public String rejoindrePartieEcran(Model model, @PathVariable(value = "idPartie") long id) {
        Joueur j = new Joueur("", 20, partieCrudService.findOne(id));
        joueurCrudService.save(j);
        model.addAttribute("joueur", j);
        return "ajout_joueur";
    }

    @RequestMapping(value = "/rejoindrePartieEcran/{idPartie}", method = RequestMethod.POST)
    public String rejoindrePartie(@ModelAttribute(value = "joueur") Joueur j, HttpSession session) {
        joueurCrudService.save(j);
        session.setAttribute("nom", j.getNom());
        Partie p = partieCrudService.findOne(j.getPartie().getId());
        p.getJoueurs().add(j);
        partieCrudService.save(p);
        demarrage(p);
        return "redirect:/jeu/" + p.getId();

    }

    public void demarrage(Partie p) {
        if (joueurCrudService.countByPartieId(p.getId()) == 2L) {
            p.setStatutPartie(StatutPartie.occupee);
            partieCrudService.save(p);
        }
    }

    @RequestMapping(value = "/jeu/{idPartie}", method = RequestMethod.GET)
    public String afficheJeu(Model model, @PathVariable(value = "idPartie") Long id) {
        Partie p = partieCrudService.findOne(id);

        for (Joueur j : p.getJoueurs()) {
            int i = joueurCrudService.findByPartieId(id).indexOf(j);

            model.addAttribute("joueur" + i, j);
        }
        return "jeu";
    }

}
