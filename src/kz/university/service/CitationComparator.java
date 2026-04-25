package kz.university.service;

import kz.university.interfaces.PaperComparator;
import kz.university.model.ResearchPaper;

public class CitationComparator implements PaperComparator {
    @Override
    public int compare(ResearchPaper a, ResearchPaper b) {
        return Integer.compare(b.getCitations(), a.getCitations());
    }
}
