import React from 'react';
import {Navbar, Nav, Container, Form, Button} from 'react-bootstrap'
import logo from './logo192.png'
import { BrowserRouter, Route, Router, Routes } from 'react-router-dom';
import LoginComponent from './Login/LoginComponent';
import UserListComponent from './UserListComponent';
import RegistrationDistributorComponent from './RegistrationComponent/RegistrationDistributorComponent';
import MainPageComponent from './MainPageComponent/MainPageComponent';

const HeaderComponent = () => {
    return (
        <>
        <Navbar fixed='top' collapseOnSelect expand = 'md' bg='dark' variant='dark'>
            <Container>
                <Navbar.Brand href = '/'>
                    <img src={logo} height='30' width='30' className='d-inline-block aligh-top' ></img>
                    Food Delivery
                </Navbar.Brand>
                <Navbar.Toggle aria-controls='responsive-navbar-nav'></Navbar.Toggle>
                <Navbar.Collapse id='responsive-navbar-nav'>
                    <Nav className='me-auto'>
                        {/* <Nav.Link href='/'>Home</Nav.Link> */}
                        <Nav.Link href='/auth'>Authorization</Nav.Link> 
                        <Nav.Link href='/getUserList'>Get User List</Nav.Link> 
                        <Nav.Link href='/registrationDistributor'>Registration for Distributors</Nav.Link>
                    </Nav>
                    <Form className="d-flex my-2 my-lg-0">
                        <Form.Control className='mr-sm-2 pl-sm-3 mx-2' type='text' placeholder='Search' aria-label='Search'></Form.Control>
                        <Button className='btn btn-outline-success my-2 my-sm-0 pl-sm-3'>Search</Button>
                    </Form>
                </Navbar.Collapse>
            </Container>
        </Navbar>
        <BrowserRouter>
            <Routes>
                {/* <Route  path='/' element = {<MainPageComponent/>}></Route> */}
                <Route  path='/auth' element = {<LoginComponent/>}></Route>
                <Route  path='/getUserList' element = {<UserListComponent/>}></Route>
                <Route  path='/registrationDistributor' element = {<RegistrationDistributorComponent/>}></Route>
            </Routes>
        </BrowserRouter>
        </>
    );
}

export default HeaderComponent;
