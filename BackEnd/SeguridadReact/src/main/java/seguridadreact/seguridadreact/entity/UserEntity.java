package seguridadreact.seguridadreact.entity;

import jakarta.persistence.*;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import lombok.*;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String userId;
private String name;
@Column(unique = true)
private String email;
private String password;
private String verifyOtp;
private Boolean isAccountVerified;
private Long verifyOtpExpireAt;
private String resetOtp;
private Long resetOtpExpireAt;

//Sirbe para saber hora exacta de la creacion del ususario
@CreationTimestamp
@Column(updatable = false)
    private Timestamp createdAt;
    //Sirbe para saber hora exacta de la actualizacion del ususario
@UpdateTimestamp
private Timestamp updatedAt;



}
