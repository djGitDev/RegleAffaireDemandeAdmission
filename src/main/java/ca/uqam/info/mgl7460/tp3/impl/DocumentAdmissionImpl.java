package ca.uqam.info.mgl7460.tp3.impl;

import ca.uqam.info.mgl7460.tp3.types.DocumentAdmission;
import ca.uqam.info.mgl7460.tp3.types.StatutVerificationDocument;
import ca.uqam.info.mgl7460.tp3.types.TypeDocumentAdmission;

import java.util.Date;

public class DocumentAdmissionImpl implements DocumentAdmission {

    private TypeDocumentAdmission typeDocumentAdmission ;
    private Date dateReception ;
    private StatutVerificationDocument statutVerificationDocument ;
    private Date dateStatutVerificationDocument ;

    public DocumentAdmissionImpl(TypeDocumentAdmission typeDocumentAdmission) {
        this.typeDocumentAdmission = typeDocumentAdmission;
        dateReception = new Date();
        dateStatutVerificationDocument = new Date();
        statutVerificationDocument = StatutVerificationDocument.NonVerifie;
    }

    @Override
    public TypeDocumentAdmission getTypeDocumentAdmission() {
        return typeDocumentAdmission;
    }

    @Override
    public void setTypeDocumentAdmission(TypeDocumentAdmission typeDocument) {
        this.typeDocumentAdmission = typeDocument;
    }

    @Override
    public Date getDateReception() {
        return dateReception;
    }

    @Override
    public void setDateReception(Date date) {
        this.dateReception = date;
    }

    @Override
    public StatutVerificationDocument getStatutVerificationDocument() {
        return statutVerificationDocument;
    }

    @Override
    public void setStatutVerificationDocument(StatutVerificationDocument statut) {
        this.statutVerificationDocument = statut;
        this.dateStatutVerificationDocument = new Date();
    }

    @Override
    public Date getDateStatutVerificationDocument() {
        return dateStatutVerificationDocument;
    }
}
