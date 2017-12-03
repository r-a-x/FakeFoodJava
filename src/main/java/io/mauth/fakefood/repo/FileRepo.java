package io.mauth.fakefood.repo;

import io.mauth.fakefood.model.File;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by rahulb on 3/12/17.
 */
public interface FileRepo extends JpaRepository<File,Long>{
    File findById(Long id);

    File findByName(String name);

    File findByPath(String path);
}
