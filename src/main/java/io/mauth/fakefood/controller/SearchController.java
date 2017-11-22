package io.mauth.fakefood.controller;

import io.mauth.fakefood.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rahulb on 4/11/17.
 */
// Based on the keyword, search will happen
//    company product flavours

@RestController
public class SearchController {

    @Autowired
    private SearchService searchService;

//    @RequestMapping(value = "/search",method = RequestMethod.POST)
//    public List<> search(@RequestBody ){
//
//    }
}
