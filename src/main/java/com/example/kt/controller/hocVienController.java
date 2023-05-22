package com.example.kt.controller;

import com.example.kt.model.hocVien;
import com.example.kt.model.khoaHoc;
import com.example.kt.seviecs.hocVienSeviecs;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

@RestController
public class hocVienController {
    @Autowired
    private hocVienSeviecs hocVienSeviecs;
    @RequestMapping(value = "/them1hocvien", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public hocVien addhocvien(@RequestBody String hv) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        hocVien hvs = gson.fromJson(hv, hocVien.class);
        return hocVienSeviecs.addhocvien(hvs);
    }
    @RequestMapping(value = "/suahocvien", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public hocVien remakehocvien(@RequestBody String hvsua) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        hocVien hv = gson.fromJson(hvsua, hocVien.class);
        return hocVienSeviecs.remakehocvien(hv);
    }
    @RequestMapping(value = "/xoahocvien", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void removekhoahoc(@RequestParam int id) {
        hocVienSeviecs.removhocvien(id);
    }
    @RequestMapping(value = "/gethocvien", method = RequestMethod.GET)
    public hocVien gethocvien(@RequestParam int id) {
        return hocVienSeviecs.gethocvien(id);
    }
    @RequestMapping(value = "/timhocvien", method = RequestMethod.GET)
    public List<hocVien> timkiem( @RequestParam String ten, String email){
        return hocVienSeviecs.timkiem(ten,email);
    }
    @RequestMapping(value = "/phantranghocvien", method = RequestMethod.GET)
    public List<hocVien> getAllhocvienByPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return hocVienSeviecs.gethocvienByPage(page, size);
    }
    @RequestMapping(value = "/macdinh", method = RequestMethod.GET)
    public void macdinh(@RequestParam String sdt, @RequestParam String email){
        hocVienSeviecs.macdinh(sdt,email);
    }
}
