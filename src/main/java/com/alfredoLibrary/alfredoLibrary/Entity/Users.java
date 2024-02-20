package com.alfredoLibrary.alfredoLibrary.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table (name = "Users")
public class Users {
    
}
