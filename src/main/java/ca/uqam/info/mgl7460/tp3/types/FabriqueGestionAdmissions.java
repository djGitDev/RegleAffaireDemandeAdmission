package ca.uqam.info.mgl7460.tp3.types;

//import ca.uqam.info.mgl7460.tp3.impl.FabriqueGestionAdmissionsImpl;

public interface FabriqueGestionAdmissions {
	
	public Etudiant creerEtudiant(String nom, String prenom, String codePermanent);
	
	public Etudiant getEtudiantAvecCodePermanent(String code);
	
	public Programme creerProgramme(String nom, String numero);
	
	public Programme getProgrammeAvecCode(String code);
	
	public DemandeAdmission creerDemandeAdmission(Etudiant candidat, Programme programme, SessionAdmission session);
	
	public DossierAdmission creerDossierAdmission(Etudiant candidat);
	
	public DocumentAdmission creerDocumentAdmission(TypeDocumentAdmission typeD);
	
	public CritereAdmission creerCritereAdmission();
	
	public DecisionAdmission creerDecisionAdmission(LibelleDecision libelle);
	
	public static FabriqueGestionAdmissions getSingleton() {
		FabriqueGestionAdmissions fabrique = null;
//		fabrique = FabriqueGestionAdmissionsImpl.getSingleton();
		
		return fabrique;
	}

}