package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberFormDTO {
    
    private Long id; 
    
    @NotBlank(message = "아이디는 필수 입력 항목입니다.")
    private String nick;
    
    @NotBlank(message = "이메일은 필수 입력 항목입니다.")
    @Email(message = "올바른 이메일 형식이 아닙니다.")
    private String email;
    
    @NotBlank(message = "사용자 이름은 필수 입력 항목입니다.")
    @Size(min = 1, max = 10, message = "사용자 이름은 1자에서 10자 사이여야 합니다.")
    private String username;
    
    @NotBlank(message = "비밀번호는 필수 입력 항목입니다.")
    @Pattern(
        regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{1,15}$",
        message = "비밀번호는 대소문자, 숫자, 특수문자를 포함하며 15자 이하이어야 합니다."
    )
    private String password;
    
    @NotBlank(message = "비밀번호 확인은 필수 입력 항목입니다.")
    private String passwordConfirm;
    
    @NotBlank(message = "전화번호는 필수 입력 항목입니다.")
    @Pattern(regexp = "^\\d{3}-\\d{3,4}-\\d{4}$", message = "전화번호 형식이 올바르지 않습니다. 예: 010-1234-5678")
    private String phonenumber;

}
