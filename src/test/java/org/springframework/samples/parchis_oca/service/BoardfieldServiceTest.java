package org.springframework.samples.parchis_oca.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.samples.parchis_oca.model.BoardField;
import org.springframework.samples.parchis_oca.service.BoardFieldService;
import org.springframework.stereotype.Service;

@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class), excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE))
public class BoardfieldServiceTest {

    @Autowired
    BoardFieldService boardFieldService;

    
    @Test
    void saveAndFindBoardField() {

        BoardField boardField = new BoardField();
        this.boardFieldService.save(boardField);

        Assertions.assertNotNull(this.boardFieldService.findById(1));

    }

   
}
