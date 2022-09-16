package com.example.ticketInformer.crawling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.ticketInformer.crawling.domain.TicketLink;


@Repository
public interface TicketLinkRepository extends JpaRepository<TicketLink,Long> {

}
