package edu.ironmount.lowkey.reunioncore.model.common;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class TimeDuration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "td_id")
    private Long id;

    @Column(name = "td_begin_datetime")
    private String beginDatetime; // yyyy-MM-dd HH:mm:ss

    @Column(name = "td_end_datetime")
    private String endDatetime; // yyyy-MM-dd HH:mm:ss

    @ManyToOne
    @JoinColumn(
        name = "user_id",
        foreignKey = @ForeignKey(name = "fk_user_id"))
    private User user;
}
