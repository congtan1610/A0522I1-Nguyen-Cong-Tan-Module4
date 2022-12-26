package com.codegym.repository;

import com.codegym.model.BoxMail;

public class BoxMailRepository implements IBoxMailRepository {
    private static BoxMail[] boxMails={new BoxMail()};

    @Override
    public BoxMail findAll() {
        return boxMails[0];
    }

    @Override
    public BoxMail save(BoxMail newBoxMail) {
        boxMails[0]=newBoxMail;
        return boxMails[0];
    }
}
