package com.hotbev.tea.Repositories;

import com.hotbev.tea.Models.TeaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface TeaRepository extends JpaRepository<TeaModel, Integer> {


}
    