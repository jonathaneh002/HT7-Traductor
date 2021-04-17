package ht7.main;


public interface IKeyCalculator<K, T> {
	public K GetKey(T value);
}
