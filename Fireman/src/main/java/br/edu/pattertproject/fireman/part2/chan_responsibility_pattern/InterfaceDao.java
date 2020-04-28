package br.edu.pattertproject.fireman.part2.chan_responsibility_pattern;

import java.util.Map;

public interface InterfaceDao {

	public <K, V> void add(K key, V value, Map<K, V> map);
}
