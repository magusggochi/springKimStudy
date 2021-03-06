package hello.hellospring.repository;

import java.util.List;
import java.util.Optional;

import hello.hellospring.domain.Board;

public interface BoardRepository {

	Board save(Board board);
	Optional<Board> boardById(int id);
	List<Board> boardListAll();
	
}
