package model.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import model.dto.NoteListDTO;


public class BlowishDAO extends AbstractDAO {

	public BlowishDAO() throws IOException {
		super();
	}

	public List<NoteListDTO> selectNoteList() throws SQLException {
		return sqlSession.selectList( "selectNoteList");
	}

}
