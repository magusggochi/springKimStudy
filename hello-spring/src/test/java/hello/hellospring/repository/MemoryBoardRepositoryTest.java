package hello.hellospring.repository;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import hello.hellospring.domain.Board;

class MemoryBoardRepositoryTest {

	MemoryBoardRepository repositroy = new MemoryBoardRepository();
	
	@AfterEach
	void afterEach() {
		repositroy.boardClear();
	}
	
	@Test
	void 테스트1() {
		//given
		Board board = new Board();
		board.setContent("himagu");
		//when
		repositroy.save(board);
		
		Board checkBoard = repositroy.boardById(board.getId()).get();
		//then
		System.out.println(checkBoard);
		System.out.println(board);
		Assertions.assertThat(checkBoard).isEqualTo(board);
		
	}
	
	
	@Test
	void 테스트2() {
		Board board = new Board();
		board.setContent("himagu");
		repositroy.save(board);
		Board board2 = new Board();
		board2.setContent("himagu");
		repositroy.save(board2);
		
		List<Board> boardList = repositroy.boardListAll();
		
		System.out.println(boardList);
		
		Assertions.assertThat(boardList.size()).isEqualTo(2);
		
	}

}
