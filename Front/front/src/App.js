import './App.css';
import LoginComponent from './components/Login/LoginComponent';
import  { Route, Routes, BrowserRouter } from 'react-router-dom'
import UserListComponent from './components/UserListComponent';
import RegistrationDistributorComponent from './components/RegistrationComponent/RegistrationDistributorComponent';
import MainPageComponent from './components/MainPageComponent/MainPageComponent';


function App() {
  return (
    <BrowserRouter>
    <Routes>
      <Route path='/' element={<MainPageComponent/>}/>
      <Route path='/auth' element={<LoginComponent/>}/>
      <Route path='/getUserList' element={<UserListComponent/>}/>
      <Route path='/registrationDistributor' element={<RegistrationDistributorComponent/>}/>
    </Routes>
    </BrowserRouter>
  )
}
export default App;
