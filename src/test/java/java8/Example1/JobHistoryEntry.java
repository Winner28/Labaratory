package java8.Example1;

public class JobHistoryEntry {

    private final int duration;
    private final String position;
    private final String employer;

    /**
     * @param duration Срок работы.
     * @param position Занимаемая позиция.
     * @param employer Работодатель.
     */
    public JobHistoryEntry(int duration, String position, String employer) {
        this.duration = duration;
        this.position = position;
        this.employer = employer;
    }

    public int getDuration() {
        return duration;
    }

    public String getPosition() {
        return position;
    }

    public String getEmployer() {
        return employer;
    }


}
