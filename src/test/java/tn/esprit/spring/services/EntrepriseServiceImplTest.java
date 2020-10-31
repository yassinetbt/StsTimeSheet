package tn.esprit.spring.services;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;

public class EntrepriseServiceImplTest {
	
	@Autowired
	EntrepriseServiceImpl test = new EntrepriseServiceImpl();
	
	
	Departement d = new Departement();
	

	@Test
	public void testAjouterEntreprise() throws NullPointerException{
		Entreprise e =new Entreprise("Esprit", "Esprit");
		e.setId(5);
		int entreadd = test.ajouterEntreprise(e);
		Assert.assertEquals(e.getId(), entreadd);
	}
	
	@Test
	public void testAjouterDepartement(){
		Departement d = new Departement("Mobile");
		d.setId(23);
		int deparadd = test.ajouterDepartement(d);
		Assert.assertEquals(d.getId(), deparadd);
	}
	
	@Test
	public void testAffecterDepartementAEntreprise(){
		Entreprise e =new Entreprise("Esprit", "Esprit");
		e.setId(12);
		Departement d = new Departement("Mobile");
		d.setId(10);
		test.affecterDepartementAEntreprise(d.getId(), e.getId());
		Assert.assertEquals(e.getId(), d.getEntreprise().getId());
		
	}
	
	/*@Test
	public void TestDeleteEntrepriseById(){
			//long x=test.entrepriseRepoistory.count();
	        //test.deleteEntrepriseById(e.getId());
	        //Assert.assertEquals(x,x-1);
	    }*/
	
	
	

}
