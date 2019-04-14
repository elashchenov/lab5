package labTasks.lab4;

import lombok.Getter;

class Detail {
    @Getter
    private final String name;
    @Getter
    private int phase;

    Detail(String name) {
        this.name = name;
        this.phase = 1;
    }

    synchronized void incrementPhase() {
        phase++;
    }
}
