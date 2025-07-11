package org.example.briefservice.service;

import org.example.briefservice.model.Brief;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BriefServiceTest {
@Autowired
private BriefService briefService;

    @Test
    void saveBrief() {

        Brief brief = new Brief();
        brief.setTitre("titre breif");
        brief.setDescription("test description");

        Brief saveBreif = briefService.saveBrief(brief);

        assertNotNull(saveBreif.getId());
        assertEquals(brief.getTitre(),saveBreif.getTitre());
    }

    @Test
    void getAllBriefs() {

        Brief brief = new Brief();
        brief.setTitre("titre breif");
        brief.setDescription("test description");


        Brief saveBreif = briefService.saveBrief(brief);

        List<Brief> briefs = briefService.getAllBriefs();

        assertNotNull(briefs);
        assertTrue(briefs.size()>0);



    }

    @Test
    void getBriefById() {

        Brief brief = new Brief();
        brief.setTitre("brief for getById");
        brief.setDescription("desc");

        Brief saved = briefService.saveBrief(brief);

        // Step 2: Get it by its ID
        Brief found = briefService.getBriefById(saved.getId());

        // Step 3: Check it's not null and has the same title
        assertNotNull(found);
        assertEquals(saved.getTitre(), found.getTitre());


    }

    @Test
    void updateBrief() {
    }
}