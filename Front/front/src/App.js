import './App.css';
import LoginComponent from './components/Login/LoginComponent';
import  { Route, Routes, BrowserRouter } from 'react-router-dom'
import UserListComponent from './components/UserListComponent';
import RegistrationDistributorComponent from './components/RegistrationComponent/RegistrationDistributorComponent';
import MainPageComponent from './components/MainPageComponent/MainPageComponent';
import HeaderComponent from './components/HeaderComponent';


function App() {
  return (
    <div>
    <HeaderComponent/>
    </div>
  )
}
export default App;
