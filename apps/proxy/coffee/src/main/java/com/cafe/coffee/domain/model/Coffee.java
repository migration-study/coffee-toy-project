package com.cafe.coffee.domain.model;

import com.cafe.coffee.domain.vo.Creator;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private Creator creator;

    @CreationTimestamp
    private LocalDateTime createAt;

    @UpdateTimestamp
    private LocalDateTime updateAt;

    public Coffee(String title, Creator creator) {
        this.title = title;
        this.creator = creator;
    }

    public static Coffee createCoffee(String title, Long id, String userId) {
        checkTitle(title);

        Creator creator = new Creator(id, userId);
        return new Coffee(title, creator);
    }

    public static void checkTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("커피 이름을 입력하세요.");
        }
    }
}
