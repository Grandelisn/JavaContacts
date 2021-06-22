package com.example.javacontacts.dto;

import com.example.javacontacts.models.Name;
import com.example.javacontacts.models.Phone;

public class CallListDto {

    private Name name;
    private Phone phone;

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}
