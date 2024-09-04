package com.example.prueba_ada.controller;


import com.example.prueba_ada.dto.CompanyDTO;
import com.example.prueba_ada.dto.CompanyDTOResponse;
import com.example.prueba_ada.entity.VersionCompany;
import com.example.prueba_ada.reponse.CompanyResponse;
import com.example.prueba_ada.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@RequestMapping("api/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<List<CompanyDTO>> getCompanys(){
        return ResponseEntity.status(HttpStatus.OK).body(companyService.getCompanys());
    }

    @GetMapping("/filter/")
    @ResponseBody
    public ResponseEntity<List<VersionCompany>> getFilterCompanys(){
        return ResponseEntity.status(HttpStatus.OK).body(companyService.getFilterCompanys());
    }


    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<CompanyDTOResponse> getCompany(@PathVariable("id") String codigo){
        CompanyDTOResponse CompanyDTOResponse =companyService.getCompany(codigo);
        return ResponseEntity.status(HttpStatus.OK).body(CompanyDTOResponse);
    }



    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<CompanyDTO> saveCompany(@RequestBody CompanyDTO companyDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(companyService.saveCompany(companyDTO));
    }


    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<CompanyDTO>updateCompany(@RequestBody CompanyDTO companyDTO){
        return ResponseEntity.status(HttpStatus.OK).body(companyService.updateCompany(companyDTO));
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public ResponseEntity<String> deleteCompany(@PathVariable("id") Long id ){
        return ResponseEntity.status(HttpStatus.OK).body(companyService.deleteCompany(id));
    }









}
