package io.mauth.fakefood.controller;

import io.mauth.fakefood.dto.AuditDto;
import io.mauth.fakefood.services.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by rahulb on 4/11/17.
 */
@RestController
public class AuditController {

    @Autowired
    private AuditService auditService;

    @RequestMapping(value = "/audits",method = RequestMethod.GET)
    public List<AuditDto> getAuditForAndroid(@RequestParam(value = "androidId",required = false) String androidId){return auditService.getAudit(androidId);}

    @RequestMapping(value = "/audits",method = RequestMethod.POST)
    public AuditDto createAudit(@RequestBody AuditDto auditDto){
        return auditService.createAudit(auditDto);
    }

    @RequestMapping(value = "/audits/{id}",method = RequestMethod.GET)
    public AuditDto getAudit(@PathVariable Long id){
        return auditService.getAudit(id);
    }

}
