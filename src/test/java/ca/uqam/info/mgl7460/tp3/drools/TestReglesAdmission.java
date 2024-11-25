package ca.uqam.info.mgl7460.tp3.drools;

import org.drools.ruleunits.api.RuleUnitProvider;

import java.util.List;

import org.drools.ruleunits.api.RuleUnitInstance;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uqam.info.mgl7460.tp3.types.DecisionAdmission;
import ca.uqam.info.mgl7460.tp3.types.DemandeAdmission;
import ca.uqam.info.mgl7460.tp3.types.LibelleDecision;
import ca.uqam.info.mgl7460.tp3.types.MotifRefus;

public class TestReglesAdmission {
    static final Logger LOG = LoggerFactory.getLogger(TestReglesAdmission.class);
    private static AdmissionsRuleUnitData admissionRuleUnitData;
    private static RuleUnitInstance<AdmissionsRuleUnitData> moteurAdmissions;

    @BeforeAll
    public static void initialiserMoteurReglesAdmission() {
        admissionRuleUnitData = new AdmissionsRuleUnitData();
        LOG.info("Creation de conteneur pour données pour admissions RÉUSSIE");

        moteurAdmissions = RuleUnitProvider.get().createRuleUnitInstance(admissionRuleUnitData);
        LOG.info("Creation de moteur pour admissions RÉUSSIE");
    }

    @Test
    public void testDemandeRefuseeBaseCEGEPSansCoteR() {

        try {
            LOG.info("Insérer une demande d'admission avec base d'admission CEGEP sans cote R");
            DemandeAdmission demandeBaseCEGEPSansCoteR = TestHarness.creerDemandeRefuseeBaseCEGEPSansCoteR();
            admissionRuleUnitData.getDemandesAdmission().add(demandeBaseCEGEPSansCoteR);
            
            LOG.info("Exécuter les règles sur une demande d'admission avec base d'admission CEGEP sans cote R");
            moteurAdmissions.fire();
            DecisionAdmission decisionBaseCEGEPSansCoteR = demandeBaseCEGEPSansCoteR.getDecisionAdmission();
            Assertions.assertEquals(LibelleDecision.RefusMotive,decisionBaseCEGEPSansCoteR.getDecision());
            Assertions.assertEquals(MotifRefus.DossierIncomplet, decisionBaseCEGEPSansCoteR.getMotifRefus());
        } finally {
            moteurAdmissions.close();
        }
    }
    @Test
    public void testDemandeDocumentFrauduleux() {
        try {
            LOG.info("Insérer une demande d'admission frauduleuse");

            DemandeAdmission demandeFrauduleuse = TestHarness.creerDemandeFrauduleuse();            
            admissionRuleUnitData.getDemandesAdmission().add(demandeFrauduleuse);
            
            LOG.info("Exécuter les règles sur demande d'admission frauduleuse");
            moteurAdmissions.fire();
            DecisionAdmission frauduleuse = demandeFrauduleuse.getDecisionAdmission();
            Assertions.assertEquals(LibelleDecision.RefusMotive,frauduleuse.getDecision());

        } finally {
            moteurAdmissions.close();
        }
    }

    @Test
    public void testDemandeDossierVide() {
        try {
            LOG.info("Insérer une demande d'admission dossier vide");

            DemandeAdmission demandeDossierVide = TestHarness.creerDemandeDossierVide();            
            admissionRuleUnitData.getDemandesAdmission().add(demandeDossierVide);
            
            LOG.info("Exécuter les règles sur demande d'admission avec dossier vide");
            moteurAdmissions.fire();
            DecisionAdmission decisionDossierVide = demandeDossierVide.getDecisionAdmission();
            Assertions.assertEquals(LibelleDecision.RefusMotive,decisionDossierVide.getDecision());
            Assertions.assertEquals(MotifRefus.DossierIncomplet, decisionDossierVide.getMotifRefus());

        } finally {
            moteurAdmissions.close();
        }
    }

