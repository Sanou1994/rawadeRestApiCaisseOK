package com.app.metier.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Dao.DaoDate;
import com.app.Dao.DaoMajourne;
import com.app.Dao.DaoPosition;
import com.app.Dao.DaoSoldeCloturerJournee;
import com.app.Dao.DaoSoldeDebuter;
import com.app.Dao.DaoSoldeDebuterAnnee;
import com.app.Dao.DaoSoleReel;
import com.app.Dao.DaoTransaction;
import com.app.Dao.DaoUser;
import com.app.metier.IService.IService;
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

@Service
public class RestService  implements IService {
	private  Date  aujourdhui = new Date();
	private SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
    @Autowired
    private DaoUser userRepository;
    @Autowired
    private DaoPosition positionRepository;
    @Autowired
    private DaoDate dateRepository;
    @Autowired
    private DaoTransaction transactionRepository;
    @Autowired
    private DaoSoldeDebuter soldeDebuterJourneeRepository;
    @Autowired
    private DaoSoleReel soldeReelRepository;
    @Autowired
    private DaoSoldeDebuterAnnee soldeDebuterAnneeRepository;
    @Autowired
    private DaoSoldeCloturerJournee soldeCloturerJourneeRepository;
    @Autowired
    private DaoMajourne maJourneeRepository;
 //LA PARTIE CRUD DE DATE   
    
    
    public List<Dates> getAllDates() {
        return dateRepository.findAll();
    }
  
	public void jour() {
    	int tester = 0;
    	Dates user = new Dates(formater.format(aujourdhui));
    	List<Dates> listes =getAllDates();
    	for (Dates dates : listes) {
			if(dates.getDates().equals(user.getDates())) {
				tester = 1; 
			}
		}
    	if(tester == 0) {
    		dateRepository.save(user);
    	}
    	
    }
   
    
    public List<Utilisateur> getAllUsers() {
        return userRepository.findAll();
    }
    
    public Utilisateur getUsersById( int userId) {
    	Utilisateur user =userRepository.findById(userId);
        return user;
    }
    
   
    public Utilisateur createUser( Utilisateur user) {
    	
        return userRepository.save(user);
    }

    public Position updatePosition(int idU,boolean status){
    	Position user = positionRepository.findById(idU);
    	         user.setStatus(status);  
    	         Position updatedUser = positionRepository.save(user);
             return updatedUser;
    }    
    public Utilisateur updateUser( int userId,  Utilisateur userDetails){
    	Utilisateur user = userRepository.findById(userId);
    	user.setNom(userDetails.getNom());
    	user.setRole(userDetails.getRole());
    	user.setPrenom(userDetails.getPrenom());
        user.setPassword(userDetails.getPassword());
    	user.setPassword(userDetails.getPassword());
    	user.setLogin(userDetails.getLogin());
    	user.setPseudo(userDetails.getPseudo());
    	user.setTelephone(userDetails.getTelephone());
    	user.setAgence(userDetails.getAgence());       
    	 Utilisateur updatedUser = userRepository.save(user);
        return updatedUser;
    }
   
