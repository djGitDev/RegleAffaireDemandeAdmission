Feature: traitement dossiers admission

  Background:  
    Given une fabrique instanciee

  Scenario: dossier admission vide
    Given une demande d'admission avec dossier vide
    When je soumets la demande
    Then je devrais avoir un refus motive avec dossier incomplet

  Scenario: dossier base admission experience sans attestation
    Given une demande admission sur base experience sans attestation emploi
    When je soumets la demande
    Then je devrais avoir un refus motive avec motif dossier incomplet