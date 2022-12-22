package com.codegym.service;

import com.codegym.model.BoxMail;

public interface IBoxMailService {
    BoxMail findAll();
    BoxMail save( BoxMail boxMail);
}
