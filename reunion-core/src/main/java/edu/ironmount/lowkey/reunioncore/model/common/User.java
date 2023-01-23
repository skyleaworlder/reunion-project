package edu.ironmount.lowkey.reunioncore.model.common;

import java.util.List;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nonnull
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_pwd")
    @Nonnull
    private String pwd;

    @Column(name = "user_name")
    @Nonnull
    private String name;

    @Column(name = "user_nickName")
    private String nickName;

    @Column(name = "user_recent_residence")
    @Nonnull
    private String recentResidence;

    @Column(name = "user_workplace")
    @Nonnull
    private String workplace;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.REMOVE})
    private List<TimeDuration> timeDurations;
}
