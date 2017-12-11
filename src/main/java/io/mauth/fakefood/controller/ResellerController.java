package io.mauth.fakefood.controller;

import io.mauth.fakefood.model.Resellers;
import io.mauth.fakefood.services.ResellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by rahulb on 4/11/17.
 */
@RestController
public class ResellerController {

    @Autowired
    private ResellerService resellerService;

    @RequestMapping(value = "/resellers",method = RequestMethod.GET)
    public List<Resellers> getAuditForAndroid(@RequestParam(value = "androidId",required = false) String androidId){
        return resellerService.getResellers();
    }

}
