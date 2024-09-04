package com.example.prueba_ada.controller;

import com.example.prueba_ada.dto.CompanyDTO;
import com.example.prueba_ada.service.CompanyService;
import com.example.prueba_ada.service.TmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@RequestMapping("api/tmp")
public class TmpController {

    @Autowired
    private TmpService tmpService;

    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<String> getCompanys() {
        return ResponseEntity.status(HttpStatus.OK).body(tmpService.getTmp());
    }
}