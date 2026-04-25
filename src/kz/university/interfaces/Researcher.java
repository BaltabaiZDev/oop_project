package kz.university.interfaces;

import java.util.List;
import kz.university.model.ResearchPaper;
import kz.university.model.ResearchProject;

public interface Researcher {
    int getHIndex();
    List<ResearchPaper> getResearchPapers();
    List<ResearchProject> getResearchProjects();
    void publishPaper(ResearchPaper paper);
    void joinProject(ResearchProject project);
    void printPapers(PaperComparator comparator);
}
