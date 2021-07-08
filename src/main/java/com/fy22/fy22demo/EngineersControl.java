package com.fy22.fy22demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
 
@RestController
@RequestMapping(value = "/engineers")
public class EngineersControl
{
    @Autowired
    EngineersRepository engineersRepository;

 
    @GetMapping(value = "/list")
    public List<Engineer> getList() {
 
         List<Engineer> engineersList = engineersRepository.findAll();
		return engineersList;
    }
 
    @GetMapping(value = "/get/{id}")
    public Engineer getById(@PathVariable(value = "id") Integer enId) {

         Engineer engineer = engineersRepository.findById(enId).get();
		
		return engineer;	
    }

    
     
    @PostMapping(value = "/save")
    public Engineer save(@RequestBody Engineer engineer) {
 
         Engineer savedEngineer = engineersRepository.save(engineer);
         
         return savedEngineer;
    }
 
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Engineer> updateEmployee(@PathVariable(value = "id") Integer enId, @Valid @RequestBody Engineer engineerDetails) {

        Engineer engineer = engineersRepository.findById(enId).get();

        //engineer.setEnId(engineerDetails.getEnId());
        engineer.setName(engineerDetails.getName());

        Engineer updatedEmployee = engineersRepository.save(engineer);
        return ResponseEntity.ok(updatedEmployee);
    }

    
    @DeleteMapping(value = "/delete/{id}")
    public  Map<String, Boolean> delete(@PathVariable(value = "id") Integer enId) {
 
      Engineer employee = engineersRepository.findById(enId).get();
 
      engineersRepository.delete(employee);

      Map<String, Boolean> response = new HashMap<>();
      response.put("deleted", Boolean.TRUE);
      return response;
     }
    
}
