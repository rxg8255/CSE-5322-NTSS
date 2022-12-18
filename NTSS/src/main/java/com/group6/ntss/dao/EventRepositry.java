package com.group6.ntss.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group6.ntss.model.Event;

public interface EventRepositry extends JpaRepository<Event, Long> {

}
