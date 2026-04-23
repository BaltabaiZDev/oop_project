package university.research;

import university.interfaces.Printable;

import java.time.LocalDate;

public class ResearchPaper implements Comparable<ResearchPaper>, Printable {
    private final String paperId;
    private String title;
    private String journal;
    private String doi;
    private int pages;
    private int citations;
    private LocalDate publishedAt;

    public ResearchPaper(String paperId, String title, String journal, String doi, int pages, int citations,
                         LocalDate publishedAt) {
        this.paperId = paperId;
        this.title = title;
        this.journal = journal;
        this.doi = doi;
        this.pages = pages;
        this.citations = citations;
        this.publishedAt = publishedAt;
    }

    public String getPaperId() {
        return paperId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getCitations() {
        return citations;
    }

    public void setCitations(int citations) {
        this.citations = citations;
    }

    public LocalDate getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(LocalDate publishedAt) {
        this.publishedAt = publishedAt;
    }

    @Override
    public int compareTo(ResearchPaper other) {
        return Integer.compare(this.citations, other.citations);
    }

    @Override
    public void print() {
        System.out.println("Printing paper: " + title + " (" + journal + ")");
    }

    @Override
    public String toString() {
        return "ResearchPaper{" +
                "paperId='" + paperId + '\'' +
                ", title='" + title + '\'' +
                ", citations=" + citations +
                '}';
    }
}
