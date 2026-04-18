package org.prog.homework11.hmdto;
import lombok.Data;

@Data
public class LocationDto {
    private StreetDto street;
    private String city;
    private String state;
    private String country;
    private String postcode;
}
