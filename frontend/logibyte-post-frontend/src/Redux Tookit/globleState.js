import { configureStore } from "@reduxjs/toolkit";
import authReducer from "./features/Auth/authSlice.js"

const globleState=configureStore({
    reducer:{
        auth: authReducer

    }
})

export default globleState;