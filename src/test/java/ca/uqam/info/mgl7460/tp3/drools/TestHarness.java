package ca.uqam.info.mgl7460.tp3.drools;

import java.util.Calendar;
import java.util.Date;

import ca.uqam.info.mgl7460.tp3.types.BaseAdmission;
import ca.uqam.info.mgl7460.tp3.types.CritereAdmission;
import ca.uqam.info.mgl7460.tp3.types.DemandeAdmission;
import ca.uqam.info.mgl7460.tp3.types.DocumentAdmission;
import ca.uqam.info.mgl7460.tp3.types.Etudiant;
import ca.uqam.info.mgl7460.tp3.types.FabriqueGestionAdmissions;
import ca.uqam.info.mgl7460.tp3.types.LibelleDomaine;
import ca.uqam.info.mgl7460.tp3.types.Programme;
import ca.uqam.info.mgl7460.tp3.types.SessionAdmission;
import ca.uqam.info.mgl7460.tp3.types.StatutVerificationDocument;
import ca.uqam.info.mgl7460.tp3.types.TypeDocumentAdmission;

public class TestHarness {

	private TestHarness() {}
	
	public static final FabriqueGestionAdmissions fabrique = FabriqueGestionAdmissions.getSingleton();

	public static final String MGL = "Maitrise en Génie Logiciel";
	
	public static DemandeAdmission creerDemandeAdmissionAcceptee() {
		
		// creer un étudiant
		Etudiant brillant = fabrique.creerEtudiant("Curie", "Marie", "CURM07616701");
		
		// créer un programme
		Programme programme = fabrique.creerProgramme(MGL, "1822");
		CritereAdmission critereUn = fabrique.creerCritereAdmission();
		critereUn.setBaseAdmission(BaseAdmission.BaccalaureatOuEquivalent);
		critereUn.setMoyenneMinimale(3.0f);
		critereUn.ajouterDomaineAdmission(LibelleDomaine.GenieLogiciel);
		critereUn.ajouterDomaineAdmission(LibelleDomaine.Informatique);
		programme.ajouteCritereAdmission(critereUn);
		
		// créer une demande sur la base d'un bacc ou équivalent
		DemandeAdmission demande = fabrique.creerDemandeAdmission(brillant, programme, SessionAdmission.HIVER_2025);
		demande.setBaseAdmission(BaseAdmission.BaccalaureatOuEquivalent);
		demande.setMoyennePourBaseAdmission(4.3f);
		
		// créér un document et l'ajouter au dossier d'admission
		DocumentAdmission attestation = fabrique.creerDocumentAdmission(TypeDocumentAdmission.AttestationDiplome);
		attestation.setStatutVerificationDocument(StatutVerificationDocument.Authentifie);
		attestation.setDateReception(Calendar.getInstance().getTime());
		
		demande.ajouterDocumentAdmission(attestation);
		
		// retourner la demande
		return demande;
	}

	public static DemandeAdmission creerDemandeRefuseeBaseCEGEPSansCoteR() {
		
		// creer un étudiant
		Etudiant ministre = fabrique.creerEtudiant("Caire", "Eric", "CAIE21056501");
		
		// créer un programme
		Programme programme = fabrique.creerProgramme(MGL, "1822");
		CritereAdmission critereUn = fabrique.creerCritereAdmission();
		critereUn.setBaseAdmission(BaseAdmission.CEGEP);
		critereUn.setMoyenneMinimale(4.0f);
		critereUn.ajouterDomaineAdmission(LibelleDomaine.Informatique);
		programme.ajouteCritereAdmission(critereUn);
		
		// créer une demande sur la base d'un bacc ou équivalent
		DemandeAdmission demande = fabrique.creerDemandeAdmission(ministre, programme, SessionAdmission.HIVER_2025);
		demande.setBaseAdmission(BaseAdmission.CEGEP);
		demande.setMoyennePourBaseAdmission(4.1f);
		demande.setCoteR(0);
		
		// créér un document et l'ajouter au dossier d'admission
		DocumentAdmission attestation = fabrique.creerDocumentAdmission(TypeDocumentAdmission.AttestationDiplome);
		attestation.setStatutVerificationDocument(StatutVerificationDocument.Authentifie);
		attestation.setDateReception(Calendar.getInstance().getTime());
		
		demande.ajouterDocumentAdmission(attestation);
		
		// retourner la demande
		return demande;
	}
	
