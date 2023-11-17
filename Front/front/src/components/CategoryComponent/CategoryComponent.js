import React, { useEffect, useRef, useState } from 'react';
import axios from 'axios';
const CategoryComponent = () => {
    const [categories, setCategories] = useState([]);
    const URL = "http://localhost:8080/api/v1/category/getAllCategories";
    const getAllCategories = async () => {
        let token = localStorage.getItem("token");
        const Authorization = `Bearer ${token}`;

        try{
            const response = await axios.get(URL,{
                headers: {
                  'Authorization' : Authorization
                }
              });
              setCategories(response.data);
            return response.data;
        }catch(e){
            alert("Authorization needed!")
            console.error(e);
        }
    }

    
    return (
        <div>
            
        </div>
    );
}

export default CategoryComponent;
