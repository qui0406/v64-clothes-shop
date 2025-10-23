import axios from "axios";
import cookie from "react-cookies";

const BASE_URL = "http://localhost:8088/api/v1";

export const endpoints ={
    "login": "/auth/token",
    "register": "/users/registration",
    "my-profile": "/users/my-info",
}

export const authApis = () => {
    return axios.create({
        baseURL: BASE_URL,
        headers: {
            'Authorization': `Bearer ${cookie.load('token')}`
        }

    });

}
export default axios.create({
    baseURL: BASE_URL,
})

