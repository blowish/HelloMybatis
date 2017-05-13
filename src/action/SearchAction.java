package action;

import java.util.List;

import model.dto.NoteListDTO;
import service.DatabaseAcccessService;

public class SearchAction extends AbstractAction {

	private static final long serialVersionUID = 1L;

	public List<NoteListDTO> noteList;

	public String execute() throws Exception {

		DatabaseAcccessService das = new DatabaseAcccessService();
		this.noteList = das.getNoteList();

		return "success";
	}

}
