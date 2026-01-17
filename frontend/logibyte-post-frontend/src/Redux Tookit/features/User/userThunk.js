import api from "@/util/api";
import { createAsyncThunk } from "@reduxjs/toolkit";

export const getUserProfile=createAsyncThunk("user/getProfile",
    async(token, {rejectWithValue})=>{
        try{
            const res=await api.get("/api/users/profile",{
                headers:{Authorization: `bearer ${token}`}
            });
            console.log("get user Profile success", res.data)
            return res.data
        } catch (error){
            console.log("error" , error?.response?.data);
            return rejectWithValue(
                error?.response?.data?.message || "Failed to fetch profile"
            );

        }
    }
);


export const getAllCustomer=createAsyncThunk("user/getCustomers",
    async(token, {rejectWithValue})=>{
        try{
            const res=await api.get("/api/users/customer",{
                headers:{Authorization: `bearer ${token}`}
            });
            console.log("get customer success", res.data)
            return res.data
        } catch (error){
            console.log("error" , error?.response?.data);
            return rejectWithValue(
                error?.response?.data?.message || "Failed to fetch Customers"
            );

        }
    }
);


export const getAllCashier=createAsyncThunk("user/getCashiers",
    async(token, {rejectWithValue})=>{
        try{
            const res=await api.get("/api/users/cashier",{
                headers:{Authorization: `bearer ${token}`}
            });
            console.log("get cashier success", res.data)
            return res.data
        } catch (error){
            console.log("error" , error?.response?.data);
            return rejectWithValue(
                error?.response?.data?.message || "Failed to cashier"
            );

        }
    }
);

export const getUserById=createAsyncThunk("user/getProfile",
    async(userId, {rejectWithValue})=>{
        try{
            const res=await api.get(`/api/users/${userId}`,{
                headers:{Authorization: `bearer ${localStorage.getItem('jwt')}`
            },
            });
            console.log("get user by id Profile success", res.data)
            return res.data
        } catch (error){
            console.log("error" , error?.response?.data);
            return rejectWithValue(
                error?.response?.data?.message || "Failed to fetch user by id"
            );

        }
    }
);