package com.codegym.service;

import com.codegym.model.BoxMail;
import com.codegym.repository.BoxMailRepository;

public class BoxMailService implements IBoxMailService{
    private BoxMailRepository boxMailRepo=new BoxMailRepository();
    @Override
    public BoxMail findAll() {
        return boxMailRepo.findAll();
    }

    @Override
    public BoxMail save(BoxMail boxMail) {
        return boxMailRepo.save(boxMail);
    }
}
