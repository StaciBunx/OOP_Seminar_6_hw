package Task2.Model;

import java.util.List;

public interface Repository {
    List<Note> getAllNotes();
    String createNote(Note note);
    Note updateNote(Note note) throws Exception;
    Note readNote(String noteId) throws Exception;
    void deleteNote(String noteId) throws Exception;


}
