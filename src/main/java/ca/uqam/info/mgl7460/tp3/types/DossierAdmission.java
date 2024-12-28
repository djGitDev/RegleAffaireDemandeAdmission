package ca.uqam.info.mgl7460.tp3.types;

import java.util.Collection;

public interface DossierAdmission {
	
	public Etudiant getCandidat();
	
	public void setCandidat(Etudiant candidat);
	
	public void ajouterDocumentAdmission(DocumentAdmission document);
	
	public DocumentAdmission retirerDocumentAdmission(DocumentAdmission document);
	
	public Collection<DocumentAdmission> getListeDocumentAdmission();
	
	public Collection<DocumentAdmission> getListeDocumentAdmissionAvecStatut(StatutVerificationDocument statut);
	
	public Collection<DocumentAdmission> getListeDocumentAdmissionDeType(TypeDocumentAdmission typeDocument);
	
	public Collection<DocumentAdmission> getListeDocumentAdmissionAvecTypeEtStatut(TypeDocumentAdmission typeDocument,StatutVerificationDocument statut);
	
}
