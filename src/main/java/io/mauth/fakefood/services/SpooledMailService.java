package io.mauth.fakefood.services;


import io.mauth.fakefood.model.Audit;

import java.util.List;

public interface SpooledMailService {

    List<Audit> getUnsentMails();

    List<Audit> getFailedMails();
//    List<SpooledMail> getUnsentAndFailedMails();
    void sendUnsentMails();
}
