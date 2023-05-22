package com.example.kt.controller;

import com.example.kt.model.khoaHoc;
import com.example.kt.model.tinhTranghoc;
import com.example.kt.seviecs.tinhTranghocSeviecs;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;

@RestController
public class tinhTranghocController {
    @Autowired
    private tinhTranghocSeviecs tthSeviecs;
    @RequestMapping(value = "/them1tinhtranghoc", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public tinhTranghoc addtinhtranghoc(@RequestBody String th) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        tinhTranghoc tths = gson.fromJson(th, tinhTranghoc.class);
        return tthSeviecs.addtinhtranghoc(tths);
    }

    @RequestMapping(value = "/suatinhtranghoc", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public tinhTranghoc remaketinhtranghoc(@RequestBody String thsua) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        tinhTranghoc tths = gson.fromJson(thsua, tinhTranghoc.class);
        return tthSeviecs.remaketinhtranghoc(tths);
    }

    @RequestMapping(value = "/xoatinhtranghoc", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void removetinhtranghoc(@RequestParam int id) {
        tthSeviecs.removetinhtranghoc(id);
    }

    @RequestMapping(value = "/gettinhtranghoc", method = RequestMethod.GET)
    public tinhTranghoc gettinhtranghoc(@RequestParam int id) {
        return tthSeviecs.gettinhtranghoc(id);
    }
}
