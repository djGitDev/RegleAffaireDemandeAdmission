package ca.uqam.info.mgl7460.tp3.impl;

import ca.uqam.info.mgl7460.tp3.types.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DossierAdmissionImpl implements DossierAdmission {

    private Etudiant etudiant;
    private List<DocumentAdmission> documentAdmissions = new ArrayList<DocumentAdmission>();


    public DossierAdmissionImpl(Etudiant etudiant) {
        this.etudiant = etudiant;
    }


    @Override
    public Etudiant getCandidat() {
        return etudiant;
    }

    @Override
    public void setCandidat(Etudiant candidat) {
        this.etudiant = candidat;
    }

    @Override
    public void ajouterDocumentAdmission(DocumentAdmission document) {
        documentAdmissions.add(document);
    }

    @Override
    public DocumentAdmission retirerDocumentAdmission(DocumentAdmission document) {
        int indexDoc = documentAdmissions.indexOf(document);
        return  documentAdmissions.remove(indexDoc) ;
    }

    @Override
    public Collection<DocumentAdmission> getListeDocumentAdmission() {
        return documentAdmissions.stream()
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public Collection<DocumentAdmission> getListeDocumentAdmissionAvecStatut(StatutVerificationDocument statut) {
        return documentAdmissions.stream()
                .filter(doc -> statut.equals(doc.getStatutVerificationDocument()))
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public Collection<DocumentAdmission> getListeDocumentAdmissionDeType(TypeDocumentAdmission typeDocument) {
        return documentAdmissions.stream()
                .filter(doc -> typeDocument.equals(doc.getTypeDocumentAdmission()))
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public Collection<DocumentAdmission> getListeDocumentAdmissionAvecTypeEtStatut(TypeDocumentAdmission typeDocument, StatutVerificationDocument statut) {
        return documentAdmissions.stream()
                .filter(doc -> typeDocument.equals(doc.getTypeDocumentAdmission())
                        && statut.equals(doc.getStatutVerificationDocument()))
                .collect(Collectors.toUnmodifiableList());
    }

}
