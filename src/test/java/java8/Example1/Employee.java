package java8.Example1;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private final Person person;
    private final List<JobHistoryEntry> jobHistory;

    public Employee(Person person, List<JobHistoryEntry> jobHistory) {
        this.person = person;
        this.jobHistory = jobHistory;
    }

    public Person getPerson() {
        return person;
    }

    public boolean testAgeIsEquals30() {
        return getPerson().getAge() == 30;
    }

    public List<JobHistoryEntry> getJobHistory() {
        return new ArrayList<>(jobHistory);
    }

}
