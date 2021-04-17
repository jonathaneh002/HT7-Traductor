package ht7.main;
/**
 * @author moise
 *
 */
public class Visit<K, T> implements IVisitar<K, T> {

	public void VisitarNodo(Association<K, T> tree) {
		Traducciones trad = (Traducciones)tree._value;
		System.out.println(trad.toString());
	}
	
}
