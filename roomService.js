import axiosInstance from "./axiosInstance";

// ✅ ADD ROOM
export const addRoom = async (data) => {
  const res = await axiosInstance.post("/rooms", data);
  return res.data; // response DTO
};

// ✅ GET ROOMS BY HOTEL
export const getRoomsByHotel = async (hotelId) => {
  const res = await axiosInstance.get(`/rooms/hotel/${hotelId}`);
  return res.data; // list of rooms
};

// ✅ DELETE ROOM
export const deleteRoom = async (id) => {
  const res = await axiosInstance.delete(`/rooms/${id}`);
  return res.data;
};