    @Test
    public void testDemandeMauvaiseBaseAdmission() {
        try {
            LOG.info("Insérer une demande d'admission mauvaise base d'admission");

            DemandeAdmission demandeMauvaiseBaseAdmission = TestHarness.creerDemandeMauvaiseBaseAdmission();            
            admissionRuleUnitData.getDemandesAdmission().add(demandeMauvaiseBaseAdmission);
            
            LOG.info("Exécuter les règles sur demande d'admission avec mauvaise base d'admission");
            moteurAdmissions.fire();
            DecisionAdmission decisionMauvaiseBaseAdmission = demandeMauvaiseBaseAdmission.getDecisionAdmission();
            Assertions.assertEquals(LibelleDecision.RefusMotive,decisionMauvaiseBaseAdmission.getDecision());
            Assertions.assertEquals(MotifRefus.RefusPourAutreMotif, decisionMauvaiseBaseAdmission.getMotifRefus());
            Assertions.assertTrue(decisionMauvaiseBaseAdmission.getCommentairesDecision().contains("Ce programme n'admet pas sur la base"));
        } finally {
            moteurAdmissions.close();
        }
    }

    @Test
    public void testDemandeBaseExperienceSansPreuve() {
        try {
            LOG.info("Insérer une demande d'admission base experience sans attestation d'emploi");

            DemandeAdmission demandeBaseExperienceSansPreuve = TestHarness.creerDemandeBaseExperienceSansPreuve();            
            admissionRuleUnitData.getDemandesAdmission().add(demandeBaseExperienceSansPreuve);
            
            LOG.info("Exécuter les règles sur demande d'admission base experience sans attestation d'emploi");
            moteurAdmissions.fire();
            DecisionAdmission decisionBaseExperienceSansPreuve = demandeBaseExperienceSansPreuve.getDecisionAdmission();
            Assertions.assertEquals(LibelleDecision.RefusMotive,decisionBaseExperienceSansPreuve.getDecision());
            Assertions.assertEquals(MotifRefus.DossierIncomplet, decisionBaseExperienceSansPreuve.getMotifRefus());
        } finally {
            moteurAdmissions.close();
        }
    }

    @Test
    public void testDemandeMoyennePlusfaibleCriteresAdmission() {
        try {
            LOG.info("Insérer une demande d'admission avec moyenne plus faible que les critères d'admission");

            DemandeAdmission demandeMoyennePlusfaibleCriteresAdmission = TestHarness.creerDemandeMoyennePlusfaibleQueCriteresAdmission();            
            admissionRuleUnitData.getDemandesAdmission().add(demandeMoyennePlusfaibleCriteresAdmission);
            
            LOG.info("Exécuter les règles sur demande d'admission avec moyenne plus faible que les critères d'admission");
            moteurAdmissions.fire();
            DecisionAdmission decisiondemandeMoyennePlusfaibleCriteresAdmission = demandeMoyennePlusfaibleCriteresAdmission.getDecisionAdmission();
            Assertions.assertEquals(LibelleDecision.RefusMotive,decisiondemandeMoyennePlusfaibleCriteresAdmission.getDecision());
            Assertions.assertEquals(MotifRefus.ResultatsScolairesTropFaibles, decisiondemandeMoyennePlusfaibleCriteresAdmission.getMotifRefus());
        } finally {
            moteurAdmissions.close();
        }
    }

    @Test
    public void testDemandeAcceptee() {
        try {
            LOG.info("Insérer une demande d'admission qui sera acceptée");

            DemandeAdmission demandeAcceptee = TestHarness.creerDemandeAdmissionAcceptee();            
            admissionRuleUnitData.getDemandesAdmission().add(demandeAcceptee);
            
            LOG.info("Exécuter les règles sur demande d'admission qui devrait etre acceptée");
            moteurAdmissions.fire();
            DecisionAdmission acceptationDefinitive = demandeAcceptee.getDecisionAdmission();
            Assertions.assertEquals(LibelleDecision.AdmissionDefinitive,acceptationDefinitive.getDecision());
            Assertions.assertTrue(acceptationDefinitive.getCommentairesDecision().contains("Félicitations!"));
        } finally {
            moteurAdmissions.close();
        }
    }


}
