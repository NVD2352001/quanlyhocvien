package com.example.kt.controller;

import com.example.kt.model.baiViet;
import com.example.kt.model.khoaHoc;
import com.example.kt.seviecs.baiVietSeviecs;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

@RestController
public class baiVietController {
    @Autowired
    private baiVietSeviecs baiVietSeviecs;
    @RequestMapping(value = "/thembv", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public baiViet addbv(@RequestBody String bv) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        baiViet bvs = gson.fromJson(bv, baiViet.class);
        return baiVietSeviecs.addbaiviet(bvs);
    }

    @RequestMapping(value = "/suabv", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public baiViet remakeloaibv(@RequestBody String bvsua) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
       baiViet bv = gson.fromJson(bvsua, baiViet.class);
        return baiVietSeviecs.remakebaiviet(bv);
    }

    @RequestMapping(value = "/xoabv", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void removebv(@RequestParam int id) {
        baiVietSeviecs.removebaiviet(id);
    }

    @RequestMapping(value = "/getbv", method = RequestMethod.GET)
    public baiViet getkhoahoc(@RequestParam int id) {
        return baiVietSeviecs.getbaiviet(id);
    }
    @RequestMapping(value = "/timbv", method = RequestMethod.GET)
    public List<baiViet> timkiem(@RequestParam String tenbv){
        return baiVietSeviecs.timkiem(tenbv);
    }
    @RequestMapping(value = "/phantrangbv",method =RequestMethod.GET)
    public List<baiViet> getbaivietByPage(@RequestParam int pageNumber, @RequestParam int pageSize){
        return baiVietSeviecs.getbaivietByPage(pageNumber,pageSize);
    }
}
