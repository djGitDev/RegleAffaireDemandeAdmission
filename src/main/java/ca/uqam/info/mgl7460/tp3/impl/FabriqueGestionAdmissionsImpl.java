package ca.uqam.info.mgl7460.tp3.impl;

import ca.uqam.info.mgl7460.tp3.types.*;

import java.util.HashMap;

public class FabriqueGestionAdmissionsImpl implements FabriqueGestionAdmissions {

    private HashMap<String,Etudiant> etudiants = new HashMap();
    private HashMap<String,Programme> programmes = new HashMap();
    private static FabriqueGestionAdmissionsImpl instance;



    public static FabriqueGestionAdmissionsImpl getSingleton(){
        if(instance == null){
            instance = new FabriqueGestionAdmissionsImpl();
        }
        return instance;
    }

    @Override
    public Etudiant creerEtudiant(String nom, String prenom, String codePermanent) {
        Etudiant etudiant = new EtudiantImpl(nom, prenom, codePermanent);
        etudiants.put(etudiant.getCodePermanent(), etudiant);
        return etudiant;
    }



    @Override
    public Etudiant getEtudiantAvecCodePermanent(String code) {
        return etudiants.get(code);
    }

    @Override
    public Programme creerProgramme(String nom, String numero) {
        Programme programme = new ProgrammeImpl(nom, numero);
        programmes.put(programme.getNumero(), programme);
        return programme;    }

    @Override
    public Programme getProgrammeAvecCode(String code) {
        return programmes.get(code);
    }

    @Override
    public DemandeAdmission creerDemandeAdmission(Etudiant candidat, Programme programme, SessionAdmission session) {
        return new DemandeAdmissionImpl(candidat, programme, session);
    }

    @Override
    public DossierAdmission creerDossierAdmission(Etudiant candidat) {
        return new DossierAdmissionImpl(candidat);
    }

    @Override
    public DocumentAdmission creerDocumentAdmission(TypeDocumentAdmission typeD) {
        return new DocumentAdmissionImpl(typeD);
    }

    @Override
    public CritereAdmission creerCritereAdmission() {
        return new CritereAdmissionImpl();
    }

    @Override
    public DecisionAdmission creerDecisionAdmission(LibelleDecision libelle) {
        return new DecisionAdmissionImpl(libelle);
    }
}
