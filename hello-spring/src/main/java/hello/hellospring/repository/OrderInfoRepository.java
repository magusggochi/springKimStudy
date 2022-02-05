package hello.hellospring.repository;

import java.util.Optional;

import hello.hellospring.domain.Orderm;

public interface OrderInfoRepository {
	
	Orderm save(Orderm orderm);
	Optional<Orderm> findAll();

}
