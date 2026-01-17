const { createSlice } = require("@reduxjs/toolkit");
const { getUserProfile } = require("./userThunk");

const initialState={
    userProfile: null,
    users:[],
    customers:[],
    cashiers:[],
    selectedUser:null,
    loading:false,
    error:null,

}

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


    }
})