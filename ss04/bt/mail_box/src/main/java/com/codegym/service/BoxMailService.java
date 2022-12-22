package com.codegym.service;

import com.codegym.model.BoxMail;
import com.codegym.repository.BoxMailRepo;

public class BoxMailService implements IBoxMailService{
    private BoxMailRepo boxMailRepo=new BoxMailRepo();
    @Override
    public BoxMail findAll() {
        return boxMailRepo.findAll();
    }

    @Override
    public BoxMail save(BoxMail boxMail) {
        return boxMailRepo.save(boxMail);
    }
}
