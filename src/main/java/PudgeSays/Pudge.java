package PudgeSays;

import java.io.Serializable;
import java.util.Locale;

public class Pudge implements Cloneable, Serializable {
	private Locale local;
	private String say01 = "say01";
	private String say02 = "say02" ;
	private String say03 = "say01";
	
	
	public Pudge() {
		
	} 
	public String getSay01() {
		return say01;
	}
	public void setSay01(String say01) {
		this.say01 = say01;
	}
	public String getSay02() {
		return say02;
	}
	public void setSay02(String say02) {
		this.say02 = say02;
	}
	public String getSay03() {
		return say03;
	}
	public void setSay03(String say03) {
		this.say03 = say03;
	}
	public Locale getLocal() {
		return local;
	}
	public void setLocal(Locale local) {
		this.local = local;
	}
	
	
	
}
