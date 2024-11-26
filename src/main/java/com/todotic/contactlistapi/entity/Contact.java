package com.todotic.contactlistapi.entity;

import jakarta.persistence.Column;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity

@RequiredArgsConstructor
@NoArgsConstructor

@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @NonNull
    private String name;
    
    @NonNull
    private String email;
    
    
    @NonNull
    @Column(name = "create_at")
    private LocalDateTime createdAt;
    
    /*@PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }*/
}
