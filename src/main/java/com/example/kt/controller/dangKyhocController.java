package com.example.kt.controller;

import com.example.kt.model.dangKyhoc;
import com.example.kt.model.hocVien;
import com.example.kt.model.khoaHoc;
import com.example.kt.seviecs.dangKyhocSeviecs;
import com.google.gson.*;
import net.bytebuddy.utility.nullability.AlwaysNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

@RestController
public class dangKyhocController {
    @Autowired
    private dangKyhocSeviecs dangKyhocSeviecs;
    @RequestMapping(value = "/themdk", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public dangKyhoc adddk(@RequestBody String dk) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        dangKyhoc dks = gson.fromJson(dk, dangKyhoc.class);
        return dangKyhocSeviecs.adddk(dks);
    }

    @RequestMapping(value = "/suadk", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public dangKyhoc remakedk(@RequestBody String dksua) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        dangKyhoc dk = gson.fromJson(dksua, dangKyhoc.class);
        return dangKyhocSeviecs.remakedk(dk);
    }

    @RequestMapping(value = "/xoadk", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void removedk(@RequestParam int id) {
        dangKyhocSeviecs.removdk(id);
    }

    @RequestMapping(value = "/gedk", method = RequestMethod.GET)
    public dangKyhoc getdk(@RequestParam int id) {
        return dangKyhocSeviecs.getdk(id);
    }
    @RequestMapping(value = "/phantrangdangky", method = RequestMethod.GET)
    public List<dangKyhoc> getdangkyByPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return dangKyhocSeviecs.getdangkyByPage(page, size);
    }
}
