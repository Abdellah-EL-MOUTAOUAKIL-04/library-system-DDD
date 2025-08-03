package com.library.domain.member;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Member {
    @Id
    private String id;
    private String name;
    private String email;

    public Member(){

    }

    public Member(String id,String name,String email){
        Objects.requireNonNull(id,"Member ID cannot be null");
        Objects.requireNonNull(name,"Name cannot be null");
        Objects.requireNonNull(email,"Email cannot be null");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public boolean equals(Object o){
        if(o==this) return true;
        if(o==null || getClass()!=o.getClass()) return false;
        Member that=(Member) o;
        return Objects.equals(id,that.id) && Objects.equals(name,that.name) && Objects.equals(email,that.email);
    }
    @Override
    public int hashCode(){
        return Objects.hash(id,name,email);
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
