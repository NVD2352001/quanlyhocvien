package com.example.kt.controller;

import com.example.kt.model.baiViet;
import com.example.kt.model.chuDe;
import com.example.kt.seviecs.chuDeSeviecs;
import com.google.gson.*;
import org.apache.tomcat.util.buf.AbstractChunk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

@RestController
public class chuDeController {
    @Autowired
    private chuDeSeviecs chuDeSeviecs;
    @RequestMapping(value = "/themcd", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public chuDe addbv(@RequestBody String cd) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        chuDe cds = gson.fromJson(cd, chuDe.class);
        return chuDeSeviecs.addcd(cds);
    }

    @RequestMapping(value = "/suacd", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public chuDe remakeloaibv(@RequestBody String cdsua) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        chuDe cd = gson.fromJson(cdsua, chuDe.class);
        return chuDeSeviecs.remakecd(cd);
    }

    @RequestMapping(value = "/xoacd", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void removebv(@RequestParam int id) {
        chuDeSeviecs.removecd(id);

    }

    @RequestMapping(value = "/getcd", method = RequestMethod.GET)
    public chuDe getkhoahoc(@RequestParam int id) {
        return chuDeSeviecs.getcd(id);
    }

    @RequestMapping(value = "/phantrangcd",method =RequestMethod.GET)
    public List<chuDe> getbaivietByPage(@RequestParam int pageNumber, @RequestParam int pageSize){
        return chuDeSeviecs.getcdByPage(pageNumber,pageSize);}
}
