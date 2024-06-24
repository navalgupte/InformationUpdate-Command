package org.example;

public interface UndoableCommand extends Command {
    public void redo();
    public void undo();
}
