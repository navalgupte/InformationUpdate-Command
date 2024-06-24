package org.example;

/*
    ChangeLocationCommand - Implements UndoableCommand interface providing the behavior required
    to change the location of an Appointment.
 */
public class ChangeLocationCommand implements UndoableCommand {
    private Appointment appointment;
    private Location oldLocation;
    private Location newLocation;
    private LocationEditor editor;

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public void setLocationEditor(LocationEditor editor) {
        this.editor = editor;
    }

    public void execute() {
        oldLocation = appointment.getLocation();
        newLocation = editor.getNewLocation();
        appointment.setLocation(newLocation);
    }

    public void redo() {
        appointment.setLocation(newLocation);
    }

    public void undo() {
        appointment.setLocation(oldLocation);
    }
}
