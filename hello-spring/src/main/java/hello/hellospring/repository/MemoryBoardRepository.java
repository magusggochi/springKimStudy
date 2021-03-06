package hello.hellospring.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import hello.hellospring.domain.Board;

public class MemoryBoardRepository implements BoardRepository {

	private static HashMap<Integer, Board> values = new HashMap<>();
	private static int sequence = 0;
	
	@Override
	public Board save(Board board) {
		board.setId(++sequence);
		values.put(board.getId(),board);
		return board;
	}

	@Override
	public Optional<Board> boardById(int id) {
		return Optional.ofNullable(values.get(id));
	}

	@Override
	public List<Board> boardListAll() {
		return new ArrayList<>(values.values());
	}
	
	public void  boardClear() {
		values.clear();
	}
	
}
