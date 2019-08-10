package hu.bme.mit.inf.modes3.utils.common.extensions

import java.util.HashMap
import java.util.Map

/**
 * Extension methods of {@link Map}.
 * 
 * @author benedekh
 */
class MapExtensions {
	
	/**
	 * @param map whose values should be mapped
	 * @param pair the mapping function
	 * @return every key-value pair of a map is mapped to a new key-value pair 
	 */
	def static <K, V, NK, NV> map(Map<K, V> map, (K, V) => Pair<NK, NV> pair) {
		new HashMap<NK, NV>(map.size) => [ retvalue |
			map.forEach [ key, value |
				val nknv = pair.apply(key, value);
				val old = retvalue.put(nknv.key, nknv.value);
				if(old !== null) throw new IllegalArgumentException('''Pair generator lambda is not injective. The generated key «nknv.key» already exists.''')
			]
		]
	}

	/**
	 * Executes the flatmap operation on every key-value pair of the map. 
	 * It means, if the value is a collection type then the map operation will be executed for each element of the collection.
	 * 
	 * @param map whose values should be mapped
	 * @param pair the mapping function
	 * @return every key-value pair of a map is mapped to a new key-value pair 
	 */
	def static <K, V, NK, NV> flatMap(Map<K, ? extends Iterable<V>> map, (K, V) => Pair<NK, NV> pair) {
		newHashMap => [ retvalue |
			map.forEach [ key, values |
				values.map [ value |
					pair.apply(key, value)
				].forEach [ nknv |
					val old = retvalue.put(nknv.key, nknv.value);
					if(old !== null) throw new IllegalArgumentException('''Pair generator lambda is not injective. The generated key «nknv.key» already exists.''')
				]
			]
		]
	}
}
