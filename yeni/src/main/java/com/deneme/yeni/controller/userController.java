/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deneme.yeni.controller;


import com.deneme.yeni.dto.requestDto;
import com.deneme.yeni.entity.user;
import java.sql.SQLException;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import kullaniciGoster.kullaniciEkle;


@RestController
@RequestMapping("user")
public class userController {
    
    private static int idGen = 110;

    private List<user> user = new ArrayList<>();
    private Random random = new Random();
    
    @PostMapping("/dda")
    @CrossOrigin(origins = "http://127.0.0.1:5502")
    @ResponseBody
    public String kullaniciEkle(@RequestBody requestDto dto) throws SQLException { //Parametre olarak dene
        idGen++;
        user temp = new user();
        temp.setusername(dto.getName());
        temp.setuserpass(dto.getPassword());
        temp.setiduser(idGen);
        kullaniciEkle sinif = new kullaniciEkle();
        int status = sinif.kullaniciEkle(
                temp.getiduser(),
                temp.getusername(),
                temp.getuserpass()
        );
        return status == 1 ? "Kayit basarili" : "Kayit basarisiz";
    }
    
        @GetMapping("/{randomkullaniciID}")
    public Long randomkullaniciID(@PathVariable(name = "id") Long id) {
        return random.nextLong();
    }
    
    
    
}
