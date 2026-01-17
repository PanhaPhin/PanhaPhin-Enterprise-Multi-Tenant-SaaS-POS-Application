import { configureStore } from "@reduxjs/toolkit";
import authReducer from "./features/Auth/authSlice.js"
import userReducer  from "./features/User/userSlice.js"


const globalState=configureStore({
    reducer:{
        auth: authReducer,
        user: userReducer,
       
    }
})

export default globalState;