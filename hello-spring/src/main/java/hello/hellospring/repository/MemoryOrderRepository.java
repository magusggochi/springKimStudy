package hello.hellospring.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import hello.hellospring.domain.Orderm;

public class MemoryOrderRepository implements OrderInfoRepository {

	private static Map<Long, Orderm> map = new HashMap<>();
	
	@Override
	public Orderm save(Orderm orderm) {
		map.put(1L, orderm);
		return orderm;
	}

	@Override
	public Optional<Orderm> findAll() {
		return Optional.ofNullable(map.get("1L"));
	}

}
