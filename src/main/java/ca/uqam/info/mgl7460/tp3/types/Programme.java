package ca.uqam.info.mgl7460.tp3.types;

import java.util.Collection;

public interface Programme {

	public String getNom();
	
	public String getNumero();
	
	public String getDescription();
	
	public void setDescription(String description);
	
	public int getNombreCredits();
	
	public void setNombreCredits(int nombre);
	
	
	public Collection<CritereAdmission> getCriteresAdmission();
	
	public void ajouteCritereAdmission(CritereAdmission critere);
	
	public CritereAdmission retireCritereAdmission(CritereAdmission critere);
}
