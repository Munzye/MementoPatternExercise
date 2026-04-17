package model;

public class TextEditor {

    private String content;

    public TextEditor() {
        this.content = "";
    }

    public void write(String newContent) {
        if (newContent == null) {
            newContent = "";
        }
        this.content = newContent;
    }

    public String getContent() {
        return content;
    }

    public EditorMemento save() {
        return new TextMemento(content);
    }
    public void restore(EditorMemento memento) {
        if (memento instanceof TextMemento) {
            TextMemento textMemento = (TextMemento) memento;
            this.content = textMemento.getSavedContent();
        } else {
            throw new IllegalArgumentException("Memento inválido para TextEditor.");
        }
    }

    private static class TextMemento implements EditorMemento {
        private final String savedContent;

        private TextMemento(String savedContent) {
            this.savedContent = savedContent;
        }

        private String getSavedContent() {
            return savedContent;
        }
    }
}
