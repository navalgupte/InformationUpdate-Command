package org.example;

import java.util.Calendar;
import java.util.Date;

public class RunPattern {
    private static Calendar dateCreator = Calendar.getInstance();

    public static void main(String[] args) {
        System.out.println("Example showing use of Command Pattern - Provide update and undo functionality");
        System.out.println("---- ---- ---- ---- ----");
        System.out.println("Creating an Appointment..");
        Contact[] people = {new ContactImpl(), new ContactImpl()};
        Appointment appointment = new Appointment("Java Design Pattern Meet-Up", people, new LocationImpl(""),
                createDate(2024, 06, 24, 14, 30), createDate(2024, 06, 24, 15, 30));

        System.out.println("Creating ChangeLocationCommand..");
        ChangeLocationCommand cmd = new ChangeLocationCommand();
        cmd.setAppointment(appointment);

        System.out.println("Creating GUI..");
        CommandGui application = new CommandGui(cmd);
        application.setAppointment(appointment);
        cmd.setLocationEditor(application);
        application.createGui();
        System.out.println("---- ---- ---- ---- ----");
    }

    public static Date createDate(int year, int month, int day, int hour, int minute) {
        dateCreator.set(year, month, day, hour, minute);
        return dateCreator.getTime();
    }
}