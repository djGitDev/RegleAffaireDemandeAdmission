package ca.uqam.info.mgl7460.tp3.impl;

import ca.uqam.info.mgl7460.tp3.types.ConditionAdmission;
import ca.uqam.info.mgl7460.tp3.types.DecisionAdmission;
import ca.uqam.info.mgl7460.tp3.types.LibelleDecision;
import ca.uqam.info.mgl7460.tp3.types.MotifRefus;

import java.util.Date;

public class DecisionAdmissionImpl implements DecisionAdmission {


    private Date dateDecision;
    private LibelleDecision libelleDecision;
    private ConditionAdmission conditionAdmission;
    private MotifRefus motifRefus;
    private String commentairesDecision;
    private boolean isConforme;

    public DecisionAdmissionImpl(LibelleDecision libelleDecision){
        this.libelleDecision = libelleDecision;
        dateDecision = new Date();
        if(libelleDecision != LibelleDecision.RefusMotive)
            isConforme = true;
    }

    @Override
    public Date getDateDecision() {
        return dateDecision;
    }

    @Override
    public LibelleDecision getDecision() {
        return libelleDecision;
    }

    @Override
    public ConditionAdmission getConditionAdmission() {
        return conditionAdmission;
    }


    @Override
    public void setConditionAdmission(ConditionAdmission condition) {
        this.conditionAdmission = condition;
    }

    @Override
    public MotifRefus getMotifRefus() {
        return motifRefus;
    }

    @Override
    public void setMotifRefus(MotifRefus motif) {
        this.motifRefus = motif;
    }

    @Override
    public String getCommentairesDecision() {
        return commentairesDecision;
    }

    @Override
    public void setCommentairesDecision(String commentaire) {
        this.commentairesDecision = commentaire;
    }

    @Override
    public boolean isDecisionConforme() {
        return isConforme;
    }

    @Override
    public void setDecisionConforme(boolean vraiIOuFaux) {
        this.isConforme = vraiIOuFaux;
    }
}
