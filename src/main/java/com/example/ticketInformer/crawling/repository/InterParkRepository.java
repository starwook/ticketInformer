package com.example.ticketInformer.crawling.repository;


import com.example.ticketInformer.crawling.domain.InterPark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterParkRepository extends JpaRepository<InterPark,Long> {
}
