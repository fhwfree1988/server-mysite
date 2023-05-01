package com.project.site.Modules.TestServices;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class MyProductDto {
    private Long id;
    private Long productNo;
    private String productName;
}
