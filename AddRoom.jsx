import React,{useEffect,useState} from "react";
import { addRoom } from "../api/roomService";
import { getHotels } from "../api/hotelService";

const AddRoom=()=>{
  const [form,setForm]=useState({});
  const [hotels,setHotels]=useState([]);

  useEffect(()=>{
    getHotels().then(res=>setHotels(res.data.data));
  },[]);

  const submit=async(e)=>{
    e.preventDefault();
    await addRoom(form);
    alert("Room added");
  };

  return(
    <form onSubmit={submit}>
      <input placeholder="Type" onChange={(e)=>setForm({...form,type:e.target.value})}/>
      <input placeholder="Price" onChange={(e)=>setForm({...form,price:e.target.value})}/>
      <input placeholder="Capacity" onChange={(e)=>setForm({...form,capacity:e.target.value})}/>
      <input placeholder="Available" onChange={(e)=>setForm({...form,availableRooms:e.target.value})}/>

      <select onChange={(e)=>setForm({...form,hotelId:e.target.value})}>
        <option>Select Hotel</option>
        {hotels.map(h=>(
          <option key={h.id} value={h.id}>{h.name}</option>
        ))}
      </select>

      <button>Add Room</button>
    </form>
  );
};

export default AddRoom;