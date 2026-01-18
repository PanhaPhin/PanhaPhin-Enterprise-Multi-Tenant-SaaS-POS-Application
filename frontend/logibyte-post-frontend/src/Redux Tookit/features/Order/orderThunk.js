import api from "@/util/api";
import { getAuthHeaders } from "@/util/getAuthHeader";
import { createAsyncThunk } from "@reduxjs/toolkit";


export const createOrder=createAsyncThunk("order/create",
    async(dto, {rejectWithValue})=>{
        try{
            const headers= getAuthHeaders();
            const res=await api.post(`/api/orders`,dto,{
            headers,
            });
            console.log("create order  success", res.data);
            return res.data;
        } catch (error){
            console.log("error" , error?.response?.data);
            return rejectWithValue(
                error?.response?.data?.message || "Failed to create order "
            );

        }
    }
);


export const getOrderById=createAsyncThunk("order/getById",
    async(id, {rejectWithValue})=>{
        try{
            const headers= getAuthHeaders();
            const res=await api.post(`/api/orders${id}`,{
            headers,
            });
            console.log("fetch  order  success", res.data);
            return res.data;
        } catch (error){
            console.log("error" , error?.response?.data);
            return rejectWithValue(
                error?.response?.data?.message || "Failed to fetch order "
            );

        }
    }
);


export const getOrdersByBranch=createAsyncThunk("order/getByBranch",
    async({branchId,customerId,cashierId,paymentType,status}, {rejectWithValue})=>{
        try{
            const headers= getAuthHeaders();
            const param=[]
            if(customerId)param.push(`customerId=${customerId}`);
            if(cashierId)param.push(`cashierId=${cashierId}`)
            if(paymentType)param.push(`paymentType=${paymentType}`)
            if(status)param.push(`status=${status}`)
                
                const query=param.length?`${param.join("&")}`:"";


            const res=await api.get(`/api/orders${branchId}${query}`,{
            headers,
            });
            console.log("fetch  branch order  success", res.data);
            return res.data;
        } catch (error){
            console.log("error" , error?.response?.data);
            return rejectWithValue(
                error?.response?.data?.message || "Failed to fetch branch order "
            );

        }
    }
);


export const getOrdersByCashier=createAsyncThunk("order/getByCashier",
    async(id, {rejectWithValue})=>{
        try{
            const headers= getAuthHeaders();
            const res=await api.post(`/api/orders/cashier/${id}`,{
            headers,
            });
            console.log("fetch cashier order  success", res.data);
            return res.data;
        } catch (error){
            console.log("error" , error?.response?.data);
            return rejectWithValue(
                error?.response?.data?.message || "Failed to fetch cashier order "
            );

        }
    }
);


export const getTodayOrdersByBranch=createAsyncThunk("order/getTodayByBranch",
    async(id, {rejectWithValue})=>{
        try{
            const headers= getAuthHeaders();
            const res=await api.post(`/api/orders/today/branch/${id}`,{
            headers,
            });
            console.log("fetch today branch order  success", res.data);
            return res.data;
        } catch (error){
            console.log("error" , error?.response?.data);
            return rejectWithValue(
                error?.response?.data?.message || "Failed to fetch order "
            );

        }
    }
);


export const deleteOrder=createAsyncThunk("order/delete",
    async(id, {rejectWithValue})=>{
        try{
            const headers= getAuthHeaders();
            const res=await api.delete(`/api/orders${id}`,{
            headers,
            });
            console.log("delete  order  success", res.data);
            return res.data;
        } catch (error){
            console.log("error" , error?.response?.data);
            return rejectWithValue(
                error?.response?.data?.message || "Failed to delete order "
            );

        }
    }
);

export const getOrderByCustomer=createAsyncThunk("order/getById",
    async(id, {rejectWithValue})=>{
        try{
            const headers= getAuthHeaders();
            const res=await api.get(`/api/orders/customer/${id}`,{
            headers,
            });
            console.log("fetch customer order  success", res.data);
            return res.data;
        } catch (error){
            console.log("error" , error?.response?.data);
            return rejectWithValue(
                error?.response?.data?.message || "Failed to fetch order "
            );

        }
    }
);


export const getRecentOrdersByBranch=createAsyncThunk("order/getRecentByBranch",
    async(id, {rejectWithValue})=>{
        try{
            const headers= getAuthHeaders();
            const res=await api.post(`/api/orders/recent/${id}`,{
            headers,
            });
            console.log("fetch recent branch order  success", res.data);
            return res.data;
        } catch (error){
            console.log("error" , error?.response?.data);
            return rejectWithValue(
                error?.response?.data?.message || "Failed to fetch order "
            );

        }
    }
);