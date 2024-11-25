package ca.uqam.info.mgl7460.tp3.types;

import java.util.Date;

public interface DocumentAdmission {
	
	public TypeDocumentAdmission getTypeDocumentAdmission();
	
	public void setTypeDocumentAdmission(TypeDocumentAdmission typeDocument);
	
	public Date getDateReception();
	
	public void setDateReception(Date date);
	
	public StatutVerificationDocument getStatutVerificationDocument();
	
	public void setStatutVerificationDocument(StatutVerificationDocument statut);
	
	public Date getDateStatutVerificationDocument();
	
}