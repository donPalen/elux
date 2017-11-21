package com.test.repository;

import com.test.model.Appliance;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by prokale on 2017-11-21.
 */
public interface ApplianceRepository extends JpaRepository<Appliance, Long> {

}
