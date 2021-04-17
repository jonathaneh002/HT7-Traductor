package ht7.main;

/**
 * @author moise
 *
 */
public class Key<K, T> implements IKeyCalculator<K, T> {

	@Override
         public K GetKey(T value) {
		Traducciones actual = (Traducciones)value;
		return (K)actual.getId();
	}
        
}
