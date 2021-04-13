package com.edexchange.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Question {

    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    @Lob
    private String description;
    private Timestamp created_date;

    @OneToOne
    private UserEntity create_by;

    @OneToMany(mappedBy = "questionId")
    private List<Answer> answers;

    private String tags;
    private boolean isResolved;
    private String attachment;

    private int vote;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Timestamp created_date) {
        this.created_date = created_date;
    }

    public UserEntity getCreate_by() {
        return create_by;
    }

    public void setCreate_by(UserEntity create_by) {
        this.create_by = create_by;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public boolean isResolved() {
        return isResolved;
    }

    public void setResolved(boolean resolved) {
        isResolved = resolved;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", created_date=" + created_date +
                ", create_by=" + create_by +
                ", answers=" + answers +
                ", tags='" + tags + '\'' +
                ", isResolved=" + isResolved +
                ", attachment='" + attachment + '\'' +
                ", vote=" + vote +
                '}';
    }
}
