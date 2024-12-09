package com.cafe.member.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userId;
    private String password;
    private String email;
    private String name;
    private LocalDate createDate;
    private boolean isManager;

    public static Member createMember(String userId, String password, String email, String name, boolean isManager) {
        checkUserId(userId);
        checkPassword(password);

        Member member = new Member();
        member.setUserId(userId);
        member.setPassword(password);
        member.setEmail(email);
        member.setName(name);
        member.setCreateDate(LocalDate.now());
        member.setManager(isManager);

        System.out.println(member);

        return member;
    }

    public static void checkUserId(String userId) {
        if (userId.isEmpty()) {
            throw new IllegalArgumentException("아이디를 입력하세요.");
        }

        if (userId.length() > 12) {
            throw new IllegalArgumentException("아이디는 12자 까지 입력할 수 있습니다.");
        }
    }

    public static void checkPassword(String password) {
        if (password.isEmpty()) {
            throw new IllegalArgumentException("비밀번호를 입력하세요.");
        }
    }

    public boolean matchUserId(String targetUserId) {
        return userId.equals(targetUserId);
    }

    public boolean matchPassword(String targetPassword) {
        return password.equals(targetPassword);
    }

    public boolean equalsNameAndEmail(Member member) {
        if (Objects.isNull(member)) {
            return false;
        }

        return name.equals(member.name) && email.equals(member.email);
    }

    public boolean isManager() {
        return isManager;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", createDate='" + createDate + '\'' +
                ", isManager='" + isManager + '\'' +
                '}';
    }
}
