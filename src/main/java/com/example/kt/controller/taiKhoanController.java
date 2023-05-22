package com.example.kt.controller;

import com.example.kt.model.khoaHoc;
import com.example.kt.model.taiKhoan;
import com.example.kt.seviecs.taiKhoanSeviecs;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

@RestController
public class taiKhoanController {
    @Autowired
    private taiKhoanSeviecs taiKhoanSeviecs;
    @RequestMapping(value = "/themtk", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public taiKhoan addkhoahoc(@RequestBody String tk) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        taiKhoan tks = gson.fromJson(tk, taiKhoan.class);
        return taiKhoanSeviecs.addtaikhoan(tks);
    }

    @RequestMapping(value = "/suatk", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public taiKhoan remakeloaikhoahoc(@RequestBody String tksua) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        taiKhoan tk = gson.fromJson(tksua,taiKhoan.class);
        return taiKhoanSeviecs.remaketaikhoan(tk);
    }

    @RequestMapping(value = "/xoatk", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void removetk(@RequestParam int id) {
        taiKhoanSeviecs.removetaikhoan(id);
    }

    @RequestMapping(value = "/gettk", method = RequestMethod.GET)
    public taiKhoan gettaikhoan(@RequestParam int id) {
        return taiKhoanSeviecs.gettaikhoan(id);
    }
    @RequestMapping(value = "/timtk", method = RequestMethod.GET)
    public List<taiKhoan> timkiem(@RequestParam String tk){
        return taiKhoanSeviecs.timkiemtk(tk);
    }
    @RequestMapping(value = "/phantrangtk",method =RequestMethod.GET)
    public List<taiKhoan> gettaikhoanByPage(@RequestParam int pageNumber,@RequestParam int pageSize){
        return taiKhoanSeviecs.gettaikhoanByPage(pageNumber,pageSize);
    }
}
