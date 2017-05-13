package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import model.dao.BlowishDAO;
import model.dto.NoteListDTO;

public class DatabaseAcccessService {
	/**
	 * ダウンロードデータの一覧を取得する
	 * @return DownloadListDTO
	 */
	public List<NoteListDTO> getNoteList() throws SQLException, IOException{

		BlowishDAO dao = new BlowishDAO();
		List<NoteListDTO> dtoList;

		//USERテーブルを検索し、結果をdtoListに入れる。
		dtoList = dao.selectNoteList();

		return dtoList;

	}
}
