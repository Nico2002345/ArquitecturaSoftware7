/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.models;

public class LoginRequestDTO {
    private String email;
    private String password;

    public LoginRequestDTO() {}

    public String getEmail() { return email; }
    public void setEmail(String email) { 
    this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { 
    this.password = password; }
}
