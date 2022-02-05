package hello.hellospring.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import hello.hellospring.domain.Member;

public class JdbcTemplateMemberRepository implements MemberRepository {

	
	private final JdbcTemplate jdbcTemplate;
	
	public JdbcTemplateMemberRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Member save(Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Member> findById(Long id) {
		List<Member> result = jdbcTemplate.query("select * from member where id = ?",  memberRowMapper());
		return result.stream().findAny();
	}

	@Override
	public Optional<Member> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private RowMapper<Member>  memberRowMapper(){
		return new RowMapper<Member>() {
			@Override
			public Member  mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Member member = new Member();
				member.setId(rs.getLong("id"));
				member.setName(rs.getString("name"));
				
				return member;
			}
		};
	}
	
	

}