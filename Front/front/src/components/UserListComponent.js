import React, { useEffect, useState } from 'react';
import axios from 'axios';
import UserComponent from './User/UserComponent';

const UserListComponent = () => {
    const [users, setUsers] = useState([]);
    const URL = "http://localhost:8080/api/v1/users/getUserList";

    const getUsers = async () => {
        let token = localStorage.getItem("token");
        const Authorization = `Bearer ${token}`;

        try{
            const response = await axios.get(URL,{
                headers: {
                  'Authorization' : Authorization
                }
              });
              setUsers(response.data);
            return response.data;
        }catch(e){
            alert("Authorization needed!")
            console.error(e);
        }
    }
    useEffect(()=>{
        getUsers();
    }, [setUsers])

    return (
        <div>
        <h1 className="text-center">UserList</h1>
        <table className="table table-striped">
            <thead>
                <tr>
                    <th>User ID</th>
                    <th>Login</th>
                    <th>Active</th>
                    <th>Set to active</th>
                    <th>UserRole</th>
                </tr>
            </thead>
            <tbody>{
                 users.map(       
                    user =>  <UserComponent user = {user} key = {user.id} ></UserComponent>
                )
                }
            </tbody>
        </table>
        <a href='/' >Back</a>
    </div>
    );
}

export default UserListComponent;
