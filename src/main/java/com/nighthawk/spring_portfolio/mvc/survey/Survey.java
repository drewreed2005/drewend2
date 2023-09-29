package com.nighthawk.spring_portfolio.mvc.survey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data  // Annotations to simplify writing code (ie constructors, setters)
@NoArgsConstructor
@AllArgsConstructor
@Entity // Annotation to simplify creating an entity, which is a lightweight persistence domain object. Typically, an entity represents a table in a relational database, and each entity instance corresponds to a row in that table.
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique=true)
    private String survey;

    private int agree;
    private int disagree;
    private int neither;

    // starting jokes
    public static String[] init() {
        final String[] surveyArray = {
            "I feel appreciated in my day to day life.",
            "I feel prepared for the future.",
            "Anyone who believes milk should go in before cereal deserves jail time.",
            "I am loved by those I love.",
            "I will go to Hazy Lane right now. The Hazy Lane calls for me.",
            "I play video games not because they're addictive, but because they help me escape and relax.",
            "I can control myself.",
            "I am centered and calm when I need to be.",
            "I \"feel\" real. I will conjure the wilderness.",
            "I support my school's theatre program.",
            "I love to solve problems.",
            "I love to solve code problems. Debugging makes me happy.",
            "I love making APIs with JPA.",
            "I love copying code (with consent and proper credit given).",
            "I love copying code (WITHOUT proper credit 😈)."
        };
        return surveyArray;
    }
}