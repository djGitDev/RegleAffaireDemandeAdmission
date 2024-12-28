package ca.uqam.info.mgl7460.tp3.types;

public class DecisionNonConforme extends Exception {

	public LibelleDecision libelle;
	
	public ConditionAdmission condition;
	
	public MotifRefus motif;
	
	public String commentaire;
	
	public DecisionNonConforme(LibelleDecision libel, ConditionAdmission cond, MotifRefus mot, String comment) {
		libelle = libel;
		condition = cond;
		motif = mot;
		commentaire = comment;
	}
}
