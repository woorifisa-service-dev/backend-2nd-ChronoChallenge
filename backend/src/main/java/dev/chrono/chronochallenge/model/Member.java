package dev.chrono.chronochallenge.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
@Table
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private int password;

    @Column
    private boolean authority;

    @Column
    private int point;

    @Column(name = "pass_ticket")
    private int passTicket;

    @Builder
    public Member(Long id, String name, int password, boolean authority, int point, int passTicket) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.authority = authority;
        this.point = point;
        this.passTicket = passTicket;
    }
}


