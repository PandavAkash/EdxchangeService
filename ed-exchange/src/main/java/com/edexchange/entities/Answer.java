package com.edexchange.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Lob
    private String answer;
    private Timestamp created_date;

    @OneToOne
    private UserEntity created_by;
    private boolean isAccepted;
    private Integer vote;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "questionId")
    @JsonIgnore
    private Question questionId;

    private String attachment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Timestamp getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Timestamp created_date) {
        this.created_date = created_date;
    }

    public UserEntity getCreated_by() {
        return created_by;
    }

    public void setCreated_by(UserEntity created_by) {
        this.created_by = created_by;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    public Integer getVote() {
        return vote;
    }

    public void setVote(Integer vote) {
        this.vote = vote;
    }

    public Question getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Question questionId) {
        this.questionId = questionId;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", answer='" + answer + '\'' +
                ", created_date=" + created_date +
                ", created_by=" + created_by +
                ", isAccepted=" + isAccepted +
                ", vote=" + vote +
                ", questionId=" + questionId +
                ", attachment='" + attachment + '\'' +
                '}';
    }
}
