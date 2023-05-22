package com.example.kt.controller;

import com.example.kt.model.khoaHoc;
import com.example.kt.seviecs.khoaHocSeviecs;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

@RestController
public class khoaHocController {
    @Autowired
    private khoaHocSeviecs khoaHocSeviecs;

    @RequestMapping(value = "/them1khoahoc", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public khoaHoc addkhoahoc(@RequestBody String kh) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        khoaHoc khs = gson.fromJson(kh, khoaHoc.class);
        return khoaHocSeviecs.addkhoahoc(khs);
    }

    @RequestMapping(value = "/suakhoahoc", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public khoaHoc remakeloaikhoahoc(@RequestBody String khsua) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        khoaHoc kh = gson.fromJson(khsua, khoaHoc.class);
        return khoaHocSeviecs.remakekhoahoc(kh);
    }

    @RequestMapping(value = "/xoa1khoahoc", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void removekhoahoc(@RequestParam int id) {
        khoaHocSeviecs.removekhoahoc(id);
    }

    @RequestMapping(value = "/getkhoahoc", method = RequestMethod.GET)
    public khoaHoc getkhoahoc(@RequestParam int id) {
        return khoaHocSeviecs.getkhoahoc(id);
    }
    @RequestMapping(value = "/timkhoahoc", method = RequestMethod.GET)
    public List<khoaHoc> timkiem(@RequestParam String hoten){
        return khoaHocSeviecs.timkiem(hoten);
    }
    @RequestMapping(value = "/phantrang",method =RequestMethod.GET)
    public List<khoaHoc> getKhoaHocByPage(@RequestParam int pageNumber,@RequestParam int pageSize){
        return khoaHocSeviecs.getKhoaHocByPage(pageNumber,pageSize);
    }
//    @RequestMapping(value = "/phantrang", method = RequestMethod.GET)
//    public List<khoaHoc> getAllKhoaHocByPage(
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "10") int size) {
//        return khoaHocSeviecs.getKhoaHocByPage(page, size);
//    }
}

