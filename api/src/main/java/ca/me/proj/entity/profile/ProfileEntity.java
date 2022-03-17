package ca.me.proj.entity.profile;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;


@Data
@Entity
@Table(name = "PROFILE")
public class ProfileEntity {
    
    @Id
    @NotNull
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Column(name = "username")
    private String username;

    @NotNull
    @Column(name = "password")
    private String password;
    @NotNull
    @Column(name = "firstname")
    private String firstName;
    
    @NotNull
    @Column(name = "middlename")
    private String middleName;

    @NotNull
    @Column(name = "lastname")
    private String lastName;

    @NotNull
    @Column(name = "dob")
    private Date DOB;

    public ProfileEntity(){}
    public ProfileEntity (
        long id,
        String firstname,
        String middlename,
        String lastname,
        Date dob
    ) {
        this.id = id;
        this.firstName = firstname;
        this.middleName = middlename;
        this.lastName = lastname;
        this.DOB=dob;     
    }
    
}
