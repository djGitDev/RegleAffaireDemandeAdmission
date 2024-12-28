package ca.uqam.info.mgl7460.tp3.impl;

import ca.uqam.info.mgl7460.tp3.types.BaseAdmission;
import ca.uqam.info.mgl7460.tp3.types.CritereAdmission;
import ca.uqam.info.mgl7460.tp3.types.LibelleDomaine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CritereAdmissionImpl implements CritereAdmission {


    private BaseAdmission baseAdmission;
    private List<LibelleDomaine> domainesAdmissibles = new ArrayList<LibelleDomaine>();
    private float moyenneMinimale;



    @Override
    public BaseAdmission getBaseAdmission() {
        return baseAdmission;
    }

    @Override
    public void setBaseAdmission(BaseAdmission base) {
        this.baseAdmission = base;
    }

    @Override
    public float getMoyenneMinimale() {
        return moyenneMinimale;
    }

    @Override
    public void setMoyenneMinimale(float moyenne) {
        this.moyenneMinimale = moyenne;
    }

    @Override
    public Collection<LibelleDomaine> getDomainesAdmissibles() {
        return domainesAdmissibles.stream()
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public void ajouterDomaineAdmission(LibelleDomaine libelle) {
        domainesAdmissibles.add(libelle);
    }

    @Override
    public void retirerDomaineAdmission(LibelleDomaine libelle) {
        domainesAdmissibles.remove(libelle);
    }
}
