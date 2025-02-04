package com.korit.springboot_study.dto.request.study;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Schema(description = "학생정보 조회 학습 DTO")
public class ReqStudentDto {
    @Schema(description = "학생 이름", example = "김준일", required = true)
    private String name;
    @Schema(description = "학생 나이", example = "32", required = true)
    private int age;
}
