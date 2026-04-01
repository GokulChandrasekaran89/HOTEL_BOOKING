package com.example.hcl_hack_bakend.room.controller;
import com.example.hcl_hack_bakend.common.dto.request.RoomRequestDTO;
import com.example.hcl_hack_bakend.common.dto.response.RoomResponseDTO;
import com.example.hcl_hack_bakend.room.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/rooms")
@CrossOrigin("*")
public class RoomController {
    @Autowired
    private RoomService roomService;
    @PostMapping
    public RoomResponseDTO addRoom(@RequestBody RoomRequestDTO dto) {
        return roomService.addRoom(dto);
    }
    @GetMapping("/hotel/{hotelId}")
    public List<RoomResponseDTO> getRooms(@PathVariable Long hotelId) {
        return roomService.getRoomsByHotel(hotelId);
    }
    @DeleteMapping("/{id}")
    public String deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
        return "Room deleted successfully";
    }
}