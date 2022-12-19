package Task2.Contollers;

import Task2.Model.Repository;
import Task2.Model.Note;

import java.util.List;

public class NoteController {
    private final Repository repository;

    public NoteController(Repository repository) {
        this.repository = repository;
    }

    public void saveNote(Note note) throws Exception {
        validateNote(note);
        repository.createNote(note);
    }

    public Note readNote(String userId) throws Exception {
        return repository.readNote(userId);
    }

    public List<Note> readNoteList() {
        return repository.getAllNotes();
    }

    public Note updateNote(Note note) throws Exception {
        validateNote(note);
        return repository.updateNote(note);
    }

    public List<Note> deleteNote(String noteId) throws Exception {
        return repository.deleteNote(noteId);
    }

    private void validateNote(Note note) throws Exception {
        if (note.getHeading().isEmpty()) {
            throw new Exception("Headig is not found");
        }
        if (note.getText().isEmpty()) {
            throw new Exception("Text is not found");
        }
    }

}
