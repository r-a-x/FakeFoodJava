package io.mauth.fakefood.repo;

import io.mauth.fakefood.model.SpooledMail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by rahulb on 20/12/17.
 */
public interface SpooledMailsRepo extends JpaRepository<SpooledMail,Long> {
    SpooledMail findByMessageId(String messageId);
}
