import createSlice  from "@reduxjs/toolkit";
import  getUserProfile, { getAllCashier, getAllCustomer, getUserById }  from "./userThunk";
import login from "@/pages/Auth/Login";

const initialState={
    userProfile: null,
    users:[],
    customers:[],
    cashiers:[],
    selectedUser:null,
    loading:false,
    error:null,

};

const userSlice=createSlice({
    name:"user",
    initialState,
    reducers:{
        clearUserState:(state)=>{
            state.userProfile=null;
            state.selectedUser=null;
            state.users=[],
            state.customers=[],
            state.cashiers=[],
            state.error=null
        }
    },
    extraReducers: (builder) =>{
        
        builder
        .addCase(getUserProfile.pending, (state)=> {
            state.loading=true;
            state.error=null;
            state.userProfile=null;
            
        })
        .addCase(getUserProfile.fulfilled, (state,action)=> {
            state.loading=false,
            state.userProfile=action.payload;
        })
        
        .addCase(getUserProfile.rejected,(state,action)=>{
            state.loading=false,
            state.error=action.payload
        })

        .addCase(getAllCustomer.fulfilled, (state, action) => {
            state.loading=false,
            state.error=action.payload
        })

        .addCase(getAllCashier.fulfilled, (state,action) => {
            state.cashiers = action.payload;
        })
       

        .addCase(getUserById.fulfilled, (state,action) => {
            state.cashiers = action.payload;
        })
        .addCase(login.fulfilled,(state)=>{
            state.userProfile = null;
            state.selectedUser = null;
            state.error = null;
        })


    }
})

export default userSlice.reducer;