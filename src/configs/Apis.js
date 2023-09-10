import axios from "axios"
import cookie from "react-cookies";
const SERVER_CONTEXT = "bookingtour";
const SERVER = "http://localhost:8080/";

export const endpoints = {
    "login" : `${SERVER_CONTEXT}/api/login/`,
    "tour" : `${SERVER_CONTEXT}/api/tours/`,
    "categories" : `${SERVER_CONTEXT}/api/categories/`,
    "tourByCate": `${SERVER_CONTEXT}/api/tours/category/`,
    "current-user": `${SERVER_CONTEXT}/api/current-user/`,
    "news": `${SERVER_CONTEXT}/api/news/`
}



export const authApi = () => {
    return axios.create({
        baseURL: SERVER,
        headers: {
            "Authorization":  cookie.load("token")
        }
    })
}


export default axios.create({
    baseURL: SERVER
})