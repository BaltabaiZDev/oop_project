package kz.university.service;

import kz.university.interfaces.PaperComparator;
import kz.university.model.ResearchPaper;

public class DateComparator implements PaperComparator {
    @Override
    public int compare(ResearchPaper a, ResearchPaper b) {
        return a.getPublishedAt().compareTo(b.getPublishedAt());
    }
}
