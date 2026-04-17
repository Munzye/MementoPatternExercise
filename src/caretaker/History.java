package caretaker;

import java.util.Stack;
import model.EditorMemento;

public class History {

    private final Stack<EditorMemento> historyStack;

    public History() {
        this.historyStack = new Stack<>();
    }

    public void save(EditorMemento memento) {
        if (memento != null) {
            historyStack.push(memento);
        }
    }

    public EditorMemento undo() {
        if (historyStack.isEmpty()) {
            return null;
        }
        return historyStack.pop();
    }

    public boolean isEmpty() {
        return historyStack.isEmpty();
    }

    public int size() {
        return historyStack.size();
    }
}
