package ca.uqam.info.mgl7460.tp3.impl;

import ca.uqam.info.mgl7460.tp3.types.CritereAdmission;
import ca.uqam.info.mgl7460.tp3.types.Programme;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ProgrammeImpl implements Programme {

    private String nom;
    private String numero;
    private String description;
    private int nombreCredits;
    private List<CritereAdmission> critereAdmissions = new ArrayList<CritereAdmission>();
//    private float plusBasseMoyenneAdmission;

    public ProgrammeImpl(String nom, String numero){
        this.nom = nom;
        this.numero = numero;
    }


    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public String getNumero() {
        return numero;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int getNombreCredits() {
        return nombreCredits;
    }

    @Override
    public void setNombreCredits(int nombre) {
        this.nombreCredits = nombre;
    }

    @Override
    public Collection<CritereAdmission> getCriteresAdmission() {
        return critereAdmissions.stream()
                .collect(Collectors.toUnmodifiableList());    }

    @Override
    public void ajouteCritereAdmission(CritereAdmission critere) {
        critereAdmissions.add(critere);
//        if (critereAdmissions.size() ==1)
//            plusBasseMoyenneAdmission = critereAdmissions.getFirst().getMoyenneMinimale();
//        plusBasseMoyenneAdmission = getPlusBasseMoyenneAdmission();
    }

    @Override
    public CritereAdmission retireCritereAdmission(CritereAdmission critere) {
        int indexDoc = critereAdmissions.indexOf(critere);
        return indexDoc >= 0 ? critereAdmissions.remove(indexDoc) : null;
    }
//    public float getBasseMoyenneAdmission(){
//        return plusBasseMoyenneAdmission;
//    }
//
//
//    private float getPlusBasseMoyenneAdmission (){
//       return critereAdmissions.stream()
//               .map(CritereAdmission::getMoyenneMinimale)
//               .min(Float::compare)
//               .orElseThrow(() -> new IllegalStateException("La liste est vide"));
//    }


}
