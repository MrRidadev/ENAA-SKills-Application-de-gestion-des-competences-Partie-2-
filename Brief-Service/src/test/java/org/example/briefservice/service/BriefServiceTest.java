package org.example.briefservice.service;
import org.example.briefservice.model.Brief;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BriefServiceTest {
@Autowired
private BriefService briefService;

private Brief brief;

    @BeforeEach

    void setUp() {

        brief = new Brief();
        brief.setTitre("A default test title");
        brief.setDescription("A default test description");
    }

    @Test
    void saveBrief() {

        Brief saveBreif = briefService.saveBrief(brief);

        assertNotNull(saveBreif.getId());
        assertEquals(brief.getTitre(),saveBreif.getTitre());
    }

    @Test
    void getAllBriefs() {
        briefService.saveBrief(brief);
        List<Brief> briefs = briefService.getAllBriefs();

        assertNotNull(briefs);
        assertTrue(briefs.size() > 0);
    }

    @Test
    void getBriefById() {

        Brief saved = briefService.saveBrief(brief);

        Brief found = briefService.getBriefById(saved.getId());
        assertNotNull(found);
        assertEquals(saved.getTitre(), found.getTitre());

    }

    @Test
    void updateBrief() {

        Brief saved = briefService.saveBrief(brief);

        Brief newData = new Brief();
        newData.setTitre("brief after update");
        newData.setDescription("new desc");

        Brief updated = briefService.updateBrief(saved.getId(), newData);

        assertEquals("brief after update", updated.getTitre());
        assertEquals("new desc", updated.getDescription());
    }
}