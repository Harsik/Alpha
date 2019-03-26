package com.example.Alpha.model;

import com.example.Alpha.model.audit.DateAudit;
import javax.persistence.*;

// import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Table(name = "votes", uniqueConstraints = { @UniqueConstraint(columnNames = { "poll_id", "user_id" }) })
public class Vote extends DateAudit {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "poll_id", nullable = false)
    private Poll poll;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "choice_id", nullable = false)
    private Choice choice;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // @Builder
    // public Vote(Long id, Poll poll, Choice choice, User user){
    //     this.id = id;
    //     this.poll = poll;
    //     this.choice = choice;
    //     this.user = user;    
    // }
}