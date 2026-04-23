package university.research;

import university.core.Researcher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResearchProject {
    private final String projectId;
    private String topic;
    private String status;
    private final List<Researcher> participants = new ArrayList<>();
    private final List<ResearchPaper> papers = new ArrayList<>();

    public ResearchProject(String projectId, String topic, String status) {
        this.projectId = projectId;
        this.topic = topic;
        this.status = status;
    }

    public void addParticipant(Researcher researcher) {
        if (!participants.contains(researcher)) {
            participants.add(researcher);
        }
    }

    public void addPaper(ResearchPaper paper) {
        papers.add(paper);
    }

    public String getProjectId() {
        return projectId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Researcher> getParticipants() {
        return Collections.unmodifiableList(participants);
    }

    public List<ResearchPaper> getPapers() {
        return Collections.unmodifiableList(papers);
    }
}
