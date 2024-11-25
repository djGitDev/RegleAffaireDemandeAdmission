package ca.uqam.info.mgl7460.tp3.types;

import java.util.Date;

public interface DecisionAdmission {
	
	public Date getDateDecision();
	
	public LibelleDecision getDecision();
	
	public ConditionAdmission getConditionAdmission();
	
	public void setConditionAdmission(ConditionAdmission condition);
	
	public MotifRefus getMotifRefus();
	
	public void setMotifRefus(MotifRefus motif);
	
	public String getCommentairesDecision();
	
	public void setCommentairesDecision(String commentaire);
	
	public boolean isDecisionConforme();
	
	public void setDecisionConforme(boolean vraiIOuFaux);


}


