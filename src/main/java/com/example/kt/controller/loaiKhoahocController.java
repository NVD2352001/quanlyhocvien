package com.example.kt.controller;

import com.example.kt.model.loaiKhoahoc;
import com.example.kt.seviecs.loaiKhoahocSeviecs;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;

@RestController
public class loaiKhoahocController {
    @Autowired
    private loaiKhoahocSeviecs loaiKhoahocSeviecs;
    @RequestMapping(value = "/them1loaikhoahoc", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public loaiKhoahoc addloaikhoahoc(@RequestBody String lkh) {
        Gson gson=new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        loaiKhoahoc lkhs = gson.fromJson(lkh,loaiKhoahoc.class);
        return loaiKhoahocSeviecs.addloaikhoahoc(lkhs);
    }
    @RequestMapping(value = "/sualoaikhoahoc", method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
    public loaiKhoahoc remakeloaikhoahoc(@RequestBody String lkhsua){
        Gson gson=new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        loaiKhoahoc lkh=gson.fromJson(lkhsua,loaiKhoahoc.class);
        return loaiKhoahocSeviecs.remakeloaikhoahoc(lkh);
    }
    @RequestMapping(value = "/xoa1loaikhoahoc", method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE)
    public void removeloaikhoahoc(@RequestParam int id) {
         loaiKhoahocSeviecs.removeloaikhoahoc(id);
    }
}
