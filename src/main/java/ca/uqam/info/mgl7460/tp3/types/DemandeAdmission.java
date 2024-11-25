package ca.uqam.info.mgl7460.tp3.types;

import java.util.Date;

public interface DemandeAdmission {
	
	// candidat.e
	
	public Etudiant getCandidat();
	
	
	// date demande
	
	public Date getDateDemandeAdmission();
	
	// programme
	
	public Programme getProgramme();
	
	public void setProgramme(Programme programme);
	

	// session admission
	
	public SessionAdmission getSessionAdmission();
	
	public void setSessionAdmission(SessionAdmission session);
	

	// base admission
	
	public BaseAdmission getBaseAdmission();
	
	public void setBaseAdmission(BaseAdmission base);
	
	
	// cote R
	
	public int getCoteR();
	
	public void setCoteR(int cote);
	
	
	public void setMoyennePourBaseAdmission(float moyenne);
	
	public float getMoyennePourBaseAdmission();
	
	// dossier admission
	
	public DossierAdmission getDossierAdmission();
	
	public void ajouterDocumentAdmission(DocumentAdmission document);
	
	public DocumentAdmission retirerDocumentAdmission(DocumentAdmission document);
	
	
	// decision admission
	
	public DecisionAdmission getDecisionAdmission();
	
	public DecisionAdmission setLibelleDecisionAdmission(LibelleDecision libelle);
	
	public DecisionAdmission setCommentaireDecision(String commentaireDecision);
	
	public DecisionAdmission setConditionAdmission(ConditionAdmission condition) throws DecisionNonConforme;
	
	public DecisionAdmission setMotifRefus(MotifRefus motif) throws DecisionNonConforme;

}
