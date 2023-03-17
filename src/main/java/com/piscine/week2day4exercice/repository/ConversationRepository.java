package com.piscine.week2day4exercice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.piscine.week2day4exercice.entity.Conversation;

@Repository
public interface ConversationRepository extends JpaRepository<Conversation, Long> {

}
