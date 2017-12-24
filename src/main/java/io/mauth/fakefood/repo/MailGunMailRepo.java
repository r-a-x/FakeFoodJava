package io.mauth.fakefood.repo;

import io.mauth.fakefood.model.MailGunMail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by rahulb on 23/12/17.
 */
public interface MailGunMailRepo extends JpaRepository<MailGunMail,Long> {
}
