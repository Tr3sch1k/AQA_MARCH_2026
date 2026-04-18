package org.prog.homework11.hmdto;

import lombok.Data;

import java.util.List;

@Data
public class ResultDto {
    private List<PersonDto> results;
}
