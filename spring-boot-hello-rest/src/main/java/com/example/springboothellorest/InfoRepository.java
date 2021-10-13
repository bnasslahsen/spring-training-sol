package com.example.springboothellorest;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author bnasslahsen
 */
public interface InfoRepository extends JpaRepository<Info, Long> {
}
