package enoca.task.enocatask.controller;

import enoca.task.enocatask.dto.EmployeeDto;
import enoca.task.enocatask.service.EmployeeService;
import enoca.task.enocatask.dto.request.CreateEmployeeRequest;
import enoca.task.enocatask.dto.request.UpdateEmployeeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody CreateEmployeeRequest request){
        return ResponseEntity.ok(employeeService.createEmployee(request));
    }

    @GetMapping("/receive/{id}")
    public ResponseEntity<EmployeeDto> receiveEmployee(@PathVariable("id") Long id)throws ChangeSetPersister.NotFoundException{
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @GetMapping("/receive")
    public ResponseEntity<List<EmployeeDto>> receiveAllEmployee()throws ChangeSetPersister.NotFoundException{
        return ResponseEntity.ok(employeeService.listAllEmployee());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id){

        return ResponseEntity.ok().body( employeeService.deleteEmployeeById(id));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long id, @RequestBody UpdateEmployeeRequest request){
        return ResponseEntity.ok().body(employeeService.updateEmployeeById(id,request));
    }

}
