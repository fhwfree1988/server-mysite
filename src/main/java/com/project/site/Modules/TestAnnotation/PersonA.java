package com.project.site.Modules.TestAnnotation;

import com.project.site.base.annotations.jsonserializable.Init;
import com.project.site.base.annotations.jsonserializable.JsonElement;
import com.project.site.base.annotations.jsonserializable.JsonSerializable;
import lombok.AllArgsConstructor;

//https://www.baeldung.com/java-custom-annotation
//we’re going to see how to take advantage of them by using Java’s Reflection API.
@JsonSerializable
@AllArgsConstructor
public class PersonA {

    @JsonElement
    private String firstName;

    @JsonElement
    private String lastName;

    @JsonElement(key = "personAge")
    private String age;

    private String address;

    @Init
    private void initNames() {
        this.firstName = this.firstName.substring(0, 1).toUpperCase()
                + this.firstName.substring(1);
        this.lastName = this.lastName.substring(0, 1).toUpperCase()
                + this.lastName.substring(1);
    }

    // Standard getters and setters
}