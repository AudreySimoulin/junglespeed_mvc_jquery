/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junglespeed.service;

import java.util.List;
import junglespeed.entity.Joueur;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author admin
 */
public interface JoueurCrudService extends CrudRepository<Joueur, Long>{
    
    public long countByPartieId(long idPartie);
    
    public List<Joueur> findByPartieId(long idPartie);
}
