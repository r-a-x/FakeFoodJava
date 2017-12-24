package io.mauth.fakefood.services;


import io.mauth.fakefood.model.Audit;

import java.util.List;

public interface SpooledMailService {

    List<Audit> getUnsentMails();

    List<Audit> getFailedMails();

    void sendUnsentMails();
}
//curl -s --user 'api:pubkey-c73aef0fdf5b57da29e7d5e13ad0a9aa' \
//        https://api.mailgun.net/v3/mg.mauth.io/messages \
//        -F from='Excited User <mailgun@mg.mauth.io>' \
//        -F to=bansal.rahul14@gmail.com \
//        -F subject='Hello' \
//        -F text='Testing some Mailgun awesomness!'