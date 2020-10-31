package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.Calcul;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService {
	
	private static final Logger logger = LogManager.getLogger(Calcul.class);
	
	@Autowired
    EntrepriseRepository entrepriseRepoistory;
	@Autowired
	DepartementRepository deptRepoistory;
	
	List<Entreprise> le = new ArrayList<>();
	List<Departement> ld = new ArrayList<>();
	Entreprise e = new Entreprise();
	Departement d =new Departement();
	
	public int ajouterEntreprise(Entreprise entreprise) {
		logger.info("ID de l'entreprise : " + entreprise.getId() +  ")");
		try{
		//entrepriseRepoistory.save(entreprise);
		le.add(entreprise);
		}
		catch(NullPointerException e){
			logger.error("Erreur -> "+e);
		}
		logger.debug("Entreprise added ");
		return entreprise.getId();
		
	}

	public int ajouterDepartement(Departement dep) {
		logger.info("ID du departement : " + dep.getId() +  ")");
		try{
		//deptRepoistory.save(dep);
			ld.add(dep);
		}
		catch(NullPointerException e){
			logger.error("Logger Erreur :"+e);
		}
		logger.debug("Departement added");
		return dep.getId();
	}
	
	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
		//Le bout Master de cette relation N:1 est departement  
				//donc il faut rajouter l'entreprise a departement 
				// ==> c'est l'objet departement(le master) qui va mettre a jour l'association
				//Rappel : la classe qui contient mappedBy represente le bout Slave
				//Rappel : Dans une relation oneToMany le mappedBy doit etre du cote one.
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////
				/*Entreprise entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId).get();
				Departement depManagedEntity = deptRepoistory.findById(depId).get();
				
				depManagedEntity.setEntreprise(entrepriseManagedEntity);
				
				deptRepoistory.save(depManagedEntity);*/
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		e.setId(entrepriseId);
		
		d.setId(depId);
		d.setEntreprise(e);
		logger.debug("Departement affectee");
		
		
	}
	
	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		Entreprise entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId).get();
		List<String> depNames = new ArrayList<>();
		for(Departement dep : entrepriseManagedEntity.getDepartements()){
			depNames.add(dep.getName());
		}
		
		return depNames;
	}

	@Transactional
	public void deleteEntrepriseById(int entrepriseId) {
		try{if (!entrepriseRepoistory.findById(entrepriseId).equals(this.getEntrepriseById(entrepriseId))) {
			logger.error("Entreprise not found");
			entrepriseRepoistory.delete(entrepriseRepoistory.findById(entrepriseId).get());
            
            
        }}
		catch(NullPointerException e){
			logger.error("Erreur -> "+e);
		}
		
		logger.debug("Entreprise supprime");
	}

	@Transactional
	public void deleteDepartementById(int depId) {
		deptRepoistory.delete(deptRepoistory.findById(depId).get());
		logger.info("Departement supprime");
	}


	public Entreprise getEntrepriseById(int entrepriseId) {
		logger.info("L'id De l'entreprise est : "+entrepriseId);
		return entrepriseRepoistory.findById(entrepriseId).get();
		
	}

}
