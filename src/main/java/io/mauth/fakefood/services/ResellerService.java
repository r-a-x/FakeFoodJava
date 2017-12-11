package io.mauth.fakefood.services;

import io.mauth.fakefood.model.Resellers;
import io.mauth.fakefood.repo.ResellersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rahulb on 11/12/17.
 */
@Service
public class ResellerService {

    @Autowired
    private ResellersRepo resellersRepo;

    public List<Resellers> getResellers() {
        return resellersRepo.findAll();
    }
}
