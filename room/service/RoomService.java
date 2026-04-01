package com.example.hcl_hack_bakend.room.service;
import com.example.hcl_hack_bakend.common.dto.request.RoomRequestDTO;
import com.example.hcl_hack_bakend.common.dto.response.RoomResponseDTO;
import com.example.hcl_hack_bakend.room.entity.Room;
import com.example.hcl_hack_bakend.room.repo.RoomRepository;
import com.example.hcl_hack_bakend.hotel.entity.Hotel;
import com.example.hcl_hack_bakend.hotel.repo.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private HotelRepository hotelRepository;
    public RoomResponseDTO addRoom(RoomRequestDTO dto) {
        Hotel hotel = hotelRepository.findById(dto.getHotelId())
                .orElseThrow(() -> new RuntimeException("Hotel not found"));
        Room room = new Room();
        room.setType(dto.getType());
        room.setPrice(dto.getPrice());
        room.setCapacity(dto.getCapacity());
        room.setAvailableRooms(dto.getAvailableRooms());
        room.setHotel(hotel);
        Room saved = roomRepository.save(room);
        return new RoomResponseDTO(
                saved.getId(),
                saved.getType(),
                saved.getPrice(),
                saved.getCapacity(),
                saved.getAvailableRooms(),
                hotel.getId()
        );
    }
    public List<RoomResponseDTO> getRoomsByHotel(Long hotelId) {
        return roomRepository.findByHotelId(hotelId)
                .stream()
                .map(r -> new RoomResponseDTO(
                        r.getId(),
                        r.getType(),
                        r.getPrice(),
                        r.getCapacity(),
                        r.getAvailableRooms(),
                        r.getHotel().getId()
                ))
                .collect(Collectors.toList());
    }
    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }
}