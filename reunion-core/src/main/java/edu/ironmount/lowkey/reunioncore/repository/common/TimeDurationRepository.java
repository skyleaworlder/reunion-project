package edu.ironmount.lowkey.reunioncore.repository.common;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ironmount.lowkey.reunioncore.model.common.TimeDuration;

public interface TimeDurationRepository extends JpaRepository<TimeDuration, Long> {}
