package uz.pdp.task10_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.task10_1.payload.RoomDto;
import uz.pdp.task10_1.service.RoomService;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/getRoomsByHotelId/{hotel_id}")
    public HttpEntity<?> getRoomsByHotelId(
            @PathVariable Long hotel_id,
            @RequestParam("page") Integer page,
            @RequestParam("size") Integer size,
            @RequestParam(value = "all",defaultValue = "true") boolean all
    ){
        return ResponseEntity.ok(roomService.getAllRoomsByHotelId(hotel_id,page,size,all));
    }

    @GetMapping("/delete/{id}")
    public HttpEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.ok(roomService.remove(id));
    }

    @PostMapping("/saveOrDelete")
    public HttpEntity<?> saveOrEdit(@RequestBody RoomDto dto){
        return ResponseEntity.ok(roomService.saveOrEdit(dto));
    }

    @GetMapping("/all")
    public HttpEntity<?> getAllRooms(){
        return ResponseEntity.ok(roomService.getAllRooms());
    }

    @GetMapping("/getRoomById/{id}")
    public HttpEntity<?> getRoomById(@PathVariable Long id){
        return ResponseEntity.ok(roomService.getRoomById(id));
    }

}
