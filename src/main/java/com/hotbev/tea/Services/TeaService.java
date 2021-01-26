package com.hotbev.tea.Services;

import com.hotbev.tea.Models.TeaModel;
import com.hotbev.tea.Repositories.TeaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

@EnableJpaRepositories
@Service
public class TeaService {

    @Autowired
    TeaRepository teaRepository;

    public TeaService(){}

    public List findAllTeas() {
        List result = teaRepository.findAll();
        return result;
    }

    public String makeTea(String description, String name, String source) {
        TeaModel newTea = new TeaModel(description, name, source);
        teaRepository.save(newTea);
        return "New Tea Entry successful";
    }


    public String deleteTea(Integer id) {
        teaRepository.deleteById(id);
        return "TeaService:: Successful Deletion!";
    }

}
