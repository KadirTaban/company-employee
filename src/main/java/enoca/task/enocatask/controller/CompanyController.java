package enoca.task.enocatask.controller;

import enoca.task.enocatask.service.CompanyService;
import enoca.task.enocatask.dto.CompanyDto;
import enoca.task.enocatask.dto.EmployeeDto;
import enoca.task.enocatask.dto.request.CreateCompanyRequest;
import enoca.task.enocatask.dto.request.UpdateCompanyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/company")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    @PostMapping("/create")
    public ResponseEntity<CompanyDto> createCompany(@RequestBody CreateCompanyRequest request){
        return ResponseEntity.ok(companyService.createCompany(request));
    }
    @GetMapping("/employees/{id}")
    public ResponseEntity<List<EmployeeDto>> getCompanyEmployee(@PathVariable("id") Long id){
        return ResponseEntity.ok(companyService.listCompanyEmployee(id));
    }
    @GetMapping("/receiveAll")
    public ResponseEntity<List<CompanyDto>> getCompany(){

        return ResponseEntity.ok(companyService.listCompanyAll());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CompanyDto> updateCompany(@PathVariable("id") Long id, @RequestBody UpdateCompanyRequest request){
        return ResponseEntity.ok(companyService.updateCompanyById(id,request));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable("id") Long id){
        return ResponseEntity.ok(companyService.deleteCompanyById(id));
    }


}