	public static DemandeAdmission creerDemandeFrauduleuse() {
		
		// creer un étudiant
		Etudiant brillant = fabrique.creerEtudiant("Gratton", "Elvis", "GRAE15035601");
		
		// créer un programme
		Programme programme = fabrique.creerProgramme(MGL, "1822");
		CritereAdmission critereUn = fabrique.creerCritereAdmission();
		critereUn.setBaseAdmission(BaseAdmission.BaccalaureatOuEquivalent);
		critereUn.setMoyenneMinimale(3.0f);
		critereUn.ajouterDomaineAdmission(LibelleDomaine.GenieLogiciel);
		critereUn.ajouterDomaineAdmission(LibelleDomaine.Informatique);
		programme.ajouteCritereAdmission(critereUn);
		
		// créer une demande sur la base d'un bacc ou équivalent
		DemandeAdmission demande = fabrique.creerDemandeAdmission(brillant, programme, SessionAdmission.HIVER_2025);
		demande.setBaseAdmission(BaseAdmission.BaccalaureatOuEquivalent);
		demande.setMoyennePourBaseAdmission(2.5f);
		
		// créér un document et l'ajouter au dossier d'admission
		DocumentAdmission attestation = fabrique.creerDocumentAdmission(TypeDocumentAdmission.AttestationDiplome);
		attestation.setStatutVerificationDocument(StatutVerificationDocument.Frauduleux);
		attestation.setDateReception(Calendar.getInstance().getTime());
		
		demande.ajouterDocumentAdmission(attestation);
		
		// retourner la demande
		return demande;
	}

    public static DemandeAdmission creerDemandeMoyennePlusfaibleQueCriteresAdmission() {
		// creer un étudiant
		Etudiant pasFort = fabrique.creerEtudiant("Donald", "Trump", "TRUD14064601");
		
		// créer un programme acceptant Bacc ou Maitrise comme base d'admission
		Programme programme = fabrique.creerProgramme(MGL, "1822");
		CritereAdmission critereUn = fabrique.creerCritereAdmission();
		critereUn.setBaseAdmission(BaseAdmission.BaccalaureatOuEquivalent);
		critereUn.setMoyenneMinimale(3.0f);
		critereUn.ajouterDomaineAdmission(LibelleDomaine.GenieLogiciel);
		programme.ajouteCritereAdmission(critereUn);
			
		CritereAdmission critereDeux = fabrique.creerCritereAdmission();
		critereDeux.setBaseAdmission(BaseAdmission.MaitriseOuEquivalent);
		critereDeux.setMoyenneMinimale(3.3f);
		critereDeux.ajouterDomaineAdmission(LibelleDomaine.GenieLogiciel);
		critereDeux.ajouterDomaineAdmission(LibelleDomaine.Informatique);
		programme.ajouteCritereAdmission(critereDeux);
				
		// créer une demande sur la base d'un bacc ou équivalent
		DemandeAdmission demande = fabrique.creerDemandeAdmission(pasFort, programme, SessionAdmission.HIVER_2025);
		demande.setBaseAdmission(BaseAdmission.BaccalaureatOuEquivalent);
		demande.setMoyennePourBaseAdmission(2.4f);
		
		// créér deux documents et les ajouter au dossier d'admission, mais aucun n'est une attestation d'emploi
		Date aujourdhui = Calendar.getInstance().getTime();

		DocumentAdmission bulletinNote = fabrique.creerDocumentAdmission(TypeDocumentAdmission.BulletinDeNote);
		bulletinNote.setStatutVerificationDocument(StatutVerificationDocument.Authentifie);
		bulletinNote.setDateReception(aujourdhui);
		demande.ajouterDocumentAdmission(bulletinNote);

		DocumentAdmission attestationDiplome = fabrique.creerDocumentAdmission(TypeDocumentAdmission.AttestationDiplome);
		attestationDiplome.setStatutVerificationDocument(StatutVerificationDocument.Authentifie);
		attestationDiplome.setDateReception(aujourdhui);
		demande.ajouterDocumentAdmission(attestationDiplome);
		
		// retourner la demande
		return demande;

    }

