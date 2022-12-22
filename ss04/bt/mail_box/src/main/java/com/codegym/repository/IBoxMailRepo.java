package com.codegym.repository;

import com.codegym.model.BoxMail;

public interface IBoxMailRepo {
    BoxMail findAll();
    BoxMail save( BoxMail boxMail);
}
