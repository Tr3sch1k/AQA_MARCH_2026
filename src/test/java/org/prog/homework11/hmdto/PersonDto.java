package org.prog.homework11.hmdto;

import lombok.Data;

@Data
public class PersonDto {
    private String gender;
    private String nat;
    private NameDto name;
    private LocationDto location;
}
