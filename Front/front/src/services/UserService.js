import axios from 'axios'
const URL_USERS="http://localhost:8080/api/v1/users/getUserList";
class UserService{
getUsers(){
    let token = localStorage.getItem("token");
    const Authorization = `Bearer ${token}`;
    
    //axios.defaults.headers.common['Authorization'] = Authorization;
    return axios.get(URL_USERS, {
        headers: {
          'Authorization' : Authorization
        }
      });
    
   }
}
const userService = new UserService();
export default userService;