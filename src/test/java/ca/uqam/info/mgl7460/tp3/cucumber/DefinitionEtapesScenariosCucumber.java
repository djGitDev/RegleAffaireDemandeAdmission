package ca.uqam.info.mgl7460.tp3.cucumber;

import org.drools.ruleunits.api.RuleUnitInstance;
import org.drools.ruleunits.api.RuleUnitProvider;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uqam.info.mgl7460.tp3.drools.AdmissionsRuleUnitData;
import ca.uqam.info.mgl7460.tp3.drools.TestHarness;
import ca.uqam.info.mgl7460.tp3.types.DecisionAdmission;
import ca.uqam.info.mgl7460.tp3.types.DemandeAdmission;
import ca.uqam.info.mgl7460.tp3.types.FabriqueGestionAdmissions;
import ca.uqam.info.mgl7460.tp3.types.LibelleDecision;
import ca.uqam.info.mgl7460.tp3.types.MotifRefus;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DefinitionEtapesScenariosCucumber {
    static final Logger LOG = LoggerFactory.getLogger(DefinitionEtapesScenariosCucumber.class);


    private FabriqueGestionAdmissions fabrique;

    private DemandeAdmission demandeAdmission;

    private AdmissionsRuleUnitData admissionRuleUnitData;
    private RuleUnitInstance<AdmissionsRuleUnitData> moteurAdmissions;

    @Given("une fabrique instanciee")
    public void une_fabrique_instanciee() {
        fabrique = FabriqueGestionAdmissions.getSingleton();
        admissionRuleUnitData = new AdmissionsRuleUnitData();
        LOG.info("Creation de conteneur pour données pour admissions RÉUSSIE");

        moteurAdmissions = RuleUnitProvider.get().createRuleUnitInstance(admissionRuleUnitData);
        LOG.info("Creation de moteur pour admissions RÉUSSIE");

    }

    @Given("une demande d'admission avec dossier vide")
    public void une_demande_d_admission_avec_dossier_vide() {
        demandeAdmission = TestHarness.creerDemandeDossierVide();
    }

    @Then("je devrais avoir un refus motive avec dossier incomplet")
    public void je_devrais_avoir_un_refus_motive_avec_dossier_incomplet() {
        DecisionAdmission decisionDossier = demandeAdmission.getDecisionAdmission();
        Assertions.assertEquals(LibelleDecision.RefusMotive,decisionDossier.getDecision());
        Assertions.assertEquals(MotifRefus.DossierIncomplet, decisionDossier.getMotifRefus());
    }

    @Given("une demande admission sur base experience sans attestation emploi")
    public void une_demande_admission_sur_base_experience_sans_attestation_emploi() {
        demandeAdmission = TestHarness.creerDemandeBaseExperienceSansPreuve();
    }

    @When("je soumets la demande")
    public void je_soumets_la_demande() {
        LOG.info("Soumettre la demande " + demandeAdmission);
        admissionRuleUnitData.getDemandesAdmission().add(demandeAdmission);
        moteurAdmissions.fire();
    }
    @Then("je devrais avoir un refus motive avec motif dossier incomplet")
    public void je_devrais_avoir_un_refus_motive_avec_motif_dossier_incomplet() {
        DecisionAdmission decisionDossier = demandeAdmission.getDecisionAdmission();
        Assertions.assertEquals(LibelleDecision.RefusMotive,decisionDossier.getDecision());
        Assertions.assertEquals(MotifRefus.DossierIncomplet, decisionDossier.getMotifRefus());
    }

    @Given("une demande admission sur base admission CEGEP et cote R non fournie")
    public void une_demande_admission_sur_base_cegep_sans_cotR() {
        demandeAdmission = TestHarness.creerDemandeRefuseeBaseCEGEPSansCoteR();
    }

    @Given("une demande admission sur base admission qui correspont pas aux bases d'admissions des criteres d'admissions")
    public void une_demande_admission_sur_base_admission_sans_correspendance() {
        demandeAdmission = TestHarness.creerDemandeMauvaiseBaseAdmission();
    }


    @Then("je devrais avoir un refus motive avec motif refus pour autre motif")
    public void je_devrais_avoir_un_refus_motive_avec_refus_autre_motif() {
        DecisionAdmission decisionDossier = demandeAdmission.getDecisionAdmission();
        Assertions.assertEquals(LibelleDecision.RefusMotive,decisionDossier.getDecision());
        Assertions.assertEquals(MotifRefus.RefusPourAutreMotif, decisionDossier.getMotifRefus());
    }

    @Given("une demande admission avec moyenne base admission inférieure aux exigences des criteres admission")
    public void une_demande_admission_avec_moyenne_basse_inferieure_aux_exigences_des_criteres_admission() {
        demandeAdmission = TestHarness.creerDemandeMoyennePlusfaibleQueCriteresAdmission();
    }

    @Then("je devrais avoir un refus motive avec motif resultat scolaire trop faible")
    public void je_devrais_avoir_un_refus_motive_avec_resultat_scolaire_faible() {
        DecisionAdmission decisionDossier = demandeAdmission.getDecisionAdmission();
        Assertions.assertEquals(LibelleDecision.RefusMotive,decisionDossier.getDecision());
        Assertions.assertEquals(MotifRefus.ResultatsScolairesTropFaibles, decisionDossier.getMotifRefus());
    }

    @Given("une demande admission avec document frauduleux")
    public void une_demande_admission_avec_document_frauduleux() {
        demandeAdmission = TestHarness.creerDemandeFrauduleuse();
    }

    @Then("je devrais avoir un refus motive")
    public void je_devrais_avoir_un_refus_motive() {
        DecisionAdmission decisionDossier = demandeAdmission.getDecisionAdmission();
        Assertions.assertEquals(LibelleDecision.RefusMotive,decisionDossier.getDecision());
    }

    @Given("une demande admission qui respecte tous les regles d'affaire")
    public void une_demande_admission_admissible() {
        demandeAdmission = TestHarness.creerDemandeAdmissionAcceptee();
    }

    @Then("je devrais avoir une admission definitive")
    public void je_devrais_avoir_une_admission() {
        DecisionAdmission decisionDossier = demandeAdmission.getDecisionAdmission();
        Assertions.assertEquals(LibelleDecision.AdmissionDefinitive,decisionDossier.getDecision());
    }
    
}
