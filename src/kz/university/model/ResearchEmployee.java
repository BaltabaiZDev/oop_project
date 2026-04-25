package kz.university.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kz.university.enums.UserRole;
import kz.university.interfaces.PaperComparator;
import kz.university.interfaces.Researcher;

public class ResearchEmployee extends Employee implements Researcher {
    private int hIndex;
    private List<ResearchPaper> researchPapers = new ArrayList<>();
    private List<ResearchProject> researchProjects = new ArrayList<>();

    public ResearchEmployee(String id, String login, String password, String firstName, String lastName,
                            double salary, int hIndex) {
        super(id, login, password, UserRole.RESEARCHER, firstName, lastName, salary);
        this.hIndex = hIndex;
    }

    @Override
    public int getHIndex() {
        return hIndex;
    }

    @Override
    public List<ResearchPaper> getResearchPapers() {
        return Collections.unmodifiableList(researchPapers);
    }

    @Override
    public List<ResearchProject> getResearchProjects() {
        return Collections.unmodifiableList(researchProjects);
    }

    @Override
    public void publishPaper(ResearchPaper paper) {
        if (!researchPapers.contains(paper)) {
            researchPapers.add(paper);
        }
        paper.addAuthor(this);
    }

    @Override
    public void joinProject(ResearchProject project) {
        if (!researchProjects.contains(project)) {
            researchProjects.add(project);
        }
        project.addParticipant(this);
    }

    @Override
    public void printPapers(PaperComparator comparator) {
        List<ResearchPaper> sorted = new ArrayList<>(researchPapers);
        sorted.sort(comparator);
        for (ResearchPaper paper : sorted) {
            paper.print();
        }
    }
}
