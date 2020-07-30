package qlhoinghi.entity;
// Generated Jul 9, 2020 3:16:50 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * TaiKhoan generated by hbm2java
 */
public class TaiKhoan  implements java.io.Serializable {


     private Integer id;
     private String ten;
     private String username;
     private String pass;
     private String email;
     private boolean truyCap;
     private Set yeuCaus = new HashSet(0);

    public TaiKhoan() {
    }

	
    public TaiKhoan(String ten, String username, String pass, String email, boolean truyCap) {
        this.ten = ten;
        this.username = username;
        this.pass = pass;
        this.email = email;
        this.truyCap = truyCap;
    }
    public TaiKhoan(String ten, String username, String pass, String email, boolean truyCap, Set yeuCaus) {
       this.ten = ten;
       this.username = username;
       this.pass = pass;
       this.email = email;
       this.truyCap = truyCap;
       this.yeuCaus = yeuCaus;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTen() {
        return this.ten;
    }
    
    public void setTen(String ten) {
        this.ten = ten;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPass() {
        return this.pass;
    }
    
    public void setPass(String pass) {
        this.pass = pass;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public boolean isTruyCap() {
        return this.truyCap;
    }
    
    public void setTruyCap(boolean truyCap) {
        this.truyCap = truyCap;
    }
    public Set getYeuCaus() {
        return this.yeuCaus;
    }
    
    public void setYeuCaus(Set yeuCaus) {
        this.yeuCaus = yeuCaus;
    }




}


