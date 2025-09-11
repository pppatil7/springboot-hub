package com.practice.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private Long id;

    @NotBlank(message = "name of the employee can not be blank")
    @Size(min = 3, max = 10, message = "the name size of employee between 3 to 10")
    private String name;

    @NotBlank(message = "email of the employee cannot be blank")
    @Email(message = "Email should be a valid email")
    private String email;

    @NotNull(message = "age of the employee cannot be blank")
    @Max(value = 80, message = "age cannot be greater than 80")
    @Min(value = 18, message = "age cannot be less than 18")
    private Integer age;

    @NotBlank(message = "role of the employee can not be blank")
    @Pattern(regexp = "^(ADMIN|USER)$")
    private String role; //ADMIN, USER

    @NotNull(message = "salary of the employee cannot be null")
    @Positive(message = "salary of the employee should be positive")
    @Digits(integer = 6, fraction = 2, message = "salary in form of XXXXX.YY")
    @DecimalMax(value = "100000.99")
    @DecimalMin(value = "100.50")
    private Double salary;

    @PastOrPresent(message = "DateOfJoining of employee not be in future")
    private LocalDate dateOfJoining;

    @AssertTrue(message = "employee should be active")
    private Boolean isActive;


}
