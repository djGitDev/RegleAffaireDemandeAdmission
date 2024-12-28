package ca.uqam.info.mgl7460.tp3.impl;

import ca.uqam.info.mgl7460.tp3.types.Etudiant;

public class EtudiantImpl implements Etudiant {

    private String nom;
    private String prenom;
    private String codePermanent;
//    private List<DemandeAdmission> demandesAdmission = new ArrayList<DemandeAdmission>();

    public EtudiantImpl(String nom, String prenom, String codePermanent) {
        this.nom = nom;
        this.prenom = prenom;
        this.codePermanent = codePermanent;
    }

    @Override
    public String getCodePermanent() {
        return "";
    }

    @Override
    public String getPrenom() {
        return "";
    }

    @Override
    public String getNom() {
        return "";
    }

//    public void addDemande(DemandeAdmission demande) {
//        demandesAdmission.add(demande);
//    }
}
