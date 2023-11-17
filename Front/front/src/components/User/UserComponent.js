import React, { useEffect, useRef, useState } from 'react';
import axios from 'axios';
const UserComponent = (props) => {

    const [user, setUser] = useState();
    const [active, setActive] = useState(props.user.active);
    const URL = "http://localhost:8080/api/v1/users/getUserById/";
    const URL_TO_INACTIVE = "http://localhost:8080/api/v1/admin/setUserToInactive/";
    const URL_TO_ACTIVE = "http://localhost:8080/api/v1/admin/setUserToActive/";


    const setToActive = async (userId) =>{
        let token = localStorage.getItem("token");
        const Authorization = `Bearer ${token}`;
        const fullUrl = `${URL_TO_ACTIVE}${userId}`;
        try{
            const response = await axios.post(fullUrl, null,{
                headers: {
                  'Authorization' : Authorization
                }
              });
              setUser(response.data);
              setActive(true);           
           // return response.data;
        }catch(e){
            console.error(e);
        }
    }

    const setToInactive = async (userId) =>{
        let token = localStorage.getItem("token");
        const Authorization = `Bearer ${token}`;
        const fullUrl = `${URL_TO_INACTIVE}${userId}`;
        try{
            const response = await axios.post(fullUrl, null,{
                headers: {
                  'Authorization' : Authorization
                }
              });
              setActive(false);
            //return response.data;
        }catch(e){
            console.error(e);
        }
    }
    useEffect(() => {
      
  }, []);
    return (
              <tr key={props.user.id}>
                         <th>{props.user.id}</th>
                         <th>{props.user.login}</th>
                         <th>{active.toString()}</th>
                         <th><button onClick={() => setToActive(props.user.id)}>Set to active</button></th> 
                         <th><button onClick={() => setToInactive(props.user.id)}>Set to inactive</button></th>
                      <th>{props.user.userRole}</th>
                     </tr>
    );
}

export default UserComponent;
