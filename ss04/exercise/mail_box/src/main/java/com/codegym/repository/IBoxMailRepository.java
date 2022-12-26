package com.codegym.repository;

import com.codegym.model.BoxMail;

public interface IBoxMailRepository {
    BoxMail findAll();
    BoxMail save( BoxMail boxMail);
}
