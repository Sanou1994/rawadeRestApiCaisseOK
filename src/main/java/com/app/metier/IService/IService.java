package com.app.metier.IService;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.app.metier.entities.Connexion;
import com.app.metier.entities.Dates;
import com.app.metier.entities.Majournee;
import com.app.metier.entities.Position;
import com.app.metier.entities.SoldeCloturerJournee;
import com.app.metier.entities.SoldeDebuterAnnee;
import com.app.metier.entities.SoldeDebuterJournee;
import com.app.metier.entities.Soldereel;
import com.app.metier.entities.Transaction;
import com.app.metier.entities.Utilisateur;
import com.app.metier.entities.history;
@Component
public interface IService {
	//PARTIE SOLDEREEL
    public List<Soldereel>getSoldereelByIdUAndDate( int id,String date) ;
	public List<Soldereel>getAllSoldeReels() ;
    public Soldereel getSoldeReelById( int userId);
    public Soldereel createSoldeReelJournee( Soldereel user) ;
    public Soldereel updateSoldeReelJournee( int userId,  Soldereel ad);
    public Map<String, Boolean> deleteSoldeSoldeReel( int userId) ;
    
  //PARTIE SOLDEDEBUTERANNEE
	public List<SoldeDebuterAnnee>getAllSoldeDebuterAnnees() ;
    public SoldeDebuterAnnee getSoldeDebuterAnneeById( int userId);
    public SoldeDebuterAnnee createOrUpdateSoldeDebuterAnnee( SoldeDebuterAnnee user) ;
    public Map<String, Boolean> deleteSoldeDebuterAnnee( int userId) ;
    
      //PARTIE SOLDECLOTURER
    public List<SoldeCloturerJournee>getSoldeCloturerJourneeByIdUAndDate( int id,String date) ;
      public List<SoldeCloturerJournee>getAllSoldeCloturerJournees() ;
      public SoldeCloturerJournee getSoldeCloturerJourneeById( int userId);
      public SoldeCloturerJournee createSoldeCloturerJournee( SoldeCloturerJournee user) ;
      public SoldeCloturerJournee updateSoldeCloturerJournee( int userId,  SoldeCloturerJournee ad);
      public Map<String, Boolean> deleteSoldeCloturerJournee( int userId) ;
	//PARTIE POSITION
	public List<Position> getPositionByIdUAndDate(int id,String date);
	public List<Position> getPositionByStatus(boolean status);
	public Position createPosition(Position position);
	public Position updatePosition(int idU,boolean status);
    //PARTIE CAISSIER-CLIENT
    public List<Dates> getAllDates();
	public void jour();
    public List<Utilisateur> getAllUsers();
    public Utilisateur getUsersById( int userId);
    public Utilisateur createUser(Utilisateur user);
    public Utilisateur updateUser( int userId,  Utilisateur userDetails);
    public Map<String, Boolean> deleteUser( int userId) ;
    public List<SoldeDebuterJournee>getSoldeDebuterJournees( int userId) ;
    public List<SoldeDebuterJournee>getSoldeDebuterJourneesByIdUAndDate( int id,String date) ;
    public List<SoldeDebuterJournee>getAllSoldeDebuterJournees() ;
    public SoldeDebuterJournee getSoldeDebuterJourneesById( int userId);
    public SoldeDebuterJournee createSoldeDebuterJournee( SoldeDebuterJournee user) ;
    public SoldeDebuterJournee updateSoldeDebuterJournee( int userId,  SoldeDebuterJournee ad);
    public Map<String, Boolean> deleteSoldeDebuterJournee( int userId) ;
    public SoldeDebuterJournee getTotalEncaissementOperateur( int userId) ;
    public SoldeDebuterJournee getTotalDecaissementOperateur( int userId) ;
    public SoldeDebuterJournee getTotalFraisOperateur( int userId) ;

    //MAJOURNEE
    public List<Majournee> getMajourneesById( int userId);
    public Majournee updateMajournee( int userId,  Majournee ad);
    public Majournee updateMajournee( int userId,  SoldeDebuterJournee ad);
    public List<Transaction>getAllTransactions();
    public Transaction getTransactionById( int userId);
    public void createTransactions(Transaction user) ;	
    public Transaction updateTransactions( int userId,  Transaction ad);       
    public Map<String, Boolean> deleteTransactions( int userId) ;	
    public Utilisateur seConnecter( Connexion con);	
    public double cloturer( int id,  double con);
    public double sommeFinale( int id);
    public double totalSortie(int id);
    public double totalEntree( int id);
    public double sommeInitiale( int id);
    public double totalDecaissement( int id);
    public double totalEncaissement( int id);
    public double totalCommission( int id);
    public double totalFrais( int id1);
    public List<Transaction>listeTriParOperateur( int id, String operateur);
    public List<Transaction>listeTansactionParCassier( int id_caissier);
    public List<Transaction>listeHistorique(history user);
    public List<Transaction>listeRehercherParOperateur( int id_caissier, String operation);
    public List<Transaction>listeRehercherParSensOperateur(String operateur,int id_caissier, String sens);
    public void actionPlafonnementDeplafonnement(SoldeDebuterJournee solde,double ancienMontant,String nomOp) ;
    public void calculeActualiser(SoldeDebuterJournee solde,double ancienMontant,String nomOp) ;
		
}