    public Map<String, Boolean> deleteUser( int userId) {
    	Utilisateur user =
                userRepository
                        .findById(userId);
        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
   
    public List<SoldeDebuterJournee>getSoldeDebuterJournees( int userId) {
        return soldeDebuterJourneeRepository.findByIdUAndStatus(userId,1);
    }
   
    public List<SoldeDebuterJournee>getAllSoldeDebuterJournees() {
        return soldeDebuterJourneeRepository.findAll();
    }
    public SoldeDebuterJournee getSoldeDebuterJourneesById( int userId) {
    	SoldeDebuterJournee user =soldeDebuterJourneeRepository.findById(userId);
        return user;
    }
    
   
    public SoldeDebuterJournee createSoldeDebuterJournee(SoldeDebuterJournee user) {
    	jour();
    	SoldeDebuterJournee objsave =soldeDebuterJourneeRepository.save(user);
    	Majournee copie = new Majournee();
    	copie.setCaisse(user.getCaisse());
    	copie.setOrange(user.getOrange());
    	copie.setxpress(user.getxpress());
    	copie.setBanque(user.getBanque());
    	copie.setExpresso(user.getExpresso());
    	copie.setProximo(user.getProximo());
    	copie.setFreeMoney(user.getFreeMoney());
    	copie.setWari(user.getWari());
    	copie.setWave(user.getWave());
    	copie.setWizall(user.getWizall());
    	copie.setYup(user.getYup()); 
    	copie.setCloturer(user.getCloturer());
    	copie.setSommeInitiale(user.getSommeInitiale());
    	copie.setIdU(user.getIdU());
    	copie.setDate(user.getDate());
    	copie.setStatus(user.getStatus());
    	copie.setIdSoldeDebuterJournee(objsave.getId());
    	maJourneeRepository.save(copie);
    	soldeDebuterJourneeRepository.save(user).getId();
        return objsave ;
    }
   
    public SoldeDebuterJournee updateSoldeDebuterJournee( int userId,  SoldeDebuterJournee ad) {
    	SoldeDebuterJournee admin =
    			soldeDebuterJourneeRepository
                        .findByIdUAndStatus(userId,1).get(0);
    	SoldeDebuterJournee copie = new SoldeDebuterJournee();
    	copie.setCaisse(admin.getCaisse());
    	copie.setOrange(admin.getOrange());
    	copie.setxpress(admin.getxpress());
    	copie.setBanque(admin.getBanque());
    	copie.setExpresso(admin.getExpresso());
    	copie.setProximo(admin.getProximo());
    	copie.setFreeMoney(admin.getFreeMoney());
    	copie.setWari(admin.getWari());
    	copie.setWave(admin.getWave());
    	copie.setWizall(admin.getWizall());
    	copie.setYup(admin.getYup()); 
    	copie.setCloturer(admin.getCloturer());
    	copie.setSommeInitiale(admin.getSommeInitiale());
    	copie.setIdU(admin.getIdU());
    	copie.setDate(admin.getDate());
    	copie.setStatus(admin.getStatus());
    	
    	admin.setCaisse(ad.getCaisse());
		admin.setOrange(ad.getOrange());
		admin.setxpress(ad.getxpress());
		admin.setExpresso(ad.getExpresso());
		admin.setProximo(ad.getProximo());
		admin.setFreeMoney(ad.getFreeMoney());
		admin.setWari(ad.getWari());
		admin.setWave(ad.getWave());
		admin.setWizall(ad.getWizall());
		admin.setYup(ad.getYup()); 
		admin.setBanque(ad.getBanque());
		admin.setCloturer(ad.getCloturer());
		admin.setSommeInitiale(ad.getSommeInitiale());
		admin.setDate(ad.getDate());
		admin.setIdU(ad.getIdU());
		admin.setStatus(ad.getStatus());
    	final SoldeDebuterJournee updatedUser = soldeDebuterJourneeRepository.save(admin);
    	updateDebuter(copie, updatedUser);
    	
        return updatedUser;
    }
   
    public Map<String, Boolean> deleteSoldeDebuterJournee(int userId)  {
    	SoldeDebuterJournee user =
    			soldeDebuterJourneeRepository
                        .findById(userId);
    	soldeDebuterJourneeRepository.delete(user);
    	maJourneeRepository.deleteById(maJourneeRepository.findByIdUAndStatus(user.getIdU(),user.getStatus()).get(0).getId());
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    public Map<String, Boolean> deleteMaJournee(int userId)  {
    	maJourneeRepository.deleteById(userId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    public List<Transaction>getAllTransactions() {
        return transactionRepository.findAll();
    }
   
    public Transaction getTransactionById( int userId) {
    	Transaction user =
    			transactionRepository
                        .findById(userId);
        return user;
    }
    
   
    public void createTransactions( Transaction user) {
    	int id_user= user.getIdU();
    	
    	SoldeDebuterJournee soldes =soldeDebuterJourneeRepository.findByIdUAndStatus(id_user,1).get(0);
    	if(user.getSens().equals("encaissement")) {
    		
    switch (user.getOperateur()) {
         case "Entree":
			soldes.setCaisse(soldes.getCaisse()+user.getMontant()+user.getFrais());
			break;
         case "Plafonnement":
			soldes.setCaisse(soldes.getCaisse()+user.getMontant()+user.getFrais());
			actionPlafonnementDeplafonnement(soldes,user.getMontant()+user.getFrais(), user.getOperation());
			break;
 		  case "Orange":
 				soldes.setCaisse(soldes.getCaisse()+user.getMontant()+user.getFrais());
 				soldes.setOrange(soldes.getOrange()-user.getMontant()-user.getFrais());
 				break;
          case "Expresso":
        	    soldes.setCaisse(soldes.getCaisse()+user.getMontant()+user.getFrais());
				soldes.setExpresso(soldes.getExpresso()-user.getMontant()-user.getFrais());
 				break;
          case "Free":
        	    soldes.setCaisse(soldes.getCaisse()+user.getMontant()+user.getFrais());
				soldes.setFreeMoney(soldes.getFreeMoney()-user.getMontant()-user.getFrais());
 	             break;
          case "Wari":
        	    soldes.setCaisse(soldes.getCaisse()+user.getMontant()+user.getFrais());
				soldes.setWari(soldes.getWari()-user.getMontant()-user.getFrais());
 	             break;
          case "Wizall":
        	    soldes.setCaisse(soldes.getCaisse()+user.getMontant()+user.getFrais());
				soldes.setWizall(soldes.getWizall()-user.getMontant()-user.getFrais());
 	              break;
           case "Proximo":
        	    soldes.setCaisse(soldes.getCaisse()+user.getMontant()+user.getFrais());
				soldes.setProximo(soldes.getProximo()-user.getMontant()-user.getFrais());
 	              break;
           case "Xpress":
        	    soldes.setCaisse(soldes.getCaisse()+user.getMontant()+user.getFrais());
				soldes.setxpress(soldes.getxpress()-user.getMontant()-user.getFrais());
 	              break;
            case "Yup":
            	soldes.setCaisse(soldes.getCaisse()+user.getMontant()+user.getFrais());
 				soldes.setYup(soldes.getYup()-user.getMontant()-user.getFrais());
 	               break;
            case "Wave":
            	soldes.setCaisse(soldes.getCaisse()+user.getMontant()+user.getFrais());
 				soldes.setYup(soldes.getYup()-user.getMontant()-user.getFrais());
 	               break;
 			default:
 				break;
 			}
 	    	
    		
    	}else if (user.getSens().equals("decaissement")) {
    		
    		 switch (user.getOperateur()) {
    		 case "Sortie":
    			 soldes.setCaisse(soldes.getCaisse()-user.getMontant()+user.getCommission());
    				break;
    	    case "Deplafonnement":
    	    	soldes.setCaisse(soldes.getCaisse()-user.getMontant()+user.getCommission());
    				actionPlafonnementDeplafonnement(soldes,-user.getMontant(), user.getOperation());
    				break;
  			case "Orange":
  				soldes.setCaisse(soldes.getCaisse()-user.getMontant()+user.getCommission());
  				soldes.setOrange(soldes.getOrange()+user.getMontant());
  				break;
  			
           case "Expresso":
        	   soldes.setCaisse(soldes.getCaisse()-user.getMontant()+user.getCommission());
 				soldes.setExpresso(soldes.getExpresso()+user.getMontant());
  				break;
           case "Free":
        	   soldes.setCaisse(soldes.getCaisse()-user.getMontant()+user.getCommission());
 				soldes.setFreeMoney(soldes.getFreeMoney()+user.getMontant());
  	             break;
           case "Wari":
        	   soldes.setCaisse(soldes.getCaisse()-user.getMontant()+user.getCommission());
 				soldes.setWari(soldes.getWari()+user.getMontant());
  	             break;
           case "Wizall":
        	   soldes.setCaisse(soldes.getCaisse()-user.getMontant()+user.getCommission());
 				soldes.setWizall(soldes.getWizall()+user.getMontant());
  	              break;
            case "Proximo":
            	soldes.setCaisse(soldes.getCaisse()-user.getMontant()+user.getCommission());
 				soldes.setProximo(soldes.getProximo()+user.getMontant());
  	              break;
            case "Xpress":
            	soldes.setCaisse(soldes.getCaisse()-user.getMontant()+user.getCommission());
 				soldes.setxpress(soldes.getxpress()+user.getMontant());
  	              break;
             case "Yup":
            	 soldes.setCaisse(soldes.getCaisse()-user.getMontant()+user.getCommission());
  				soldes.setYup(soldes.getYup()+user.getMontant());
  	               break;
             case "Wave":
            	 soldes.setCaisse(soldes.getCaisse()-user.getMontant()+user.getCommission());
  				soldes.setWave(soldes.getWave()+user.getMontant());
  	               break;
  			default:
  				break;
  			}
  	    	
    	}
    	updateSoldeDebuterJournee(id_user,soldes);
    	
        Transaction transactionCreate =transactionRepository.save(user);
        transactionCreate.setIdCopie(transactionCreate.getId());
        transactionRepository.save(transactionCreate);
    }
    
  
    public Transaction updateTransactions( int userId,  Transaction ad) {
    	Transaction admin =
    			transactionRepository
                        .findById(userId);
    	SoldeDebuterJournee soldes =soldeDebuterJourneeRepository.findByIdUAndStatus(admin.getIdU(),1).get(0);
    	double dec = admin.getMontant()-admin.getCommission()-ad.getMontant()+ad.getCommission();
        if(ad.getSens().equals("encaissement")) {
    		
    		switch (ad.getOperateur()) {
    		 case "Entree":
  				soldes.setCaisse(soldes.getCaisse()+ad.getMontant()+ad.getFrais()-admin.getFrais());
  				break;
  	         case "Plafonnement":
  				soldes.setCaisse(soldes.getCaisse()+ad.getMontant()-admin.getEncaissement()+ad.getFrais()-admin.getFrais());
		  				switch (ad.getOperation()) {
		  				case "Orange":
		  					soldes.setOrange(soldes.getOrange()-ad.getMontant()-ad.getFrais()+admin.getFrais());
		  					break;
		  	           case "Expresso":
		  	        	    soldes.setExpresso(soldes.getExpresso()-ad.getMontant()-ad.getFrais()+admin.getFrais());		  					
		  					break;
		  	           case "Free":
		  	        	    soldes.setFreeMoney(soldes.getFreeMoney()-ad.getMontant()-ad.getFrais()+admin.getFrais());
		  				
		  		             break;
		  	           case "Wari":
		  	        	    soldes.setWari(soldes.getWari()-ad.getMontant()-ad.getFrais()+admin.getFrais());
		  				
		
		  		             break;
		  	           case "Wizall":
		  	        	    soldes.setWizall(soldes.getWizall()-ad.getMontant()-ad.getFrais()+admin.getFrais());		  				
		
		  		              break;
		  	            case "Proximo":
		  	            	soldes.setProximo(soldes.getProximo()-ad.getMontant()-ad.getFrais()+admin.getFrais());
		  		              break;
		  	            case "Xpress":
		  	            	soldes.setxpress(soldes.getxpress()-ad.getMontant()-ad.getFrais()+admin.getFrais());
		  		              break;
		  	             case "Yup":
		  	            	 soldes.setYup(soldes.getYup()-ad.getMontant()-ad.getFrais()+admin.getFrais());
		  		               break;
		  	             case "Wave":
		  	            	 soldes.setWave(soldes.getWave()-ad.getMontant()-ad.getFrais()+admin.getFrais());
		  		               break;
		  				default:
		  					break;
		  				}
		  				calculeActualiser(soldes,admin.getMontant(),admin.getOperation());
  				break;
			case "Orange":
				soldes.setOrange(soldes.getOrange()-ad.getMontant()-ad.getFrais()+admin.getFrais());
				soldes.setCaisse(soldes.getCaisse()-dec+ad.getFrais()-admin.getFrais());
				break;
			
           case "Expresso":
        	    soldes.setExpresso(soldes.getExpresso()-ad.getMontant()-ad.getFrais()+admin.getFrais());
				soldes.setCaisse(soldes.getCaisse()-dec+ad.getFrais()-admin.getFrais());
				
				break;
           case "Free":
        	    soldes.setFreeMoney(soldes.getFreeMoney()-ad.getMontant()-ad.getFrais()+admin.getFrais());
				soldes.setCaisse(soldes.getCaisse()-dec+ad.getFrais()-admin.getFrais());
			
	             break;
           case "Wari":
        	    soldes.setWari(soldes.getWari()-ad.getMontant()-ad.getFrais()+admin.getFrais());
				soldes.setCaisse(soldes.getCaisse()-dec+ad.getFrais()-admin.getFrais());
			

	             break;
           case "Wizall":
        	    soldes.setWizall(soldes.getWizall()-ad.getMontant()-ad.getFrais()+admin.getFrais());
				soldes.setCaisse(soldes.getCaisse()-dec+ad.getFrais()-admin.getFrais());
			

	              break;
            case "Proximo":
            	soldes.setProximo(soldes.getProximo()-ad.getMontant()-ad.getFrais()+admin.getFrais());
				soldes.setCaisse(soldes.getCaisse()-dec+ad.getFrais()-admin.getFrais());
	              break;
            case "Xpress":
            	soldes.setxpress(soldes.getxpress()-ad.getMontant()-ad.getFrais()+admin.getFrais());
				soldes.setCaisse(soldes.getCaisse()-dec+ad.getFrais()-admin.getFrais());
	              break;
             case "Yup":
            	 soldes.setYup(soldes.getYup()-ad.getMontant()-ad.getFrais()+admin.getFrais());
 				 soldes.setCaisse(soldes.getCaisse()-dec+ad.getFrais()-admin.getFrais());
	               break;
             case "Wave":
            	 soldes.setWave(soldes.getWave()-ad.getMontant()-ad.getFrais()+admin.getFrais());
 				 soldes.setCaisse(soldes.getCaisse()-dec+ad.getFrais()-admin.getFrais());
	               break;
			default:
				break;
			}
    		calculeActualiser(soldes,admin.getMontant(),admin.getOperateur());
    	}else if(ad.getSens().equals("decaissement")) {
    		switch (ad.getOperateur()) {
    		 case "Sortie":
 				soldes.setCaisse(soldes.getCaisse()-ad.getMontant()-admin.getCommission()+ad.getCommission());
 				break;
 	         case "Deplafonnement":
 				soldes.setCaisse(soldes.getCaisse()-admin.getCommission()-ad.getMontant()+ad.getCommission()+admin.getDecaissement());
		 				switch (ad.getOperation()) {
		  				case "Orange":
		  					soldes.setOrange(soldes.getOrange()+ad.getMontant());
		  					break;
		  				
		  	           case "Expresso":
		  	        	    soldes.setExpresso(soldes.getExpresso()+ad.getMontant());		  					
		  					break;
		  	           case "Free":
		  	        	    soldes.setFreeMoney(soldes.getFreeMoney()+ad.getMontant());
		  				
		  		             break;
		  	           case "Wari":
		  	        	    soldes.setWari(soldes.getWari()+ad.getMontant());
		  		             break;
		  	           case "Wizall":
		  	        	    soldes.setWizall(soldes.getWizall()+ad.getMontant());		  				
		
		  		              break;
		  	            case "Proximo":
		  	            	soldes.setProximo(soldes.getProximo()+ad.getMontant());
		  		              break;
		  	            case "Xpress":
		  	            	soldes.setxpress(soldes.getxpress()+ad.getMontant());
		  		              break;
		  	             case "Yup":
		  	            	 soldes.setYup(soldes.getYup()+ad.getMontant());
		  		               break;
		  	             case "Wave":
		  	            	 soldes.setWave(soldes.getWave()+ad.getMontant());
		  		               break;
		  				default:
		  					break;
		  				}
		 				calculeActualiser(soldes,-admin.getMontant(),admin.getOperation());
 				break;
 	       
			case "Orange":
				soldes.setOrange(soldes.getOrange()+ad.getMontant());
				soldes.setCaisse(soldes.getCaisse()+dec);
				break;
           case "Expresso":
        	    soldes.setExpresso(soldes.getExpresso()+ad.getMontant());
				soldes.setCaisse(soldes.getCaisse()+dec);
				
				break;
           case "Free":
        	    soldes.setFreeMoney(soldes.getFreeMoney()+ad.getMontant());
				soldes.setCaisse(soldes.getCaisse()+dec);
			
	             break;
           case "Wari":
        	    soldes.setWari(soldes.getWari()+ad.getMontant());
				soldes.setCaisse(soldes.getCaisse()+dec);
			

	             break;
           case "Wizall":
        	    soldes.setWizall(soldes.getWizall()+ad.getMontant());
				soldes.setCaisse(soldes.getCaisse()+dec);
			

	              break;
            case "Proximo":
            	soldes.setProximo(soldes.getProximo()+ad.getMontant());
				soldes.setCaisse(soldes.getCaisse()+dec);
	              break;
            case "Xpress":
            	soldes.setxpress(soldes.getxpress()+ad.getMontant());
				soldes.setCaisse(soldes.getCaisse()+dec);
	              break;
             case "Yup":
            	 soldes.setYup(soldes.getYup()+ad.getMontant());
 				 soldes.setCaisse(soldes.getCaisse()+dec);
	               break;
             case "Wave":
            	 soldes.setWave(soldes.getWave()+ad.getMontant());
 				 soldes.setCaisse(soldes.getCaisse()+dec);
	               break;
			default:
				break;
			}
    		calculeActualiser(soldes,-admin.getMontant(),admin.getOperateur());
    	}
    	
        updateSoldeDebuterJournee(soldes.getIdU(),soldes);
        
    	admin.setId(userId);
		admin.setOperateur(ad.getOperateur());
		admin.setOperation(ad.getOperation());
		admin.setDecaissement(ad.getDecaissement());
		admin.setCommission(ad.getCommission());
		admin.setEncaissement(ad.getEncaissement());
		admin.setFrais(ad.getFrais());
		admin.setTaxe(ad.getTaxe());
		admin.setMontant(ad.getMontant());
		admin.setSurplux(ad.getSurplux());
		admin.setNumero(ad.getNumero());
		admin.setSens(ad.getSens());
		admin.setReference(ad.getReference());
		admin.setCredit(ad.getCredit());
		admin.setDebit(ad.getDebit());
    	final Transaction updatedUser = transactionRepository.save(admin);
    	
    	
    	
        return updatedUser;
    }
      public Map<String, Boolean> deleteTransactions( int userId)  {
    	Transaction user =
    			transactionRepository
                        .findById(userId);
    	SoldeDebuterJournee solde =soldeDebuterJourneeRepository.findByIdUAndStatus(user.getIdU(),1).get(0);
    	if(user.getSens().equals("decaissement")) {
            switch (user.getOperateur()) {
             case "Sortie":
                 solde.setCaisse(solde.getCaisse()+user.getMontant()-user.getCommission());
 				break;
 	         case "Deplafonnement":
                 solde.setCaisse(solde.getCaisse()+user.getMontant()-user.getCommission());
                 actionPlafonnementDeplafonnement(solde,user.getMontant(),user.getOperation());
 				break;
 				
 	          case "Orange":      
 	            	solde.setOrange(solde.getOrange()-user.getDecaissement());
 	                solde.setCaisse(solde.getCaisse()+user.getDecaissement()-user.getCommission());
 					break;
 	       
 	            case "Expresso":
 	            	solde.setExpresso(solde.getExpresso()-user.getDecaissement());
 	            	 solde.setCaisse(solde.getCaisse()+user.getDecaissement()-user.getCommission());
 					break;
 	            case "Free":
 	            	solde.setFreeMoney(solde.getFreeMoney()-user.getDecaissement());
 	            	 solde.setCaisse(solde.getCaisse()+user.getDecaissement()-user.getCommission());
 		             break;
 	            case "Wari":
 	            	solde.setWari(solde.getWari()-user.getDecaissement());
	            	 solde.setCaisse(solde.getCaisse()+user.getDecaissement()-user.getCommission());

 		             break;
 	            case "Wizall":
 	            	solde.setWizall(solde.getWizall()-user.getDecaissement());
	            	 solde.setCaisse(solde.getCaisse()+user.getDecaissement()-user.getCommission());

 		              break;
 	            case "Proximo":
 	            	 solde.setProximo(solde.getProximo()-user.getDecaissement());
 	            	 solde.setCaisse(solde.getCaisse()+user.getDecaissement()-user.getCommission());
 		              break;
 	            case "Xpress":
 	            	 solde.setxpress(solde.getxpress()-user.getDecaissement());
 	            	 solde.setCaisse(solde.getCaisse()+user.getDecaissement()-user.getCommission());
 		              break;
 	            case "Yup":
 	            	  solde.setYup(solde.getYup()-user.getDecaissement());
  	            	 solde.setCaisse(solde.getCaisse()+user.getDecaissement()-user.getCommission());
 		               break;
 	            case "Wave":
 	            	  solde.setWave(solde.getWave()-user.getDecaissement());
  	            	  solde.setCaisse(solde.getCaisse()+user.getDecaissement()-user.getCommission());
 		               break;
 				default:
 					break;
 				}
    	}else if(user.getSens().equals("encaissement")){
    		 switch (user.getOperateur()) {
             case "Entree":
                 solde.setCaisse(solde.getCaisse()-user.getMontant()-user.getFrais());
 				break;
 	         case "Plafonnement":
                 solde.setCaisse(solde.getCaisse()-user.getMontant()-user.getFrais());
                 actionPlafonnementDeplafonnement(solde,-user.getMontant()-user.getFrais(),user.getOperation());
 				break;
 				
 	          case "Orange":      
 	            	solde.setOrange(solde.getOrange()+user.getEncaissement()+user.getFrais());
 	                solde.setCaisse(solde.getCaisse()-user.getEncaissement()-user.getFrais());
 					break;
 	        
 	            case "Expresso":
 	            	solde.setExpresso(solde.getExpresso()+user.getEncaissement()+user.getFrais());
 	            	 solde.setCaisse(solde.getCaisse()-user.getEncaissement()-user.getFrais());
 					break;
 	            case "Free":
 	            	solde.setFreeMoney(solde.getFreeMoney()+user.getEncaissement()+user.getFrais());
 	            	 solde.setCaisse(solde.getCaisse()-user.getEncaissement()-user.getFrais());
 		             break;
 	            case "Wari":
 	            	solde.setWari(solde.getWari()+user.getEncaissement()+user.getFrais());
	            	 solde.setCaisse(solde.getCaisse()-user.getEncaissement()-user.getFrais());

 		             break;
 	            case "Wizall":
 	            	solde.setWizall(solde.getWizall()+user.getEncaissement()+user.getFrais());
	            	 solde.setCaisse(solde.getCaisse()-user.getEncaissement()-user.getFrais());

 		              break;
 	            case "Proximo":
 	            	 solde.setProximo(solde.getProximo()+user.getEncaissement()+user.getFrais());
 	            	 solde.setCaisse(solde.getCaisse()-user.getEncaissement()-user.getFrais());
 		              break;
 	            case "Xpress":
 	            	 solde.setxpress(solde.getxpress()+user.getEncaissement()+user.getFrais());
 	            	 solde.setCaisse(solde.getCaisse()-user.getEncaissement()-user.getFrais());
 		              break;
 	            case "Yup":
 	            	  solde.setYup(solde.getYup()+user.getEncaissement()+user.getFrais());
  	            	 solde.setCaisse(solde.getCaisse()-user.getEncaissement()-user.getFrais());
 		               break;
 	            case "Wave":
 	            	  solde.setWave(solde.getWave()+user.getEncaissement()+user.getFrais());
  	            	  solde.setCaisse(solde.getCaisse()-user.getEncaissement()-user.getFrais());
 		               break;
 				default:
 					break;
 				}
    	}
        updateSoldeDebuterJournee(solde.getIdU(),solde);
    	transactionRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    
    
    
  
    public Utilisateur seConnecter( Connexion con){	
    	Utilisateur user = null;
    	if(userRepository.findByLogin(con.getLogin())!=null) {
    		
    		user=userRepository.findByLoginAndPassword(con.getLogin(), con.getPassword());	
    	}
    	return user ;
     }
   
    public double cloturer(  int id, double con){	
    	Position position = new Position();
    	position.setIdU(id);
    	position.setSommeInitiale(sommeInitiale(id));
    	position.setDate(formater.format(aujourdhui));
    	position.setEntree(totalEntree(id));
    	position.setSortie(totalSortie(id));
    	position.setSoldeCaisse(getSoldeDebuterJournees(id).get(0).getCaisse());
    	position.setSommeFinale(sommeFinale(id));
    	position.setSoldeJournal(1000);
    	position.setStatus(false);
		positionRepository.save(position);
    	List<Soldereel> soldeCloturerJournees =soldeReelRepository.findByIdUAndDateAndStatus(id, formater.format(aujourdhui),1);
    	soldeCloturerJournees.get(0).setStatus(0);
    	soldeReelRepository.save(soldeCloturerJournees.get(0));
    	SoldeDebuterJournee solde =soldeDebuterJourneeRepository.findByIdUAndStatus(id,1).get(0);
    	Majournee solde1 =maJourneeRepository.findByIdSoldeDebuterJournee(solde.getId());
        solde.setCloturer(con);
        solde1.setCloturer(con);
        updateSoldeDebuterJournee(id,solde);
        updateMajournee(solde1.getId(),solde1);
        mettreTransactionAzero(id) ;
    	return con;
     }
    
    public double sommeFinale( int id){
    	double somme = 0;
    	try {
    		somme = sommeInitiale(id)+totalEntree(id)-totalSortie(id);
    	}catch (Exception e) {
    		somme = 0;

		}
    	
    	return somme ;
     }
    
    public double totalSortie( int id){
    	double somme=0;
    	List<Transaction>listes = listeTansactionParCassier(id);
    	for (Transaction transaction : listes) {
    		
    		switch (transaction.getOperateur()) {
			case "Sortie":
				somme = somme +transaction.getMontant();

				break;
            case "Deplafonnement":
				somme = somme +transaction.getMontant();

				break;
			default:
				somme = somme +transaction.getDecaissement();

				break;
			}
    		
    		
		}
    	return somme;
     }
   
    public double totalEntree( int id){
    	double somme=0;
    	List<Transaction>listes = listeTansactionParCassier(id);
    	for (Transaction transaction : listes) {
    		
    		switch (transaction.getOperateur()) {
			case "Entree":
				somme = somme +transaction.getMontant()+transaction.getFrais()+transaction.getCommission();

				break;
            case "Plafonnement":
				somme = somme +transaction.getMontant()+transaction.getFrais()+transaction.getCommission();

				break;
			default:
				somme = somme +transaction.getEncaissement()+transaction.getFrais()+transaction.getCommission();

				break;
			}
    		
    		
		}
    	return somme;
     }

    
    public double sommeInitiale( int id){
    	Majournee solde =maJourneeRepository.findByIdUAndStatus(id,1).get(0);
    	return (solde!=null)? solde.getCaisse() : 0;
     }
   
    public double totalDecaissement( int id){
    	double somme=0;
    	List<Transaction>listes = listeTansactionParCassier(id);
    	for (Transaction transaction : listes) {
			somme = somme +transaction.getDecaissement();
		}
    	return somme;
     }
    
    public  SoldeDebuterJournee totalDecaissementParIdParDate( int idU,String date,String date1){
    List<Transaction>listes = transactionRepository.findByIdUAndDateBetween(idU,date,date1);
    SoldeDebuterJournee total = new SoldeDebuterJournee();
    for (Transaction transaction : listes) {

    if(transaction.getSens().equals("decaissement")) {
    	switch (transaction.getOperateur()) {
        case "Orange":    
				total.setOrange(total.getOrange()+transaction.getDecaissement());
				break;			
        
          case "Expresso":
				total.setExpresso(total.getExpresso()+transaction.getDecaissement());

				break;
          case "Free":
				total.setFreeMoney(total.getFreeMoney()+transaction.getDecaissement());

	             break;
          case "Wari":
				total.setWari(total.getWari()+transaction.getDecaissement());

	             break;
          case "Wizall":
				total.setWizall(total.getWizall()+transaction.getDecaissement());
          	
	              break;
          case "Proximo":
				total.setProximo(total.getProximo()+transaction.getDecaissement());

	              break;
          case "Xpress":
				total.setxpress(total.getxpress()+transaction.getDecaissement());

	              break;
          case "Yup":
				total.setYup(total.getYup()+transaction.getDecaissement());

	               break;
          case "Wave":
				total.setWave(total.getWave()+transaction.getDecaissement());
	               break;
			default:
				break;
			}

    	
     }
    }
    	return total;
    }
    public  SoldeDebuterJournee totalFraisParIdParDate( int idU,String date,String date1){
        List<Transaction>listes = transactionRepository.findByIdUAndDateBetween(idU,date,date1);
        SoldeDebuterJournee total = new SoldeDebuterJournee();
        for (Transaction transaction : listes) {

        	switch (transaction.getOperateur()) {
            case "Orange":    
    				total.setOrange(total.getOrange()+transaction.getFrais());
    				break;			
            
              case "Expresso":
    				total.setExpresso(total.getExpresso()+transaction.getFrais());

    				break;
              case "Free":
    				total.setFreeMoney(total.getFreeMoney()+transaction.getFrais());

    	             break;
              case "Wari":
    				total.setWari(total.getWari()+transaction.getFrais());

    	             break;
              case "Wizall":
    				total.setWizall(total.getWizall()+transaction.getFrais());
              	
    	              break;
              case "Proximo":
    				total.setProximo(total.getProximo()+transaction.getFrais());

    	              break;
              case "Xpress":
    				total.setxpress(total.getxpress()+transaction.getFrais());

    	              break;
              case "Yup":
    				total.setYup(total.getYup()+transaction.getFrais());

    	               break;
              case "Wave":
    				total.setWave(total.getWave()+transaction.getFrais());
    	               break;
    			default:
    				break;
    			}

        }
        	return total;
        }
    
    
    public  SoldeDebuterJournee totalEncaissementParIdParDate( int idU,String date,String date1){
        List<Transaction>listes = transactionRepository.findByIdUAndDateBetween(idU,date,date1);
        SoldeDebuterJournee total = new SoldeDebuterJournee();
        for (Transaction transaction : listes) {

        if(transaction.getSens().equals("encaissement")) {
        	switch (transaction.getOperateur()) {
            case "Orange":    
    				total.setOrange(total.getOrange()+transaction.getEncaissement());
    				break;			
            
              case "Expresso":
    				total.setExpresso(total.getExpresso()+transaction.getEncaissement());

    				break;
              case "Free":
    				total.setFreeMoney(total.getFreeMoney()+transaction.getEncaissement());

    	             break;
              case "Wari":
    				total.setWari(total.getWari()+transaction.getEncaissement());

    	             break;
              case "Wizall":
    				total.setWizall(total.getWizall()+transaction.getEncaissement());
              	
    	              break;
              case "Proximo":
    				total.setProximo(total.getProximo()+transaction.getEncaissement());

    	              break;
              case "Xpress":
    				total.setxpress(total.getxpress()+transaction.getEncaissement());

    	              break;
              case "Yup":
    				total.setYup(total.getYup()+transaction.getEncaissement());

    	               break;
              case "Wave":
    				total.setWave(total.getWave()+transaction.getEncaissement());
    	               break;
    			default:
    				break;
    			}

        	
         }
        }
        	return total;
        }

    public double totalEncaissement( int id){
    	double somme=0;
    	List<Transaction>listes = listeTansactionParCassier(id);
    	for (Transaction transaction : listes) {
			somme = somme +transaction.getEncaissement();
		}
    	return somme;
     }
   
    public double totalCommission( int id){
    	double somme=0;
    	List<Transaction>listes = listeTansactionParCassier(id);
    	for (Transaction transaction : listes) {
			somme = somme +transaction.getCommission();
		}
    	return somme;
     }
   
    public double totalFrais( int id1){
    	double somme=0;
    	List<Transaction>listes = listeTansactionParCassier(id1);
    	for (Transaction transaction : listes) {
			somme = somme +transaction.getFrais();
		}
    	return somme;
     }
   
    public List<Transaction>listeTriParOperateur( int id, String operateur){
    	List<Transaction>listes = listeTansactionParCassier(id);
    	List<Transaction> listeTri= new ArrayList<Transaction>();
    	
    	for (Transaction transaction : listes) {
			
    		if(transaction.getOperateur().equals(operateur)) {
    			listeTri.add(transaction);
    		}
		}
    	
    	return listeTri;
    }
    public List<Transaction>listeTansactionParCassier( int id_caissier){
	   List<Transaction> listes =transactionRepository.findByIdUAndDateAndStatusOrderByIdCopieAsc(id_caissier, formater.format(aujourdhui),1);
    	return listes;
    }
    
    public List<Transaction>listeHistorique( history user){
    	
    	return transactionRepository.findByIdUAndDateBetween(user.getId(),user.getDate(),user.getDate1());
    }
   public List<Transaction>listeRehercherParSens( int id_caissier,String sens){
    	
    	return transactionRepository.findBySensAndDateAndIdUAndStatus(sens,formater.format(aujourdhui), id_caissier,1);
    }
    public List<Transaction>listeRehercherParOperateur( int id_caissier,String operation){
    	
    	return transactionRepository.findByOperateurAndDateAndIdUAndStatus(operation,formater.format(aujourdhui), id_caissier,1);
    }
   
    public List<Transaction>listeRehercherParSensOperateur(String operateur,int id_caissier, String sens){
    	
    	return transactionRepository.findByOperateurAndDateAndIdUAndSensAndStatus(operateur,formater.format(aujourdhui), id_caissier,sens,1);
    }
    public void actionPlafonnementDeplafonnement(SoldeDebuterJournee solde,double ancienMontant,String nomOp) {
    	  switch (nomOp) {
          	
	          case "Orange":      
	            	solde.setOrange(solde.getOrange()-ancienMontant);
					break;
					
	         
	            case "Expresso":
	            	solde.setExpresso(solde.getExpresso()-ancienMontant);
					break;
	            case "Free":
	            	solde.setFreeMoney(solde.getFreeMoney()-ancienMontant);
		             break;
	            case "Wari":
	            	solde.setWari(solde.getWari()-ancienMontant);
		             break;
	            case "Wizall":
	            	solde.setWizall(solde.getWizall()-ancienMontant);
	            	
		              break;
	            case "Proximo":
	            	 solde.setProximo(solde.getProximo()-ancienMontant);
		              break;
	            case "Xpress":
	            	 solde.setxpress(solde.getxpress()-ancienMontant);
		              break;
	            case "Yup":
	            	  solde.setYup(solde.getYup()-ancienMontant);
		               break;
	            case "Wave":
	            	  solde.setWave(solde.getWave()-ancienMontant);
		               break;
				default:
					break;
				}
         updateSoldeDebuterJournee(solde.getIdU(),solde);
    	
    }
    public void calculeActualiser(SoldeDebuterJournee solde,double ancienMontant,String nomOp) {
		
	
           switch (nomOp) {
           case "Entree":
				solde.setCaisse(solde.getCaisse()-ancienMontant);
				break;
	       case "Plafonnement":
						 switch (nomOp) {
					          case "Orange":    
									solde.setCaisse(solde.getCaisse()-ancienMontant);
					            	solde.setOrange(solde.getOrange()+ancienMontant);
									break;
									
					          
					            case "Expresso":
									solde.setCaisse(solde.getCaisse()-ancienMontant);
					            	solde.setExpresso(solde.getExpresso()+ancienMontant);
									break;
					            case "Free":
									solde.setCaisse(solde.getCaisse()-ancienMontant);
					            	solde.setFreeMoney(solde.getFreeMoney()+ancienMontant);
						             break;
					            case "Wari":
									solde.setCaisse(solde.getCaisse()-ancienMontant);
					            	solde.setWari(solde.getWari()+ancienMontant);
						             break;
					            case "Wizall":
									solde.setCaisse(solde.getCaisse()-ancienMontant);
					            	solde.setWizall(solde.getWizall()+ancienMontant);
					            	
						              break;
					            case "Proximo":
									solde.setCaisse(solde.getCaisse()-ancienMontant);
					            	 solde.setProximo(solde.getProximo()+ancienMontant);
						              break;
					            case "Xpress":
									solde.setCaisse(solde.getCaisse()-ancienMontant);
					            	 solde.setxpress(solde.getxpress()+ancienMontant);
						              break;
					            case "Yup":
									solde.setCaisse(solde.getCaisse()-ancienMontant);
					            	  solde.setYup(solde.getYup()+ancienMontant);
						               break;
					            case "Wave":
									solde.setCaisse(solde.getCaisse()-ancienMontant);
					            	  solde.setWave(solde.getWave()+ancienMontant);
						               break;
								default:
									break;
								}
				break;
            case "Sortie":
				solde.setCaisse(solde.getCaisse()-ancienMontant);
				break;
	         case "Deplafonnement":
				solde.setCaisse(solde.getCaisse()+ancienMontant);
						switch (nomOp) {
				          case "Orange":      
								solde.setCaisse(solde.getCaisse()-ancienMontant);
				            	solde.setOrange(solde.getOrange()-ancienMontant);
								break;
								
				         
				            case "Expresso":
								solde.setCaisse(solde.getCaisse()-ancienMontant);
				            	solde.setExpresso(solde.getExpresso()-ancienMontant);
								break;
				            case "Free":
								solde.setCaisse(solde.getCaisse()-ancienMontant);
				            	solde.setFreeMoney(solde.getFreeMoney()-ancienMontant);
					             break;
				            case "Wari":
								solde.setCaisse(solde.getCaisse()-ancienMontant);
				            	solde.setWari(solde.getWari()-ancienMontant);
					             break;
				            case "Wizall":
								solde.setCaisse(solde.getCaisse()-ancienMontant);
				            	solde.setWizall(solde.getWizall()-ancienMontant);
				            	
					              break;
				            case "Proximo":
								solde.setCaisse(solde.getCaisse()-ancienMontant);
				            	 solde.setProximo(solde.getProximo()-ancienMontant);
					              break;
				            case "Xpress":
								solde.setCaisse(solde.getCaisse()-ancienMontant);
				            	 solde.setxpress(solde.getxpress()-ancienMontant);
					              break;
				            case "Yup":
								solde.setCaisse(solde.getCaisse()-ancienMontant);
				            	  solde.setYup(solde.getYup()-ancienMontant);
					               break;
				            case "Wave":
								solde.setCaisse(solde.getCaisse()-ancienMontant);
				            	  solde.setWave(solde.getWave()-ancienMontant);
					               break;
							default:
								break;
							}
				break;
				
	          case "Orange":      
	            	solde.setOrange(solde.getOrange()+ancienMontant);
					break;
					
	         
	            case "Expresso":
	            	solde.setExpresso(solde.getExpresso()+ancienMontant);
					break;
	            case "Free":
	            	solde.setFreeMoney(solde.getFreeMoney()+ancienMontant);
		             break;
	            case "Wari":
	            	solde.setWari(solde.getWari()+ancienMontant);
		             break;
	            case "Wizall":
	            	solde.setWizall(solde.getWizall()+ancienMontant);
	            	
		              break;
	            case "Proximo":
	            	 solde.setProximo(solde.getProximo()+ancienMontant);
		              break;
	            case "Xpress":
	            	 solde.setxpress(solde.getxpress()+ancienMontant);
		              break;
	            case "Yup":
	            	  solde.setYup(solde.getYup()+ancienMontant);
		               break;
	            case "Wave":
	            	  solde.setWave(solde.getWave()+ancienMontant);
		               break;
				default:
					break;
				}
          updateSoldeDebuterJournee(solde.getIdU(),solde);
		}	
    
    private void update(int idU,String operateur) {
		
    	SoldeDebuterJournee solde =soldeDebuterJourneeRepository.findByIdUAndStatus(idU,1).get(0);
    	   switch (operateur) {
    	   case "caisse":
				  solde.setCaisse(solde.getCaisse()+totalEncaissement(idU)-totalDecaissement(idU));
				break;
    	   case "Banque":
				double sommeDa = 0,sommeBanqueP = 0;
				double sommeEa = 0,sommeBanqueD = 0;
				List<Transaction> listeDa =transactionRepository.findByDateAndOperateurAndSensAndIdU(formater.format(aujourdhui),"Banque","decaissement",idU);
				List<Transaction> listeEa =transactionRepository.findByDateAndOperateurAndSensAndIdU(formater.format(aujourdhui),"Banque","encaissement",idU);
				List<Transaction> listeBanqueP =transactionRepository.findByOperateurAndOperationAndDateAndIdU("Plafonnement", "Banque",formater.format(aujourdhui),idU);
				List<Transaction> listeBanqueD =transactionRepository.findByOperateurAndOperationAndDateAndIdU("Deplafonnement", "Banque",formater.format(aujourdhui),idU);
				for (Transaction transaction : listeBanqueP) {
					sommeBanqueP = sommeBanqueP + transaction.getMontant();
				}
				for (Transaction transaction : listeBanqueD) {
					sommeBanqueD = sommeBanqueD + transaction.getMontant();
				}
				for (Transaction transaction : listeEa) {
					sommeEa = sommeEa + transaction.getEncaissement();
				}
				for (Transaction transaction : listeDa) {
					sommeDa = sommeDa + transaction.getDecaissement();
				}
				
               solde.setBanque(solde.getBanque()-sommeEa+sommeDa-sommeBanqueP+sommeBanqueD);
				break;
			case "Orange":
				double sommeD = 0,sommeOrangeD = 0;
				double sommeE = 0,sommeOrangeP = 0;
				List<Transaction> listeD =transactionRepository.findByDateAndOperateurAndSensAndIdU(formater.format(aujourdhui),"Orange","decaissement",idU);
				List<Transaction> listeE =transactionRepository.findByDateAndOperateurAndSensAndIdU(formater.format(aujourdhui),"Orange","encaissement",idU);
				List<Transaction> listeOrangeP =transactionRepository.findByOperateurAndOperationAndDateAndIdU("Plafonnement", "Orange",formater.format(aujourdhui),idU);
				List<Transaction> listeOrangeD =transactionRepository.findByOperateurAndOperationAndDateAndIdU("Deplafonnement", "Orange",formater.format(aujourdhui),idU);
				for (Transaction transaction : listeOrangeP) {
					sommeOrangeP = sommeOrangeP + transaction.getMontant();
				}
				for (Transaction transaction : listeOrangeD) {
					sommeOrangeD = sommeOrangeD + transaction.getMontant();
				}
				for (Transaction transaction : listeE) {
					sommeE = sommeE + transaction.getEncaissement();
				}
				for (Transaction transaction : listeD) {
					sommeD = sommeD + transaction.getDecaissement();
				}
                solde.setOrange(solde.getOrange()-sommeE+sommeD-sommeOrangeP+sommeOrangeD);
				break;
            case "Expresso":
            	double sommeD1 = 0,sommeExpressoP= 0;
				double sommeE1 = 0,sommeExpressoD= 0;
				List<Transaction> listeD1 =transactionRepository.findByDateAndOperateurAndSensAndIdU(formater.format(aujourdhui),"Expresso","decaissement",idU);
				List<Transaction> listeE1 =transactionRepository.findByDateAndOperateurAndSensAndIdU(formater.format(aujourdhui),"Expresso","encaissement",idU);
				List<Transaction> listeExpressoP =transactionRepository.findByOperateurAndOperationAndDateAndIdU("Plafonnement", "Expresso",formater.format(aujourdhui),idU);
				List<Transaction> listeExpressoD =transactionRepository.findByOperateurAndOperationAndDateAndIdU("Deplafonnement", "Expresso",formater.format(aujourdhui),idU);
				for (Transaction transaction : listeExpressoP) {
					sommeExpressoP = sommeExpressoP + transaction.getMontant();
				}
				for (Transaction transaction : listeExpressoD) {
					sommeExpressoD = sommeExpressoD + transaction.getMontant();
				}
				for (Transaction transaction : listeE1) {
					sommeE1 = sommeE1 + transaction.getEncaissement();
				}
				for (Transaction transaction : listeD1) {
					sommeD1 = sommeD1 + transaction.getDecaissement();
				}
				 solde.setExpresso(solde.getExpresso()-sommeE1+sommeD1-sommeExpressoP+sommeExpressoD);
				break;
            case "Free":
            	double sommeD11 = 0,sommeFreeP =0;
				double sommeE11 = 0,sommeFreeD =0;
				List<Transaction> listeE11 =transactionRepository.findByDateAndOperateurAndSensAndIdU(formater.format(aujourdhui),"Free","decaissement",idU);
				List<Transaction> listeD11 =transactionRepository.findByDateAndOperateurAndSensAndIdU(formater.format(aujourdhui),"Free","encaissement",idU);
				List<Transaction> listeFreeP =transactionRepository.findByOperateurAndOperationAndDateAndIdU("Plafonnement", "Free",formater.format(aujourdhui),idU);
				List<Transaction> listeFreeD =transactionRepository.findByOperateurAndOperationAndDateAndIdU("Deplafonnement", "Free",formater.format(aujourdhui),idU);
				for (Transaction transaction : listeFreeP) {
					sommeFreeP = sommeFreeP + transaction.getMontant();
				}
				for (Transaction transaction : listeFreeD) {
					sommeFreeD = sommeFreeD + transaction.getMontant();
				}
				for (Transaction transaction : listeD11) {
					sommeE11 = sommeE11 + transaction.getEncaissement();
				}
				for (Transaction transaction : listeE11) {
					sommeD11 = sommeD11 + transaction.getDecaissement();
				}
				 solde.setFreeMoney(solde.getFreeMoney()-sommeE11+sommeD11-sommeFreeP+sommeFreeD);
	             break;
            case "Wari":
            	double sommeD111 = 0,sommeWariP=0;
				double sommeE111 = 0,sommeWariD = 0;
				List<Transaction> listeD111 =transactionRepository.findByDateAndOperateurAndSensAndIdU(formater.format(aujourdhui),"Wari","decaissement",idU);
				List<Transaction> listeE111 =transactionRepository.findByDateAndOperateurAndSensAndIdU(formater.format(aujourdhui),"Wari","encaissement",idU);
				List<Transaction> listeWariP =transactionRepository.findByOperateurAndOperationAndDateAndIdU("Plafonnement", "Wari",formater.format(aujourdhui),idU);
				List<Transaction> listeWariD =transactionRepository.findByOperateurAndOperationAndDateAndIdU("Deplafonnement", "Wari",formater.format(aujourdhui),idU);
				for (Transaction transaction : listeWariP) {
					sommeWariP = sommeWariP + transaction.getMontant();
				}
				for (Transaction transaction : listeWariD) {
					sommeWariD = sommeWariD + transaction.getMontant();
				}
				for (Transaction transaction : listeE111) {
					sommeE111 = sommeE111 + transaction.getEncaissement();
				}
				for (Transaction transaction : listeD111) {
					sommeD111 = sommeD111 + transaction.getDecaissement();
				}
				 solde.setWari(solde.getWari()-sommeE111+sommeD111-sommeWariP+sommeWariD);
	             break;
            case "Wizall":
            	double somme1 = 0,sommeWizallP=0;
				double somme2 = 0,sommeWizallD=0;
				List<Transaction> liste1 =transactionRepository.findByDateAndOperateurAndSensAndIdU(formater.format(aujourdhui),"Wizall","decaissement",idU);
				List<Transaction> liste2 =transactionRepository.findByDateAndOperateurAndSensAndIdU(formater.format(aujourdhui),"Wizall","encaissement",idU);
				List<Transaction> listeWizallP =transactionRepository.findByOperateurAndOperationAndDateAndIdU("Plafonnement", "Wizall",formater.format(aujourdhui),idU);
				List<Transaction> listeWizallD =transactionRepository.findByOperateurAndOperationAndDateAndIdU("Deplafonnement", "Wizall",formater.format(aujourdhui),idU);
				for (Transaction transaction : listeWizallP) {
					sommeWizallP = sommeWizallP + transaction.getMontant();
				}
				for (Transaction transaction : listeWizallD) {
					sommeWizallD = sommeWizallD + transaction.getMontant();
				}
				for (Transaction transaction : liste1) {
					somme1 = somme1 + transaction.getDecaissement();
				}
				for (Transaction transaction : liste2) {
					somme2 = somme2 + transaction.getEncaissement();
				}
				 solde.setWizall(solde.getWizall()-somme2+somme1-sommeWizallP+sommeWizallD);
	              break;
             case "Proximo":
            	 double somme11 = 0,sommeProximoP=0;
 				double somme21 = 0,sommeProximoD=0;
 				List<Transaction> liste21 =transactionRepository.findByDateAndOperateurAndSensAndIdU(formater.format(aujourdhui),"Proximo","decaissement",idU);
				List<Transaction> liste11 =transactionRepository.findByDateAndOperateurAndSensAndIdU(formater.format(aujourdhui),"Proximo","encaissement",idU);
				List<Transaction> listeProximoP =transactionRepository.findByOperateurAndOperationAndDateAndIdU("Plafonnement", "Proximo",formater.format(aujourdhui),idU);
				List<Transaction> listeProximoD =transactionRepository.findByOperateurAndOperationAndDateAndIdU("Deplafonnement", "Proximo",formater.format(aujourdhui),idU);
				for (Transaction transaction : listeProximoP) {
					sommeProximoP = sommeProximoP + transaction.getMontant();
				}
				for (Transaction transaction : listeProximoD) {
					sommeProximoD = sommeProximoD + transaction.getMontant();
				}
 				for (Transaction transaction : liste11) {
 					somme11 = somme11 + transaction.getEncaissement();
 				}
 				for (Transaction transaction : liste21) {
 					somme21 = somme21 + transaction.getEncaissement();
 				}
				 solde.setProximo(solde.getProximo()-somme11+somme21-sommeProximoP+sommeProximoD);
	              break;
             case "Xpress":
            	 double somme111 = 0,sommeXpressP = 0;
  				double somme211 = 0,sommeXpressD = 0;
  				List<Transaction> liste211 =transactionRepository.findByDateAndOperateurAndSensAndIdU(formater.format(aujourdhui),"Xpress","decaissement",idU);
				List<Transaction> liste111 =transactionRepository.findByDateAndOperateurAndSensAndIdU(formater.format(aujourdhui),"Xpress","encaissement",idU);
				List<Transaction> listeXpressP =transactionRepository.findByOperateurAndOperationAndDateAndIdU("Plafonnement", "Xpress",formater.format(aujourdhui),idU);
				List<Transaction> listeXpressD =transactionRepository.findByOperateurAndOperationAndDateAndIdU("Deplafonnement", "Xpress",formater.format(aujourdhui),idU);
				for (Transaction transaction : listeXpressP) {
					sommeXpressP = sommeXpressP + transaction.getMontant();
				}
				for (Transaction transaction : listeXpressD) {
					sommeXpressD = sommeXpressD + transaction.getMontant();
				}
  				for (Transaction transaction : liste111) {
  					somme111 = somme111 + transaction.getEncaissement();
  				}
  				for (Transaction transaction : liste211) {
  					somme211 = somme211 + transaction.getDecaissement();
  				}
				 solde.setxpress(solde.getxpress()-somme111+somme211-sommeXpressP+sommeXpressD);
	              break;
              case "Yup":
            	  double somme1111 = 0,sommeYupP = 0;
    				double somme2111 = 0,sommeYupD = 0;
    				List<Transaction> liste2111 =transactionRepository.findByDateAndOperateurAndSensAndIdU(formater.format(aujourdhui),"Yup","decaissement",idU);
    				List<Transaction> liste1111 =transactionRepository.findByDateAndOperateurAndSensAndIdU(formater.format(aujourdhui),"Yup","encaissement",idU);
    				List<Transaction> listeYupP =transactionRepository.findByOperateurAndOperationAndDateAndIdU("Plafonnement", "Yup",formater.format(aujourdhui),idU);
    				List<Transaction> listeYupD =transactionRepository.findByOperateurAndOperationAndDateAndIdU("Deplafonnement", "Yup",formater.format(aujourdhui),idU);
    				for (Transaction transaction : listeYupP) {
    					sommeYupP = sommeYupP + transaction.getMontant();
    				}
    				for (Transaction transaction : listeYupD) {
    					sommeYupD = sommeYupD + transaction.getMontant();
    				}
    				for (Transaction transaction : liste1111) {
    					somme1111 = somme1111 + transaction.getEncaissement();
    				}
    				for (Transaction transaction : liste2111) {
    					somme2111 = somme2111 + transaction.getDecaissement();
    				}
   				 solde.setYup(solde.getYup()-somme1111+somme2111-sommeYupP+sommeYupD);
	               break;
       
              case "Wave":
            	  double somme11111 = 0,sommeWaveP = 0;
  				double somme21111 = 0 , sommeWaveD = 0;
  				List<Transaction> liste21111 =transactionRepository.findByDateAndOperateurAndSensAndIdU(formater.format(aujourdhui),"Wave","decaissement",idU);
				List<Transaction> liste11111 =transactionRepository.findByDateAndOperateurAndSensAndIdU(formater.format(aujourdhui),"Wave","encaissement",idU);
				List<Transaction> listeWaveP =transactionRepository.findByOperateurAndOperationAndDateAndIdU("Plafonnement", "Wave",formater.format(aujourdhui),idU);
				List<Transaction> listeWaveD =transactionRepository.findByOperateurAndOperationAndDateAndIdU("Deplafonnement", "Wave",formater.format(aujourdhui),idU);
				for (Transaction transaction : listeWaveP) {
					sommeWaveP = sommeWaveP + transaction.getMontant();
				}
				for (Transaction transaction : listeWaveD) {
					sommeWaveD = sommeWaveD + transaction.getMontant();
				}
  				for (Transaction transaction : liste11111) {
  					somme11111 = somme11111 + transaction.getEncaissement();
  				}
  				for (Transaction transaction : liste21111) {
  					somme21111 = somme21111 + transaction.getDecaissement();
  				}
  				 solde.setWave(solde.getWave()-somme11111+somme21111-sommeWaveP+sommeWaveD);
	               break;
              default:
            	  break;
		           	   }
    	   updateSoldeDebuterJournee(solde.getIdU(),solde);
	}
    
    private void updateDebuter(SoldeDebuterJournee solde_ancien,SoldeDebuterJournee solde_nouveau) {
         if((solde_ancien.getCaisse()-solde_nouveau.getCaisse()) != 0) {
        	 update(solde_ancien.getIdU(),"caisse");
         }
         if((solde_ancien.getOrange()-solde_nouveau.getOrange()) != 0) {
        	 update(solde_ancien.getIdU(),"Orange");
         }
         if((solde_ancien.getOrange()-solde_nouveau.getOrange()) != 0) {
        	 update(solde_ancien.getIdU(),"Plafonnement");
         }
         if((solde_ancien.getOrange()-solde_nouveau.getOrange()) != 0) {
        	 update(solde_ancien.getIdU(),"Deplafonnement");
         }
         if((solde_ancien.getOrange()-solde_nouveau.getOrange()) != 0) {
        	 update(solde_ancien.getIdU(),"Entree");
         }
         if((solde_ancien.getOrange()-solde_nouveau.getOrange()) != 0) {
        	 update(solde_ancien.getIdU(),"Sortie");
         }
        
         if((solde_ancien.getExpresso()-solde_nouveau.getExpresso()) != 0) {
        	 update(solde_ancien.getIdU(),"Expresso");
         }
         if((solde_ancien.getFreeMoney()-solde_nouveau.getFreeMoney()) != 0) {
        	 update(solde_ancien.getIdU(),"Free");
         }
         if((solde_ancien.getWari()-solde_nouveau.getWari()) != 0) {
        	 update(solde_ancien.getIdU(),"Wari");
         }
         if((solde_ancien.getProximo()-solde_nouveau.getProximo()) != 0) {
        	 update(solde_ancien.getIdU(),"Proximo");
         }
         if((solde_ancien.getWizall()-solde_nouveau.getWizall()) != 0) {
        	 update(solde_ancien.getIdU(),"Wizall");
         }
         if((solde_ancien.getxpress()-solde_nouveau.getxpress()) != 0) {
        	 update(solde_ancien.getIdU(),"Xpress");
         }
         if((solde_ancien.getYup()-solde_nouveau.getYup()) != 0) {
        	 update(solde_ancien.getIdU(),"Yup");
         }
         if((solde_ancien.getWave()-solde_nouveau.getWave()) != 0) {
        	 update(solde_ancien.getIdU(),"Wave");
         }
    }
    
    private void mettreTransactionAzero(int idU) {
    	SoldeDebuterJournee solde =soldeDebuterJourneeRepository.findByIdUAndStatus(idU,1).get(0);
    	Majournee jour = maJourneeRepository.findByIdSoldeDebuterJournee(solde.getId());
    	List<Transaction> listes = listeTansactionParCassier(idU);
    	
    	for (Transaction transaction : listes) {
    		transaction.setStatus(0);
    		updateTransactions(transaction.getId(), transaction);
    		
			
		}
		solde.setStatus(0);
	    jour.setStatus(0);
		updateSoldeDebuterJournee(idU, solde);
		updateMajournee(jour.getId(), jour);
		
    }

	@Override
	public  List<Majournee> getMajourneesById(int userId) {
		
		return maJourneeRepository.findByIdUAndStatus( userId,1);
	}

	@Override
	public Majournee updateMajournee(int userId, Majournee ad) {
		Majournee admin =maJourneeRepository
                        .findById(userId);
	
    	admin.setCaisse(ad.getCaisse());
		admin.setOrange(ad.getOrange());
		admin.setxpress(ad.getxpress());
		admin.setExpresso(ad.getExpresso());
		admin.setProximo(ad.getProximo());
		admin.setFreeMoney(ad.getFreeMoney());
		admin.setWari(ad.getWari());
		admin.setWave(ad.getWave());
		admin.setWizall(ad.getWizall());
		admin.setYup(ad.getYup()); 
		admin.setBanque(ad.getBanque());
		admin.setCloturer(ad.getCloturer());
		admin.setSommeInitiale(ad.getSommeInitiale());
		admin.setDate(ad.getDate());
		admin.setIdU(ad.getIdU());
		admin.setStatus(ad.getStatus());
    	final Majournee updatedUser = maJourneeRepository.save(admin);	
        return updatedUser;
	}

	@Override
	public Majournee updateMajournee(int userId, SoldeDebuterJournee user) {
		
		
    	SoldeDebuterJournee solde =soldeDebuterJourneeRepository.findByIdUAndStatus(userId,1).get(0);
        
		
		Majournee copie = maJourneeRepository.findByIdSoldeDebuterJournee(solde.getId());
    	copie.setCaisse(user.getCaisse());
    	copie.setOrange(user.getOrange());
    	copie.setxpress(user.getxpress());
    	copie.setBanque(user.getBanque());
    	copie.setExpresso(user.getExpresso());
    	copie.setProximo(user.getProximo());
    	copie.setFreeMoney(user.getFreeMoney());
    	copie.setWari(user.getWari());
    	copie.setWave(user.getWave());
    	copie.setWizall(user.getWizall());
    	copie.setYup(user.getYup()); 
    	copie.setCloturer(user.getCloturer());
    	copie.setSommeInitiale(user.getSommeInitiale());
    	copie.setIdU(user.getIdU());
    	copie.setDate(user.getDate());
    	copie.setStatus(user.getStatus());
		return updateMajournee( copie.getId(), copie);
	}

	@Override
	public SoldeDebuterJournee getTotalEncaissementOperateur(int userId) {
		 List<Transaction>listes = transactionRepository.findBySensAndDateAndIdUAndStatus("encaissement",formater.format(aujourdhui),userId,1);
		 SoldeDebuterJournee solde = new SoldeDebuterJournee();
		 for (Transaction transaction : listes) {
				 switch (transaction.getOperateur()) {
		         case "Orange":      
		           	solde.setOrange(solde.getOrange()+transaction.getEncaissement());
						break;
						
		       
		           case "Expresso":
		           	solde.setExpresso(solde.getExpresso()+transaction.getEncaissement());
						break;
		           case "Free":
		           	solde.setFreeMoney(solde.getFreeMoney()+transaction.getEncaissement());
			             break;
		           case "Wari":
		           	solde.setWari(solde.getWari()+transaction.getEncaissement());
			             break;
		           case "Wizall":
		           	solde.setWizall(solde.getWizall()+transaction.getEncaissement());
		           	
			              break;
		           case "Proximo":
		           	 solde.setProximo(solde.getProximo()+transaction.getEncaissement());
			              break;
		           case "Xpress":
		           	 solde.setxpress(solde.getxpress()+transaction.getEncaissement());
			              break;
		           case "Yup":
		           	  solde.setYup(solde.getYup()+transaction.getEncaissement());
			               break;
		           case "Wave":
		           	  solde.setWave(solde.getWave()+transaction.getEncaissement());
			               break;
					default:
						break;
					}
			 } 
		return solde;
	}

	@Override
	public SoldeDebuterJournee getTotalDecaissementOperateur(int userId) {
		 List<Transaction>listes = transactionRepository.findBySensAndDateAndIdUAndStatus("decaissement",formater.format(aujourdhui),userId,1);
		 SoldeDebuterJournee solde = new SoldeDebuterJournee();
		 for (Transaction transaction : listes) {
				 switch (transaction.getOperateur()) {
			       	
		         case "Orange":      
		           	solde.setOrange(solde.getOrange()+transaction.getDecaissement());
						break;
						
		        
		           case "Expresso":
		           	solde.setExpresso(solde.getExpresso()+transaction.getDecaissement());
						break;
		           case "Free":
		           	solde.setFreeMoney(solde.getFreeMoney()+transaction.getDecaissement());
			             break;
		           case "Wari":
		           	solde.setWari(solde.getWari()+transaction.getDecaissement());
			             break;
		           case "Wizall":
		           	solde.setWizall(solde.getWizall()+transaction.getDecaissement());
		           	
			              break;
		           case "Proximo":
		           	 solde.setProximo(solde.getProximo()+transaction.getDecaissement());
			              break;
		           case "Xpress":
		           	 solde.setxpress(solde.getxpress()+transaction.getDecaissement());
			              break;
		           case "Yup":
		           	  solde.setYup(solde.getYup()+transaction.getDecaissement());
			               break;
		           case "Wave":
		           	  solde.setWave(solde.getWave()+transaction.getDecaissement());
			               break;
					default:
						break;
					}
			 } 
		return solde;
	}

	@Override
	public SoldeDebuterJournee getTotalFraisOperateur(int userId) {
		 List<Transaction>listes = transactionRepository.findByIdUAndDateAndStatusOrderByIdCopieAsc(userId,formater.format(aujourdhui),1);
		 SoldeDebuterJournee solde = new SoldeDebuterJournee();
		 for (Transaction transaction : listes) {
				 switch (transaction.getOperateur()) {
			       	
		         case "Orange":      
		           	solde.setOrange(solde.getOrange()+transaction.getFrais());
						break;
						
		         
		           case "Expresso":
		           	solde.setExpresso(solde.getExpresso()+transaction.getFrais());
						break;
		           case "Free":
		           	solde.setFreeMoney(solde.getFreeMoney()+transaction.getFrais());
			             break;
		           case "Wari":
		           	solde.setWari(solde.getWari()+transaction.getFrais());
			             break;
		           case "Wizall":
		           	solde.setWizall(solde.getWizall()+transaction.getFrais());
		           	
			              break;
		           case "Proximo":
		           	 solde.setProximo(solde.getProximo()+transaction.getFrais());
			              break;
		           case "Xpress":
		           	 solde.setxpress(solde.getxpress()+transaction.getFrais());
			              break;
		           case "Yup":
		           	  solde.setYup(solde.getYup()+transaction.getFrais());
			               break;
		           case "Wave":
		           	  solde.setWave(solde.getWave()+transaction.getFrais());
			               break;
					default:
						break;
					}
			 } 
		return solde;
	}
	@Override
	public Position createPosition(Position position) {
		return positionRepository.save(position);
	}

	@Override
	public List<Position> getPositionByStatus(boolean status) {
		// TODO Auto-generated method stub
		return positionRepository.findByStatus(status);
	}

	@Override
	public List<Position> getPositionByIdUAndDate(int id,String date) {
		// TODO Auto-generated method stub
		return positionRepository.findByIdUAndDate(id, date);
	}

	@Override
	public List<SoldeDebuterJournee> getSoldeDebuterJourneesByIdUAndDate(int id, String date) {
		// TODO Auto-generated method stub
		return soldeDebuterJourneeRepository.findByIdUAndDate(id, date);
	}

	@Override
	public List<Soldereel> getAllSoldeReels() {
		return soldeReelRepository.findAll();
	}

	@Override
	public Soldereel getSoldeReelById(int userId) {
		return soldeReelRepository.findById(userId);
	}

	@Override
	public Soldereel createSoldeReelJournee(Soldereel user) {
		return soldeReelRepository.save(user);
	}

	@Override
	public Soldereel updateSoldeReelJournee(int userId, Soldereel ad) {
		// TODO Auto-generated method stub
		ad.setId(userId);
		return soldeReelRepository.save(ad);
	}

	@Override
	public Map<String, Boolean> deleteSoldeSoldeReel(int userId) {
		soldeReelRepository.deleteById(userId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
	}

	@Override
	public List<SoldeCloturerJournee> getAllSoldeCloturerJournees() {
		// TODO Auto-generated method stub
		return soldeCloturerJourneeRepository.findAll();
	}
	@Override
	public SoldeCloturerJournee getSoldeCloturerJourneeById(int userId) {
		return soldeCloturerJourneeRepository.findById(userId);
	}

	@Override
	public SoldeCloturerJournee createSoldeCloturerJournee(SoldeCloturerJournee user) {
		// TODO Auto-generated method stub
		return soldeCloturerJourneeRepository.save(user);
	}

	@Override
	public SoldeCloturerJournee updateSoldeCloturerJournee(int userId, SoldeCloturerJournee ad) {
		SoldeCloturerJournee admin =
				soldeCloturerJourneeRepository
                        .findById(userId);
    	admin.setCaisse(ad.getCaisse());
		admin.setOrange(ad.getOrange());
		admin.setXpress(ad.getXpress());
		admin.setExpresso(ad.getExpresso());
		admin.setProximo(ad.getProximo());
		admin.setFreemoney(ad.getFreemoney());
		admin.setWari(ad.getWari());
		admin.setWave(ad.getWave());
		admin.setWizall(ad.getWizall());
		admin.setYup(ad.getYup()); 
		admin.setBanque(ad.getBanque());
		admin.setCloturer(ad.getCloturer());
		admin.setSommeInitiale(ad.getSommeInitiale());
		admin.setDate(ad.getDate());
		admin.setStatus(ad.getStatus());
    	final SoldeCloturerJournee updatedUser = soldeCloturerJourneeRepository.save(admin);
        return updatedUser;
	}

	@Override
	public Map<String, Boolean> deleteSoldeCloturerJournee(int userId) {
		SoldeCloturerJournee user =
				soldeCloturerJourneeRepository
                        .findById(userId);
		soldeCloturerJourneeRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
	}

	@Override
	public List<Soldereel> getSoldereelByIdUAndDate(int id, String date) {
		// TODO Auto-generated method stub
		return soldeReelRepository.findByIdUAndDateAndStatus(id, date,1);
	}

	@Override
	public List<SoldeCloturerJournee> getSoldeCloturerJourneeByIdUAndDate(int id, String date) {
		// TODO Auto-generated method stub
		return soldeCloturerJourneeRepository.findByIdUAndDateAndStatus(id, date,1);
	}

	@Override
	public List<SoldeDebuterAnnee> getAllSoldeDebuterAnnees() {
		return soldeDebuterAnneeRepository.findAll();
	}

	@Override
	public SoldeDebuterAnnee getSoldeDebuterAnneeById(int userId) {
		return soldeDebuterAnneeRepository.findById(userId);
	}

	@Override
	public SoldeDebuterAnnee createOrUpdateSoldeDebuterAnnee(SoldeDebuterAnnee user) {
		return soldeDebuterAnneeRepository.save(user);
	}

	@Override
	public Map<String, Boolean> deleteSoldeDebuterAnnee(int userId) {
		soldeDebuterAnneeRepository.deleteById(userId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
	}

}
