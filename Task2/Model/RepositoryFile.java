package Task2.Model;

import java.util.ArrayList;
import java.util.List;

public class RepositoryFile implements Repository {
    private NoteMapper mapper = new NoteMapper();
    private FileOperation fileOperation;

    public RepositoryFile(FileOperation fileOperation) {
        this.fileOperation = fileOperation;
    }

    @Override
    public List<Note> getAllNotes() {
        List<String> lines = fileOperation.readAllLines();
        List<Note> notes = new ArrayList<>();
        for (String line : lines) {
            notes.add(mapper.map(line));
        }
        return notes;
    }

    @Override
    public String createNote(Note note) {
        List<Note> notes = getAllNotes();
        int max = 0;
        for (Note item : notes) {
            int id = Integer.parseInt(item.getId());
            if (max < id) {
                max = id;
            }
        }
        int newId = max + 1;
        String id = String.format("%d", newId);
        note.setId(id);
        notes.add(note);
        saveNotes(notes);
        return id;
    }

    private void saveNotes(List<Note> notes) {
        List<String> lines = new ArrayList<>();
        for (Note item : notes) {
            lines.add(mapper.map(item));
        }
        fileOperation.saveAllLines(lines);
    }

    @Override
    public Note updateNote(Note note) throws Exception {
        List<Note> notes = getAllNotes();
        Note foundNote = findNotebyId(notes, note.getId());
        foundNote.setHeading(note.getHeading());
        foundNote.setText(note.getText());
        saveNotes(notes);
        return foundNote;
    }

    private Note findNotebyId(List<Note> notes, String noteId) throws Exception {
        for (Note note : notes) {
            if (note.getId().equals(noteId)) {
                return note;
            }
        }
        throw new Exception("User not found");
    }

    @Override
    public Note readNote(String noteId) throws Exception {
        List<Note> notes = getAllNotes();
        return findNotebyId(notes, noteId);
    }

    @Override
    public void deleteNote(String noteId) throws Exception {
        List<Note> notes = getAllNotes();
        Note foundNote = findNotebyId(notes, noteId);
        notes.remove(foundNote);
        saveNotes(notes);
    }
}
