package com.example.kt.controller;

import com.example.kt.model.khoaHoc;
import com.example.kt.model.loaiBaiviet;
import com.example.kt.seviecs.loaiBaivietSeviecs;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

@RestController
public class loaiBaivietController {
    @Autowired
    private loaiBaivietSeviecs loaiBaivietSeviecs;
    @RequestMapping(value = "/themlbv", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public loaiBaiviet addlbv(@RequestBody String lbv) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        loaiBaiviet lbvs = gson.fromJson(lbv, loaiBaiviet.class);
        return loaiBaivietSeviecs.addlbv(lbvs);
    }

    @RequestMapping(value = "/sualbv", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public loaiBaiviet remakelbv(@RequestBody String lbvsua) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        loaiBaiviet lbv = gson.fromJson(lbvsua, loaiBaiviet.class);
        return loaiBaivietSeviecs.remakelbv(lbv);
    }

    @RequestMapping(value = "/xoalbv", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void removekhoahoc(@RequestParam int id) {
        loaiBaivietSeviecs.removelbv(id);
    }

    @RequestMapping(value = "/getlbv", method = RequestMethod.GET)
    public loaiBaiviet getkhoahoc(@RequestParam int id) {
        return loaiBaivietSeviecs.getlbv(id);
    }
    @RequestMapping(value = "/phantranglbv",method =RequestMethod.GET)
    public List<loaiBaiviet> getlbvByPage(@RequestParam int pageNumber,@RequestParam int pageSize){
        return loaiBaivietSeviecs.getlbvByPage(pageNumber,pageSize);
    }
}
