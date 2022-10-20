package com.softserve.sportshub.subcategory.controller;

import com.softserve.sportshub.status.StatusDto;
import com.softserve.sportshub.subcategory.command.CreateSubcategoryCommand;
import com.softserve.sportshub.subcategory.command.EditSubcategoryCommand;
import com.softserve.sportshub.subcategory.dto.SubcategoryDto;
import com.softserve.sportshub.subcategory.model.Subcategory;
import com.softserve.sportshub.subcategory.service.SubcategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subcategory")
@RequiredArgsConstructor
public class SubcategoryController {

    private final SubcategoryService subcategoryService;

    @GetMapping
    public ResponseEntity<List<SubcategoryDto>> getAll() {
        return ResponseEntity.ok(subcategoryService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubcategoryDto> getSingle(@PathVariable(name = "id") long id) {
        SubcategoryDto subcategoryDto = subcategoryService.getDtoById(id);
        return ResponseEntity.ok(subcategoryDto);
    }

    @PostMapping
    public ResponseEntity<StatusDto> add(@RequestBody CreateSubcategoryCommand command) {
        subcategoryService.save(new Subcategory(command.getName()));
        return ResponseEntity.status(HttpStatus.CREATED).body(new StatusDto("Subcategory was created successfully!"));
    }

    @PutMapping
    public ResponseEntity<StatusDto> edit(@RequestBody EditSubcategoryCommand command) {
        subcategoryService.update(command);
        return ResponseEntity.ok(new StatusDto("Subcategory was edited successfully!"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StatusDto> delete(@PathVariable(name = "id") long id) {
        subcategoryService.deleteById(id);
        return ResponseEntity.ok(new StatusDto("Subcategory was removed successfully!"));
    }

}
