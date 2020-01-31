import axios from 'axios';
import AuthService from "./authService";

const hosts = {
    development: 'http://dev.local:8080/user/api/',
    test: 'http://dev.local:8080/user/api/',
    production: '/user/api/'
};

const axiosInstance = axios.create({
    baseURL: hosts[process.env.NODE_ENV]
});

const isHandlerEnabled = (config = {}) => {
    return config.hasOwnProperty('handlerEnabled') && !config.handlerEnabled ? false : true
};

const requestHandler = (request) => {
    if (isHandlerEnabled(request)) {
        console.log(AuthService.getUserInfo());

        request.headers['Authorization'] = AuthService.getAuthorization();

    }
    return request
};

const errorHandler = (error) => {
    if (isHandlerEnabled(error.config)) {
        if (error.response && error.response.data) {
            alert(error.response.data.message);
        }
    }
    return Promise.reject({ ...error })
};

axiosInstance.interceptors.request.use(
    request => requestHandler(request)
);
axiosInstance.interceptors.response.use(response => response, error => errorHandler(error));

export default axiosInstance;