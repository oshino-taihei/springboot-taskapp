package com.example.web.form;

import com.example.persistence.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class TaskForm {
    private Integer id;

    @NotBlank
    @Length(min = 1, max = 32)
    private String title;

    @NotBlank
    @Length(min = 1, max = 1024)
    private String body;

    private Integer status;

    @DateTimeFormat(pattern = "uuuu-MM-dd")
    private LocalDate createdOn;

    /**
     * フィールドがすべて空（null）のFormインスタンスを生成する
     */
    public static TaskForm createEmptyForm() {
        return new TaskForm(null, null, null, null, null);
    }

    /**
     * Taskエンティティに変換する
     */
    public Task convertToEntity() {
        return new Task(id, title, body, status, createdOn);
    }
}
