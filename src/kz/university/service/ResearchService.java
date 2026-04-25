package kz.university.service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kz.university.interfaces.PaperComparator;
import kz.university.interfaces.Researcher;
import kz.university.model.ResearchPaper;
import kz.university.model.Student;

public class ResearchService {
    private List<Researcher> researchers = new ArrayList<>();

    public void addResearcher(Researcher researcher) {
        if (!researchers.contains(researcher)) {
            researchers.add(researcher);
        }
    }

    public void printAllPapers(PaperComparator comparator) {
        Set<ResearchPaper> uniquePapers = new LinkedHashSet<>();
        for (Researcher researcher : researchers) {
            uniquePapers.addAll(researcher.getResearchPapers());
        }
        List<ResearchPaper> sorted = new ArrayList<>(uniquePapers);
        sorted.sort(comparator);

        System.out.println("All university research papers:");
        for (ResearchPaper paper : sorted) {
            paper.print();
        }
    }

    public Researcher printTopCitedResearcher() {
        Researcher top = null;
        int bestCitations = -1;
        for (Researcher researcher : researchers) {
            int citations = 0;
            for (ResearchPaper paper : researcher.getResearchPapers()) {
                citations += paper.getCitations();
            }
            if (citations > bestCitations) {
                bestCitations = citations;
                top = researcher;
            }
        }
        System.out.println("Top cited researcher total citations: " + bestCitations);
        return top;
    }

    public void assignSupervisor(Student student, Researcher researcher) {
        student.assignSupervisor(researcher);
    }

    public List<Researcher> getResearchers() {
        return researchers;
    }
}
