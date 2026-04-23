package university.core;

import university.research.ResearchPaper;
import university.research.ResearchProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Researcher extends Employee {
    private int hIndex;
    private final List<ResearchPaper> ownPapers = new ArrayList<>();
    private final List<ResearchProject> projects = new ArrayList<>();

    public Researcher(String id, String login, String password, String firstName, String lastName, double salary,
                      int hIndex) {
        super(id, login, password, firstName, lastName, salary);
        this.hIndex = hIndex;
    }

    public void publishPaper(ResearchPaper paper) {
        ownPapers.add(paper);
    }

    public void joinProject(ResearchProject project) {
        if (!projects.contains(project)) {
            projects.add(project);
            project.addParticipant(this);
        }
    }

    public List<ResearchPaper> viewOwnPapers() {
        return Collections.unmodifiableList(ownPapers);
    }

    public int gethIndex() {
        return hIndex;
    }

    public void sethIndex(int hIndex) {
        this.hIndex = hIndex;
    }

    public List<ResearchProject> getProjects() {
        return Collections.unmodifiableList(projects);
    }
}
