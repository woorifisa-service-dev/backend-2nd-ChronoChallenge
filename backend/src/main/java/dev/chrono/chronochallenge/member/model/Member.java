package dev.chrono.chronochallenge.member.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20,nullable = false)
    private String name;

    @Column(length = 20,nullable = false)
    private String password;

    @Column(nullable = false)
    @ColumnDefault("false")
    private boolean authority;

    @Column
    @ColumnDefault("0")
    private int point;

    @Column(name = "pass_ticket")
    @ColumnDefault("0")
    private int passTicket;

    @Builder
    public Member(Long id, String name, String password, boolean authority, int point, int passTicket) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.authority = authority;
        this.point = point;
        this.passTicket = passTicket;
    }
}


