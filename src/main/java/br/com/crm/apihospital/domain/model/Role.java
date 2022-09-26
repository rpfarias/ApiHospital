package br.com.crm.apihospital.domain.model;

import br.com.crm.apihospital.enumeration.RoleName;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity(name = "tbl_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleName name;

    @ToString.Exclude
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<Users> users;
}
