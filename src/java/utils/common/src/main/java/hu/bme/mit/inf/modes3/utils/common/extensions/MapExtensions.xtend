package hu.bme.mit.inf.modes3.utils.common.extensions

import java.util.HashMap
import java.util.Map

class MapExtensions {

	def static <K, V, NK, NV> map(Map<K, V> map, (K, V) => Pair<NK, NV> pair) {
		new HashMap<NK, NV>(map.size) => [ retvalue |
			map.forEach [ key, value |
				val nknv = pair.apply(key, value);
				val old = retvalue.put(nknv.key, nknv.value);
				if(old !== null) throw new IllegalArgumentException('''Pair generator lambda is not injective. The generated key «nknv.key» already exists.''')
			]
		]
	}

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
