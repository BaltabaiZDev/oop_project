package kz.university.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import kz.university.interfaces.Printable;
import kz.university.interfaces.Researcher;

public class ResearchPaper implements Comparable<ResearchPaper>, Printable, Serializable {
    private String paperId;
    private String title;
    private List<Researcher> authors = new ArrayList<>();
    private String journal;
    private String doi;
    private int pages;
    private int citations;
    private LocalDate publishedAt;

    public ResearchPaper(String paperId, String title, String journal, String doi,
                         int pages, int citations, LocalDate publishedAt) {
        this.paperId = paperId;
        this.title = title;
        this.journal = journal;
        this.doi = doi;
        this.pages = pages;
        this.citations = citations;
        this.publishedAt = publishedAt;
    }

    public void addAuthor(Researcher researcher) {
        if (researcher != null && !authors.contains(researcher)) {
            authors.add(researcher);
        }
    }

    public String getPaperId() {
        return paperId;
    }

    public String getTitle() {
        return title;
    }

    public List<Researcher> getAuthors() {
        return Collections.unmodifiableList(authors);
    }

    public String getJournal() {
        return journal;
    }

    public String getDoi() {
        return doi;
    }

    public int getPages() {
        return pages;
    }

    public int getCitations() {
        return citations;
    }

    public LocalDate getPublishedAt() {
        return publishedAt;
    }

    @Override
    public int compareTo(ResearchPaper other) {
        return this.publishedAt.compareTo(other.publishedAt);
    }

    @Override
    public void print() {
        System.out.println(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ResearchPaper)) return false;
        ResearchPaper other = (ResearchPaper) obj;
        return Objects.equals(paperId, other.paperId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paperId);
    }

    @Override
    public String toString() {
        return "ResearchPaper{" +
                "title='" + title + '\'' +
                ", journal='" + journal + '\'' +
                ", doi='" + doi + '\'' +
                ", pages=" + pages +
                ", citations=" + citations +
                ", publishedAt=" + publishedAt +
                ", authors=" + authors.size() +
                '}';
    }
}
