package com.example.kt.controller;

import com.example.kt.model.khoaHoc;
import com.example.kt.model.quyenHan;
import com.example.kt.seviecs.quyenHanSeviecs;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

@RestController
public class quyenHanController {
    @Autowired
    private quyenHanSeviecs quyenHanSeviecs;
    @RequestMapping(value = "/themquyenhan", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public quyenHan addkhoahoc(@RequestBody String qh) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        quyenHan khs = gson.fromJson(qh, quyenHan.class);
        return quyenHanSeviecs.addquyenhan(khs);
    }

    @RequestMapping(value = "/suaquyenhan", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public quyenHan remakeloaikhoahoc(@RequestBody String qhsua) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        quyenHan qh = gson.fromJson(qhsua, quyenHan.class);
        return quyenHanSeviecs.remakekhoahoc(qh);
    }

    @RequestMapping(value = "/xoaquyenhan", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void removequyenhan(@RequestParam int id) {
        quyenHanSeviecs.removequyenhan(id);
    }

    @RequestMapping(value = "/getquyenhan", method = RequestMethod.GET)
    public quyenHan getquyenhan(@RequestParam int id) {
        return quyenHanSeviecs.getquyenhan(id);
    }
    @RequestMapping(value = "/phantrangquyenhan",method =RequestMethod.GET)
    public List<quyenHan> getquyenhanByPage(@RequestParam int pageNumber, @RequestParam int pageSize){
        return quyenHanSeviecs.getquyenhanByPage(pageNumber,pageSize);
    }
}
