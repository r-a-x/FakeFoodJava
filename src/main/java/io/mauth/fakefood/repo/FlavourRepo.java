package io.mauth.fakefood.repo;

import io.mauth.fakefood.model.Flavours;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by rahulb on 12/11/17.
 */
public interface FlavourRepo extends JpaRepository<Flavours,Long> {

    List<Flavours> findAll();
    Flavours findById(Long id);

    Flavours findByFlavour(String flavour);
}
