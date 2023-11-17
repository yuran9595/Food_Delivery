import React, { useState } from 'react';
import axios from 'axios';

const RegistrationComponent = () => {
    const REGISTRATION_USER="http://localhost:8080/registration/distributor";
    const [login, setLogin] = useState("");
    const [password, setPassword] = useState("");
    const [nameOfDistributorCompany, setNameOfDistributorCompany] = useState("");
    const handleSubmit = async (event) => {
        try{
        event.preventDefault();
            const response = await axios.post(REGISTRATION_USER, {login, password, nameOfDistributorCompany})
            return response.data;
        }catch(error){
            console.error(error);
        }
    }
    return (
        <div>
             <form onSubmit={handleSubmit} method='post'>
            <label>UserName</label> 
           <input type='text' name='login' onChange={(Event)=> setLogin(Event.target.value)}/><br></br>
           <label>Password</label>
           <input type='text' name='password' onChange={(Event)=> setPassword(Event.target.value)} /><br></br>
           <label>Name of Company</label>
           <input type='text' name='nameOfDistributorCompany' onChange={(Event) => setNameOfDistributorCompany(Event.target.value)}></input>
           <br></br>
           <button>Registration Distributor</button>
           <a href='/' >Back</a>
            </form>
        </div>
    );
}

export default RegistrationComponent;