    public static DemandeAdmission creerDemandeBaseExperienceSansPreuve() {
		// creer un étudiant
		Etudiant flye = fabrique.creerEtudiant("Kennedy", "Robert", "KENR17015401");
		
		// créer un programme acceptant l'expérience comme base d'admission
		Programme programme = fabrique.creerProgramme(MGL, "1822");
		CritereAdmission critereUn = fabrique.creerCritereAdmission();
		critereUn.setBaseAdmission(BaseAdmission.Experience);
		critereUn.setMoyenneMinimale(3.0f);
		critereUn.ajouterDomaineAdmission(LibelleDomaine.GenieLogiciel);
		critereUn.ajouterDomaineAdmission(LibelleDomaine.Informatique);
		programme.ajouteCritereAdmission(critereUn);
		
		// créer une demande sur la base d'un bacc ou équivalent
		DemandeAdmission demande = fabrique.creerDemandeAdmission(flye, programme, SessionAdmission.HIVER_2025);
		demande.setBaseAdmission(BaseAdmission.Experience);
		demande.setMoyennePourBaseAdmission(3.4f);
		
		// créér deux documents et les ajouter au dossier d'admission, mais aucun n'est une attestation d'emploi
		Date aujourdhui = Calendar.getInstance().getTime();

		DocumentAdmission bulletinNote = fabrique.creerDocumentAdmission(TypeDocumentAdmission.BulletinDeNote);
		bulletinNote.setStatutVerificationDocument(StatutVerificationDocument.Authentifie);
		bulletinNote.setDateReception(aujourdhui);
		demande.ajouterDocumentAdmission(bulletinNote);

		DocumentAdmission lettreMotivation = fabrique.creerDocumentAdmission(TypeDocumentAdmission.LettreMotivation);
		lettreMotivation.setStatutVerificationDocument(StatutVerificationDocument.Authentifie);
		lettreMotivation.setDateReception(aujourdhui);
		demande.ajouterDocumentAdmission(lettreMotivation);
		
		// retourner la demande
		return demande;
    }

    public static DemandeAdmission creerDemandeMauvaiseBaseAdmission() {
		// creer un étudiant
		Etudiant flye = fabrique.creerEtudiant("Pierre", "Poilievre", "POIP03067901");
		
		// créer un programme acceptant Bacc ou Maitrise comme base d'admission
		Programme programme = fabrique.creerProgramme(MGL, "1822");
		CritereAdmission critereUn = fabrique.creerCritereAdmission();
		critereUn.setBaseAdmission(BaseAdmission.BaccalaureatOuEquivalent);
		critereUn.setMoyenneMinimale(3.0f);
		critereUn.ajouterDomaineAdmission(LibelleDomaine.GenieLogiciel);
		programme.ajouteCritereAdmission(critereUn);
		
		CritereAdmission critereDeux = fabrique.creerCritereAdmission();
		critereDeux.setBaseAdmission(BaseAdmission.MaitriseOuEquivalent);
		critereDeux.setMoyenneMinimale(3.3f);
		critereDeux.ajouterDomaineAdmission(LibelleDomaine.GenieLogiciel);
		critereDeux.ajouterDomaineAdmission(LibelleDomaine.Informatique);
		programme.ajouteCritereAdmission(critereDeux);


		// créer une demande sur la base de l'expérience
		DemandeAdmission demande = fabrique.creerDemandeAdmission(flye, programme, SessionAdmission.HIVER_2025);
		demande.setBaseAdmission(BaseAdmission.Experience);
		demande.setMoyennePourBaseAdmission(3.4f);
		
		// créér deux documents et les ajouter au dossier d'admission, mais aucun n'est une attestation d'emploi
		Date aujourdhui = Calendar.getInstance().getTime();

		DocumentAdmission bulletinNote = fabrique.creerDocumentAdmission(TypeDocumentAdmission.BulletinDeNote);
		bulletinNote.setStatutVerificationDocument(StatutVerificationDocument.Authentifie);
		bulletinNote.setDateReception(aujourdhui);
		demande.ajouterDocumentAdmission(bulletinNote);

		DocumentAdmission attestationEmploi = fabrique.creerDocumentAdmission(TypeDocumentAdmission.AttestationEmploi);
		attestationEmploi.setStatutVerificationDocument(StatutVerificationDocument.Authentifie);
		attestationEmploi.setDateReception(aujourdhui);
		demande.ajouterDocumentAdmission(attestationEmploi);
		
		// retourner la demande
		return demande;
    }

    public static DemandeAdmission creerDemandeDossierVide() {
		// creer un étudiant
		Etudiant distrait = fabrique.creerEtudiant("Biden", "Joe", "BIDJ12114201");
		
		// créer un programme
		Programme programme = fabrique.creerProgramme(MGL, "1822");
		CritereAdmission critereUn = fabrique.creerCritereAdmission();
		critereUn.setBaseAdmission(BaseAdmission.BaccalaureatOuEquivalent);
		critereUn.setMoyenneMinimale(3.0f);
		critereUn.ajouterDomaineAdmission(LibelleDomaine.GenieLogiciel);
		critereUn.ajouterDomaineAdmission(LibelleDomaine.Informatique);
		programme.ajouteCritereAdmission(critereUn);
		
		// créer une demande sur la base d'un bacc ou équivalent
		DemandeAdmission demande = fabrique.creerDemandeAdmission(distrait, programme, SessionAdmission.HIVER_2025);
		demande.setBaseAdmission(BaseAdmission.BaccalaureatOuEquivalent);
		demande.setMoyennePourBaseAdmission(3.5f);
		
		// Ne rien mettre dans le dossier d'admission
		
		// retourner la demande
		return demande;

    }
}
