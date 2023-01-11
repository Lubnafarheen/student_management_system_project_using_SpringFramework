package org.lubna.sequencer;

public class StudentDaoListSequencer {

    private static int sequencer = 0;

    public static int nextId() {
        return ++sequencer;
    }
}
