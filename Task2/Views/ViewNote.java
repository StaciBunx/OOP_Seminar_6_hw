package Task2.Views;

import Task2.Contollers.NoteController;
import Task2.Model.Note;

import java.util.Scanner;
import java.util.List;

public class ViewNote {

    private NoteController noteController;

    public ViewNote(NoteController noteController) {
        this.noteController = noteController;
    }

    public void run() {
        Commands com = Commands.NONE;

        while (true) {
            String command = prompt("Type the command: ");
            try {
                com = Commands.valueOf(command);
            } catch (IllegalArgumentException e) {
                System.out.println("Command doesn't exist");
            }
            if (com == Commands.EXIT)
                return;
            try {
                switch (com) {
                    case CREATE:
                        Note note = setNote(false);
                        noteController.saveNote(note);
                        System.out.println("The note has been created");
                        break;
                    case READ:
                        String id = prompt("Note's ID: ");
                        Note readNote = noteController.readNote(id);
                        System.out.println(readNote);
                        break;
                    case LIST:
                        List<Note> noteList = noteController.readNoteList();
                        for (Note item : noteList) {
                            System.out.println(item);
                            System.out.println();
                        }
                        break;
                    case UPDATE:
                        Note updatedNote = setNote(true);
                        noteController.updateNote(updatedNote);
                        System.out.println("The note has been updated");
                        break;
                    case DELETE:
                        String idDelete = prompt("Insert ID for deletion: ");
                        noteController.deleteNote(idDelete);
                        System.out.println("The note has been deleted");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    private Note setNote(boolean forUpdate) {
        String id = "";
        if (forUpdate) {
            id = prompt("ID: ");
        }
        String heading = prompt("Heading: ");
        String text = prompt("Text: ");
        if (forUpdate) {
            return new Note(id, heading, text);
        } else {
            return new Note(heading, text);
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

}
