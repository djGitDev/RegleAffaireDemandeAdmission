package ca.uqam.info.mgl7460.tp3.drools;

import java.util.HashSet;
import java.util.Set;

import org.drools.ruleunits.api.DataSource;
import org.drools.ruleunits.api.DataStore;
import org.drools.ruleunits.api.RuleUnitData;

import ca.uqam.info.mgl7460.tp3.types.DemandeAdmission;

public class AdmissionsRuleUnitData implements RuleUnitData {

    private final DataStore<DemandeAdmission> demandesAdmissions;

    private final Set<String> controlSet = new HashSet<>();

    public AdmissionsRuleUnitData() {
        this(DataSource.createStore());
    }

    public AdmissionsRuleUnitData(DataStore<DemandeAdmission> demandes) {
        this.demandesAdmissions = demandes;
    }

    public DataStore<DemandeAdmission> getDemandesAdmission() {
        return demandesAdmissions;
    }

    public Set<String> getControlSet() {
        return controlSet;
    }

}
