package kz.university.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kz.university.exceptions.NotResearcherException;
import kz.university.interfaces.Researcher;

public class ResearchProject implements Serializable {
    private String projectId;
    private String topic;
    private String status;
    private List<ResearchPaper> publishedPapers = new ArrayList<>();
    private List<Researcher> participants = new ArrayList<>();

    public ResearchProject(String projectId, String topic, String status) {
        this.projectId = projectId;
        this.topic = topic;
        this.status = status;
    }

    public void addParticipant(Researcher researcher) {
        if (researcher == null) {
            throw new NotResearcherException("Only Researcher can join a research project");
        }
        if (!participants.contains(researcher)) {
            participants.add(researcher);
        }
    }

    public void addPaper(ResearchPaper paper) {
        if (!publishedPapers.contains(paper)) {
            publishedPapers.add(paper);
        }
    }

    public String getProjectId() {
        return projectId;
    }

    public String getTopic() {
        return topic;
    }

    public String getStatus() {
        return status;
    }

    public List<ResearchPaper> getPublishedPapers() {
        return Collections.unmodifiableList(publishedPapers);
    }

    public List<Researcher> getParticipants() {
        return Collections.unmodifiableList(participants);
    }

    @Override
    public String toString() {
        return "ResearchProject{" +
                "topic='" + topic + '\'' +
                ", status='" + status + '\'' +
                ", participants=" + participants.size() +
                ", papers=" + publishedPapers.size() +
                '}';
    }
}
