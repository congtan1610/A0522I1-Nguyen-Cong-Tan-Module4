package com.codegym.service;

import com.codegym.model.ContactAddress;
import com.codegym.model.Symptom;
import com.codegym.model.UserInf;

public class MedicalDeclarationService implements IMedicalDeclarationService {
    private UserInf[] list1={new UserInf()};
    private ContactAddress[] list2={new ContactAddress()};
    private Symptom[] list3= {new Symptom()};

    @Override
    public UserInf findUserInf() {
        return list1[0];
    }

    @Override
    public ContactAddress findContactAddress() {
        return list2[0];
    }

    @Override
    public Symptom findSymptom() {
        return list3[0];
    }

    @Override
    public void save(UserInf userInf, ContactAddress contactAddress, Symptom symptom) {
        list1[0]=userInf;
        list2[0]=contactAddress;
        list3[0]=symptom;
    }
}
