package ca.uqam.info.mgl7460.tp3.types;

import java.util.Collection;

public interface CritereAdmission {
	
	public BaseAdmission getBaseAdmission();
	
	public void setBaseAdmission(BaseAdmission base);
	
	public float getMoyenneMinimale();
	
	public void setMoyenneMinimale(float moyenne);
	
	public Collection<LibelleDomaine> getDomainesAdmissibles();
	
	public void ajouterDomaineAdmission(LibelleDomaine libelle);
	
	public void retirerDomaineAdmission(LibelleDomaine libelle);

}
