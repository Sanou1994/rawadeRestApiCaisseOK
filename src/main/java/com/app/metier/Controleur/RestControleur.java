package com.app.metier.Controleur;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.metier.Service.RestService;
import com.app.metier.entities.Connexion;
import com.app.metier.entities.Dates;
import com.app.metier.entities.Majournee;
import com.app.metier.entities.Position;
import com.app.metier.entities.PositionPost;
import com.app.metier.entities.SoldeCloturerJournee;
import com.app.metier.entities.SoldeDebuterAnnee;
import com.app.metier.entities.SoldeDebuterJournee;
import com.app.metier.entities.Soldereel;
import com.app.metier.entities.Transaction;
import com.app.metier.entities.Utilisateur;
import com.app.metier.entities.history;
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class RestControleur {
    @Autowired(required=true)
    private RestService service;
    
    //CRUD SOLDEDEBUTERANNNE
    @GetMapping("/soldedebuterannees")
    public List<SoldeDebuterAnnee> listeSoldeDebuterAnnee() {
        return service.getAllSoldeDebuterAnnees();
    }
    @GetMapping("/soldedebuterannees/{id}")
    public SoldeDebuterAnnee getSoldeDebuterAnneeById(@PathVariable(value = "id") int userId) {   
        return service.getSoldeDebuterAnneeById(userId);
    }
    
    @PostMapping("/soldedebuterannees/ajouter")
    public SoldeDebuterAnnee createSoldeDebuterAnnee( @RequestBody SoldeDebuterAnnee user) {
        return service.createOrUpdateSoldeDebuterAnnee(user);
    }
    
    
    @PutMapping("/position/modifier/{id}/{status}")
    public Position modifierPosition(@PathVariable(value = "id") int idU,@PathVariable(value = "status") boolean status) {
        return service.updatePosition(idU, status);
    }
    @PostMapping("/position/rechercher/id/date")
    public  List<Position> positions( @RequestBody PositionPost position){
    	return service.getPositionByIdUAndDate(position.getIdU(),position.getDate());
     }
    @GetMapping("/position/rechercher/status/{status}")
    public  List<Position> position(@PathVariable(value = "status") boolean userId){
    	return service.getPositionByStatus(userId);
     }
	@GetMapping("/dates")
    public List<Dates> listeDate() {
		return service.getAllDates();
	}
  //LA PARTIE CRUD DE SOLDEREEL   
	 @PostMapping("/soldereels/rechercher/id/date")
	    public  List<Soldereel> soldereelJournees( @RequestBody PositionPost position){
	    	return service.getSoldereelByIdUAndDate(position.getIdU(), position.getDate());
	     }
    @GetMapping("/soldereels")
    public List<Soldereel> listeSoldeReels() {
        return service.getAllSoldeReels();
    }
    @GetMapping("/soldereel/{id}")
    public Soldereel getSoldeReelById(@PathVariable(value = "id") int userId) {   
        return service.getSoldeReelById(userId);
    }
    
    @PostMapping("/soldereels/ajouter")
    public Soldereel createSoldeReel( @RequestBody Soldereel user) {
        return service.createSoldeReelJournee(user);
    }
    
    @PutMapping("/soldereels/modifier/{id}")
    public Soldereel updateSoldeReel( @PathVariable(value = "id") int userId, @RequestBody Soldereel userDetails) {
        return service.updateSoldeReelJournee(userId, userDetails);
    }
    @DeleteMapping("/soldereels/supprimer/{id}")
    public Map<String, Boolean> deleteSoldeReel(@PathVariable(value = "id") int userId) {
        return service.deleteSoldeSoldeReel(userId);
    }
  //LA PARTIE CRUD DE SOLDECLOTURERJOURNEE   
    @PostMapping("/soldecloturerjournes/rechercher/id/date")
    public  List<SoldeCloturerJournee> soldeCloturerJourneeJournees( @RequestBody PositionPost position){
    	return service.getSoldeCloturerJourneeByIdUAndDate(position.getIdU(), position.getDate());
     }
    @GetMapping("/soldecloturerjournes")
    public List<SoldeCloturerJournee> listeSoldeCloturerJournes() {
        return service.getAllSoldeCloturerJournees();
    }
    @GetMapping("/soldecloturerjourne/{id}")
    public SoldeCloturerJournee getSoldeCloturerJourneeById(@PathVariable(value = "id") int userId) {   
        return service.getSoldeCloturerJourneeById(userId);
    }
    
    @PostMapping("/soldecloturerjournes/ajouter")
    public SoldeCloturerJournee createSoldeCloturerJournee( @RequestBody SoldeCloturerJournee user) {
        return service.createSoldeCloturerJournee(user);
    }
    
    @PutMapping("/soldecloturerjournes/modifier/{id}")
    public SoldeCloturerJournee updateSoldeCloturerJournee( @PathVariable(value = "id") int userId, @RequestBody SoldeCloturerJournee userDetails) {
        return service.updateSoldeCloturerJournee(userId, userDetails);
    }
    @DeleteMapping("/soldecloturerjournes/supprimer/{id}")
    public Map<String, Boolean> deleteSoldeCloturerJournee(@PathVariable(value = "id") int userId) {
        return service.deleteSoldeCloturerJournee(userId);
    }                
   //LA PARTIE CRUD DE UTILISATEUR    
    
    @GetMapping("/utilisateurs")
    public List<Utilisateur> listeUtilisateurs() {
        return service.getAllUsers();
    }
    @GetMapping("/utilisateurs/{id}")
    public Utilisateur getUsersById(@PathVariable(value = "id") int userId) {   
        return service.getUsersById(userId);
    }
    
    @PostMapping("/utilisateurs/ajouter")
    public Utilisateur createUser( @RequestBody Utilisateur user) {
        return service.createUser(user);
    }
    
    @PutMapping("/utilisateurs/modifier/{id}")
    public Utilisateur updateUser( @PathVariable(value = "id") int userId, @RequestBody Utilisateur userDetails) {
        return service.updateUser(userId, userDetails);
    }
    @DeleteMapping("/utilisateurs/supprimer/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") int userId) {
        return service.deleteUser(userId);
    }
    
    //LA PARTIE CRUD DE SOLDEDEBUTERJOURNEE  
    @PostMapping("/soldeDebuterJournees/rechercher/id/date")
    public  List<SoldeDebuterJournee> soldeDebuterJournees( @RequestBody PositionPost position){
    	return service.getSoldeDebuterJourneesByIdUAndDate(position.getIdU(), position.getDate());
     }
    @GetMapping("/soldeDebuterJournees/caissier/{idU}")
    public List<SoldeDebuterJournee> getSoldeDebuterJournees(@PathVariable(value = "idU") int userId) {
        return service.getSoldeDebuterJournees(userId);
    }

    @GetMapping("/soldeDebuterJournees/totalEncaissement/caissier/{idU}")
    public SoldeDebuterJournee gettotalEncaissement(@PathVariable(value = "idU") int userId) {
        return service.getTotalEncaissementOperateur(userId);
    }
    @GetMapping("/soldeDebuterJournees/totalDecaissement/caissier/{idU}")
    public SoldeDebuterJournee gettotaldecaissement(@PathVariable(value = "idU") int userId) {
        return service.getTotalDecaissementOperateur(userId);
    }
    @GetMapping("/soldeDebuterJournees/totalFrais/caissier/{idU}")
    public SoldeDebuterJournee gettotalfrais(@PathVariable(value = "idU") int userId) {
        return service.getTotalFraisOperateur(userId);
    }
    @GetMapping("/soldeDebuterJournees")
    public List<SoldeDebuterJournee>getAllSoldeDebuterJournees() {
        return service.getAllSoldeDebuterJournees();
    }
    @GetMapping("/soldeDebuterJournees/{id}")
    public SoldeDebuterJournee getSoldeDebuterJourneesById(@PathVariable(value = "id") int userId) {
        return service.getSoldeDebuterJourneesById(userId);
    }
    
    @GetMapping("/maJournee/{id}")
    public List<Majournee> getMJourneesById(@PathVariable(value = "id") int userId) {
        return service.getMajourneesById(userId);
    }
    @DeleteMapping("/maJournee/supprimer/{id}")
    public Map<String, Boolean> deleteMaJournee(@PathVariable(value = "id") int userId) {
    	
        return service.deleteMaJournee(userId);
    }
    @PostMapping("/soldeDebuterJournees/ajouter")
    public SoldeDebuterJournee createSoldeDebuterJournee( @RequestBody SoldeDebuterJournee user) {
        return service.createSoldeDebuterJournee(user);
    }
    
    @PutMapping("/soldeDebuterJournees/modifier/{id}")
    public SoldeDebuterJournee updateSoldeDebuterJournee(@PathVariable(value = "id") int userId,  @RequestBody SoldeDebuterJournee ad){
    	service.updateMajournee(userId,ad);
    	return service.updateSoldeDebuterJournee(userId, ad);
    }
    @DeleteMapping("/soldeDebuterJournees/supprimer/{id}")
    public Map<String, Boolean> deleteSoldeDebuterJournee(@PathVariable(value = "id") int userId) {
    	
        return service.deleteSoldeDebuterJournee(userId);
    }
    
  //LA PARTIE CRUD DE TRANSACTION  
    @GetMapping("/transactions")
    public List<Transaction>getAllTransactions() {
        return service.getAllTransactions();
    }
    @GetMapping("/transactions/{id}")
    public Transaction getTransactionById(@PathVariable(value = "id") int userId){
        return service.getTransactionById(userId);
    }
    
    @PostMapping("/transactions/ajouter")
    public void createTransactions( @RequestBody Transaction user) {
    	service.createTransactions(user);
    }
    
    @PutMapping("/transactions/modifier/{id}")
    public Transaction updateTransactions(@PathVariable(value = "id") int userId,  @RequestBody Transaction ad){   
        return service.updateTransactions(userId, ad);
    }
    @DeleteMapping("/transactions/supprimer/{id}")
    public Map<String, Boolean> deleteTransactions(@PathVariable(value = "id") int userId) throws Exception { 	
        return service.deleteTransactions(userId);
    }
    
    
    //LA PARTIE TARITEMENT DES DONNEES
    @PostMapping("/authentification")
    public Utilisateur seConnecter( @RequestBody Connexion con){	
    	return service.seConnecter(con) ;
     }
    @PostMapping("/cloturer/{id}/{somme}")
    public double cloturer( @PathVariable(value="id") int id, @PathVariable(value="somme") double con){	
    	return service.cloturer(id, con);
     }
    @GetMapping("/sommeFinale/{id}")
    public double sommeFinale(@PathVariable(value="id") int id){
    	return service.sommeFinale(id) ;
     }
    @GetMapping("/totalSortie/{id}")
    public double totalSortie(@PathVariable(value="id") int id){
    	return service.totalSortie(id);
     }
    @GetMapping("/totalEntree/{id}")
    public double totalEntree(@PathVariable(value="id") int id){
    	return service.totalEntree(id);
     }

    @GetMapping("/sommeInitiale/{id}")
    public double sommeInitiale(@PathVariable(value="id") int id){
    	return service.sommeInitiale(id);
     }
    @GetMapping("/totalDecaissement/{id}")
    public double totalDecaissement(@PathVariable(value="id") int id){
    	return service.totalDecaissement(id);
     }
    
    @PostMapping("/totalDecaissement/date/id")
    public SoldeDebuterJournee totalDecaissementParIdParDate(@RequestBody PositionPost position){
    	SoldeDebuterJournee solde =service.totalDecaissementParIdParDate(position.getIdU(), position.getDate(), position.getDate());
    	return solde;
     }
    @PostMapping("/totalEncaissement/date/id")
    public SoldeDebuterJournee totalEncaissementParIdParDate(@RequestBody PositionPost position){
    	SoldeDebuterJournee solde =service.totalEncaissementParIdParDate(position.getIdU(), position.getDate(), position.getDate());
    	return solde;
     }
    @PostMapping("/totalFrais/date/id")
    public SoldeDebuterJournee totalFraistParIdParDate(@RequestBody PositionPost position){
    	SoldeDebuterJournee solde =service.totalFraisParIdParDate(position.getIdU(), position.getDate(), position.getDate());
    	return solde;
     }
    @GetMapping("/totalEncaissement/{id}")
    public double totalEncaissement(@PathVariable(value="id") int id){
    	return service.totalEncaissement(id);
     }
    @GetMapping("/totalCommission/{id}")
    public double totalCommission(@PathVariable(value="id") int id){
    	return service.totalCommission(id);
     }
    @GetMapping("/totalFrais/{id1}")
    public double totalFrais(@PathVariable(value="id1") int id1){
    	return service.totalFrais(id1);
     }
    @GetMapping("/trier/caissier/{id}/{operateur}")
    public List<Transaction>listeTriParOperateur(@PathVariable(value="id") int id,@PathVariable( "operateur") String operateur){
    	return service.listeTriParOperateur(id, operateur);
    }
    @GetMapping("/transactions/caissier/{id_caissier}")
    public List<Transaction>listeTansactionParCassier(@PathVariable(value = "id_caissier") int id_caissier){
    	return service.listeTansactionParCassier(id_caissier);
    }
    @PostMapping("/transactions/caissier/historiques")
    public List<Transaction>listeHistorique( @RequestBody history user){
    	return service.listeHistorique(user);
    }
    @GetMapping("/transactions/caissier/{id}/recherche/sens/{sens}")
    public List<Transaction>listeRehercherParSens(@PathVariable(value = "id") int id_caissier,@PathVariable("sens") String sens){
    	return service.listeRehercherParSens(id_caissier, sens);
    }
    @GetMapping("/transactions/caissier/{id}/recherche/operateur/{operateur}")
    public List<Transaction>listeRehercherParOperateur(@PathVariable(value = "id") int id_caissier,@PathVariable("operateur") String operation){
    	return service.listeRehercherParOperateur(id_caissier, operation);
    }
    @GetMapping("/transactions/caissier/{id}/recherche/operateur/{operateur}/sens/{sens}")
    public List<Transaction>listeRehercherParOperation(@PathVariable(value = "id") int id_caissier,@PathVariable("operateur") String operateur,@PathVariable("sens") String sens){
    	
    	return service.listeRehercherParSensOperateur(operateur,id_caissier,sens);
    }
    public void actionPlafonnementDeplafonnement(SoldeDebuterJournee solde,double ancienMontant,String nomOp) {
    	service.actionPlafonnementDeplafonnement(solde, ancienMontant, nomOp); 
    	
    }
    public void calculeActualiser(SoldeDebuterJournee solde,double ancienMontant,String nomOp) {
		service.calculeActualiser(solde, ancienMontant, nomOp);
		}	
    
    
}
