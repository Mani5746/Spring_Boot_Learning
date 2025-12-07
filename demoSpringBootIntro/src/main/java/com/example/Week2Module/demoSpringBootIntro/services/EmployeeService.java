package com.example.Week2Module.demoSpringBootIntro.services;

import com.example.Week2Module.demoSpringBootIntro.dto.EmployeeDTO;
import com.example.Week2Module.demoSpringBootIntro.entities.EmployeeEntity;
import com.example.Week2Module.demoSpringBootIntro.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;


    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }



    public Optional<EmployeeDTO> getEmployeeById(Long id) {
    Optional<EmployeeEntity> employeeEntity=employeeRepository.findById(id);

        return employeeRepository.findById(id).
                map(employeeEntity1 ->
                        modelMapper.map(employeeEntity1, EmployeeDTO.class));
    }

    public List<EmployeeDTO> getAllEmployees() {

        List<EmployeeEntity> employeeEntities=employeeRepository.findAll();

        return employeeEntities.stream().
                map(employeeEntity -> modelMapper.
                        map(employeeEntity,EmployeeDTO.class)).
                    collect(Collectors.toList());


    }

    public EmployeeDTO createNewEmployee(EmployeeDTO inputEmployee) {
       EmployeeEntity toSaveEntity =modelMapper.map(inputEmployee,EmployeeEntity.class);
        EmployeeEntity savedEmployeeEntity= employeeRepository.save(toSaveEntity);
        return modelMapper.map(savedEmployeeEntity,EmployeeDTO.class);
    }


    public EmployeeDTO updateEmployeeById(EmployeeDTO employeeDTO, Long employeeID) {
        EmployeeEntity employeeEntity=modelMapper.map(employeeDTO,EmployeeEntity.class);
        employeeEntity.setId(employeeID);
        EmployeeEntity savedEmployeeEntity=employeeRepository.save(employeeEntity);
        return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);
    }

    public boolean deleteById(Long employeeId) {

        if(!employeeRepository.existsById(employeeId)) return false;

          employeeRepository.deleteById(employeeId);
          return true;
    }


    public EmployeeDTO updatePartialById(Long employeeId, Map<String, Object> updates) {
        if(!employeeRepository.existsById(employeeId)) return null;

        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).get();

        updates.forEach((field, value) -> {
            Field fieldToBeUpdated = ReflectionUtils.findField(EmployeeEntity.class, field);
            assert fieldToBeUpdated != null;
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated, employeeEntity, value);
        });

        return modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDTO.class);
    }

}
