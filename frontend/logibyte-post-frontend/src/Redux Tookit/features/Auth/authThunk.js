import { createAsyncThunk } from "@reduxjs/toolkit";
import api from "@/util/api";


export const signup = createAsyncThunk("auth/signup" , 
    async (userData, {rejectWithValue})=>{
        try{
            const res=await api.post("/auth/signup",userData)
            localStorage.setItem("jwt",res.data.data.jwt)
            console.log("login success", res.data);
            return res.data;

        } catch (error){
            console.log("signup", error);
            return rejectWithValue(error.response?.data?.message || "singup failed")
        }

    }
)