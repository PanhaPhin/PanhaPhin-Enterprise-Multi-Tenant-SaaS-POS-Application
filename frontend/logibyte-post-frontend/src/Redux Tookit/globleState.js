import { configureStore } from "@reduxjs/toolkit";
import authReducer from "./features/Auth/authSlice.js"
import customerReducer from "./features/Customer/customerSlice.js"
import orderReducer from "./features/Order/orderSlice.js"
import userReducer from "./features/User/userSlice.js"


const globalState=configureStore({
    reducer:{
        auth: authReducer,
        user: userReducer,
        customer:customerReducer,
        order:orderReducer,
       
    }
})

export default globalState;