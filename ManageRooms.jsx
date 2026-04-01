import React,{useState} from "react";
import { getRoomsByHotel, deleteRoom } from "../api/roomService";

const ManageRooms=()=>{
  const [id,setId]=useState("");
  const [rooms,setRooms]=useState([]);

  const load=async()=>{
    const res=await getRoomsByHotel(id);
    setRooms(res.data);
  };

  return(
    <div>
      <input placeholder="Hotel ID" onChange={(e)=>setId(e.target.value)}/>
      <button onClick={load}>Load</button>

      {rooms.map(r=>(
        <div key={r.id}>
          {r.type}
          <button onClick={()=>deleteRoom(r.id).then(load)}>Delete</button>
        </div>
      ))}
    </div>
  );
};

export default ManageRooms;