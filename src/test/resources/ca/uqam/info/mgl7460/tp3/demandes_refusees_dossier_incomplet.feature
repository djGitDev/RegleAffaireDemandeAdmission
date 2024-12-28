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

  Scenario: dossier base admission CEGEP et cote R non fournie
    Given une demande admission sur base admission CEGEP et cote R non fournie
    When je soumets la demande
    Then je devrais avoir un refus motive avec motif dossier incomplet

  Scenario: dossier base admission ne correspont pas aux bases d'admissions des criteres d'admissions
    Given une demande admission sur base admission qui correspont pas aux bases d'admissions des criteres d'admissions
    When je soumets la demande
    Then je devrais avoir un refus motive avec motif refus pour autre motif

  Scenario: dossier moyenne base admission inférieure aux exigences des criteres admission
    Given une demande admission avec moyenne base admission inférieure aux exigences des criteres admission
    When je soumets la demande
    Then je devrais avoir un refus motive avec motif resultat scolaire trop faible

  Scenario: dossier frauduleux
    Given une demande admission avec document frauduleux
    When je soumets la demande
    Then je devrais avoir un refus motive

  Scenario: dossier admissible
    Given une demande admission qui respecte tous les regles d'affaire
    When je soumets la demande
    Then je devrais avoir une admission definitive