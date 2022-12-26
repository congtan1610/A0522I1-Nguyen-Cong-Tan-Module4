package com.codegym.service;

import com.codegym.model.ContactAddress;
import com.codegym.model.Symptom;
import com.codegym.model.UserInf;

import java.util.ArrayList;
import java.util.List;

public interface IMedicalDeclarationService {
    UserInf findUserInf();
    ContactAddress findContactAddress();
    Symptom findSymptom();
    void save(UserInf  userInf,ContactAddress contactAddress,Symptom symptom);
}
