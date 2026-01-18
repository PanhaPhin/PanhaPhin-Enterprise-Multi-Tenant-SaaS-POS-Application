import { configureStore } from "@reduxjs/toolkit";
import authReducer from "./features/Auth/authSlice.js"
import userReducer  from "./features/User/userSlice.js"
import customerReducer from "./features/Customer/customerSlice.js"


const globalState=configureStore({
    reducer:{
        auth: authReducer,
        user: userReducer,
        customer:customerReducer,
       
    }
})

export default globalState;