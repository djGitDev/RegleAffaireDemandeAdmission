package ca.uqam.info.mgl7460.tp3.impl;

import ca.uqam.info.mgl7460.tp3.types.*;

import java.util.Date;

import static ca.uqam.info.mgl7460.tp3.types.FabriqueGestionAdmissions.getSingleton;

public class DemandeAdmissionImpl implements DemandeAdmission {

    private Etudiant candidat;
    private Programme programme;
    private SessionAdmission sessionAdmission;
    private Date dateDemandeAdmission;
    private BaseAdmission baseAdmission;
    private int coteR;
    private float moyennePourBaseAdmission = 0f;
    private DossierAdmission dossierAdmission ;
    private DecisionAdmission decisionAdmission;


    public DemandeAdmissionImpl(Etudiant etudiant,Programme programme, SessionAdmission session) {
        this.candidat = etudiant;
        FabriqueGestionAdmissions fabrique = getSingleton();
        this.dossierAdmission = fabrique.creerDossierAdmission(etudiant);
        this.decisionAdmission = fabrique.creerDecisionAdmission(LibelleDecision.ListeAttente);
        this.programme = programme;
        this.sessionAdmission = session;
        this.dateDemandeAdmission = new Date();
        this.coteR = 0;
    }




    @Override
    public Etudiant getCandidat() {
        return candidat;
    }

    @Override
    public Date getDateDemandeAdmission() {
        return dateDemandeAdmission;
    }

    @Override
    public Programme getProgramme() {
        return programme;
    }

    @Override
    public void setProgramme(Programme programme) {
        this.programme = programme;
    }

    @Override
    public SessionAdmission getSessionAdmission() {
        return sessionAdmission;
    }

    @Override
    public void setSessionAdmission(SessionAdmission session) {
         this.sessionAdmission = session;
    }

    @Override
    public BaseAdmission getBaseAdmission() {
         return baseAdmission;
    }

    @Override
    public void setBaseAdmission(BaseAdmission base) {
        this.baseAdmission = base;
    }

    @Override
    public int getCoteR() {
        return coteR;
    }

    @Override
    public void setCoteR(int cote) {
        this.coteR = cote;
    }

    @Override
    public void setMoyennePourBaseAdmission(float moyenne) {
        this.moyennePourBaseAdmission = moyenne;
    }

    @Override
    public float getMoyennePourBaseAdmission() {
        return moyennePourBaseAdmission;
    }

    @Override
    public DossierAdmission getDossierAdmission() {
        return dossierAdmission;
    }

    @Override
    public void ajouterDocumentAdmission(DocumentAdmission document) {
        dossierAdmission.ajouterDocumentAdmission(document);
    }

    @Override
    public DocumentAdmission retirerDocumentAdmission(DocumentAdmission document) {
       return dossierAdmission.retirerDocumentAdmission(document);
    }

    @Override
    public DecisionAdmission getDecisionAdmission() {
        return decisionAdmission;
    }

    @Override
    public DecisionAdmission setLibelleDecisionAdmission(LibelleDecision libelle) {
        FabriqueGestionAdmissions fabrique = getSingleton();
        DecisionAdmission decisionAdmission = fabrique.creerDecisionAdmission(libelle);
        this.decisionAdmission = decisionAdmission;
        return decisionAdmission;
    }

    @Override
    public DecisionAdmission setCommentaireDecision(String commentaireDecision) {
         decisionAdmission.setCommentairesDecision(commentaireDecision);
         return decisionAdmission;
    }

    @Override
    public DecisionAdmission setConditionAdmission(ConditionAdmission condition) throws DecisionNonConforme {
        decisionAdmission.setConditionAdmission(condition);
        return decisionAdmission;
    }

    @Override
    public DecisionAdmission setMotifRefus(MotifRefus motif) throws DecisionNonConforme {
        decisionAdmission.setMotifRefus(motif);
        return decisionAdmission;
    }
}
