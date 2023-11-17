import React from 'react';
import { Link } from 'react-router-dom';
import "./MainPageComponent.css"

const MainPageComponent = () => {
    return (
        <nav>
            <ul>
                <li><Link to="/auth">Авторизация</Link></li>
                <li><Link to="/getUserList">Получить список юзеров</Link></li>
                <li><Link to="/getAllCategories">Получить список категорий товаров</Link></li>
            </ul>
        </nav>
    );
}

export default MainPageComponent;
