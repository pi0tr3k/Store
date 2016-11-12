package pl.edu.pw.javaee.store.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by chada on 07.11.2016.
 */

@Getter
@Setter
@Entity
public class Authorities {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int authoritiesId;
    private String username;
    private String authority;
}
