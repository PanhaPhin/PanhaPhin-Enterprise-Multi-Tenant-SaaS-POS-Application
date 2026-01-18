import { createAsyncThunk } from "@reduxjs/toolkit";
import api from "@/util/api";
import { getAuthHeaders } from "@/util/getAuthHeader";


export const createCustomer=createAsyncThunk("customer/create",
    async(customer, {rejectWithValue})=>{
        try{
            const headers= getAuthHeaders();
            const res=await api.post(`/api/customers/`,customer,{
            headers,
            });
            console.log("create customer  success", res.data);
            return res.data;
        } catch (error){
            console.log("error" , error?.response?.data);
            return rejectWithValue(
                error?.response?.data?.message || "Failed to fetch customer"
            );

        }
    }
);


export const updateCustomer=createAsyncThunk("customer/update",
    async(customer,id, {rejectWithValue})=>{
        try{
            const headers= getAuthHeaders();
            const res=await api.put(`/api/customers/${id}`,customer,{
            headers,
            });
            console.log("update customer  success", res.data);
            return res.data;
        } catch (error){
            console.log("error" , error?.response?.data);
            return rejectWithValue(
                error?.response?.data?.message || "Failed to update customer"
            );

        }
    }
);



export const deleteCustomer=createAsyncThunk("customer/delete",
    async(id, {rejectWithValue})=>{
        try{
            const headers= getAuthHeaders();
            const res=await api.delete(`/api/customers/${id}`,{
            headers,
            });
            console.log("delete customer  success", res.data);
            return res.data;
        } catch (error){
            console.log("error" , error?.response?.data);
            return rejectWithValue(
                error?.response?.data?.message || "Failed to delete customer"
            );

        }
    }
);


export const getCustomerById=createAsyncThunk("customer/getById",
    async(id, {rejectWithValue})=>{
        try{
            const headers= getAuthHeaders();
            const res=await api.get(`/api/customers/${id}`,{
            headers,
            });
            console.log("get customer by id success", res.data);
            return res.data;
        } catch (error){
            console.log("error" , error?.response?.data);
            return rejectWithValue(
                error?.response?.data?.message || "Failed to fetch customer"
            );

        }
    }
);



export const getAllCustomer=createAsyncThunk("customer/getALL",
    async(_, {rejectWithValue})=>{
        try{
            const headers= getAuthHeaders();
            const res=await api.get(`/api/customers/`,{
            headers,
            });
            console.log("get All customer success", res.data);
            return res.data;
        } catch (error){
            console.log("error" , error?.response?.data);
            return rejectWithValue(
                error?.response?.data?.message || "Failed to fetch customer"
            );

        }
    }
)