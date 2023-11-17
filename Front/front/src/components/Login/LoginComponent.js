import React, { useState } from 'react';
import axios from 'axios'
import "./LoginComponent.css"
const AUTH_USER="http://localhost:8080/auth";
const LoginComponent = () => {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const getToken = async (userCredentials) => {
        try{
            const response = await axios.post(AUTH_USER, userCredentials);
            localStorage.setItem("token", response.data.token);
           console.log(response.data.token);
            return response.data;
        }catch(e){
            alert("Wrong Credentials!")
            console.error(e);
        }
    }
    const handleSubmit = async (event) => {
       event.preventDefault();
       await getToken({username, password});
      };
    
    return (
        <div>
            <form onSubmit={handleSubmit}>
            <label>UserName</label> 
           <input type='text' name='username' onChange={(Event)=> setUsername(Event.target.value)}/><br></br>
           <label>Password</label>
           <input type='text' name='password' onChange={(Event)=> setPassword(Event.target.value)} /><br></br>
           <button>Submit</button>
           <a href='/' >Back</a>
           <br></br>
           <a href='/registrationDistributor'>Registration Distributor</a>
            </form>
        </div>
    );
}

export default LoginComponent;
