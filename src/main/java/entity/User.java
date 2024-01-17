package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.namespace.QName;

@Getter
@Setter
@Entity
public class User {
    @Id
    String UserID;
    String name;
    String email;
    String password;
}
