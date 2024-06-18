package com.montrackii.fixmontrack.user.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;


@Table(name = "users", schema = "montrack")
@Entity
@Getter
@Setter
public class Users {

   @Id
   @Column(name = "id", nullable = false)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "montrack.users_id_gen")
   @SequenceGenerator(name = "montrack.users_id_gen", sequenceName = "montrack.users_id_seq", allocationSize = 1)
    private Long Id;

   @NotNull
   @Column(name = "email", nullable = false, length = 100)
    private String email;

   @Column(name = "username", nullable = false, length = 100)
   private String username;

   @Column(name = "password", nullable = false, length = 100)
    private String password;

   @Column(name = "avatar")
    private String avatar;

   @Column(name = "quote")
    private String quote;


   @Column(name = "currency", nullable = false)
    private int currency;

   @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

   @Column(name = "created_at", nullable = false)
    private Instant createdAt;

   @Column(name = "deleted_at")
    private Instant deletedAt;

    @PrePersist
    public void prePersist() {
     this.createdAt = Instant.now();
     this.updatedAt = Instant.now();
    }

    @PreUpdate
    public void preUpdate() {
     this.updatedAt = Instant.now();
    }

    @PreRemove
    public void preRemove() {
     this.deletedAt = Instant.now();
    }


}
